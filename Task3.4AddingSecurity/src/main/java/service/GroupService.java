package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Group;
import lombok.RequiredArgsConstructor;
import repository.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Integer id) {
        return groupRepository.findById(id);
    }

    @Transactional
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }
}
