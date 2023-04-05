package domain.student;

import domain.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    public void createStudent(){
        Subject subjectWithoutCorrelatives = new Subject("Paradigmas");
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subjectWithoutCorrelatives);

        Student student = new Student("Eze",subjects);

        Assert.assertEquals("Eze",student.name());
        Assert.assertFalse(student.completedSubjects().isEmpty());

    }
}
