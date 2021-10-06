package za.ac.nwu.ac.web.sb.endpoints.unit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.UpdateMemberService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateMemberServiceTest
{
    @Mock
    private Member_Repo userRepository;

    @InjectMocks
    private UpdateMemberService updateUserService;

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() throws ResourceNotFoundException {
       Member user = new Member();
                user.setId(89L);
                user.setCurrency(50);


        Member newUser = new Member();
                user.setCurrency(user.getCurrency()-5);

        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));
        updateUserService.updateMember(user.getId(),newUser.getCurrency());

        verify(userRepository).save(newUser);
        verify(userRepository).findById(user.getId());
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() throws ResourceNotFoundException {
        Member user = new Member();
                user.setId(89L);
                user.setCurrency(50);
                
        Member newUser = new Member();
        newUser.setId(90L);
        user.setCurrency(user.getCurrency()-5);


        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        updateUserService.updateMember(user.getId(), newUser.getCurrency());
    }
}
