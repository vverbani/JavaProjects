package team6;

import java.util.*;

public class ReportData {

	// instance variables
	private Course c;
	private Student s;
	private int num;

	public ReportData(Course c, Student s, int num) {
		this.c = c;
		this.s = s;
		this.num = num;
	}

	public String getCourseTitle() {
		if (num > -1)
			return null;
		return c.getCourseTitle();
	}

	public String getReportCourseCode() {
		if (num > -1)
			return null;
		return c.getCourseCode();
	}

	public String getReportCourseTerm() {
		if (num > -1)
			return null;
		return c.getCourseTerm();
	}

	public double getClassAvg() {
		if (num == -1)
			return -1;
		return c.getClassAverage();
	}

	public double getStudentAvg() {
		if (num == -1)
			return -1;
		return s.getAverage();
	}

	public double getDevAverage() {
		if (num == -1)
			return -1;
		return c.getDeliverableAvg(num);
	}

	public String getStudentFirstName() {
		if (num > -1)
			return null;
		return s.getFirstName();
	}

	public String getStudentLastName() {
		if (num > -1)
			return null;
		return s.getLastName();
	}

	public String getStudentEmail() {
		if (num > -1)
			return null;
		return s.getEmailAddress();
	}

	public String getStudentID() {
		if (num > -1)
			return null;
		String str = "" + s.getStudentNumber();
		return str;
	}

	public double getStudentGrade() {
		if (num == -1)
			return -1;
		return s.getGrades().get(num).getGrade();
	}

	public double getDevWeight() {
		if (num == -1)
			return -1;
		return c.getDeliverables().get(num).getWeight();
	}

	public String getDevName() {
		if (num == -1)
			return null;
		return c.getDeliverables().get(num).getName();
	}

	public String getDevType() {
		if (num == -1)
			return null;
		return c.getDeliverables().get(num).getType();
	}
}
