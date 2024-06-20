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

import entity.Department;
import service.DepartmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    private static final int FIRS_TEST_DEPARTMENT_ID = 1;
    private static final String FIRST_TEST_DEPARTMENT_NAME = "Department 1";
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    private static final String SECOND_TEST_DEPARTMENT_NAME = "Department 2";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void testGetAllDepartments() throws Exception {
        Department department1 = new Department(FIRS_TEST_DEPARTMENT_ID, FIRST_TEST_DEPARTMENT_NAME);
        Department department2 = new Department(SECOND_TEST_DEPARTMENT_ID, SECOND_TEST_DEPARTMENT_NAME);
        List<Department> allDepartments = Arrays.asList(department1, department2);

        given(departmentService.findAll()).willReturn(allDepartments);

        mvc.perform(MockMvcRequestBuilders.get("/api/departments").contentType("application/json")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departmentId").value(department1.getDepartmentId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departmentName").value(department1.getDepartmentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].departmentId").value(department2.getDepartmentId()))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[1].departmentName").value(department2.getDepartmentName()));
    }
}
