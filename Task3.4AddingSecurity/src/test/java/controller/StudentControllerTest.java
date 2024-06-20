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

import entity.Student;
import service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {
    private static final int FIRS_TEST_STUDENT_ID = 1;
    private static final String FIRST_TEST_STUDENT_SURNAME = "Student sur 1";
    private static final String FIRST_TEST_STUDENT_NAME = "Student 1";
    private static final int SECOND_TEST_STUDENT_ID = 2;
    private static final String SECOND_TEST_STUDENT_NAME = "Student 2";
    private static final String SECOND_TEST_STUDENT_SURNAME = "Student sur 2";
    private static final int FIRS_TEST_GROUP_ID = 1;
    private static final int SECOND_TEST_GROUP_ID = 2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student(FIRS_TEST_STUDENT_ID, FIRS_TEST_GROUP_ID, FIRST_TEST_STUDENT_NAME,
                FIRST_TEST_STUDENT_SURNAME);
        Student student2 = new Student(SECOND_TEST_STUDENT_ID, SECOND_TEST_GROUP_ID, SECOND_TEST_STUDENT_NAME,
                SECOND_TEST_STUDENT_SURNAME);
        List<Student> allStudents = Arrays.asList(student1, student2);

        given(studentService.findAll()).willReturn(allStudents);

        mvc.perform(MockMvcRequestBuilders.get("/api/students").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentId").value(student1.getStudentId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value(student1.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value(student1.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentId").value(student2.getStudentId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value(student2.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName").value(student2.getLastName()));
    }
}
