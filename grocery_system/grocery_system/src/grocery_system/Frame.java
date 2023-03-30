package grocery_system;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    
// Creating an object of Store class
Store Store1;

// Defining 5 JPanels
public JPanel panel1 ;
public JPanel panel2 ;
public JPanel panel3 ;
public JPanel panel4 ;
public JPanel panel5;
    
// Defining 2 JLabels
JLabel LabelUp;
JLabel LabelDown;
    
// Defining 1 JButton
JButton Button ;
    
// Defining 2 JTextAreas and 2 Fonts
JTextArea TextArea ;
JTextArea TextFild;
Font  Fonts; 
Font  Fonts2;
     
// Defining a constructor that takes an object of Store class as a parameter
public Frame(Store Store2){
         
    // Initializing Store1 with the passed object
    this.Store1= Store2;
    
    // Setting the title and size of the JFrame object
    this.setTitle("CS151-376-Group 3");
    this.setSize(600, 600);
    
    // Setting the default close operation and layout of the JFrame object
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(5,1));
      
    // Initializing 5 JPanels
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();
    panel4 = new JPanel();
    panel5= new JPanel();
      
    // Initializing 2 JLabels
    LabelUp = new JLabel("ENTER product ID :");
    LabelDown = new JLabel();
      
    // Initializing 1 JButton and setting its preferred size
    Button = new JButton("click");
    Button.setPreferredSize(new Dimension(150, 70));
      
    // Initializing 2 Fonts
    Fonts = new Font("SanSerif",Font.BOLD,14);
    Fonts2 = new Font("SanSerif",Font.BOLD,20);
      
    // Initializing 2 JTextAreas
    TextFild = new JTextArea();
    TextArea = new JTextArea();
    
    // Setting the layout of each JPanel
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
      
    // Setting the fonts of the JLabels and JButton
    LabelUp.setFont(Fonts2);
    Button.setFont(Fonts2);
    LabelDown.setFont(Fonts2);
    Button.setFont(Fonts2);
      
    // Setting the font of the first JTextArea
    TextArea.setFont(Fonts);
      
    // Adding the JPanels to the JFrame
    add(panel1);
    add(panel2);
    add(panel3);
    add(panel4);
    add(panel5);

    // Adding the JTextArea, JLabels and JButton to their respective JPanels
    panel1.add(TextArea);
    panel2.add(LabelUp);
    panel3.add(TextFild);
    panel4.add(Button);
    panel5.add(LabelDown);
       
    // Setting the preferred size, editability and text of the second JTextArea
    TextFild.setPreferredSize(new Dimension(500,500));
    TextFild.setEditable(true);
    TextFild.setText("");
	
    // Setting the preferred size, editability and text of the first JTextArea
    TextArea.setPreferredSize(new Dimension(600,600));
    TextArea.setEditable(false);
    TextArea.append(Store2.toString());
         // Making the frame visible
this.setVisible(true);

// Adding an action listener to the button
Button.addActionListener(this);

//------------------------------------------------------------
       // Overriding the actionPerformed method from the ActionListener interface
       @Override
       public void actionPerformed(ActionEvent e){
        	  
        	// Getting the product ID entered by the user from the TextFild JTextArea
            String MyID = TextFild.getText();
            // Parsing the ID string to an integer
            int ID = Integer.parseInt(MyID);

             // If the product with the given ID is successfully removed from the store
             if ( Store1.removeProduct(ID)){
	         LabelUp.setText(""); 
	         LabelDown.setText("Removed the product correctly");
              }
             // If the product with the given ID is not found in the store
            else {
	        LabelUp.setText("");
	        LabelDown.setText("The product cannot be removed, please enter an existing product ID");
            }

            // Clearing the first JTextArea and appending the updated store information
            TextArea.setText("");
	   TextArea.append(Store1.toString());}
