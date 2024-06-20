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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import entity.Student;
import repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
class StudentServiceTest {
    private static final int FIRS_TEST_STUDENT_ID = 1;
    private static final String FIRST_TEST_STUDENT_SURNAME = "Student sur 1";
    private static final String FIRST_TEST_STUDENT_NAME = "Student 1";
    private static final int SECOND_TEST_STUDENT_ID = 2;
    private static final String SECOND_TEST_STUDENT_NAME = "Student 2";
    private static final String SECOND_TEST_STUDENT_SURNAME = "Student sur 2";
    private static final int FIRS_TEST_GROUP_ID = 1;
    private static final int SECOND_TEST_GROUP_ID = 2;

    @Mock
    private StudentRepository studentRepositoryMock;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testFindAll() {
        List<Student> expectedStudents = Arrays.asList(
                new Student(FIRS_TEST_STUDENT_ID, FIRS_TEST_GROUP_ID, FIRST_TEST_STUDENT_NAME,
                        FIRST_TEST_STUDENT_SURNAME),
                new Student(SECOND_TEST_STUDENT_ID, SECOND_TEST_GROUP_ID, SECOND_TEST_STUDENT_NAME,
                        SECOND_TEST_STUDENT_SURNAME));
        when(studentRepositoryMock.findAll()).thenReturn(expectedStudents);
        List<Student> actualStudents = studentService.findAll();
        assertEquals(expectedStudents.size(), actualStudents.size());
    }

    @Test
    public void testFindById() {
        Student expectedStudent = new Student(FIRS_TEST_STUDENT_ID, FIRS_TEST_GROUP_ID, FIRST_TEST_STUDENT_NAME,
                FIRST_TEST_STUDENT_SURNAME);
        when(studentRepositoryMock.findById(FIRS_TEST_STUDENT_ID)).thenReturn(Optional.of(expectedStudent));
        Optional<Student> actualStudent = studentService.findById(FIRS_TEST_STUDENT_ID);
        assertTrue(actualStudent.isPresent());
        assertEquals(expectedStudent, actualStudent.get());
    }

    @Test
    public void testSave() {
        Student studentToSave = new Student(FIRS_TEST_STUDENT_ID, FIRS_TEST_GROUP_ID, FIRST_TEST_STUDENT_NAME,
                FIRST_TEST_STUDENT_SURNAME);
        Student savedStudent = studentService.save(studentToSave);
        assertNotNull(savedStudent);
        assertEquals(studentToSave.getFirstName(), savedStudent.getFirstName());
    }

    @Test
    public void testDeleteById() {
        studentService.deleteById(FIRS_TEST_STUDENT_ID);
        verify(studentRepositoryMock).deleteById(FIRS_TEST_STUDENT_ID);
    }
}
