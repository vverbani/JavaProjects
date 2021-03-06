package team6.project;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class EditCourse extends javax.swing.JPanel {

 private ArrayList<Course> courses;

 /**
  * Creates new form EditCourse
  */
 public EditCourse(ArrayList<Course> courses) {
  this.courses = courses;
  initComponents();
 }

 /**
  * This method is called from within the constructor to initialize the form.
  * WARNING: Do NOT modify this code. The content of this method is always
  * regenerated by the Form Editor.
  */
 @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed"
 // desc="Generated Code">//GEN-BEGIN:initComponents
 private void initComponents() {

  selectCourseLabel = new javax.swing.JLabel();
  CourseListCombo = new javax.swing.JComboBox();
  jPanel7 = new javax.swing.JPanel();
  courseTermLabel = new javax.swing.JLabel();
  courseCombo = new javax.swing.JComboBox();
  courseTitle = new javax.swing.JTextField();
  courseCode = new javax.swing.JTextField();
  courseCodeLabel = new javax.swing.JLabel();
  courseTitleLabel = new javax.swing.JLabel();
  addCourseButton = new javax.swing.JButton();

  selectCourseLabel.setText("Select Course:");

  // Add list of courses to combo box
  for (int i = 0; i < courses.size(); i++)
   CourseListCombo.addItem(courses.get(i));

  CourseListCombo.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    CourseListComboActionPerformed(evt);
   }
  });

  jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

  courseTermLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseTermLabel.setText("Course Term:");

  courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
    "Spring 2013", "Winter 2014", "Summer 2014", "Spring 2014" }));

  courseCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseCodeLabel.setText("Course Code:");

  courseTitleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseTitleLabel.setText("Course Title: ");

  addCourseButton.setText("Add");
  addCourseButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    addCourseButtonActionPerformed(evt);
   }
  });

  javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
    jPanel7);
  jPanel7.setLayout(jPanel7Layout);
  jPanel7Layout
    .setHorizontalGroup(jPanel7Layout
      .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(
        jPanel7Layout
          .createSequentialGroup()
          .addContainerGap()
          .addGroup(
            jPanel7Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(
                courseTermLabel)
              .addComponent(
                courseCodeLabel)
              .addComponent(
                courseTitleLabel))
          .addGap(18, 18, 18)
          .addGroup(
            jPanel7Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(
                courseTitle)
              .addComponent(
                courseCode)
              .addComponent(
                courseCombo, 0,
                259,
                Short.MAX_VALUE))
          .addGap(12, 12, 12))
      .addGroup(
        javax.swing.GroupLayout.Alignment.TRAILING,
        jPanel7Layout
          .createSequentialGroup()
          .addContainerGap(
            javax.swing.GroupLayout.DEFAULT_SIZE,
            Short.MAX_VALUE)
          .addComponent(addCourseButton)
          .addContainerGap()));
  jPanel7Layout
    .setVerticalGroup(jPanel7Layout
      .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(
        jPanel7Layout
          .createSequentialGroup()
          .addContainerGap()
          .addGroup(
            jPanel7Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                courseCodeLabel)
              .addComponent(
                courseCode,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                20,
                javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          .addGroup(
            jPanel7Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                courseTitleLabel)
              .addComponent(
                courseTitle,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(19, 19, 19)
          .addGroup(
            jPanel7Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                courseTermLabel)
              .addComponent(
                courseCombo,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(
            javax.swing.LayoutStyle.ComponentPlacement.RELATED,
            101, Short.MAX_VALUE)
          .addComponent(addCourseButton)
          .addContainerGap()));

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
  this.setLayout(layout);
  layout.setHorizontalGroup(layout
    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(
      layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(selectCourseLabel)
        .addGap(18, 18, 18)
        .addComponent(CourseListCombo, 0, 292,
          Short.MAX_VALUE).addContainerGap())
    .addGroup(
      layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel7,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE)
            .addContainerGap())));
  layout.setVerticalGroup(layout
    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(
      layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(
          layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(selectCourseLabel)
            .addComponent(
              CourseListCombo,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(269, Short.MAX_VALUE))
    .addGroup(
      layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          layout.createSequentialGroup()
            .addContainerGap(42,
              Short.MAX_VALUE)
            .addComponent(
              jPanel7,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())));
 }// </editor-fold>//GEN-END:initComponents

 private void CourseListComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CourseListComboActionPerformed
  // TODO add your handling code here:
 }// GEN-LAST:event_CourseListComboActionPerformed

 /**
  * Find appropriate information from fields and call the updateAddCourse
  * method
  * 
  * @param evt
  */
 private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addCourseButtonActionPerformed
  if (CourseListCombo.getSelectedIndex() >= 0) {
   String[] s = new String[] { "Spring 2013", "Winter 2014",
     "Summer 2014", "Spring 2014" };
   String term = s[courseCombo.getSelectedIndex()];
   GradeBookUI.updateEditCourse(CourseListCombo.getSelectedIndex(),
     courseTitle.getText(), courseCode.getText(), term);
  }
 }// GEN-LAST:event_addCourseButtonActionPerformed

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JComboBox CourseListCombo;
 private javax.swing.JButton addCourseButton;
 private javax.swing.JTextField courseCode;
 private javax.swing.JLabel courseCodeLabel;
 private javax.swing.JComboBox courseCombo;
 private javax.swing.JLabel courseTermLabel;
 private javax.swing.JTextField courseTitle;
 private javax.swing.JLabel courseTitleLabel;
 private javax.swing.JPanel jPanel7;
 private javax.swing.JLabel selectCourseLabel;
 // End of variables declaration//GEN-END:variables
}
