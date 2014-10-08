package team6;

import java.util.ArrayList;
import java.io.*;

/**
 * Course object class
 * @author CS2212 - Team 6
 */
public class Course implements Serializable {


 /* ************************************************************
  * Instance Variables
  ************************************************************ */
 private String courseCode, courseTitle, courseTerm;
 private ArrayList<Deliverable> deliverables = new ArrayList<Deliverable>();
 private ArrayList<Student> students = new ArrayList<Student>();

 /**
  * Constructor for new courses
  * 
  * @param courseTitle  Title  
  * @param courseCode Code  
  * @param courseTerm Term
  *           
  */
 public Course(String courseTitle, String courseCode, String courseTerm) {
  this.courseCode = courseCode;
  this.courseTerm = courseTerm;
  this.courseTitle = courseTitle;
  this.students = students;
  this.deliverables = deliverables;
 }
 
 /**
  * Getter for deliverables list
  */
 public ArrayList<Deliverable> getDeliverables() {
	return deliverables;
}

/**
 * Getter for student list
 * @return
 */
public ArrayList<Student> getStudents() {
	return students;
}

/**
  * getter for the course code
  * @return course code
  */
 public String getCourseCode() {
  return courseCode;
 }
 /**
  * setter for the course code
  * @param courseCode
  */
 public void setCourseCode(String courseCode) {
  this.courseCode = courseCode;
 }
 /**
  * getter for the course title
  * @return the course title
  */
 public String getCourseTitle() {
  return courseTitle;
 }
 /**
  * setter for the course title
  * @param courseTitle the course title
  */
 public void setCourseTitle(String courseTitle) {
  this.courseTitle = courseTitle;
 }
 /**
  * getter for the course term
  * @return the course term
  */
 public String getCourseTerm() {
  return courseTerm;
 }
 /**
  * setter for the course term
  * @param courseTerm the course term
  */
 public void setCourseTerm(String courseTerm) {
  this.courseTerm = courseTerm;
 }
 /**
  * adding a deliverable to the course
  * @param name   the name of the deliverable
  * @param type   the type of the deliverable
  * @param weight  the weight of the deliverable
  */
 public void addDeliverable(String name, String type, double weight) {
  deliverables.add(new Deliverable(name, type, weight));
 }

 /**
  * adding a student to a course
  * @param fname  student first name
  * @param lname  student last name
  * @param snumber student number
  * @param email  student email
  */
 public void addStudent(String fname, String lname, int snumber, String email) {
  students.add(new Student(fname, lname, snumber, email));
 }

 /**
  *Remove a deliverable
  * 
  * @param dname name of deliverable
  */
 public void removeDeliverable(String dname) {
  int i = 0;
  while (i < deliverables.size()) {
   if (deliverables.get(i).getName().equals(dname)) {
    deliverables.remove(i);
    return;
   }
   i++;
  }
 }

 /**
  * remove a student from a course
  * 
  * @param fname  first name
  * @param lname  last name
  */
 public void removeStudent(String fname, String lname) {
  int i = 0;
  while (i < students.size()) {
   if (students.get(i).getFirstName().equals(fname))
    if (students.get(i).getLastName().equals(lname)) {
     students.remove(i);
     return;
    }
   i++;
  }
 }

 /**
  * @return a string containing the course data
  */
 public String toString() {
  return courseCode + " | " + courseTitle + " | " + courseTerm;
 }
}
