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

import entity.Course;
import service.CourseService;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
class CourseControllerTest {
    private static final String FIRST_TEST_COURSE_NAME = "Course 1";
    private static final String FIRST_TEST_COURSE_DESCRIPTION = "Descrription 1";
    private static final int FIRS_TEST_COURSE_ID = 1;
    private static final String SECOND_TEST_COURSE_NAME = "Course 2";
    private static final String SECOND_TEST_COURSE_DESCRIPTION = "Descrription 2";
    private static final int SECOND_TEST_COURSE_ID = 2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void testGetAllCourses() throws Exception {
        Course course1 = new Course(FIRS_TEST_COURSE_ID, FIRST_TEST_COURSE_NAME, FIRST_TEST_COURSE_DESCRIPTION);
        Course course2 = new Course(SECOND_TEST_COURSE_ID, SECOND_TEST_COURSE_NAME, SECOND_TEST_COURSE_DESCRIPTION);
        List<Course> allCourses = Arrays.asList(course1, course2);

        given(courseService.findAll()).willReturn(allCourses);

        mvc.perform(MockMvcRequestBuilders.get("/api/courses").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseId").value(course1.getCourseId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseName").value(course1.getCourseName()))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[0].courseDescription").value(course1.getCourseDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].courseId").value(course2.getCourseId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].courseName").value(course2.getCourseName())).andExpect(
                        MockMvcResultMatchers.jsonPath("$[1].courseDescription").value(course2.getCourseDescription()));
    }
}
