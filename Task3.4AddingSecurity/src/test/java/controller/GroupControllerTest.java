package controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import entity.Group;
import service.GroupService;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
class GroupControllerTest {
    private static final int FIRS_TEST_GROUP_ID = 1;
    private static final String FIRST_TEST_GROUP_NAME = "Group 1";
    private static final int SECOND_TEST_GROUP_ID = 2;
    private static final String SECOND_TEST_GROUP_NAME = "Group 2";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GroupService groupService;

    @Test
    public void testGetAllGroups() throws Exception {
        Group group1 = new Group(FIRS_TEST_GROUP_ID, FIRST_TEST_GROUP_NAME);
        Group group2 = new Group(SECOND_TEST_GROUP_ID, SECOND_TEST_GROUP_NAME);
        List<Group> allGroups = Arrays.asList(group1, group2);

        given(groupService.findAll()).willReturn(allGroups);

        mvc.perform(MockMvcRequestBuilders.get("/api/groups").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].groupId").value(group1.getGroupId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].groupName").value(group1.getGroupName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].groupId").value(group2.getGroupId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].groupName").value(group2.getGroupName()));
    }
}
