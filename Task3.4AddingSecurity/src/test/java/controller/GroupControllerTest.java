package controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.yevhenpiven.bootstrapproject.BootstrapprojectApplication;
import com.yevhenpiven.bootstrapproject.entity.Group;
import com.yevhenpiven.bootstrapproject.service.GroupService;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
class GroupControllerTest {

    private static final int FIRST_TEST_GROUP_ID = 1;
    private static final String FIRST_TEST_GROUP_NAME = "Group 1";
    private static final int SECOND_TEST_GROUP_ID = 2;
    private static final String SECOND_TEST_GROUP_NAME = "Group 2";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GroupService groupService;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testListGroups() throws Exception {
        Group group1 = new Group(FIRST_TEST_GROUP_ID, FIRST_TEST_GROUP_NAME);
        Group group2 = new Group(SECOND_TEST_GROUP_ID, SECOND_TEST_GROUP_NAME);
        List<Group> allGroups = Arrays.asList(group1, group2);

        given(groupService.findAll()).willReturn(allGroups);

        mvc.perform(MockMvcRequestBuilders.get("/groups").contentType("text/html")).andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
