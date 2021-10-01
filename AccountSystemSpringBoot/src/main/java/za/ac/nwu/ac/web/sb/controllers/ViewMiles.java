package za.ac.nwu.ac.web.sb.controllers;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.nwu.ac.domain.service.GeneralResponse;*
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class ViewMiles
{
    @Autowired
    Member_Repo repo;

    @GetMapping("/MEMBER_/{id}")
    public ResponseEntity<Member> viewBalance(@PathVariable(value = "id") Long MEMBER_ID) throws ResourceNotFoundException
    {
        Member member = repo.findById(Math.toIntExact(MEMBER_ID)).orElseThrow(() -> new ResourceNotFoundException("Member of this ID was not found:: " + MEMBER_ID));
        return ResponseEntity.ok().body(member);
    }
}
