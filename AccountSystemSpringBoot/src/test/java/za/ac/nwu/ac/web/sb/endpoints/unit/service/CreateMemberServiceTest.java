package za.ac.nwu.ac.web.sb.endpoints.unit.service;


import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.services.CreateMemberService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
 public class CreateMemberServiceTest
{
    @Mock
    private Member_Repo repo;
    @InjectMocks
    private CreateMemberService createMemberService;
    @Test
    public void createNewMember()
    {
        Member member = new Member();
        member.setFirst_name("Test");

        when(repo.save(ArgumentMatchers.any(Member.class))).thenReturn(member);

        Member created = createMemberService.createNewMember(member);

        assertThat(created.getFirst_name()).isSameAs(member.getFirst_name());
        verify(repo).save(member);
    }
}