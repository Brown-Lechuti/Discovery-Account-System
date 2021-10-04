package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.web.sb.services.CreateMemberService;

import java.net.URI;

@RestController
@RequestMapping("/MEMBER_")
public class CreateMemberAccount {
    @Autowired
    CreateMemberService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Member> createNewMember_whenPostMember(@RequestBody Member member) {
        Member createdMember = service.createNewMember(member);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdMember.getId()).toUri();
        return ResponseEntity.created(uri).body(createdMember);
    }
}

