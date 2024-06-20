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

import entity.Classroom;
import service.ClassroomService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClassroomController.class)
class ClassroomControllerTest {
    private static final String FIRSR_TEST_CLASSROOM_NAME = "Classroom 1";
    private static final String SECOND_TEST_CLASSROOM_NAME = "Classroom 2";
    private static final int FIRS_TEST_CLASSROOM_ID = 1;
    private static final int SECOND_TEST_CLASSROOM_ID = 2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClassroomService classroomService;

    @Test
    public void testGetAllClassrooms() throws Exception {
        Classroom classroom1 = new Classroom(FIRS_TEST_CLASSROOM_ID, FIRSR_TEST_CLASSROOM_NAME);
        Classroom classroom2 = new Classroom(SECOND_TEST_CLASSROOM_ID, SECOND_TEST_CLASSROOM_NAME);
        List<Classroom> allClassrooms = Arrays.asList(classroom1, classroom2);

        given(classroomService.findAll()).willReturn(allClassrooms);

        mvc.perform(MockMvcRequestBuilders.get("/api/classrooms").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].classroomId").value(classroom1.getClassroomId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].classroomName").value(classroom1.getClassroomName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].classroomId").value(classroom2.getClassroomId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].classroomName").value(classroom2.getClassroomName()));
    }
}
