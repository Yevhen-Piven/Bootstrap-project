package entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "timetable")
@Builder
public class Timetable {

    public Timetable(int firsTestTimetableId, Date valueOf, Time valueOf2, Time valueOf3, int firsTestCourseId,
            int firsTestDepartmentId) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableId;
    @Column(name = "timetable_date")
    private Date date;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "room_id")
    private int roomId;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Classroom classroom;
}
