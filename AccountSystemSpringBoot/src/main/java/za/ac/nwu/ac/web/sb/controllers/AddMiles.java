package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AddMiles
{
    @Autowired
    Member_Repo repo;

    @PatchMapping("MEMBER_/{id}/{currency_available}")
    public ResponseEntity<Member> addMiles(@PathVariable(value = "id") Long MEMBER_ID, @PathVariable(value = "currency_available") Integer currency_available) throws ResourceNotFoundException {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        int newCurrency = member.getCurrency() + currency_available;//Increment member's currency (current number of miles balance) with newly earned miles
        member.setCurrency(newCurrency);
        final Member updatedMember = repo.save(member);
        return ResponseEntity.ok(updatedMember);
    }

}
