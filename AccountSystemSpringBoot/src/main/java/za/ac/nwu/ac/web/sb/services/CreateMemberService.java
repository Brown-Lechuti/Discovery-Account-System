package za.ac.nwu.ac.web.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;


@Service
public class CreateMemberService {
    @Autowired
    Member_Repo repo;

    public Member createNewMember(Member user) {
        return repo.save(user);
    }
}