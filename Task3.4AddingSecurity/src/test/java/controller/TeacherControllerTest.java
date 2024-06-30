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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.yevhenpiven.bootstrapproject.BootstrapprojectApplication;

import entity.Teacher;
import service.TeacherService;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
class TeacherControllerTest {
    private static final int FIRST_TEST_TEACHER_ID = 1;
    private static final String FIRST_TEST_TEACHER_SURNAME = "Teacher sur 1";
    private static final String FIRST_TEST_TEACHER_NAME = "Teacher 1";
    private static final int SECOND_TEST_TEACHER_ID = 2;
    private static final String SECOND_TEST_TEACHER_NAME = "Teacher 2";
    private static final String SECOND_TEST_TEACHER_SURNAME = "Teacher sur 2";
    private static final int FIRST_TEST_DEPARTMENT_ID = 1;
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeacherService teacherService;

    @Test
    public void testGetAllTeachers() throws Exception {
        Teacher teacher1 = new Teacher(FIRST_TEST_TEACHER_ID, FIRST_TEST_DEPARTMENT_ID, FIRST_TEST_TEACHER_NAME,
                FIRST_TEST_TEACHER_SURNAME);
        Teacher teacher2 = new Teacher(SECOND_TEST_TEACHER_ID, SECOND_TEST_DEPARTMENT_ID, SECOND_TEST_TEACHER_NAME,
                SECOND_TEST_TEACHER_SURNAME);
        List<Teacher> allTeachers = Arrays.asList(teacher1, teacher2);

        given(teacherService.findAll()).willReturn(allTeachers);

        mvc.perform(MockMvcRequestBuilders.get("/").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
