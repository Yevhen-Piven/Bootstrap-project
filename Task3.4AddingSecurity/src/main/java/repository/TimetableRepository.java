package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dto.TimetableDTO;
import entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    @Query("SELECT new dto.TimetableDTO(t.timetableId, t.date, t.startTime, t.endTime, "
            + "c.courseId, c.courseName, c.description, " 
            + "te.teacherId, te.name, te.surname, "
            + "cl.roomId, cl.roomNumber, cl.capacity, " 
            + "g.groupId, g.groupName, "
            + "d.departmentId, d.departmentName, " 
            + "s.studentId, s.name, s.surname) " 
            + "FROM Timetable t "
            + "JOIN t.course c " 
            + "JOIN c.teacher te " 
            + "JOIN c.students s " 
            + "JOIN s.group g "
            + "JOIN te.department d " 
            + "JOIN t.classroom cl " 
            + "WHERE t.date = :date")
    List<TimetableDTO> findTimetableByDate(@Param("date") LocalDate date);
}
