package team6.project;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Vanessa
 */
public class DeleteStudent extends javax.swing.JPanel {

 /**
  * Creates new form DeleteStudent
  */
 public DeleteStudent() {
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

  selectStudentLabel = new javax.swing.JLabel();
  studentListCombo = new javax.swing.JComboBox();
  jPanel12 = new javax.swing.JPanel();
  deleteStudentButton = new javax.swing.JButton();
  firstNameLabel = new javax.swing.JLabel();
  lastNameLabel = new javax.swing.JLabel();
  studentIDLabel = new javax.swing.JLabel();
  studentEmailLabel = new javax.swing.JLabel();
  firstName = new javax.swing.JLabel();
  lastName = new javax.swing.JLabel();
  studentID = new javax.swing.JLabel();
  studentEmail = new javax.swing.JLabel();
  selectCourse = new javax.swing.JComboBox();
  selectCourseLabel = new javax.swing.JLabel();

  selectStudentLabel.setText("Select Student:");

  studentListCombo.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    studentListComboActionPerformed(evt);
   }
  });

  jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

  deleteStudentButton.setText("Delete");

  firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  firstNameLabel.setText("First Name:");

  lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  lastNameLabel.setText("Last Name:");

  studentIDLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  studentIDLabel.setText("Student ID:");

  studentEmailLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  studentEmailLabel.setText("Email:");

  firstName.setText("jLabel1");

  lastName.setText("jLabel1");

  studentID.setText("jLabel1");

  studentEmail.setText("jLabel1");

  javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(
    jPanel12);
  jPanel12.setLayout(jPanel12Layout);
  jPanel12Layout
    .setHorizontalGroup(jPanel12Layout
      .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(
        jPanel12Layout
          .createSequentialGroup()
          .addContainerGap()
          .addGroup(
            jPanel12Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel12Layout
                  .createSequentialGroup()
                  .addGap(0,
                    293,
                    Short.MAX_VALUE)
                  .addComponent(
                    deleteStudentButton))
              .addGroup(
                jPanel12Layout
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
                jPanel12Layout
                  .createSequentialGroup()
                  .addGroup(
                    jPanel12Layout
                      .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(
                        lastNameLabel)
                      .addComponent(
                        studentEmailLabel)
                      .addComponent(
                        studentIDLabel))
                  .addGap(18,
                    18,
                    18)
                  .addGroup(
                    jPanel12Layout
                      .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(
                        lastName,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                      .addComponent(
                        studentID,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                      .addComponent(
                        studentEmail,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE))))
          .addContainerGap()));
  jPanel12Layout
    .setVerticalGroup(jPanel12Layout
      .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(
        jPanel12Layout
          .createSequentialGroup()
          .addContainerGap()
          .addGroup(
            jPanel12Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                firstNameLabel)
              .addComponent(firstName))
          .addGap(18, 18, 18)
          .addGroup(
            jPanel12Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                lastNameLabel)
              .addComponent(lastName))
          .addGap(18, 18, 18)
          .addGroup(
            jPanel12Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                studentIDLabel)
              .addComponent(studentID))
          .addGap(18, 18, 18)
          .addGroup(
            jPanel12Layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(
                studentEmailLabel)
              .addComponent(
                studentEmail))
          .addPreferredGap(
            javax.swing.LayoutStyle.ComponentPlacement.RELATED,
            70, Short.MAX_VALUE)
          .addComponent(deleteStudentButton)
          .addContainerGap()));

  selectCourse.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    selectCourseActionPerformed(evt);
   }
  });

  selectCourseLabel.setText("Select Course:");

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
  this.setLayout(layout);
  layout.setHorizontalGroup(layout
    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(
      layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(
          layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
              jPanel12,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE)
            .addGroup(
              layout.createSequentialGroup()
                .addGroup(
                  layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(
                      selectStudentLabel)
                    .addComponent(
                      selectCourseLabel))
                .addGap(18, 18,
                  18)
                .addGroup(
                  layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(
                      selectCourse,
                      0,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE)
                    .addComponent(
                      studentListCombo,
                      0,
                      288,
                      Short.MAX_VALUE))))
        .addContainerGap()));
  layout.setVerticalGroup(layout
    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(
      layout.createSequentialGroup()
        .addContainerGap(
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE)
        .addGroup(
          layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(selectCourseLabel)
            .addComponent(
              selectCourse,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(
          javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(
          layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(
              selectStudentLabel)
            .addComponent(
              studentListCombo,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(
          javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel12,
          javax.swing.GroupLayout.PREFERRED_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap()));
 }// </editor-fold>//GEN-END:initComponents

 private void studentListComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_studentListComboActionPerformed
  // TODO add your handling code here:
 }// GEN-LAST:event_studentListComboActionPerformed

 private void selectCourseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectCourseActionPerformed
  // TODO add your handling code here:
 }// GEN-LAST:event_selectCourseActionPerformed

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JButton deleteStudentButton;
 private javax.swing.JLabel firstName;
 private javax.swing.JLabel firstNameLabel;
 private javax.swing.JPanel jPanel12;
 private javax.swing.JLabel lastName;
 private javax.swing.JLabel lastNameLabel;
 private javax.swing.JComboBox selectCourse;
 private javax.swing.JLabel selectCourseLabel;
 private javax.swing.JLabel selectStudentLabel;
 private javax.swing.JLabel studentEmail;
 private javax.swing.JLabel studentEmailLabel;
 private javax.swing.JLabel studentID;
 private javax.swing.JLabel studentIDLabel;
 private javax.swing.JComboBox studentListCombo;
 // End of variables declaration//GEN-END:variables
}