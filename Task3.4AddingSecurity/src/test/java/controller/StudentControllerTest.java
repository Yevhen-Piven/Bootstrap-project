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

import entity.Student;
import service.StudentService;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
public class StudentControllerTest {

    private static final int FIRST_TEST_STUDENT_ID = 1;
    private static final String FIRST_TEST_STUDENT_SURNAME = "Student sur 1";
    private static final String FIRST_TEST_STUDENT_NAME = "Student 1";
    private static final int SECOND_TEST_STUDENT_ID = 2;
    private static final String SECOND_TEST_STUDENT_NAME = "Student 2";
    private static final String SECOND_TEST_STUDENT_SURNAME = "Student sur 2";
    private static final int FIRST_TEST_GROUP_ID = 1;
    private static final int SECOND_TEST_GROUP_ID = 2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testListStudents() throws Exception {
        Student student1 = new Student(FIRST_TEST_STUDENT_ID, FIRST_TEST_GROUP_ID, FIRST_TEST_STUDENT_NAME,
                FIRST_TEST_STUDENT_SURNAME);
        Student student2 = new Student(SECOND_TEST_STUDENT_ID, SECOND_TEST_GROUP_ID, SECOND_TEST_STUDENT_NAME,
                SECOND_TEST_STUDENT_SURNAME);
        List<Student> students = Arrays.asList(student1, student2);
        given(studentService.findAll()).willReturn(students);

        mvc.perform(MockMvcRequestBuilders.get("/").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
