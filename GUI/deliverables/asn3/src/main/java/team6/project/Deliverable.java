package team6;

import java.util.ArrayList;
import java.io.*;

public class Deliverable implements Serializable {

 /* ************************************************************
  * Instance Variables
  ************************************************************ */
 protected String name;
 protected String type;
 protected double weight;
 private ArrayList<Grade> grades;

 /**
  * Constructor
  * @param type type of deliverable
  * @param name name of deliverable
  * @param weight weight of deliverable (percentage)
  */
 public Deliverable (String name, String type, double weight){

  this.name = name;
  this.type = type;
  this.weight = weight;
  this.grades = new ArrayList<Grade>();

 }

 /**
  * getter for the deliverable name
  * @return the deliverable name
  */
 public String getName(){
  return name;
 }

 /**
  * getter for deliverable type
  * @return the type of the deliverable
  */
 public String getType(){
  return type;
 }

 /**
  * getter for the weight of the deliverable
  * @return the weight of the deliverable
  */
 public double getWeight(){
  return weight;
 }

 /**
  * set the name of the deliverable
  * @param name the name to be set
  */
 public void setName(String name){
  this.name = name;

 }
 /**
  * set the type of the deliverable
  * @param type the type of the deliverable
  */

 public void setType(String type){
  this.type = type;
 }

 /**
  * set the weight of the deliverable
  * @param weight the weight of the deliverable
  */
 public void setWeight(double weight){
  this.weight = weight;
 }
 
 /**
  * Get Grades
  * @return the list of grades related to this deliverable
  */
  public ArrayList<Grade> getGrades() {
	return grades;
  }
  
  /*
   * Set grades
   * @param grades	the list of grades related to this deliverable
   */
   public void setGrade(ArrayList<Grade> grades) {
	this.grades = grades;
   }

 /**
  * Adds a grade to the deliverable
  * @param grade   a grade to be added to the deliverable
  * @param title   the name of the deliverable
  */
 public void addGrades(double grade, Deliverable title) {
  grades.add(new Grade(grade, title));
 }

 /**
  * remove a grade from deliverable
  * 
  * @param fname  first name
  * @param lname  last name
  */
 public void removeGrade(double grade, Deliverable title) {
  int i = 0;
  while (i < grades.size()) {
   if (grades.get(i).getGrade() == grade)
    if (grades.get(i).getDeliverable().equals(title)) {
     grades.remove(i);
     return;
    }
   i++;
  }
 }

 /**
  * creates a string with the deliverable data
  * @return the deliverable data in string form. 
  */
 public String toString(){
  String string = " ";
  string = name +  " | " + type + " - " + weight + "%";
  return string;

 }
}