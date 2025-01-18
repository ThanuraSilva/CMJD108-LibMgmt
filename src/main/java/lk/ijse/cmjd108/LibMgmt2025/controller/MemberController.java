package lk.ijse.cmjd108.LibMgmt2025.controller;
import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("health")
    public String healthTest(){
        return "Member Controller is running";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody MemberDTO memberDTO){
        memberService.saveMember(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("memberId") String memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{memberId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String memberId, @RequestBody MemberDTO memberDetails){
        memberService.updateMember(memberId,memberDetails);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{memberId}")
    public ResponseEntity<MemberDTO> getSelectedMember(@PathVariable String memberId){
        return ResponseEntity.ok(memberService.getSelectedMember(memberId));
    }
    @GetMapping
    public ResponseEntity<List<MemberDTO>>getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
