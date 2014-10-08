package team6;

import java.util.*;
import java.io.*;

/**
 * Course grade class
 * 
 * @author CS2212 - Team 6
 */
public class Grade implements Serializable {

	/* ************************************************************
	 * Instance Variables
	 * ***********************************************************
	 */
	private double grade;
	private String title;
	private String type;
	private double weight;

	/**
	 * Constructor for Grade objects
	 * 
	 * @param grade
	 *            actual grade value
	 * @param title
	 *            title of the corresponding deliverable
	 */
	public Grade(double grade, String title, double weight) {

		this.grade = grade;
		this.title = title;
		this.weight = weight;
	}

	/**
	 * Constructor for Grade objects
	 * 
	 * @param grade
	 *            actual grade value
	 * @param title
	 *            title of the corresponding deliverable
	 */
	public Grade(double grade, String title, double weight, String type) {

		this.grade = grade;
		this.title = title;
		this.weight = weight;
		this.type = type;
	}

	/**
	 * getter for the deliverable associated with this grade
	 * 
	 * @return the deliverable
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * setter for the deliverable associated with this grade
	 * 
	 * @param title
	 *            the deliverable
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * getter for the grade
	 * 
	 * @return the mark received
	 */
	public double getGrade() {

		return this.grade;
	}

	/**
	 * getter for the type
	 * 
	 * @return the type (assignment/exam)
	 */
	public String getType() {

		return this.type;
	}

	/**
	 * getter for the weight
	 * 
	 * @return the weight for the grade
	 */
	public double getWeight() {

		return this.weight;
	}

	public void setWeight(double weight) {

		this.weight = weight;
	}

	/**
	 * setter for the grade,
	 * 
	 * @param grade
	 *            the mark received
	 * @param title
	 *            the deliverable information
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}

	/**
	 * to String method
	 * 
	 * @return the string containing all the grade data
	 */
	public String toString() {
		return grade + "";
	}
}
