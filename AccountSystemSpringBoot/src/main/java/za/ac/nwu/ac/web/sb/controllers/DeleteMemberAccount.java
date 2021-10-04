package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.DeleteMemberService;

@RestController
@RequestMapping("/MEMBER_/{id}")
public class DeleteMemberAccount {
    @Autowired
    DeleteMemberService service;
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser_whenDeleteUser(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteMember(id);
    }
}

