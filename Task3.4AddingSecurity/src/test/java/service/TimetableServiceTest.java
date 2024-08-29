package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.yevhenpiven.bootstrapproject.BootstrapprojectApplication;

import entity.Timetable;
import repository.TimetableRepository;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@ActiveProfiles("test")
public class TimetableServiceTest {

    private static final int FIRST_TEST_TIMETABLE_ID = 1;
    private static final LocalDate TEST_DATE = LocalDate.now();
    private static final LocalTime TEST_START_TIME = LocalTime.of(9, 0);
    private static final LocalTime TEST_END_TIME = LocalTime.of(10, 0);

    @Mock
    private TimetableRepository timetableRepository;

    @InjectMocks
    private TimetableService timetableService;

    @Test
    public void testFindAll() {
        Timetable timetable1 = new Timetable(FIRST_TEST_TIMETABLE_ID, TEST_DATE, TEST_START_TIME, TEST_END_TIME, null,
                null);
        Timetable timetable2 = new Timetable(FIRST_TEST_TIMETABLE_ID + 1, TEST_DATE.plusDays(1),
                TEST_START_TIME.plusHours(1), TEST_END_TIME.plusHours(1), null, null);
        List<Timetable> expectedTimetables = Arrays.asList(timetable1, timetable2);

        when(timetableRepository.findAll()).thenReturn(expectedTimetables);

        List<Timetable> actualTimetables = timetableService.findAll();

        assertNotNull(actualTimetables);
        assertEquals(expectedTimetables.size(), actualTimetables.size());
        assertEquals(expectedTimetables, actualTimetables);
    }

    @Test
    public void testFindById() {
        Timetable expectedTimetable = new Timetable(FIRST_TEST_TIMETABLE_ID, TEST_DATE, TEST_START_TIME, TEST_END_TIME,
                null, null);

        when(timetableRepository.findById(FIRST_TEST_TIMETABLE_ID)).thenReturn(Optional.of(expectedTimetable));

        Optional<Timetable> actualTimetable = timetableService.findById(FIRST_TEST_TIMETABLE_ID);

        assertTrue(actualTimetable.isPresent());
        assertEquals(expectedTimetable, actualTimetable.get());
    }

    @Test
    public void testSave() {
        Timetable timetableToSave = new Timetable(FIRST_TEST_TIMETABLE_ID, TEST_DATE, TEST_START_TIME, TEST_END_TIME,
                null, null);

        when(timetableRepository.save(any(Timetable.class))).thenReturn(timetableToSave);

        Timetable savedTimetable = timetableService.save(timetableToSave);

        assertNotNull(savedTimetable);
        assertEquals(timetableToSave, savedTimetable);
    }

    @Test
    public void testDeleteById() {
        timetableService.deleteById(FIRST_TEST_TIMETABLE_ID);

        verify(timetableRepository, times(1)).deleteById(FIRST_TEST_TIMETABLE_ID);
    }
}