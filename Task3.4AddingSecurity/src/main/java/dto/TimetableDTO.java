package dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TimetableDTO {

    private Integer timetableId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private Integer teacherId;
    private String teacherName;
    private String teacherSurname;
    private Integer roomId;
    private String roomNumber;
    private Integer roomCapacity;
    private Integer groupId;
    private String groupName;
    private Integer departmentId;
    private String departmentName;
    private Integer studentId;
    private String studentName;
    private String studentSurname;
}
