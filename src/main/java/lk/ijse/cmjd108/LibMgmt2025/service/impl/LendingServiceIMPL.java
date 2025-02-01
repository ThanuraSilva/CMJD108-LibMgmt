package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.LendingDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.MemberDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.*;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.LendingMapping;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class LendingServiceIMPL implements LendingService {
    @Value("${perDayFine}") // Value injection
    private Double perDayFineAmount;
    private final LendingMapping lendingMapping;
    private final BookDao bookDao;
    private final MemberDao memberDao;
    private final LendingDao lendingDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        //relevant book
        //relevant member
        String bookId = lendingDTO.getBook();
        String member = lendingDTO.getMember();
        BookEntity bookEntity = bookDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));
        MemberEntity memberEntity = memberDao.findById(member).orElseThrow(() -> new MemberNotFoundException("Member Not Found"));
        // check the availability
        if(bookDao.avlilQty(bookId) > 0){
            // Books are available
            if(bookDao.deductBasedOnLending(bookId) > 0){
                //process the lending
                 lendingDTO.setLendingId(UtilData.generateLendingId());
                 lendingDTO.setLendingDate(UtilData.generateTodayDate());
                 lendingDTO.setReturnDate(UtilData.generateBookReturnDate());
                 lendingDTO.setIsActiveLending(true);
                 lendingDTO.setOverdueDays(0L);
                 lendingDTO.setFineAmount(0.0);
                 lendingDao.save(LendingMapping.toLendingEntity(lendingDTO, bookEntity, memberEntity));

            }else {
              throw new DataPersistException("Cannot update book data with 0 available Qty");
            }
        }else {
            throw new EnoughBooksNotFoundException("Not enough books to proceed");
        }
    }

    @Override
    public void handOverBook(String lendingId) {
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));
        var returnDate = foundLending.getReturnDate();
        var overDue = calcOverDue(returnDate); // overdue date count
        var fineAmount = calcFine(overDue); // calc fine against overdue dates

        foundLending.setOverdueDays(overDue);
        foundLending.setFineAmount(fineAmount);
        foundLending.setIsActiveLending(false);
        //update the book qty against the bookId
        bookDao.addBookBasedBookHandover(foundLending.getBook().getBookId());
    }

    @Override
    public void deleteLendingData(String lendingId) {
         //validation the ID
        var foundLending = lendingDao.findById(lendingId).orElseThrow(() ->
                new LendingDataNotFoundException("Lending data not found"));
        lendingDao.deleteById(lendingId);
        //add the book when delete the lending record
        if(foundLending.getIsActiveLending() == true){
            bookDao.addBookBasedBookHandover(foundLending.getBook().getBookId());
        }
    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
        var foundLending = lendingDao.findById(lendingId).orElseThrow(() ->
                new LendingDataNotFoundException("Lending data not found"));
        return LendingMapping.toLendingDTO(foundLending);
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
       return null;

    }
    private Long calcOverDue(LocalDate returnDate){
        var today = UtilData.generateTodayDate();
        if(returnDate.isBefore(today)){
            return ChronoUnit.DAYS.between(today,returnDate);
        }
        return 0L;
    }
    private Double calcFine(Long daysCount){
        return daysCount * perDayFineAmount;
    }
}
