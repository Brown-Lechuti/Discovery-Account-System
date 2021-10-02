package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeleteMemberAccount {
    @Autowired
    Member_Repo repo;
    @DeleteMapping("/MEMBER_/{id}")
    public Map< String, Boolean > deleteMember(@PathVariable(value = "id") Long MEMBER_ID) throws ResourceNotFoundException
    {
        Member member = repo.findById(MEMBER_ID).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + MEMBER_ID));
        repo.delete(member);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
