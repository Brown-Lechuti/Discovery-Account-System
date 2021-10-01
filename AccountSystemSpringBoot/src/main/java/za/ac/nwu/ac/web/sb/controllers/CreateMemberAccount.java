package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;

import javax.validation.Valid;

@RestController
public class CreateMemberAccount {
    @Autowired
    Member_Repo repo;
    @PostMapping("/MEMBER_")
    public Member createMemberAccount(@Valid @RequestBody Member member)
    {
        return repo.save(member);
    }
}
