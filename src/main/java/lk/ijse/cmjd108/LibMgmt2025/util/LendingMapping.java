package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class LendingMapping {
    public static LendingDTO toLendingDTO(LendingEntity lendingEntity) {
        var lendingDTO = new LendingDTO();
        lendingDTO.setLendingId(lendingEntity.getLendingId());
        lendingDTO.setBook(lendingEntity.getBook().getBookId());
        lendingDTO.setMember(lendingEntity.getMember().getMemberId());
        lendingDTO.setLendingDate(lendingEntity.getLendingDate());
        lendingDTO.setReturnDate(lendingEntity.getReturnDate());
        lendingDTO.setIsActiveLending(lendingEntity.getIsActiveLending());
        lendingDTO.setOverdueDays(lendingEntity.getOverdueDays());
        lendingDTO.setFineAmount(lendingEntity.getFineAmount());
        return lendingDTO;
    }
    public static LendingEntity toLendingEntity(LendingDTO lendingDTO, BookEntity bookEntity, MemberEntity memberEntity) {
        var lendingEntity = new LendingEntity();
        lendingEntity.setLendingId(lendingDTO.getLendingId());
        lendingEntity.setBook(bookEntity);
        lendingEntity.setMember(memberEntity);
        lendingEntity.setLendingDate(lendingDTO.getLendingDate());
        lendingEntity.setReturnDate(lendingDTO.getReturnDate());
        lendingEntity.setIsActiveLending(lendingDTO.getIsActiveLending());
        lendingEntity.setOverdueDays(lendingDTO.getOverdueDays());
        lendingEntity.setFineAmount(lendingDTO.getFineAmount());
        return lendingEntity;
    }
}
