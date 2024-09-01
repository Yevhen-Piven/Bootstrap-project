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
import com.yevhenpiven.bootstrapproject.controller.service.GroupService;
import com.yevhenpiven.bootstrapproject.entity.Group;
import com.yevhenpiven.bootstrapproject.repository.GroupRepository;

@SpringBootTest(classes = BootstrapprojectApplication.class)
@ActiveProfiles("test")
class GroupServiceTest {
    private static final int FIRS_TEST_GROUP_ID = 1;
    private static final String FIRST_TEST_GROUP_NAME = "Group 1";
    private static final int SECOND_TEST_GROUP_ID = 2;
    private static final String SECOND_TEST_GROUP_NAME = "Group 2";

    @Mock
    private GroupRepository groupRepositoryMock;

    @InjectMocks
    private GroupService groupService;

    @Test
    public void testFindAll() {
        List<Group> expectedGroups = Arrays.asList(new Group(FIRS_TEST_GROUP_ID, FIRST_TEST_GROUP_NAME),
                new Group(SECOND_TEST_GROUP_ID, SECOND_TEST_GROUP_NAME));
        when(groupRepositoryMock.findAll()).thenReturn(expectedGroups);
        List<Group> actualGroups = groupService.findAll();
        assertEquals(expectedGroups.size(), actualGroups.size());
    }

    @Test
    public void testFindById() {
        Group expectedGroup = new Group(FIRS_TEST_GROUP_ID, FIRST_TEST_GROUP_NAME);
        when(groupRepositoryMock.findById(FIRS_TEST_GROUP_ID)).thenReturn(Optional.of(expectedGroup));
        Optional<Group> actualGroup = groupService.findById(FIRS_TEST_GROUP_ID);
        assertTrue(actualGroup.isPresent());
        assertEquals(expectedGroup, actualGroup.get());
    }

    @Test
    public void testSave() {
        Group groupToSave = new Group(FIRS_TEST_GROUP_ID, FIRST_TEST_GROUP_NAME);
        when(groupRepositoryMock.save(groupToSave)).thenReturn(groupToSave);
        Group savedGroup = groupService.save(groupToSave);
        assertNotNull(savedGroup);
        assertEquals(FIRST_TEST_GROUP_NAME, savedGroup.getGroupName());
    }

    @Test
    public void testDeleteById() {
        groupService.deleteById(FIRS_TEST_GROUP_ID);
        verify(groupRepositoryMock).deleteById(FIRS_TEST_GROUP_ID);
    }
}
