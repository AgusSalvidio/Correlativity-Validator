package domain.inscription;

import domain.student.Student;
import domain.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InscriptionTest {
    @Test
    public void successfulInscriptionForSubjectWithoutCorrelatives(){
        Subject completedSubject = new Subject("Paradigmas");
        List<Subject> completedSubjects = new ArrayList<>();
        completedSubjects.add(completedSubject);
        Student student = new Student("Eze",completedSubjects);

        Subject subjectWithoutCorrelatives = new Subject("Análisis Matemático 1");
        List<Subject> enrollSubjects = new ArrayList<>();
        enrollSubjects.add(subjectWithoutCorrelatives);

        Inscription inscription = new Inscription(student,enrollSubjects);

        Assert.assertEquals(student,inscription.student());
        Assert.assertEquals(enrollSubjects,inscription.enrollSubjects());
        Assert.assertTrue(inscription.isApproved());
    }

    @Test
    public void successfulInscriptionForSubjectWithCorrelatives(){
        Subject completedSubject = new Subject("Paradigmas");
        List<Subject> completedSubjects = new ArrayList<>();
        completedSubjects.add(completedSubject);
        Student student = new Student("Eze",completedSubjects);

        Subject subjectWithCorrelatives = new Subject("Sistemas Operativos");
        List<Subject> enrollSubjects = new ArrayList<>();
        subjectWithCorrelatives.addCorrelative(completedSubject);
        enrollSubjects.add(subjectWithCorrelatives);

        Inscription inscription = new Inscription(student,enrollSubjects);

        Assert.assertEquals(student,inscription.student());
        Assert.assertEquals(enrollSubjects,inscription.enrollSubjects());
        Assert.assertTrue(inscription.isApproved());
    }
    @Test
    public void unSuccessfulInscriptionForSubjectWithCorrelatives(){
        Subject completedSubject = new Subject("Paradigmas");
        List<Subject> completedSubjects = new ArrayList<>();
        completedSubjects.add(completedSubject);

        Subject anotherSubject = new Subject("Fisica 1");
        List<Subject> anotherSubjects = new ArrayList<>();
        anotherSubjects.add(anotherSubject);

        Student student = new Student("Eze",anotherSubjects);

        Subject subjectWithCorrelatives = new Subject("Sistemas Operativos");
        List<Subject> enrollSubjects = new ArrayList<>();
        subjectWithCorrelatives.addCorrelative(completedSubject);
        enrollSubjects.add(subjectWithCorrelatives);

        Inscription inscription = new Inscription(student,enrollSubjects);

        Assert.assertEquals(student,inscription.student());
        Assert.assertEquals(enrollSubjects,inscription.enrollSubjects());
        Assert.assertFalse(inscription.isApproved());
    }
    @Test
    public void unSuccessfulInscriptionForSubjectAlreadyCompleted(){
        Subject completedSubject = new Subject("Paradigmas");
        List<Subject> completedSubjects = new ArrayList<>();
        completedSubjects.add(completedSubject);


        Student student = new Student("Eze",completedSubjects);

        List<Subject> enrollSubjects = new ArrayList<>();
        enrollSubjects.add(completedSubject);

        Inscription inscription = new Inscription(student,enrollSubjects);

        Assert.assertEquals(student,inscription.student());
        Assert.assertEquals(enrollSubjects,inscription.enrollSubjects());
        Assert.assertFalse(inscription.isApproved());
    }
}
