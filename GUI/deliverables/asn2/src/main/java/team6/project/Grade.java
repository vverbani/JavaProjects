package team6.project;
import java.util.*;
import java.io.*;


/**
 * Course grade class
 * 
 */
public class Grade  implements Serializable{


 /* ************************************************************
  * Instance Variables
  ************************************************************ */
 private double grade;
 private Deliverable title;

 /**
  * Constructor for Grade objects
  * @param grade actual grade value
  * @param title title of the corresponding deliverable
  */
 public Grade(double grade, Deliverable title) {

  this.grade = grade;
  this.title = title;

 }
 /**
  * getter for the deliverable associated with this grade
  * @return the deliverable
  */
 public Deliverable getDeliverable() {
  return this.title;
 }
 /**
  * setter for the deliverable associated with this grade
  * @param title the deliverable
  */
 public void setTitle(Deliverable title) {
  this.title = title;
 }
 /**
  * getter for the grade
  * @return the mark received
  */
 public double getGrade() {

  return this.grade;
 }
 /**
  * setter for the grade,
  * @param grade  the mark received  
  * @param title  the deliverable information
  */
 public void setGrade(double grade, Deliverable title) {
  this.grade = grade;
  this.title = title;
 }
 /**
  * @return the string containing all the grade data
  */
 public String toString() {
  return "Grade is : " + this.grade + "\n" + "Title is : " + this.title.toString();
 }

}
