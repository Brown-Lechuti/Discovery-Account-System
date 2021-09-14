package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;



import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;

@RestController
@RequestMapping("/api")
public class MemberSignUp
{
    @Autowired
    Member_Repo repo;

    @GetMapping("/MEMBER_")
    public List < Member> getAllMembers()
    {
        return repo.findAll();
    }

    @GetMapping("/MEMBER_/{id}")
    public ResponseEntity < Member > getEmployeeById(@PathVariable(value = "id") Long MEMBER_ID) throws ResourceNotFoundException
    {
        Member member = repo.findById(MEMBER_ID).orElseThrow(() -> new ResourceNotFoundException("Member of this ID was not found:: " + MEMBER_ID));
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/MEMBER_")
    public Member createEmployee(@Valid @RequestBody Member member)
    {
        return repo.save(member);
    }

    @PutMapping("/MEMBER_/{id}")
    public ResponseEntity < Member > updateMember(@PathVariable(value = "id") Long MEMBER_ID,@Valid @RequestBody Member memberDetails) throws ResourceNotFoundException
    {
        Member member = repo.findById(MEMBER_ID).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));

        member.setFirst_name(memberDetails.getFirst_name());
        member.setLast_name(memberDetails.getLast_name());
        member.setActivation_date(memberDetails.getActivation_date());
        member.setCurrency(memberDetails.getCurrency());
        member.setPlays(memberDetails.getPlays());
        final Member updatedMember = repo.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/MEMBER_/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long MEMBER_ID) throws ResourceNotFoundException
    {
        Member member = repo.findById(MEMBER_ID).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        repo.delete(member);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
