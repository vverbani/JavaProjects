package team6;

/**
 * GradeBook application that a teacher or professor can use to track students' grades.
 * The user can create, edit and delete courses, students and deliverables which are then generated item a report
 * where grades can be entered. Lists of students and grades can be imported and exported and student grades reports
 * can be emailed to individual students.
 * The application uses Git for version control, Maven for build automation, JUnit for unit testing, a Jenkins server for Continuous
 * Integration, and JaCoCo for coverage reports
 *@author  University of Western Ontario (UWO) - Computer Science class 2212 - Team 6 Project
 */
public class App{

  
  /**
   * Runs the gradebook application
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
             .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(GradeBookUI.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(GradeBookUI.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(GradeBookUI.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GradeBookUI.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GradeBookUI().setVisible(true);
      }
    });
  }
}