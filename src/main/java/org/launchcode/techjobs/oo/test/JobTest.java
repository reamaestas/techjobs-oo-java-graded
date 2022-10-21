package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().toString());
        assertEquals("Desert", jobThree.getLocation().toString());
        assertEquals("Quality control", jobThree.getPositionType().toString());
        assertEquals("Persistence", jobThree.getCoreCompetency().toString());

        assertTrue(jobThree.getName() != null);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job jobFour = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobFive = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(jobFour == jobFive);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar,'\n');
        assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job.getId(), job.getName(), job.getEmployer(), job.getLocation(),
                job.getPositionType(), job.getCoreCompetency());
        assertEquals(output, job.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("Persistence"));
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: Data not available\n" +
                        "Location: %s\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: %s\n", job.getId(), job.getName(), job.getLocation(),
                        job.getCoreCompetency());
        assertEquals(output, job.toString());
    }
}


