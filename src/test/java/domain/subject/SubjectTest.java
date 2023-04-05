package domain.subject;

import org.junit.Assert;
import org.junit.Test;

public class SubjectTest {
    @Test
    public void createSubjectWithoutCorrelatives() {
        Subject subject = new Subject("Paradigmas");

        Assert.assertEquals("Paradigmas",subject.name());
        Assert.assertFalse(subject.hasCorrelatives());
    }

    @Test
    public void createSubjectWithCorrelatives() {
        Subject subjectWithoutCorrelatives = new Subject("Paradigmas");
        Subject subjectWithCorrelatives = new Subject("Sistemas Operativos");

        subjectWithCorrelatives.addCorrelative(subjectWithoutCorrelatives);

        Assert.assertEquals("Paradigmas",subjectWithoutCorrelatives.name());
        Assert.assertFalse(subjectWithoutCorrelatives.hasCorrelatives());
        Assert.assertTrue(subjectWithCorrelatives.hasCorrelatives());
        Assert.assertTrue(subjectWithCorrelatives.correlativesSubjects().contains(subjectWithoutCorrelatives));
    }
}
