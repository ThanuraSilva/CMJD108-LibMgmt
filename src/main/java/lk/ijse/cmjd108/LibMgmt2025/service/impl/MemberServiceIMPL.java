package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceIMPL implements MemberService {
    @Override
    public void saveMember(MemberDTO member) {

    }

    @Override
    public void updateMember(String memberId, MemberDTO member) {

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        MemberDTO member = new MemberDTO();
        member.setMemberId("M005");
        member.setName("John Doe");
        member.setEmail("johndoe@example.com");
        member.setMembershipDate("2025-01-18");
        return member;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<>();
        MemberDTO member1 = new MemberDTO();
        member1.setMemberId("M12345");
        member1.setName("John Doe");
        member1.setEmail("johndoe@example.com");
        member1.setMembershipDate("2025-01-18");

        MemberDTO member2 = new MemberDTO();
        member2.setMemberId("M12346");
        member2.setName("Jane Smith");
        member2.setEmail("janesmith@example.com");
        member2.setMembershipDate("2025-01-19");

        MemberDTO member3 = new MemberDTO();
        member3.setMemberId("M12347");
        member3.setName("Bob Johnson");
        member3.setEmail("bobjohnson@example.com");
        member3.setMembershipDate("2025-01-20");

        MemberDTO member4 = new MemberDTO();
        member4.setMemberId("M12348");
        member4.setName("Alice Brown");
        member4.setEmail("alicebrown@example.com");
        member4.setMembershipDate("2025-01-21");

        MemberDTO member5 = new MemberDTO();
        member5.setMemberId("M12349");
        member5.setName("Charlie Davis");
        member5.setEmail("charliedavis@example.com");
        member5.setMembershipDate("2025-01-22");

        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);
        return members;
    }
}
