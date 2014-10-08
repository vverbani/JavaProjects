package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class the implement the user interface for adding students to the GradeBook
 * 
 * @author CS2212 - Team 6
 */
public class AddStudentUI extends javax.swing.JPanel {

	// Instance Variables
	private JButton addStudentButton;
	private JTextField firstName;
	private JLabel firstNameLabel;
	private JPanel jPanel11;
	private JTextField lastName;
	private JLabel lastNameLabel;
	private JTextField studentEmail;
	private JLabel studentEmailLabel;
	private JTextField studentID;
	private JLabel studentIDLabel;
	private JLabel alert;
	private ArrayList<Student> students;

	/**
	 * Creates new form AddStudent
	 * 
	 * @param courses
	 *            list of courses in the gradebook
	 */
	public AddStudentUI(ArrayList<Student> students) {
		this.students = students;
		initComponents();
	}

	/**
	 * Finds appropriate elements from fields and calls the updateAddStudent
	 * method in order to add Student information
	 * 
	 * @param evt
	 *            event handler
	 */
	private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// check if the first name is not empty
		if (firstName.getText().equals("")) {
			alert.setText("A student's first name must be entered");
		}
		// check if the last name is not empty
		else if (lastName.getText().equals("")) {
			alert.setText("A student's last name must be entered");
		} else {
			// check if the first name and last name are only characters
			for (int i = 0; i < firstName.getText().length(); i++) {
				if (!firstName.getText().matches("[a-zA-Z]+")) {
					alert.setText("Student's first name not valid format");
					return;
				}
			}
			for (int i = 0; i < lastName.getText().length(); i++) {
				if (!lastName.getText().matches("[a-zA-Z]+")) {
					alert.setText("Student's first name not valid format");
					return;
				}
			}
			// check if student ID is a number
			try {
				int studentIDInt = Integer.parseInt(studentID.getText());
				// check uniqueness of student ID and e-mail
				for (int i = 0; i < students.size(); i++) {
					if (studentIDInt == students.get(i).getStudentNumber()) {
						alert.setText("Student ID number already exists");
						return;
					} else if (studentEmail.getText().equals(
							students.get(i).getEmailAddress())) {
						alert.setText("Student email already exists");
						return;
					}
				}
				// check e-mail format validity
				if (!studentEmail.getText().equals("")) {
					boolean flag = true;
					int atPointer = -1;
					int dotPointer = -1;
					int atCounter = 0;
					int dotCounter = 0;
					String eAddress = studentEmail.getText();
					for (int i = 0; i < eAddress.length(); i++) {
						if (eAddress.charAt(i) == '@') {
							atPointer = i;
							atCounter++;
						} else if (eAddress.charAt(i) == '.') {
							dotPointer = i;
							dotCounter++;
						} else if (eAddress.charAt(i) == ' ') {
							flag = false;
						}
					}
					
					if (atPointer > dotPointer || atCounter != 1 || dotCounter != 1 || dotPointer - atPointer <  2)
						flag = false;
					//System.out.println("TEST: " + flag);
					if (flag) 
					{
						GradeBookUI.updateAddStudent(firstName.getText(),lastName.getText(), studentIDInt,studentEmail.getText());
					} 
					else 
					{
						alert.setText("email format not valid");
					}
				} else
					alert.setText("A student's email must be entered");
			} catch (NumberFormatException e) {
				alert.setText("Student ID must be a number");
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// user interface elements
		jPanel11 = new javax.swing.JPanel();
		lastName = new javax.swing.JTextField();
		firstName = new javax.swing.JTextField();
		firstNameLabel = new javax.swing.JLabel();
		lastNameLabel = new javax.swing.JLabel();
		addStudentButton = new javax.swing.JButton();
		studentIDLabel = new javax.swing.JLabel();
		studentID = new javax.swing.JTextField();
		studentEmailLabel = new javax.swing.JLabel();
		studentEmail = new javax.swing.JTextField();
		alert = new javax.swing.JLabel();

		jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		firstNameLabel.setText("First Name:");

		lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		lastNameLabel.setText("Last Name:");

		// calls the event handler for add button
		addStudentButton.setText("Add");
		addStudentButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStudentButtonActionPerformed(evt);
			}
		});

		studentIDLabel.setFont(new java.awt.Font("Arial", 0, 12));
		studentIDLabel.setText("Student ID:");

		studentEmailLabel.setFont(new java.awt.Font("Arial", 0, 12));
		studentEmailLabel.setText("Email:");

		alert.setFont(new java.awt.Font("Tahoma", 1, 12));

		// user interface layout
		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(
				jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout
				.setHorizontalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				firstNameLabel)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				firstName,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel11Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								lastNameLabel)
																						.addComponent(
																								studentIDLabel)
																						.addComponent(
																								studentEmailLabel))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel11Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel11Layout
																										.createSequentialGroup()
																										.addComponent(
																												alert,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												305,
																												Short.MAX_VALUE)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												addStudentButton))
																						.addComponent(
																								studentEmail,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								studentID,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lastName,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		jPanel11Layout
				.setVerticalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																firstNameLabel)
														.addComponent(
																firstName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																20,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lastNameLabel)
														.addComponent(
																lastName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																studentIDLabel)
														.addComponent(
																studentID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																studentEmailLabel)
														.addComponent(
																studentEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																addStudentButton)
														.addComponent(
																alert,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																15,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(195, Short.MAX_VALUE)));

		jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { alert, firstName, lastName,
						studentEmail, studentID });

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel11,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel11,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
	}
}
