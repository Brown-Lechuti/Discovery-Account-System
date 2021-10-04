package za.ac.nwu.ac.web.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

@Service
public class UpdateMemberAdd {
    @Autowired
    Member_Repo repo;
    public Member updateMemberA(Long id, Integer currency_available) throws ResourceNotFoundException {
        Member member = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member account not found for this id :: " + id));
        member.setCurrency(member.getCurrency() + currency_available);
        final Member updatedMember = repo.save(member);
        return updatedMember;
    }
}