package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.StaffEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    //Books
    public BookEntity convertBookDTOToBookEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntity.class);
    }
    public BookDTO convertBookEntityToBookDTO(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDTO.class);
    }
    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList) {
        return modelMapper.map(bookEntityList,new TypeToken<List<BookDTO>>(){}.getType());
    }
    //Members
    public MemberEntity convertMemberDTOToMemberEntity(MemberDTO memberDTO) {
        return modelMapper.map(memberDTO,MemberEntity.class);
    }
    public MemberDTO convertMemberEntityToMemberDTO(MemberEntity memberEntity) {
        return modelMapper.map(memberEntity,MemberDTO.class);
    }
    public List<MemberDTO> toMemberDTOList(List<MemberEntity> memberEntityList) {
        return modelMapper.map(memberEntityList,new TypeToken<List<MemberDTO>>(){}.getType());
    }
    //Staff
    public StaffEntity convertStaffDTOTOStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO,StaffEntity.class);
    }
    public StaffDTO convertStaffEntityToStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity,StaffDTO.class);
    }
    public List<StaffDTO> toStaffDTOList(List<StaffEntity> staffEntityList) {
        return modelMapper.map(staffEntityList,new TypeToken<List<StaffDTO>>(){}.getType());
    }
}
