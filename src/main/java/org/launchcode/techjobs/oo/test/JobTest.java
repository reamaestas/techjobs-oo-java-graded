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

}

