package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the delete deliverable user interface
 * @author CS2212 - Team 6
 */
public class DeleteDeliverableUI extends javax.swing.JPanel {
	
    // Instance Variables                  
    private JLabel alert;
    private JComboBox<Course> courseListCombo;
    private JButton deleteDeliverableButton;
    private JComboBox<Deliverable> deliverableCombo;
    private JLabel deliverableLabel;
    private JPanel jPanel11;
    private JLabel name;
    private JLabel nameLabel;
    private JLabel selectCourseLabel;
    private JLabel type;
    private JLabel typeLabel;
    private JLabel weight;
    private JLabel weightLabel; 
    private ArrayList<Course> courses;
	private ArrayList<Deliverable> deliverables;

    /**
     * Creates new form DeleteDeliverable
     */
    public DeleteDeliverableUI(ArrayList<Course> courses) {
    	this.courses = courses;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")                   
    private void initComponents() {

        selectCourseLabel = new JLabel();
        courseListCombo = new JComboBox<Course>();
        deliverableCombo = new JComboBox<Deliverable>();
        deliverableLabel = new JLabel();
        jPanel11 = new JPanel();
        nameLabel = new JLabel();
        weightLabel = new JLabel();
        deleteDeliverableButton = new JButton();
        typeLabel = new JLabel();
        alert = new JLabel();
        name = new JLabel();
        weight = new JLabel();
        type = new JLabel();

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

        deliverableLabel.setText("Select Deliverable: ");
        
        deliverableCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverableComboActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameLabel.setText("Name:");

        weightLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        weightLabel.setText("Weight:");

        deleteDeliverableButton.setText("Delete");
        deleteDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDeliverableButtonActionPerformed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        typeLabel.setText("Type:");

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		// user interface layout
        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weightLabel)
                    .addComponent(typeLabel)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteDeliverableButton))
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(weight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel)
                    .addComponent(weight))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(type))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteDeliverableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {name, type, typeLabel, weight});

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
                            .addComponent(deliverableCombo, 0, 300, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {courseListCombo, deliverableCombo});

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

    		// If the deliverable list within the course is not empty, add the list of deliverables to student combo box
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
	* Action event handler for the delete button
	* @param evt	action event
	*/
    private void deleteDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// get the deliverable required
		 if (courseListCombo.getSelectedIndex() > 0) {
			 if (deliverableCombo.getSelectedIndex() >= 0) {
				 GradeBookUI.updateDeleteDeliverable(courseListCombo.getSelectedIndex(), deliverableCombo.getSelectedIndex());
				 alert.setText("The deliverable has been deleted");
			 }
			 // if no deliverable was selected to delete and delete button was pressed, show alert
			 else
				 alert.setText("A deliverable must be selected");
		 }
		 // if no course was selected to choose a deliverable from and delete button was pressed, show alert
		 else
			 alert.setText("A course must be selected");
    }
    
	/**
	* Action method for the deliverable combo box to display the info of the object selected
	* @param evt	action event
	*/
    private void deliverableComboActionPerformed(java.awt.event.ActionEvent evt) {
		// populate information of deliverable to be deleted for user
    	name.setText(deliverables.get(deliverableCombo.getSelectedIndex()).getName());
    	type.setText(deliverables.get(deliverableCombo.getSelectedIndex()).getType());
    	String weightStr = Double.toString(deliverables.get(deliverableCombo.getSelectedIndex()).getWeight()) + "%";
    	weight.setText(weightStr); 
    } 
}
