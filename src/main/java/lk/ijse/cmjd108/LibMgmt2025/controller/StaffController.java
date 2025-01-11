package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
    @GetMapping("health")
    public String healthTest(){
        return "Staff Controller is running";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO){
        System.out.println(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        System.out.println(staffId);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{staffId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody BookDTO staffMemberDetails){
        System.out.println(staffId);
        System.out.println(staffMemberDetails);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{staffId}")
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@PathVariable String staffId){
        System.out.println("Get selected staffMember for "+staffId);
        return ResponseEntity.ok(new StaffDTO());
    }
    @GetMapping
    public ResponseEntity<List<StaffDTO>>getAllStaffMembers(){
        return ResponseEntity.ok(new ArrayList<>());
    }
}
