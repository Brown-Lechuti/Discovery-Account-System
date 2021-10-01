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
public class SubtractMiles {
    @Autowired
    Member_Repo repo;

    @PutMapping("MEMBER_/{id}/{currency_available}")
    public ResponseEntity<Member> subMiles(@PathVariable(value = "id") Long MEMBER_ID, @PathVariable(value = "currency_available") Integer currency_available) throws ResourceNotFoundException {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        member.setCurrency(member.getCurrency() - currency_available);
        final Member updatedEmployee = repo.save(member);
        return ResponseEntity.ok(updatedEmployee);
    }
}