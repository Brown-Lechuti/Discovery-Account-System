package za.ac.nwu.ac.web.sb.endpoints.unit.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.web.sb.controllers.ViewMiles;
import za.ac.nwu.ac.web.sb.exceptions.ResourceNotFoundException;
import za.ac.nwu.ac.web.sb.services.DetailMemberService;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ViewMiles.class)
public class ViewMilesTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DetailMemberService detailUserService;

    @Test
    public void listUserById_whenGetMethod() throws Exception {

        Member user = new Member();
        user.setFirst_name("Name");
        user.setLast_name("Surname");
        user.setActivation_date("2021-10-02");
        user.setCurrency(150);
        user.setPlays(5);
        user.setId(89L);

        given(detailUserService.listMember(user.getId())).willReturn(user);

        mvc.perform(get("/MEMBER_/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.first_name", is(user.getFirst_name())));
    }

    @Test
    public void should_throw_exception_when_user_doesnt_exist() throws Exception {
        Member user = new Member();
        user.setId(89L);
        user.setFirst_name("Name");
        user.setLast_name("Surname");
        user.setActivation_date("2021-10-02");
        user.setCurrency(150);
        user.setPlays(5);

        Mockito.doThrow(new ResourceNotFoundException("Member account not found for this id :: "+user.getId())).when(detailUserService).listMember(user.getId());

        mvc.perform(get("/MEMBER_/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
