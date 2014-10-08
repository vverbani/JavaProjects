package team6;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the Edit Deliverable user interface
 * @author CS2212 - Team 6
 */
public class EditDeliverableUI extends javax.swing.JPanel {
	
    // Instance Variables                     
    private JLabel alert;
    private JComboBox<Course> courseListCombo;
    private JComboBox<Deliverable> deliverableCombo;
    private JLabel deliverableLabel;
    private JButton editDeliverableButton;
    private JPanel jPanel11;
    private JTextField name;
    private JLabel nameLabel;
    private JLabel selectCourseLabel;
    private JTextField type;
    private JLabel typeLabel;
    private JTextField weight;
    private JLabel weightLabel;
	private ArrayList<Course> courses;
	private ArrayList<Deliverable> deliverables;

    /**
     * Creates new form EditDeliverable
     * @param courses2 
     */
    public EditDeliverableUI(ArrayList<Course> courses) {
    	this.courses = courses;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        courseListCombo = new javax.swing.JComboBox<Course>();
        selectCourseLabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        weight = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        editDeliverableButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        alert = new javax.swing.JLabel();
        deliverableCombo = new javax.swing.JComboBox<Deliverable>();
        deliverableLabel = new javax.swing.JLabel();

        selectCourseLabel.setText("Select Course:");
        
        // Add list of courses to combo box
        for (int i = 0; i < courses.size(); i++) {
        	courseListCombo.addItem(courses.get(i));
        }
        
        courseListCombo.addActionListener(new java.awt.event.ActionListener() {
        	   public void actionPerformed(java.awt.event.ActionEvent evt) {
        	    courseListComboActionPerformed(evt);
        	   }
        	  });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameLabel.setText("Name:");

        weightLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        weightLabel.setText("Weight:");

        editDeliverableButton.setText("Update");
        editDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDeliverableButtonActionPerformed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        typeLabel.setText("Type:");
        
        deliverableLabel.setText("Select Deliverable: ");
        
        deliverableCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverableComboActionPerformed(evt);
            }
        });

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

       javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weightLabel)
                    .addComponent(nameLabel)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(editDeliverableButton))
                    .addComponent(type)
                    .addComponent(weight)
                    .addComponent(name))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDeliverableButton)
                    .addComponent(alert))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, name, type, weight});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCourseLabel)
                            .addComponent(deliverableLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliverableCombo, 0, 211, Short.MAX_VALUE)
                            .addComponent(courseListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(courseListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deliverableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliverableLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {courseListCombo, deliverableCombo});

    }                      

	/**
	* Action event handler for the edit button
	* @param evt	action event
	*/
    private void editDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// get the deliverable required	
    	if (courseListCombo.getSelectedIndex() > 0) {
    		if (deliverableCombo.getSelectedIndex() >= 0) {
    			double weightDouble = Double.parseDouble(weight.getText());
    			GradeBookUI.updateEditDeliverable(courseListCombo.getSelectedIndex(), deliverableCombo.getSelectedIndex(),
    					name.getText(), weightDouble, type.getText());
    			alert.setText("The deliverable has been edited");
    		}
			// if no deliverable was selected to edit and update button was pressed, show alert
    		else
    			alert.setText("A deliverable must be selected");
    	}
		// if no course was selected to choose a deliverable from and update button was pressed, show alert
    	else
    		alert.setText("A course must be selected");
    }
    
	/**
	* Action event handle for the course list combo box. Gets the course selected and populates the deliverables combo box
	* @param evt	action event
	*/
    private void courseListComboActionPerformed(java.awt.event.ActionEvent evt) {
		// get the course required
    	if (courseListCombo.getSelectedIndex() > 0) {
    		int c = courseListCombo.getSelectedIndex();
    		Course course = courses.get(c);
    		deliverables = course.getDeliverables();

    		// If the deliverables list within the course is not empty, add the list of deliverables to the combo box
    		if (!deliverables.isEmpty()) {
    			for (int i = 0; i < deliverables.size(); i++)
    				deliverableCombo.addItem(deliverables.get(i));

    			deliverableCombo.addActionListener(new java.awt.event.ActionListener() {
    				public void actionPerformed(java.awt.event.ActionEvent evt) {
    					deliverableComboActionPerformed(evt);
    				}
    			});
    		}
    	}
    }
    
	/**
	* Action method for the deliverable combo box
	* @param evt	action event
	*/
    private void deliverableComboActionPerformed(java.awt.event.ActionEvent evt) {

    } 
}
