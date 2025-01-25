package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.StaffDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.Role;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.StaffEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.StaffMemberNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {
    private final StaffDao staffDao;
    private final EntityDTOConvert entityDTOConvert;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
       staffDTO.setStaffId(UtilData.generateStaffId());
       staffDTO.setLastUpdate(UtilData.generateTodayDate());
       staffDTO.setLastUpdateTime(UtilData.generateCurrentTime());
       staffDao.save(entityDTOConvert.convertStaffDTOTOStaffEntity(staffDTO));
    }

    @Override
    public void updateStaff(String staffId,StaffDTO staffDTO) {
        var foundStaffMember = staffDao.findById(staffId);
        if(!foundStaffMember.isPresent()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        foundStaffMember.get().setFirstName(staffDTO.getFirstName());
        foundStaffMember.get().setLastName(staffDTO.getLastName());
        foundStaffMember.get().setEmail(staffDTO.getEmail());
        foundStaffMember.get().setJoinDate(staffDTO.getJoinDate());
        foundStaffMember.get().setLastUpdate(UtilData.generateTodayDate());
        foundStaffMember.get().setLastUpdateTime(UtilData.generateCurrentTime());
        foundStaffMember.get().setPhone(staffDTO.getPhone());
        foundStaffMember.get().setRole(staffDTO.getRole());
    }

    @Override
    public void deleteStaff(String staffId) {
        if(!staffDao.findById(staffId).isPresent()){
            throw new StaffMemberNotFoundException("Staff member not fond");
        }
        staffDao.deleteById(staffId);
    }

    @Override
    public StaffDTO getSelectedStaffMember(String staffId) {
        if(!staffDao.findById(staffId).isPresent()){
            throw new StaffMemberNotFoundException("Staff member not fond");
        }
        return entityDTOConvert.
                convertStaffEntityToStaffDTO(staffDao.getReferenceById(staffId));
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return entityDTOConvert.toStaffDTOList(staffDao.findAll());
    }
}
