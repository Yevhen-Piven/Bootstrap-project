package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.yevhenpiven.bootstrapproject.BootstrapprojectApplication;
import com.yevhenpiven.bootstrapproject.controller.service.CourseService;
import com.yevhenpiven.bootstrapproject.entity.Course;
import com.yevhenpiven.bootstrapproject.repository.CourseRepository;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@ActiveProfiles("test")
class CourseServiceTest {
    private static final String FIRST_TEST_COURSE_NAME = "Course 1";
    private static final String FIRST_TEST_COURSE_DESCRIPTION = "Descrription 1";
    private static final int FIRS_TEST_COURSE_ID = 1;
    private static final String SECOND_TEST_COURSE_NAME = "Course 2";
    private static final String SECOND_TEST_COURSE_DESCRIPTION = "Descrription 2";
    private static final int SECOND_TEST_COURSE_ID = 2;

    @Mock
    private CourseRepository courseRepositoryMock;

    @InjectMocks
    private CourseService courseService;

    @Test
    public void testFindAll() {
        List<Course> expectedCourses = Arrays.asList(
                new Course(FIRS_TEST_COURSE_ID, FIRST_TEST_COURSE_NAME, FIRST_TEST_COURSE_DESCRIPTION),
                new Course(SECOND_TEST_COURSE_ID, SECOND_TEST_COURSE_NAME, SECOND_TEST_COURSE_DESCRIPTION));
        when(courseRepositoryMock.findAll()).thenReturn(expectedCourses);
        List<Course> actualCourses = courseService.findAll();
        assertEquals(expectedCourses.size(), actualCourses.size());
    }

    @Test
    public void testFindById() {
        Course expectedCourse = new Course(FIRS_TEST_COURSE_ID, FIRST_TEST_COURSE_NAME, FIRST_TEST_COURSE_DESCRIPTION);
        when(courseRepositoryMock.findById(FIRS_TEST_COURSE_ID)).thenReturn(Optional.of(expectedCourse));
        Optional<Course> actualCourse = courseService.findById(FIRS_TEST_COURSE_ID);
        assertTrue(actualCourse.isPresent());
        assertEquals(expectedCourse, actualCourse.get());
    }

    @Test
    public void testSave() {
        Course courseTest = new Course(FIRS_TEST_COURSE_ID, FIRST_TEST_COURSE_NAME, FIRST_TEST_COURSE_DESCRIPTION);
        when(courseRepositoryMock.save(courseTest)).thenReturn(courseTest);
        Course courseSaved = courseService.save(courseTest);
        assertNotNull(courseSaved);
        assertEquals(FIRST_TEST_COURSE_NAME, courseSaved.getCourseName());
    }

    @Test
    public void testDeleteById() {
        courseService.deleteById(FIRS_TEST_COURSE_ID);
        verify(courseRepositoryMock).deleteById(FIRS_TEST_COURSE_ID);
    }
}
