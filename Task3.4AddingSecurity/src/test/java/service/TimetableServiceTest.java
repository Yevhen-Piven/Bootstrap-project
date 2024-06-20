package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import dto.TimetableDTO;
import entity.Timetable;
import repository.TimetableRepository;

@RunWith(MockitoJUnitRunner.class)
class TimetableServiceTest {
    private static final int FIRS_TEST_TIMETABLE_ID = 1;
    private static final int SECOND_TEST_TIMETABLE_ID = 2;
    private static final int FIRS_TEST_COURSE_ID = 1;
    private static final int SECOND_TEST_COURSE_ID = 2;
    private static final int FIRS_TEST_DEPARTMENT_ID = 1;
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    @Mock
    private TimetableRepository timetableRepositoryMock;

    @InjectMocks
    private TimetableService timetableService;

    @Test
    public void testFindAll() {
        List<Timetable> expectedTimetables = Arrays.asList(
                new Timetable(FIRS_TEST_TIMETABLE_ID, new Date(System.currentTimeMillis()),
                        new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 3600000), 101, 202,
                        null, null),
                new Timetable(SECOND_TEST_TIMETABLE_ID, new Date(System.currentTimeMillis()),
                        new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 3600000), 102, 203,
                        null, null));
        when(timetableRepositoryMock.findAll()).thenReturn(expectedTimetables);
        List<Timetable> actualTimetables = timetableService.findAll();
        assertEquals(expectedTimetables.size(), actualTimetables.size());
    }

    @Test
    public void testFindById() {
        Timetable expectedTimetable = new Timetable(FIRS_TEST_TIMETABLE_ID, new Date(System.currentTimeMillis()),
                new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 3600000), 101, 202, null,
                null);
        when(timetableRepositoryMock.findById(FIRS_TEST_TIMETABLE_ID)).thenReturn(Optional.of(expectedTimetable));
        Optional<Timetable> actualTimetable = timetableService.findById(FIRS_TEST_TIMETABLE_ID);
        assertTrue(actualTimetable.isPresent());
        assertEquals(expectedTimetable, actualTimetable.get());
    }

    @Test
    public void testSave() {
        Timetable timetableToSave = new Timetable(FIRS_TEST_TIMETABLE_ID, new Date(System.currentTimeMillis()),
                new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 3600000), 101, 202, null,
                null);
        when(timetableRepositoryMock.save(timetableToSave)).thenReturn(timetableToSave);
        Timetable savedTimetable = timetableService.save(timetableToSave);
        assertNotNull(savedTimetable);
        assertEquals(timetableToSave.getDate(), savedTimetable.getDate());
    }

    @Test
    public void testDeleteById() {
        timetableService.deleteById(FIRS_TEST_TIMETABLE_ID);
        verify(timetableRepositoryMock).deleteById(FIRS_TEST_TIMETABLE_ID);
    }

    @Test
    public void testGetTimetableByDate() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        List<TimetableDTO> expectedTimetables = Arrays.asList(
                TimetableDTO.builder().timetableId(FIRS_TEST_TIMETABLE_ID).date(date).startTime(time).endTime(time)
                        .courseId(FIRS_TEST_COURSE_ID).departmentId(FIRS_TEST_DEPARTMENT_ID).build(),
                TimetableDTO.builder().timetableId(SECOND_TEST_TIMETABLE_ID).date(date).startTime(time).endTime(time)
                        .courseId(SECOND_TEST_COURSE_ID).departmentId(SECOND_TEST_DEPARTMENT_ID).build());
        when(timetableRepositoryMock.findTimetableByDate(date)).thenReturn(expectedTimetables);
        List<TimetableDTO> actualTimetables = timetableService.getTimetableByDate(date);
        assertEquals(expectedTimetables.size(), actualTimetables.size());
        assertEquals(expectedTimetables, actualTimetables);
    }
}