package team6;

import java.util.*;
import java.io.*;
/**
* Student Object Class- each student object contains student data such as name, email,
* student number ,etc.  as well as a list of their grades for each deliverable. 
*@author Team 6 - CS2212 - UWO
*/
public class Student implements Serializable {

	/* ************************************************************
	 * Instance Variables
	 * ***********************************************************
	 */

	private String firstName; // Student's first name
	private String lastName; // Student's last name
	private int studentNumber; // Student's Student Number
	private String emailAddress; // Student's Email Address
	private ArrayList<Grade> grades; // Student's list of their grades
	private double average;

	/**
	 * Constructor to construct a student object that does not belong to a
	 * specific course
	 * 
	 * @param firstName
	 *            First name
	 * @param lastName
	 *            last name
	 * @param studentNumber
	 *            Student number
	 * @param emailAddress
	 *            student's email address
	 */
	public Student(String firstName, String lastName, int studentNumber,
			String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.studentNumber = studentNumber;
		this.grades = new ArrayList<Grade>();
		this.average = 0.0;
	}

	/**
	 * getter for the student's first name
	 * 
	 * @return the student's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * getter for the student's last name
	 * 
	 * @return the student's last name
	 */
	public String getLastName() {
		return this.lastName;

	}

	/**
	 * getter for the student's email address
	 * 
	 * @return the student's email address
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * getter for the student's student number
	 * 
	 * @return the student's student number
	 */
	public int getStudentNumber() {
		return this.studentNumber;
	}

	/**
	 * getter for list of grades for this student
	 * 
	 * @return list of grades belonging to this student
	 */
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	/**
	 * adds a grade to the specified student, which is associated with a
	 * specific deliverable
	 * 
	 * @param grade
	 *            grade to be added
	 * @param del
	 *            String with the grade's name
	 */
	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	/**
	 * setter for the student's first name
	 * 
	 * @param firstName
	 *            the student's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * setter for the student's last name
	 * 
	 * @param lastName
	 *            the student's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * setter for the student's email address
	 * 
	 * @param emailAddress
	 *            the student's email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * setter for the student's student number
	 * 
	 * @param studentNumber
	 *            the student's studentNumber
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * setter for the student's average
	 * 
	 * @param average
	 *            the student's average
	 */
	public void setAverage(Double a) {
		this.average = a;
	}

	/**
	 * getter for the student's weighted average
	 * 
	 * @param average
	 *            the student's average
	 */

	public double getAverage() {
		calcAverage();
		int tmp = (int) (average * 100);
		average = tmp / (double) 100;
		return average;
	}

	/**
	 * getter method that returns the student's average
	 */

	public double average() {
		return average;
	}

	/**
	 * Private method that calculates the average for the student
	 */
	private void calcAverage() {
		double sum = 0;
		double wsum = 0;
		for (int i = 0; i < grades.size(); i++) {
			sum += grades.get(i).getWeight() * grades.get(i).getGrade();
			wsum += grades.get(i).getWeight();
		}
		average = sum / wsum;
	}

	/**
	 * Private method that calculates the assignment average for the student
	 */
	public double getAssignmentAverage() {
		double sum = 0;
		double wsum = 0;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i).getType().equals("Assignment")) {
				sum += grades.get(i).getWeight() * grades.get(i).getGrade();
				wsum += grades.get(i).getWeight();
			}
		}

		int tmp = (int) (sum / wsum * 100);
		return tmp / (double) 100;
	}

	/**
	 * Private method that calculates the exam average for the student
	 */
	public double getExamAverage() {
		double sum = 0;
		double wsum = 0;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i).getType().equals("Exam")) {
				sum += grades.get(i).getWeight() * grades.get(i).getGrade();
				wsum += grades.get(i).getWeight();
			}
		}

		int tmp = (int) (sum / wsum * 100);
		return tmp / (double) 100;
	}

	/**
	 * @return a string containing the Student data
	 */
	public String toString() {
		return firstName + " " + lastName + "  |  " + studentNumber + "  |  "
				+ emailAddress;
	}
}
