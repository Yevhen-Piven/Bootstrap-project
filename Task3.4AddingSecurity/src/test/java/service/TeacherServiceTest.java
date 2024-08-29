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

import entity.Teacher;
import repository.TeacherRepository;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@ActiveProfiles("test")
class TeacherServiceTest {
    private static final int FIRS_TEST_TEACHER_ID = 1;
    private static final String FIRST_TEST_TEACHER_SURNAME = "Teacher sur 1";
    private static final String FIRST_TEST_TEACHER_NAME = "Teacher 1";
    private static final int SECOND_TEST_TEACHER_ID = 2;
    private static final String SECOND_TEST_TEACHER_NAME = "Teacher 2";
    private static final String SECOND_TEST_TEACHER_SURNAME = "Teacher sur 2";
    private static final int FIRS_TEST_DEPARTMENT_ID = 1;
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;

    @Mock
    private TeacherRepository teacherRepositoryMock;

    @InjectMocks
    private TeacherService teacherService;

    @Test
    public void testFindAll() {
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(FIRS_TEST_TEACHER_ID, FIRST_TEST_TEACHER_NAME, FIRST_TEST_TEACHER_SURNAME,
                        FIRS_TEST_DEPARTMENT_ID),
                new Teacher(SECOND_TEST_TEACHER_ID, SECOND_TEST_TEACHER_NAME, SECOND_TEST_TEACHER_SURNAME,
                        SECOND_TEST_DEPARTMENT_ID));
        when(teacherRepositoryMock.findAll()).thenReturn(expectedTeachers);
        List<Teacher> actualTeachers = teacherService.findAll();
        assertEquals(expectedTeachers.size(), actualTeachers.size());
    }

    @Test
    public void testFindById() {

        Teacher expectedTeacher = new Teacher(FIRS_TEST_TEACHER_ID, FIRST_TEST_TEACHER_NAME, FIRST_TEST_TEACHER_SURNAME,
                FIRS_TEST_DEPARTMENT_ID);
        when(teacherRepositoryMock.findById(FIRS_TEST_TEACHER_ID)).thenReturn(Optional.of(expectedTeacher));
        Optional<Teacher> actualTeacher = teacherService.findById(FIRS_TEST_TEACHER_ID);
        assertTrue(actualTeacher.isPresent());
        assertEquals(expectedTeacher, actualTeacher.get());
    }

    @Test
    public void testSave() {
        Teacher teacherToSave = new Teacher(FIRS_TEST_TEACHER_ID, FIRST_TEST_TEACHER_NAME, FIRST_TEST_TEACHER_SURNAME,
                FIRS_TEST_DEPARTMENT_ID);
        when(teacherRepositoryMock.save(teacherToSave)).thenReturn(teacherToSave);
        Teacher savedTeacher = teacherService.save(teacherToSave);
        assertNotNull(savedTeacher);
        assertEquals(FIRST_TEST_TEACHER_NAME, savedTeacher.getFirstName());
    }

    @Test
    public void testDeleteById() {
        teacherService.deleteById(FIRS_TEST_TEACHER_ID);
        verify(teacherRepositoryMock).deleteById(FIRS_TEST_TEACHER_ID);
    }
}
