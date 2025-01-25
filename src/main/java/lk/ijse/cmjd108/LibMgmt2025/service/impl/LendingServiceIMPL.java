package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.LendingDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.MemberDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.BookNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.exception.EnoughBooksNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.exception.MemberNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.LendingMapping;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LendingServiceIMPL implements LendingService {
    @Value("${perDayFine}") // Value injection
    private Double perDayAmount;
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


        }else {
            throw new EnoughBooksNotFoundException("Not enough books to proceed");
        }





        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(UtilData.generateTodayDate());
        lendingDTO.setReturnDate(UtilData.generateBookReturnDate());
        lendingDTO.setIsActiveLending(true);
        lendingDTO.setFineAmount(0.00);
        lendingDTO.setOverdueDays(0L);
        System.out.println(lendingDTO);
    }

    @Override
    public void handOverBook(String lendingId) {
        //Todo 1: Check the details of the lending record - DB
        //Todo: Check overdue and fine



    }

    @Override
    public void deleteLendingData(String lendingId) {

    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
       return null;
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
       return null;

    }
    private Long calcOverDue(){
        //Today
        LocalDate today = UtilData.generateTodayDate();
        LocalDate returnDate = UtilData.generateBookReturnDateCalc();
        if(returnDate.isBefore(today)){
           return ChronoUnit.DAYS.between(today, returnDate);
        }
        return 0L;
    }
    private Double calcFine(Long datCount){
        return datCount * perDayAmount;
    }
}
