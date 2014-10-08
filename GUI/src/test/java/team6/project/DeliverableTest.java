/*
 *@author team6
 *This class is the tests class for the Deliverable class
 *This tests all the methods in the Deliverable class to see if they are properly working
 *
 */
package team6;

import org.junit.Before;
//import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * This class contains Junit tests for the Deliverable class.
 * 
 * @author Team 6
 *
 */

public class DeliverableTest {
	Deliverable deliverable;

	/*
	 * private attributes to use for our new deliverable
	 */
	private String name = "Assignment";
	private String type = "One";
	private double weight = 10.9;

	/*
	 * Before running our tests, create the new deliverable
	 */
	@Before
	public void createDeliverable() {
		this.deliverable = new Deliverable(name, type, weight);
	}

	/*
	 * test checking if its the right deliverable name
	 */
	@Test
	public void testGettingDeliverableName() {
		String result = deliverable.getName();
		Assert.assertEquals("Assignment", result);

	}

	/*
	 * test checking whether setting the deliverable type works
	 */
	@Test
	public void testSettingDeliverableType() {
		String dtype = "Exam";
		deliverable.setType(dtype);
		String result = deliverable.getType();
		Assert.assertEquals("Exam", result);

	}

	/*
	 * test checking whether getting the deliverable type works
	 */
	@Test
	public void testGettingDeliverableType() {
		String result = deliverable.getType();
		Assert.assertEquals("One", result);

	}

	/*
	 * test checking whether setting the deliverable name works
	 */
	@Test
	public void testSettingDeliverableName() {
		String dName = "Final";
		deliverable.setType(dName);
		String result = deliverable.getType();
		Assert.assertEquals("Final", result);

	}

	/*
	 * test checking whether getting the deliverable weight works
	 */
	@Test
	public void testGettingDeliverableWeight() {
		double result = deliverable.getWeight();
		Assert.assertEquals(10.9, result);

	}

	/*
	 * test checking whether setting deliverable weight works
	 */
	@Test
	public void testSettingDeliverableWeight() {
		double wWeight = 20.0;
		deliverable.setWeight(wWeight);
		double result = deliverable.getWeight();
		Assert.assertEquals(20.0, result);

	}

	/*
	 * test whether the deliverable toString works
	 */
	@Test
	public void testDeliverableToString() {
		String nName = deliverable.getName();
		String tType = deliverable.getType();
		double wWeight = deliverable.getWeight();

		String compare = nName + " | " + tType + " - " + wWeight + "%";
		String result = deliverable.toString();
		Assert.assertEquals(compare, result);
	}

}