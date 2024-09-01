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
import com.yevhenpiven.bootstrapproject.controller.service.ClassroomService;
import com.yevhenpiven.bootstrapproject.entity.Classroom;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
class ClassroomControllerTest {

    private static final int FIRST_TEST_CLASSROOM_ID = 1;
    private static final String FIRST_TEST_CLASSROOM_NAME = "Classroom 1";
    private static final int SECOND_TEST_CLASSROOM_ID = 2;
    private static final String SECOND_TEST_CLASSROOM_NAME = "Classroom 2";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClassroomService classroomService;

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    public void testListClassroomsWithUserRole() throws Exception {

        Classroom classroom1 = new Classroom(FIRST_TEST_CLASSROOM_ID, FIRST_TEST_CLASSROOM_NAME);
        Classroom classroom2 = new Classroom(SECOND_TEST_CLASSROOM_ID, SECOND_TEST_CLASSROOM_NAME);
        List<Classroom> allClassrooms = Arrays.asList(classroom1, classroom2);

        given(classroomService.findAll()).willReturn(allClassrooms);

        mvc.perform(MockMvcRequestBuilders.get("/classrooms").contentType("text/html")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
