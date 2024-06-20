package controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.sql.Date;
import java.sql.Time;
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

import entity.Timetable;
import service.TimetableService;

@RunWith(SpringRunner.class)
@WebMvcTest(TimetableController.class)
class TimetableControllerTest {
    private static final int FIRS_TEST_TIMETABLE_ID = 1;
    private static final int SECOND_TEST_TIMETABLE_ID = 2;
    private static final int FIRS_TEST_COURSE_ID = 1;
    private static final int SECOND_TEST_COURSE_ID = 2;
    private static final int FIRS_TEST_DEPARTMENT_ID = 1;
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    private static final String FIRST_TEST_DATE = "2023-06-01";
    private static final String FIRST_TEST_START_TIME = "09:00:00";
    private static final String FIRST_TEST_TIME = "10:00:00";
    private static final String SECOND_TEST_DATE = "2023-06-02";
    private static final String SECOND_TEST_START_TIME = "10:00:00";
    private static final String SECOND_TEST_TIME = "11:00:00";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TimetableService timetableService;

    @Test
    public void testGetAllTimetables() throws Exception {
        Timetable timetable1 = new Timetable(FIRS_TEST_TIMETABLE_ID, Date.valueOf(FIRST_TEST_DATE),
                Time.valueOf(FIRST_TEST_START_TIME), Time.valueOf(FIRST_TEST_TIME), FIRS_TEST_COURSE_ID,
                FIRS_TEST_DEPARTMENT_ID);
        Timetable timetable2 = new Timetable(SECOND_TEST_TIMETABLE_ID, Date.valueOf(SECOND_TEST_DATE),
                Time.valueOf(SECOND_TEST_START_TIME), Time.valueOf(SECOND_TEST_TIME), SECOND_TEST_COURSE_ID,
                SECOND_TEST_DEPARTMENT_ID);
        List<Timetable> allTimetables = Arrays.asList(timetable1, timetable2);

        given(timetableService.findAll()).willReturn(allTimetables);

        mvc.perform(MockMvcRequestBuilders.get("/api/timetables").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].timetableId").value(timetable1.getTimetableId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value(timetable1.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].startTime").value(timetable1.getStartTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endTime").value(timetable1.getEndTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].timetableId").value(timetable2.getTimetableId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date").value(timetable2.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].startTime").value(timetable2.getStartTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].endTime").value(timetable2.getEndTime().toString()));
    }
}
