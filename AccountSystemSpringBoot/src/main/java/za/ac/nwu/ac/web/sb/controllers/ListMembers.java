package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.services.ListMemberService;

import java.util.List;


@RestController
@RequestMapping("/MEMBER_")
public class ListMembers {
    @Autowired
    ListMemberService service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Member>> listAllUsers_whenGetUsers() {
        return ResponseEntity.ok().body(service.listAllMembers());
    }
}
