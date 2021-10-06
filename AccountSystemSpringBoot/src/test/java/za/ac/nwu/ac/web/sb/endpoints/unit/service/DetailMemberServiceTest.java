package za.ac.nwu.ac.web.sb.endpoints.unit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.DetailMemberService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMemberServiceTest {

    @Mock
    private Member_Repo repo;

    @InjectMocks
    private DetailMemberService detailUserService;

    @Test
    public void whenGivenId_shouldReturnUser_ifFound() throws ResourceNotFoundException {
        Member user = new Member();
        user.setId(89L);

        when(repo.findById(user.getId())).thenReturn(Optional.of(user));

        Member expected = detailUserService.listMember(user.getId());

        assertThat(expected).isSameAs(user);
        verify(repo).findById(user.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void should_throw_exception_when_user_doesnt_exist() throws ResourceNotFoundException {
        Member user = new Member();
        user.setId(89L);
        user.setFirst_name("Name");
        user.setLast_name("Surname");
        user.setActivation_date("2021-10-02");
        user.setCurrency(150);
        user.setPlays(5);

        given(repo.findById(anyLong())).willReturn(Optional.ofNullable(null));
        detailUserService.listMember(user.getId());
    }
}
