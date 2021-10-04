package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.UpdateMemberAdd;
import za.ac.nwu.ac.web.sb.services.UpdateMemberService;

import javax.validation.Valid;


@RestController
@RequestMapping("MEMBER_/{id}/{currency_available}")
public class AddMiles {
    @Autowired
    UpdateMemberAdd service;
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Member updateUser_whenPutUser(@PathVariable Long id, @PathVariable Integer currency_available) throws ResourceNotFoundException {
        return service.updateMemberA(id,currency_available);
    }
}
