package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuyVoucher
{
    @Autowired
    Member_Repo repo;

    @PatchMapping("MEMBER_/{id}/{currency_available}")
    public ResponseEntity<Member> setCurrency(@PathVariable(value = "id") Long MEMBER_ID, @PathVariable(value = "currency_available") Integer currency_available) throws ResourceNotFoundException {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        member.setCurrency(currency_available);
        final Member updatedMember = repo.save(member);
        return ResponseEntity.ok(updatedMember);
    }
    @GetMapping("/MEMBER_")
    public List < Member> getAllMembers()
    {
        return repo.findAll();
    }

    @PostMapping("/MEMBER_")
    public Member createMemberAccount(@Valid @RequestBody Member member)
    {
        return repo.save(member);
    }


    /*@DeleteMapping("/MEMBER_/{id}")
    public Map < String, Boolean > deleteMember(@PathVariable(value = "id") Long MEMBER_ID) throws ResourceNotFoundException
    {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        repo.delete(member);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
        /*@PutMapping("/MEMBER_/{id}")
    public ResponseEntity<Member> updateBalance(@PathVariable(value = "id") Long MEMBER_ID, @Valid @RequestBody Member memberDetails) throws ResourceNotFoundException
    {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));

        //member.setFirst_name(memberDetails.getFirst_name());
        //member.setLast_name(memberDetails.getLast_name());
        //member.setActivation_date(memberDetails.getActivation_date());
        member.setCurrency(memberDetails.getCurrency());
        //member.setPlays(memberDetails.getPlays());
        final Member updatedMember = repo.save(member);
        return ResponseEntity.ok(updatedMember);
    }*/

}
