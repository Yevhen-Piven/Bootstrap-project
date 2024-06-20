package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Teacher;
import lombok.RequiredArgsConstructor;
import repository.TeacherRepository;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
