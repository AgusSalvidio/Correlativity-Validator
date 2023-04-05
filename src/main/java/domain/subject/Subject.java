package domain.subject;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Subject>correlativesSubjects;

    public Subject(String aName){
        this.name = aName;
        this.correlativesSubjects = new ArrayList<>();
    }

    public String name(){
        return name;
    }

    public Boolean hasCorrelatives(){
        return !correlativesSubjects.isEmpty();
    }

    public List<Subject> correlativesSubjects() {
        return correlativesSubjects;
    }

    //Done this way to deliver fast.... Should look for an initialization message to create with or without subjects
    public void addCorrelative(Subject aCorrelativeSubject){
        correlativesSubjects.add(aCorrelativeSubject);
    }
}
