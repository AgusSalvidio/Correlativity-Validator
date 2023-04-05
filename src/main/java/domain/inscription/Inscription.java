package domain.inscription;

import domain.student.Student;
import domain.subject.Subject;

import java.util.List;

public class Inscription {
    private Student student;
    private List<Subject> enrollSubjects;

    public Inscription(Student aStudent,List<Subject> aEnrollSubjectCollection){
        this.student = aStudent;
        this.enrollSubjects = aEnrollSubjectCollection;
    }

    public Student student(){
        return student;
    }

    public List<Subject> enrollSubjects(){
        return enrollSubjects;
    }

    public Boolean isApproved(){
        List<Subject> completedSubjects = this.student().completedSubjects();

        for(Subject subject : enrollSubjects) {
            if(!completedSubjects.containsAll(subject.correlativesSubjects()) || completedSubjects.contains(subject))
                return false;
        }
        return true;
    }
}
