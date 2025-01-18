package lk.ijse.cmjd108.LibMgmt2025.service;

import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    void updateStaff(String staffId,StaffDTO staffDTO);
    void deleteStaff(String staffId);
    StaffDTO getSelectedStaffMember(String staffId);
    List<StaffDTO> getAllStaff();
}
