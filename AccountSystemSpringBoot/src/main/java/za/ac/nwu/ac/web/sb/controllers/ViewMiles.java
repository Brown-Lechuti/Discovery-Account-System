package za.ac.nwu.ac.web.sb.controllers;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.nwu.ac.domain.service.GeneralResponse;*
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.DetailMemberService;


@RestController
@RequestMapping("/MEMBER_/{id}")
public class ViewMiles {
    @Autowired
    DetailMemberService service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Member> list(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(service.listMember(id));
    }
}

