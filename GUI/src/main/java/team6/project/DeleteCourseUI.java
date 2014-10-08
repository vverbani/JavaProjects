package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the delete course user interface
 * @author CS2212 - Team 6
 */
public class DeleteCourseUI extends javax.swing.JPanel {

	// Instance Variables
	private JLabel courseCode;
	private JLabel courseCodeLabel;
	private JLabel courseTerm;
	private JLabel courseTermLabel;
	private JLabel courseTitle;
	private JLabel courseTitleLabel;
	private JButton deleteCourseButton;
	private JPanel jPanel10;
	private JLabel alert;
	private Course course;

	/**
	 * Creates new form DeleteCourse
	 */
	public DeleteCourseUI(Course course) {
		this.course = course;
		initComponents();
	}

	/**
	 * Action handler for delete course button
	 * 
	 * @param evt
	 *            event handler
	 */
	private void deleteCourseButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		GradeBookUI.updateDeleteCourse();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// elements of user interface
		jPanel10 = new JPanel();
		courseCodeLabel = new JLabel();
		courseTitleLabel = new JLabel();
		courseTermLabel = new JLabel();
		courseCode = new JLabel();
		courseTitle = new JLabel();
		courseTerm = new JLabel();
		deleteCourseButton = new JButton();
		alert = new JLabel();

		jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		courseCodeLabel.setFont(new java.awt.Font("Arial", 0, 12));
		courseCodeLabel.setText("Course Code:");

		courseTitleLabel.setFont(new java.awt.Font("Arial", 0, 12));
		courseTitleLabel.setText("Course Title:");

		courseTermLabel.setFont(new java.awt.Font("Arial", 0, 12));
		courseTermLabel.setText("Course Term:");

		courseCode.setFont(new java.awt.Font("Arial", 0, 12));

		courseTitle.setFont(new java.awt.Font("Arial", 0, 12));

		courseTerm.setFont(new java.awt.Font("Arial", 0, 12));

		// populate the labels with the course to be deleted's information
		courseTitle.setText(course.getCourseTitle());
		courseCode.setText(course.getCourseCode());
		courseTerm.setText(course.getCourseTerm());

		deleteCourseButton.setText("Delete");
		deleteCourseButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteCourseButtonActionPerformed(evt);
					}
				});

		alert.setFont(new java.awt.Font("Tahoma", 1, 12));

		// user interface layout
		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																courseCodeLabel)
														.addComponent(
																courseTitleLabel)
														.addComponent(
																courseTermLabel))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addComponent(
																				alert,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				deleteCourseButton))
														.addComponent(
																courseCode,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																341,
																Short.MAX_VALUE)
														.addComponent(
																courseTitle,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																courseTerm,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																courseCodeLabel)
														.addComponent(
																courseCode))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																courseTitleLabel)
														.addComponent(
																courseTitle))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																courseTermLabel)
														.addComponent(
																courseTerm))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																deleteCourseButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																alert,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(158, Short.MAX_VALUE)));

		jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { courseCode, courseCodeLabel,
						courseTerm, courseTermLabel, courseTitle,
						courseTitleLabel });

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel10,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel10,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
	}
}
