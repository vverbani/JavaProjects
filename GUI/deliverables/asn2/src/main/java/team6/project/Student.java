package team6.project;
import java.util.*;
import java.io.*;
public class Student implements Serializable {


 /* ************************************************************
  * Instance Variables
  ************************************************************ */

 private String firstName;   //Student's first name
 private String lastName;   //Student's last name
 private int studentNumber;   //Student's Student Number
 private String emailAddress;  //Student's Email Address
 private ArrayList<Grade> grades; //Student's list of their grades



 /* *
  * Constructor .
  * @param firstName First name
  * @param lastName last name
  * @param studentNumber Student number
  * @param emailAddress student's email address
  */
 public Student(String firstName, String lastName, int studentNumber,
   String emailAddress) {

  this.firstName = firstName;
  this.lastName = lastName;
  this.emailAddress = emailAddress;
  this.studentNumber = studentNumber;
 }
 /**
  * getter for the student's first name
  * @return the student's first name
  */
 public String getFirstName() {
  return this.firstName;
 }
 /**
  * getter for the student's last name
  * @return the student's last name
  */
 public String getLastName() {
  return this.lastName;

 }
 /**
  * getter for the student's email address
  * @return the student's email address
  */
 public String getEmailAddress() {
  return this.emailAddress;
 }
 /**
  * getter for the student's student number
  * @return the student's student number
  */
 public int getStudentNumber() {
  return this.studentNumber;
 }
 /**
  * setter for the student's first name
  * @param firstName the student's first name
  */
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }
 
 /**
  * setter for the student's last name
  * @param lastName the student's last name
  */
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 /**
  * setter for the student's email address
  * @param emailAddress the student's email address
  */
 public void setEmailAddress(String emailAddress) {
  this.emailAddress = emailAddress;
 }

 /**
  * setter for the student's student number
  * @param studentNumber the student's studentNumber
  */
 public void setStudentNumber(int studentNumber) {
  this.studentNumber = studentNumber;
 }
}
