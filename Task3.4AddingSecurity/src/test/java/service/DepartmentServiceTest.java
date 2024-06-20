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

import entity.Department;
import repository.DepartmentRepository;

@RunWith(MockitoJUnitRunner.class)
class DepartmentServiceTest {
    private static final int FIRS_TEST_DEPARTMENT_ID = 1;
    private static final String FIRST_TEST_DEPARTMENT_NAME = "Department 1";
    private static final int SECOND_TEST_DEPARTMENT_ID = 2;
    private static final String SECOND_TEST_DEPARTMENT_NAME = "Department 2";
    @Mock
    private DepartmentRepository departmentRepositoryMock;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void testFindAll() {
        List<Department> expectedDepartments = Arrays.asList(
                new Department(FIRS_TEST_DEPARTMENT_ID, FIRST_TEST_DEPARTMENT_NAME),
                new Department(SECOND_TEST_DEPARTMENT_ID, SECOND_TEST_DEPARTMENT_NAME));
        when(departmentRepositoryMock.findAll()).thenReturn(expectedDepartments);
        List<Department> actualDepartments = departmentService.findAll();
        assertEquals(expectedDepartments.size(), actualDepartments.size());
    }

    @Test
    public void testFindById() {
        Department expectedDepartment = new Department(FIRS_TEST_DEPARTMENT_ID, FIRST_TEST_DEPARTMENT_NAME);
        when(departmentRepositoryMock.findById(FIRS_TEST_DEPARTMENT_ID)).thenReturn(Optional.of(expectedDepartment));
        Optional<Department> actualDepartment = departmentService.findById(FIRS_TEST_DEPARTMENT_ID);
        assertTrue(actualDepartment.isPresent());
        assertEquals(expectedDepartment, actualDepartment.get());
    }

    @Test
    public void testSave() {
        Department departmentToSave = new Department(FIRS_TEST_DEPARTMENT_ID, FIRST_TEST_DEPARTMENT_NAME);
        Department savedDepartment = departmentService.save(departmentToSave);
        assertNotNull(savedDepartment);
        assertEquals(departmentToSave.getDepartmentName(), savedDepartment.getDepartmentName());
    }

    @Test
    public void testDeleteById() {
        departmentService.deleteById(FIRS_TEST_DEPARTMENT_ID);
        verify(departmentRepositoryMock).deleteById(FIRS_TEST_DEPARTMENT_ID);
    }
}
