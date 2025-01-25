package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.StaffDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.Role;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.exception.StaffMemberNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
       staffDao.save(entityDTOConvert.convertStaffDTOTOStaffEntity(staffDTO));
    }

    @Override
    public void updateStaff(String staffId,StaffDTO staffDTO) {

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
        StaffDTO staff = new StaffDTO();
        staff.setStaffId("S001");
        staff.setFirstName("John");
        staff.setLastName("Doe");
        staff.setEmail("john.doe@example.com");
        staff.setJoinDate("2025-01-18");
        staff.setPhone("123-456-7890");
        staff.setRole(Role.ADMIN);
        return staff;
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<StaffDTO> staffList = new ArrayList<>();

        StaffDTO staff1 = new StaffDTO();
        staff1.setStaffId("S12345");
        staff1.setFirstName("John");
        staff1.setLastName("Doe");
        staff1.setEmail("john.doe@example.com");
        staff1.setJoinDate("2025-01-18");
        staff1.setPhone("123-456-7890");
        staff1.setRole(Role.ADMIN);

        StaffDTO staff2 = new StaffDTO();
        staff2.setStaffId("S12346");
        staff2.setFirstName("Jane");
        staff2.setLastName("Smith");
        staff2.setEmail("jane.smith@example.com");
        staff2.setJoinDate("2025-02-20");
        staff2.setPhone("987-654-3210");
        staff2.setRole(Role.LIBRARIAN);

        StaffDTO staff3 = new StaffDTO();
        staff3.setStaffId("S12347");
        staff3.setFirstName("Bob");
        staff3.setLastName("Johnson");
        staff3.setEmail("bob.johnson@example.com");
        staff3.setJoinDate("2025-03-15");
        staff3.setPhone("456-789-0123");
        staff3.setRole(Role.OFFICER);

        StaffDTO staff4 = new StaffDTO();
        staff4.setStaffId("S12348");
        staff4.setFirstName("Alice");
        staff4.setLastName("Brown");
        staff4.setEmail("alice.brown@example.com");
        staff4.setJoinDate("2025-04-10");
        staff4.setPhone("321-654-0987");
        staff4.setRole(Role.OFFICER);

        StaffDTO staff5 = new StaffDTO();
        staff5.setStaffId("S12349");
        staff5.setFirstName("Charlie");
        staff5.setLastName("Davis");
        staff5.setEmail("charlie.davis@example.com");
        staff5.setJoinDate("2025-05-05");
        staff5.setPhone("789-012-3456");
        staff5.setRole(Role.OFFICER);

        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);
        staffList.add(staff5);

        return staffList;

    }
}
