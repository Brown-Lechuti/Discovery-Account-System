package za.ac.nwu.ac.web.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;

@Service
public class DeleteMemberService {
    @Autowired
    Member_Repo repo;
    public void deleteMember(Long id) throws ResourceNotFoundException {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member account not found for this id :: "+id));
        repo.deleteById(id);
    }
}
