package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;

import java.util.List;

@RestController
public class ListMembers {

    @Autowired
    Member_Repo repo;
    @GetMapping("/MEMBER_")
    public List<Member> getAllMembers()
    {
        return repo.findAll();
    }
}
