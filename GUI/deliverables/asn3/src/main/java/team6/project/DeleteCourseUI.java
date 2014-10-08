package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the delete course user interface
 * @author Vanessa
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
	private JComboBox<Course>selectCourse;
	private JLabel selectCourseLabel;
	private JLabel alert;
	private ArrayList<Course> courses;

	/**
	 * Creates new form DeleteCourse
	 */
	public DeleteCourseUI(ArrayList<Course> courses) {
		this.courses = courses;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// elements of user interface
		selectCourseLabel = new JLabel();
		selectCourse = new JComboBox<Course>();
		jPanel10 = new JPanel();
		courseCodeLabel = new JLabel();
		courseTitleLabel = new JLabel();
		courseTermLabel = new JLabel();
		courseCode = new JLabel();
		courseTitle = new JLabel();
		courseTerm = new JLabel();
		deleteCourseButton = new JButton();
        alert = new JLabel();

		selectCourseLabel.setText("Select Course:");

		selectCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectCourseActionPerformed(evt);
			}
		});

		// Add list of courses to combo box
		for (int i = 0; i < courses.size(); i++)
			selectCourse.addItem(courses.get(i));

		jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		courseCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseCodeLabel.setText("Course Code:");

		courseTitleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseTitleLabel.setText("Course Title:");

		courseTermLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseTermLabel.setText("Course Term:");

		courseCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		courseTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		courseTerm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		deleteCourseButton.setText("Delete");
		deleteCourseButton
		.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteCourseButtonActionPerformed(evt);
			}
		});

	       alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		   // user interface layout
         javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseCodeLabel)
                    .addComponent(courseTitleLabel)
                    .addComponent(courseTermLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCourseButton))
                    .addComponent(courseCode, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(courseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseTerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseCodeLabel)
                    .addComponent(courseCode))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseTitleLabel)
                    .addComponent(courseTitle))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseTermLabel)
                    .addComponent(courseTerm))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {courseCode, courseCodeLabel, courseTerm, courseTermLabel, courseTitle, courseTitleLabel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectCourseLabel)
                        .addGap(18, 18, 18)
                        .addComponent(selectCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(selectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}

	/**
	* Action handler for course list combo box, populates label fields from course that is selected
	*
	*/
	private void selectCourseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectCourseActionPerformed
		courseCode.setText(courses.get(selectCourse.getSelectedIndex())
				.getCourseCode());
		courseTerm.setText(courses.get(selectCourse.getSelectedIndex())
				.getCourseTerm());
		courseTitle.setText(courses.get(selectCourse.getSelectedIndex())
				.getCourseTitle());
	}

	/**
	* Action handler for delete course button
	* @param evt	event handler
	*/
	private void deleteCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectCourse.getSelectedIndex() > 0) {
			int ind = selectCourse.getSelectedIndex();
			selectCourse.remove(ind);
			GradeBookUI.updateDeleteCourse(ind);
			alert.setText("The course has been deleted");
		}
		else
			alert.setText("A course must be selected");
	}
}
