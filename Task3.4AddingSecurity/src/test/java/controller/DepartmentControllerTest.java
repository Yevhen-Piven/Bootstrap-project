package controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import com.yevhenpiven.bootstrapproject.entity.Department;
import com.yevhenpiven.bootstrapproject.service.DepartmentService;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@AutoConfigureMockMvc
class DepartmentControllerTest {

    private static final int FIRST_TEST_DEPARTMENT_ID = 1;
    private static final String FIRST_TEST_DEPARTMENT_NAME = "Department 1";
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    private static final String SECOND_TEST_DEPARTMENT_NAME = "Department 2";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testListDepartments() throws Exception {
        Department department1 = new Department(FIRST_TEST_DEPARTMENT_ID, FIRST_TEST_DEPARTMENT_NAME);
        Department department2 = new Department(SECOND_TEST_DEPARTMENT_ID, SECOND_TEST_DEPARTMENT_NAME);
        List<Department> allDepartments = Arrays.asList(department1, department2);

        given(departmentService.findAll()).willReturn(allDepartments);

        mvc.perform(MockMvcRequestBuilders.get("/departments").contentType("text/html")).andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
