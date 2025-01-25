package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO){
        staffService.saveStaff(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        staffService.deleteStaff(staffId);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{staffId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody StaffDTO staffMemberDetails){
        staffService.updateStaff(staffId,staffMemberDetails);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{staffId}")
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@PathVariable String staffId){
        return ResponseEntity.ok(staffService.getSelectedStaffMember(staffId));
    }
    @GetMapping
    public ResponseEntity<List<StaffDTO>>getAllStaffMembers(){
        return ResponseEntity.ok(staffService.getAllStaff());
    }
}
