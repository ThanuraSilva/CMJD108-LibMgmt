package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Service
public class LendingServiceIMPL implements LendingService {
    @Value("${perDayFine}") // Value injection
    private Double perDayAmount;
    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(String.valueOf(UtilData.generateTodayDate()));
        lendingDTO.setReturnDate(String.valueOf(UtilData.generateBookReturnDate()));
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
        var lendingData = new LendingDTO();
        lendingData.setLendingId("L0001");
        lendingData.setBook("The Great Gatsby");
        lendingData.setMember("M12345");
        lendingData.setLendingDate("2025-01-01");
        lendingData.setReturnDate("2025-01-15");
        lendingData.setIsActiveLending(true);
        lendingData.setOverdueDays(2L);
        lendingData.setFineAmount(5.00);
        return lendingData;
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
        List<LendingDTO> lendingList = new ArrayList<>();

        LendingDTO lending1 = new LendingDTO();
        lending1.setLendingId("L12345");
        lending1.setBook("The Great Gatsby");
        lending1.setMember("M12345");
        lending1.setLendingDate("2025-01-01");
        lending1.setReturnDate("2025-01-15");
        lending1.setIsActiveLending(true);
        lending1.setOverdueDays(2L);
        lending1.setFineAmount(5.00);

        LendingDTO lending2 = new LendingDTO();
        lending2.setLendingId("L12346");
        lending2.setBook("1984");
        lending2.setMember("M12346");
        lending2.setLendingDate("2025-01-05");
        lending2.setReturnDate("2025-01-20");
        lending2.setIsActiveLending(false);
        lending2.setOverdueDays(0L);
        lending2.setFineAmount(0.00);

        LendingDTO lending3 = new LendingDTO();
        lending3.setLendingId("L12347");
        lending3.setBook("To Kill a Mockingbird");
        lending3.setMember("M12347");
        lending3.setLendingDate("2025-01-10");
        lending3.setReturnDate("2025-01-25");
        lending3.setIsActiveLending(true);
        lending3.setOverdueDays(1L);
        lending3.setFineAmount(2.50);

        LendingDTO lending4 = new LendingDTO();
        lending4.setLendingId("L12348");
        lending4.setBook("Pride and Prejudice");
        lending4.setMember("M12348");
        lending4.setLendingDate("2025-01-12");
        lending4.setReturnDate("2025-01-27");
        lending4.setIsActiveLending(false);
        lending4.setOverdueDays(0L);
        lending4.setFineAmount(0.00);

        LendingDTO lending5 = new LendingDTO();
        lending5.setLendingId("L12349");
        lending5.setBook("Moby Dick");
        lending5.setMember("M12349");
        lending5.setLendingDate("2025-01-15");
        lending5.setReturnDate("2025-01-30");
        lending5.setIsActiveLending(true);
        lending5.setOverdueDays(3L);
        lending5.setFineAmount(7.50);

        lendingList.add(lending1);
        lendingList.add(lending2);
        lendingList.add(lending3);
        lendingList.add(lending4);
        lendingList.add(lending5);
        return lendingList;
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
