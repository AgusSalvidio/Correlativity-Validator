package domain.student;

import domain.subject.Subject;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> completedSubjects;

    public Student(String aName, List<Subject> aSubjectCollection){
        this.name = aName;
        this.completedSubjects = aSubjectCollection;
    }
    public String name(){
        return name;
    }

    public List<Subject> completedSubjects(){
        return completedSubjects;
    }


}
