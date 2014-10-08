package team6;

import java.util.ArrayList;
import java.io.*;

/**
 * Course object class- Each course contains basic course information,
 * A list of students, and a list of deliverables for the course
 * @author CS2212 - Team 6
 */
public class Course implements Serializable {

	/* ************************************************************
	 * Instance Variables										  *
	 **************************************************************/

	private String courseCode, courseTitle, courseTerm;
	private ArrayList<Deliverable> deliverables;
	private ArrayList<Student> students;
	private double weightSum;

	/**
	 * Constructor for new courses
	 * 
	 * @param courseTitle
	 *            Title
	 * @param courseCode
	 *            Code
	 * @param courseTerm
	 *            Term
	 * 
	 */
	public Course(String courseTitle, String courseCode, String courseTerm) {
		this.courseCode = courseCode;
		this.courseTerm = courseTerm;
		this.courseTitle = courseTitle;
		this.students = new ArrayList<Student>();
		this.deliverables = new ArrayList<Deliverable>();
		this.weightSum = 0;
	}

	/**
	 * Getter for deliverables list
	 */
	public ArrayList<Deliverable> getDeliverables() {
		return deliverables;
	}

	/**
	 * Getter for student list
	 * 
	 * @return
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * getter for the course code
	 * 
	 * @return course code
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * setter for the course code
	 * 
	 * @param courseCode
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * getter for the course title
	 * 
	 * @return the course title
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * setter for the course title
	 * 
	 * @param courseTitle
	 *            the course title
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * getter for the course term
	 * 
	 * @return the course term
	 */
	public String getCourseTerm() {
		return courseTerm;
	}

	/**
	 * setter for the course term
	 * 
	 * @param courseTerm
	 *            the course term
	 */
	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}

	/**
	 * Getter for the total weight of the deliverables for this course
	 * 
	 * @return the total weight of the deliverables for this course
	 */
	public double getWeightSum() {
		return weightSum;
	}

	/**
	 * adding a deliverable to the course
	 * 
	 * @param name
	 *            the name of the deliverable
	 * @param type
	 *            the type of the deliverable
	 * @param weight
	 *            the weight of the deliverable
	 */
	public void addDeliverable(Deliverable deliverable) {
		weightSum = weightSum + deliverable.getWeight();
		deliverables.add(deliverable);
	}

	/**
	 * adding a student to a course
	 * 
	 * @param fname
	 *            student first name
	 * @param lname
	 *            student last name
	 * @param snumber
	 *            student number
	 * @param email
	 *            student email
	 */
	public void addStudent(Student student) {
		students.add(student);
	}

	/**
	 * Remove a deliverable
	 * 
	 * @param dname
	 *            name of deliverable
	 */
	public void removeDeliverable(String dname) {
		int i = 0;
		while (i < deliverables.size()) {
			if (deliverables.get(i).getName().equals(dname)) {
				weightSum = weightSum - deliverables.get(i).getWeight();
				deliverables.remove(i);
				return;
			}
			i++;
		}
	}

	/**
	 * this method determines whether a student exists within the course.
	 * 
	 * @param studentNumber
	 * @return true or false, depending on whether or not the student exists.
	 */
	public boolean findStudent(int studentNumber) {
		int i = 0;
		while (i < students.size()) {
			if (students.get(i).getStudentNumber() == studentNumber)
				return true;
			i++;
		}
		return false;
	}

	/**
	 * Calculates the class average for this class
	 */
	public double getClassAverage() {
		double avg = 0;
		for (int i = 0; i < students.size(); i++) {
			avg = avg + students.get(i).getAverage();
		}
		return avg / students.size();
	}

	/**
	 *
	 *
	 */
	public double getDeliverableAvg(int deliverableIndex) {
		double sum = 0;
		if (deliverables.size() != 0) {

			for (int j = 0; j < students.size(); j++) {
				sum = sum
						+ students.get(j).getGrades().get(deliverableIndex)
								.getGrade();
			}
		}
		return sum / students.size();
	}

	/**
	 * This method returns a string containing course information
	 * @return a string containing the course data
	 */
	public String toString() {
		return courseCode + " | " + courseTitle + " | " + courseTerm;
	}
}
