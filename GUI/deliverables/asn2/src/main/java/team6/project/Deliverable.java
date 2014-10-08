package team6.project;
/**
 * Class to implement the Deliverable object.
 * 
 * @author UWO - CS2212 - Team 6 (ATripleV)
 */
import java.util.*;
import java.io.*;
public class Deliverable implements Serializable {
 
 /* ************************************************************
 * Instance Variables
 ************************************************************ */
 protected String name;
 protected String type;
 protected double weight;
 
/**
 * Constructor
 * @param type type of deliverable
 * @param name name of deliverable
 * @param weight weight of deliverable (percentage)
 */
 public Deliverable (String type, String name, double weight){
  
  this.name = name;
  this.type = type;
  this.weight = weight;
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
  * creates a string with the deliverable data
  * @return the deliverable data in string form. 
  */
 public String toString(){
  String string = " ";
  string = "Deliverable Name: " + name + "\n" +  "Deliverable Type : " + type + "\n" + "Deliverable Weight : " + weight;
  return string;
  
 }
}

