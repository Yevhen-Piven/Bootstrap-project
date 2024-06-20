package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classroom")
public class Classroom {

    public Classroom(int classroomId, String classroomName) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;
    @Column(name = "classroom_name")
    private String classroomName;
    @OneToMany(mappedBy = "classroom")
    private List<Timetable> timetables;

}
