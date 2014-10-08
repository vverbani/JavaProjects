package team6.project;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class DeliverableTest
{
	Deliverable deliverable;
	// public Deliverable (String type, String name, double weight)
	
	private String type = "Assignment";
	private String name = "One";
	private double weight = 10.9;
	
	@Before
	public void createStudent()
	{
		this.deliverable = new Deliverable(type, name, weight);
	}
	
	@Test
	public void testGettingDeliverableType()
	{
		Deliverable deliverable = new Deliverable(type, name, weight);
		String result = deliverable.getType();
		Assert.assertEquals("Assignment", result);
		
	}
	@Test
	public void testSettingDeliverableType()
	{
		String dtype = "Exam";
		Deliverable deliverable = new Deliverable(type, name, weight);
		deliverable.setType(dtype);
		String result = deliverable.getType();
		Assert.assertEquals("Exam", result);
		
	}
	@Test
	public void testGettingDeliverableName()
	{
		Deliverable deliverable = new Deliverable(type, name, weight);
		String result = deliverable.getName();
		Assert.assertEquals("One", result);
		
	}
	@Test
	public void testSettingDeliverableName()
	{
		String dName = "Final";
		Deliverable deliverable = new Deliverable(type, name, weight);
		deliverable.setType(dName);
		String result = deliverable.getType();
		Assert.assertEquals("Final", result);
		
	}
	@Test
	public void testGettingDeliverableWeight()
	{
		Deliverable deliverable = new Deliverable(type, name, weight);
		double result = deliverable.getWeight();
		Assert.assertEquals(10.9, result);

	}
	@Test
	public void testSettingDeliverableWeight()
	{
		double wWeight = 20.0;
		Deliverable deliverable = new Deliverable(type, name, weight);
		deliverable.setWeight(wWeight);
		double result = deliverable.getWeight();
		Assert.assertEquals(20.0, result);
		
	}
	
}