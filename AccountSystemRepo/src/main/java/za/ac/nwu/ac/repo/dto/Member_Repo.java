package za.ac.nwu.ac.repo.dto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.Member;

@Repository
public interface Member_Repo extends JpaRepository<Member, Integer>
{

}
