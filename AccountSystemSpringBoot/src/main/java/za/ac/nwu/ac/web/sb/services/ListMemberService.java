package za.ac.nwu.ac.web.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;

import java.util.List;

@Service
public class ListMemberService {
    @Autowired
    Member_Repo repo;
    public List<Member> listAllMembers() {
        return repo.findAll();
    }
}
