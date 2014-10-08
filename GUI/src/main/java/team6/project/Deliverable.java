package team6;

import java.util.ArrayList;
import java.io.*;

/**
* Deliverable object class- each deliverable has a name, type, and weight.
*@author Team 6 - CS2212 - UWO
*/
public class Deliverable implements Serializable {

	/* ************************************************************
	 * Instance Variables
	 * ***********************************************************
	 */
	protected String name;
	protected String type;
	protected double weight;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            type of deliverable
	 * @param name
	 *            name of deliverable
	 * @param weight
	 *            weight of deliverable (percentage)
	 */
	public Deliverable(String name, String type, double weight) {
		this.name = name;
		this.type = type;
		this.weight = weight;
	}

	/**
	 * getter for the deliverable name
	 * 
	 * @return the deliverable name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for deliverable type
	 * 
	 * @return the type of the deliverable
	 */
	public String getType() {
		return type;
	}

	/**
	 * getter for the weight of the deliverable
	 * 
	 * @return the weight of the deliverable
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * set the name of the deliverable
	 * 
	 * @param name
	 *            the name to be set
	 */
	public void setName(String name) {
		this.name = name;

	}

	/**
	 * set the type of the deliverable
	 * 
	 * @param type
	 *            the type of the deliverable
	 */

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * set the weight of the deliverable
	 * 
	 * @param weight
	 *            the weight of the deliverable
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * creates a string with the deliverable data
	 * 
	 * @return the deliverable data in string form.
	 */
	public String toString() {
		String string = " ";
		string = name + " | " + type + " - " + weight + "%";
		return string;

	}
}