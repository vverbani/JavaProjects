package team6;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;
/**
 * This class contains Junit tests for the Grade class.
 * 
 * @author Team 6
 *
 */
public class GradeTest {
	Grade grade;

	private double mark = 10.0;
	private String deliverable = "title";
	private double weight = 10.0;
	private String type = "One";

	@Before
	public void createGrade() {
		this.grade = new Grade(mark, deliverable, weight);
	}

	@Test
	public void testGettingTypeOfTheGrade() {
		Grade g = new Grade(mark, deliverable, weight, type);
		String result = g.getType();
		Assert.assertEquals(true, result.equals(type));
	}

	@Test
	public void testGettingGrade() {

		double result = grade.getGrade();
		Assert.assertEquals(10.0, result);

	}

	@Test
	public void testSettingGrade() {

		grade.setGrade(15.0);
		double result = grade.getGrade();
		Assert.assertEquals(15.0, result);

	}

	@Test
	public void testGettingWeightOfTheGrade() {
		double result = grade.getWeight();
		Assert.assertEquals(10.0, result);
	}

	@Test
	public void testSettingWeightOfTheGrade() {
		grade.setWeight(15.0);
		double result = grade.getWeight();
		Assert.assertEquals(15.0, result);
	}

	@Test
	public void testGettingDeliverableTitle() {
		String result = grade.getTitle();
		Assert.assertEquals("title", result);
	}

	@Test
	public void testSettingDeliverableTitle() {
		grade.setTitle("tester");
		String result = grade.getTitle();
		Assert.assertEquals("tester", result);

	}

	@Test
	public void testGradeToString() {
		String compareTo = grade.getGrade() + "";
		String result = grade.toString();
		Assert.assertEquals(compareTo, result);
	}

}