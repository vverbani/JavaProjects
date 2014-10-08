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
    private JPanel jPanel;
    private JTextField name;
    private JLabel nameLabel;
    private JTextField type;
    private JLabel typeLabel;
    private JTextField weight;
    private JLabel weightLabel;
	private JRadioButton assgnmtRBtn;
	private JRadioButton examRBtn;
	private ButtonGroup group;
	private double weightSum;
	private ArrayList<Deliverable>deliverables;
    /**
     * Creates new form AddDeliverable
     */
    public AddDeliverableUI(double weightSum, ArrayList<Deliverable> deliverables) {
		this.weightSum = weightSum;
		this.deliverables = deliverables;
        initComponents();
    }
	
	/**
	* Action handler for add button to add a deliverable to the gradebook
	* @param evet	action handler
	*/
    private void addDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// if no name is not is inserted, then show alert
		if (name.getText().equals(""))
			alert.setText("A deliverable name must be entered");
		else {
			try {
				double weightDouble = Double.parseDouble(weight.getText());
				//if the entered weight is greater than 0, add deliverable
				if (weightDouble > 0) {
					//System.out.println("WeightDouble: "+ weightDouble);
					//System.out.println( "weightSum" + weightSum);
					// if the total weight of all deliverable is not greater than 100%, add deliverable
					if ((weightSum+weightDouble) <= 100) {
						//if the deliverable name is already in use
						if(!find(name.getText()))
						{
							// if assignment is selected, add deliverable
							if (assgnmtRBtn.isSelected())
								GradeBookUI.updateAddDeliverable("Assignment", name.getText(), weightDouble);
							// if exam is selected, add deliverable
							else if (examRBtn.isSelected())
								GradeBookUI.updateAddDeliverable("Exam", name.getText(), weightDouble);
							// if not type is selected, show alert
							else
								alert.setText("A deliverable's type must be selected");
						}
						else
							alert.setText("This deliverable name is already in use for the given course");
					}
					else
						alert.setText("The weight of all deliverables is greater than 100%");
				}
				else
					alert.setText("The deliverable weight must be greater than zero");
			}
			// if the weight is parsed and it is not a number, catch exception and show alert
			catch(NumberFormatException e) {
				alert.setText("A deliverable's weight must be a number");
			}
		}
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
		assgnmtRBtn = new JRadioButton();
		examRBtn = new JRadioButton();
        alert = new JLabel();
		group = new ButtonGroup();

        jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12));
        nameLabel.setText("Name:");

        weightLabel.setFont(new java.awt.Font("Arial", 0, 12));
        weightLabel.setText("Weight:");

        addDeliverableButton.setText("Add");
        addDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliverableButtonActionPerformed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        typeLabel.setText("Type:");
		
		assgnmtRBtn.setText("Assignment");
        examRBtn.setText("Exam");
		
		// add radio buttons to the button group
		group.add(assgnmtRBtn);
		group.add(examRBtn);

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  
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
                    .addComponent(weight)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDeliverableButton))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(assgnmtRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(examRBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assgnmtRBtn, examRBtn});

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
                    .addComponent(typeLabel)
                    .addComponent(assgnmtRBtn)
                    .addComponent(examRBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alert)
                    .addComponent(addDeliverableButton))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, name, weight});

        jPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {assgnmtRBtn, examRBtn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }           
    /**
     * Checks whether or not a deliverable is in the course
     * @param s the name of the deliverable
     * @return boolean depending on the success of the search
     */
	private boolean find(String s)
	{
		for(int i = 0; i < deliverables.size(); i++)
		{
			if(s.equals(deliverables.get(i).getName()))
				return true;
		}
		return false;
	}
}
