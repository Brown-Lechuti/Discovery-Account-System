package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.UpdateMemberService;


@RestController
@RequestMapping("MEMBER_/{id}/{currency_available}")
public class SubtractMiles {
    @Autowired
    UpdateMemberService service;
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Member updateUser_whenPutUser(@PathVariable Long id, @PathVariable Integer currency_available) throws ResourceNotFoundException {
        return service.updateMember(id,currency_available);
    }
}
/*@RestController
@RequestMapping("/api")
public class SubtractMiles {
    @Autowired
    Member_Repo repo;

    @PutMapping("MEMBER_/{id}/{currency_available}")
    public ResponseEntity<Member> subMiles(@PathVariable(value = "id") Long MEMBER_ID, @PathVariable(value = "currency_available") Integer currency_available) throws ResourceNotFoundException {
        Member member = repo.findById(MEMBER_ID).orElseThrow(() -> new ResourceNotFoundException("Member account not found for this id :: " + MEMBER_ID));
        member.setCurrency(member.getCurrency() - currency_available);
        final Member updatedEmployee = repo.save(member);
        return ResponseEntity.ok(updatedEmployee);
    }
}*/