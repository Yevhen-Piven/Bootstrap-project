package controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.yevhenpiven.bootstrapproject.BootstrapprojectApplication;

import entity.Timetable;
import service.TimetableService;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
public class TimetableControllerTest {

    private static final int FIRST_TEST_TIMETABLE_ID = 1;
    private static final int SECOND_TEST_TIMETABLE_ID = 2;
    private static final int FIRST_TEST_COURSE_ID = 1;
    private static final int SECOND_TEST_COURSE_ID = 2;
    private static final int FIRST_TEST_DEPARTMENT_ID = 1;
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    private static final String FIRST_TEST_DATE = "2023-06-01";
    private static final String FIRST_TEST_START_TIME = "09:00:00";
    private static final String FIRST_TEST_END_TIME = "10:00:00";
    private static final String SECOND_TEST_DATE = "2023-06-02";
    private static final String SECOND_TEST_START_TIME = "10:00:00";
    private static final String SECOND_TEST_END_TIME = "11:00:00";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TimetableService timetableService;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testListTimetables() throws Exception {
       
        Timetable timetable1 = new Timetable(FIRST_TEST_TIMETABLE_ID, Date.valueOf(FIRST_TEST_DATE),
                Time.valueOf(FIRST_TEST_START_TIME), Time.valueOf(FIRST_TEST_END_TIME), FIRST_TEST_COURSE_ID,
                FIRST_TEST_DEPARTMENT_ID);
        Timetable timetable2 = new Timetable(SECOND_TEST_TIMETABLE_ID, Date.valueOf(SECOND_TEST_DATE),
                Time.valueOf(SECOND_TEST_START_TIME), Time.valueOf(SECOND_TEST_END_TIME), SECOND_TEST_COURSE_ID,
                SECOND_TEST_DEPARTMENT_ID);
        List<Timetable> timetables = Arrays.asList(timetable1, timetable2);

        given(timetableService.findAll()).willReturn(timetables);

        mvc.perform(MockMvcRequestBuilders.get("/").contentType("text/html")).andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
