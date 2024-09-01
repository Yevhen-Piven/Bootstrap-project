package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.yevhenpiven.bootstrapproject.controller.service.ClassroomService;
import com.yevhenpiven.bootstrapproject.entity.Classroom;
import com.yevhenpiven.bootstrapproject.repository.ClassroomRepository;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@ActiveProfiles("test")
class ClassromServiceTest {

    @Mock
    private ClassroomRepository classroomRepositoryMock;

    @InjectMocks
    private ClassroomService classroomService;
    private static final String FIRSR_TEST_CLASSROOM_NAME = "Classroom 1";
    private static final String SECOND_TEST_CLASSROOM_NAME = "Classroom 2";
    private static final int FIRS_TEST_CLASSROOM_ID = 1;
    private static final int SECOND_TEST_CLASSROOM_ID = 2;

    @Test
    public void testFindAll() {

        List<Classroom> expectedClassrooms = Arrays.asList(
                new Classroom(FIRS_TEST_CLASSROOM_ID, FIRSR_TEST_CLASSROOM_NAME),
                new Classroom(SECOND_TEST_CLASSROOM_ID, SECOND_TEST_CLASSROOM_NAME));
        when(classroomRepositoryMock.findAll()).thenReturn(expectedClassrooms);
        List<Classroom> actualClassrooms = classroomService.findAll();
        assertEquals(expectedClassrooms.size(), actualClassrooms.size());
    }

    @Test
    public void testFindById() {
        Classroom expectedClassroom = new Classroom(FIRS_TEST_CLASSROOM_ID, FIRSR_TEST_CLASSROOM_NAME);
        when(classroomRepositoryMock.findById(FIRS_TEST_CLASSROOM_ID)).thenReturn(Optional.of(expectedClassroom));
        Optional<Classroom> actualClassroom = classroomService.findById(FIRS_TEST_CLASSROOM_ID);
        assertTrue(actualClassroom.isPresent());
        assertEquals(expectedClassroom, actualClassroom.get());
    }

    @Test
    public void testSave() {
        Classroom classroomTest = new Classroom(FIRS_TEST_CLASSROOM_ID, FIRSR_TEST_CLASSROOM_NAME);
        when(classroomRepositoryMock.save(classroomTest)).thenReturn(classroomTest);
        Classroom savedClassroom = classroomService.save(classroomTest);
        assertNotNull(savedClassroom);
        assertEquals(FIRSR_TEST_CLASSROOM_NAME, savedClassroom.getClassroomName());
    }

    @Test
    public void testDeleteById() {
        classroomService.deleteById(FIRS_TEST_CLASSROOM_ID);
        assertFalse(classroomService.findById(FIRS_TEST_CLASSROOM_ID).isPresent());
    }
}
