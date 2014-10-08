package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement adding a deliverable to the gradebook
 * @author CS2212 - Team 6
 */
public class AddDeliverableUI extends javax.swing.JPanel {
	
    // Instance Variables                    
    private JButton addDeliverableButton;
    private JLabel alert;
    //private JComboBox<Course> courseListCombo;
    private JPanel jPanel;
    private JTextField name;
    private JLabel nameLabel;
    private JLabel selectCourseLabel;
    private JTextField type;
    private JLabel typeLabel;
    private JTextField weight;
    private JLabel weightLabel;
    //private ArrayList<Course> courses;
    private ArrayList<Deliverable> deliverables;

    /**
     * Creates new form AddDeliverable
     */
    public AddDeliverableUI(ArrayList<Course> courses) {
    	//this.courses = courses;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

		// initialize all items in the user interface
        jPanel = new JPanel();
        weight = new JTextField();
        name = new JTextField();
        nameLabel = new JLabel();
        weightLabel = new JLabel();
        addDeliverableButton = new JButton();
        typeLabel = new JLabel();
        type = new JTextField();
        alert = new JLabel();
        selectCourseLabel = new JLabel();
        //courseListCombo = new JComboBox();

        jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameLabel.setText("Name:");

        weightLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        weightLabel.setText("Weight:");

        addDeliverableButton.setText("Add");
        addDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliverableButtonActionPerformed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        typeLabel.setText("Type:");

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        
        selectCourseLabel.setText("Select Course:");
        /*
        // Add list of courses to combo box
        for (int i = 0; i < courses.size(); i++) {
        	courseListCombo.addItem(courses.get(i));
        }
        
		// call course list combo box action handler
        courseListCombo.addActionListener(new java.awt.event.ActionListener() {
        	   public void actionPerformed(java.awt.event.ActionEvent evt) {
        	    courseListComboActionPerformed(evt);
        	   }
        	  });
*/
		// user interface
         javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(weightLabel)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(type)
                    .addComponent(weight)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDeliverableButton)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alert)
                    .addComponent(addDeliverableButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, name, type, weight});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    /*.addGroup(layout.createSequentialGroup()
                        .addComponent(selectCourseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))*/)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                /*.addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCourseLabel))*/
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }               

	/**
	* Action handler for add button to add a deliverable to the gradebook
	* @param evet	action handler
	*/
    private void addDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
		/*if (courseListCombo.getSelectedIndex() > 0) {
			double weightDouble = Double.parseDouble(weight.getText());
			GradeBookUI.updateAddDeliverable(type.getText(), name.getText(), weightDouble);
			alert.setText("The deliverable has been added");
		}
		// display alert if no course was selected and add button was pushed
		else
			alert.setText("A course must be selected");*/
			double weightDouble = Double.parseDouble(weight.getText());
			GradeBookUI.updateAddDeliverable(type.getText(), name.getText(), weightDouble);
    }

	/**
	* Action handler for course list combo box
	* @param evt	action handler
	*/
    /*private void courseListComboActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }*/
}
