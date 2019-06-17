

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class GUI extends JFrame {
	
	private double currentGrade = 0.0;
	
	private int weight = 0;
	
	private double possiblePointsAssignment = 0;
	private double possiblePointsCategory = 0.0;	
	private double currentPointsCategory = 0.0;
	
	
	private double otherGrades = 0.0;
	
	
	
	
	
	private double lowestPercent = 0.0;
	private double percentWithHighScore = 0.0;
	//public static double percentWithLowScore = 0.0;
	
    private JTextField LowPoints;
    private JTextField LowPointPercent;
    private JTextField HighPointPercent;
	
    public GUI() {
        // create frame and order list
        setTitle("Grade Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        // set up text field with lowPoints
        LowPoints = new JTextField("", 10);
        LowPoints.setEditable(false);
        LowPoints.setEnabled(false);
        LowPoints.setDisabledTextColor(Color.BLACK);
        
        // set up text field with lowPointsPercent
        LowPointPercent = new JTextField("", 10);
        LowPointPercent.setEditable(false);
        LowPointPercent.setEnabled(false);
        LowPointPercent.setDisabledTextColor(Color.BLACK);
        
        // set up text field with highPointsPercent
        HighPointPercent = new JTextField("", 10);
        HighPointPercent.setEditable(false);
        HighPointPercent.setEnabled(false);
        HighPointPercent.setDisabledTextColor(Color.BLACK);
        
        
        
        JPanel p = new JPanel();
        //this is where i can add more outputs
	        p.setBackground(Color.WHITE);
	        JLabel n = new JLabel("");
	        n.setForeground(Color.ORANGE);
	        
	        n = new JLabel("Lowest score before grade becomes B: ");
	        p.add(n);
	        p.add(LowPoints);
	        
	        n = new JLabel("Percentage with lowest points: ");
	        p.add(n);
	        p.add(LowPointPercent);
	        
	        n = new JLabel("Percentage if you get 100% on the assignment: ");
	        p.add(n);
	        p.add(HighPointPercent);
	        
	        
	        
	        add(p, BorderLayout.NORTH);

	        p = new JPanel(new GridLayout(5, 1));
	        
	        
	        for(int i = 1; i <= 5; i++)
	        	addItem(i, p);
	        
	        
	        add(p, BorderLayout.CENTER);
        
        // adjust size to just fit
        pack();
    }
    
    // adds a product to the panel, including a text field for user input of
    // the quantity
    private void addItem(final int i, JPanel p) {

        JPanel background = new JPanel(new FlowLayout(FlowLayout.LEFT));
        background.setBackground(Color.darkGray);
        final JTextField textBox = new JTextField(3);
        textBox.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JLabel description = null;
    
		if(i == 1) {
			textBox.setText("" + currentGrade);
			background.add(textBox);
	        description = new JLabel("Your current grade in the class (Eg. 97.23)");
	        description.setForeground(Color.white);
	        background.add(description);
	        p.add(background);
	        
	        textBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateItem(0.0, 1, textBox);
	                textBox.transferFocus();
	            }
	        });
	        textBox.addFocusListener(new FocusAdapter() {
	            public void focusLost( FocusEvent e) {
	                updateItem(0.0, 1, textBox);
	            }
	        });
		} else if(i == 2) {
			textBox.setText("" + weight);
			background.add(textBox);
	        description = new JLabel("The weight of the category the assignment is in (Eg. 30)");
	        description.setForeground(Color.white);
	        background.add(description);
	        p.add(background);
	        
	        textBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateItem(0, 2, textBox);
	                textBox.transferFocus();
	            }
	        });
	        textBox.addFocusListener(new FocusAdapter() {
	            public void focusLost(FocusEvent e) {
	                updateItem(0, 2, textBox);
	            }
	        });
		} else if(i == 3) {
			textBox.setText("" + possiblePointsAssignment);
			background.add(textBox);
	        description = new JLabel("The possible points you can get on the assigment (Eg. 15.0)");
	        description.setForeground(Color.white);
	        background.add(description);
	        p.add(background);
	        
	        textBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateItem(0, 3, textBox);
	                textBox.transferFocus();
	            }
	        });
	        textBox.addFocusListener(new FocusAdapter() {
	            public void focusLost(FocusEvent e) {
	                updateItem(0, 3, textBox);
	            }
	        });
		} else if(i == 4) {
			textBox.setText("" + possiblePointsCategory);
			background.add(textBox);
	        description = new JLabel("The total possible points of the category that the assignment is in (Eg. 20.0)");
	        description.setForeground(Color.white);
	        background.add(description);
	        p.add(background);
	        
	        textBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateItem(0.0, 4, textBox);
	                textBox.transferFocus();
	            }
	        });
	        textBox.addFocusListener(new FocusAdapter() {
	            public void focusLost(FocusEvent e) {
	                updateItem(0.0, 4, textBox);
	            }
	        });
		} else if(i == 5) {
			textBox.setText("" + currentPointsCategory);
			background.add(textBox);
	        description = new JLabel("The current points you have in the category that the assignment is in (Eg. 15.9)");
	        description.setForeground(Color.white);
	        background.add(description);
	        p.add(background);
	        
	       textBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateItem(0.0, 5, textBox);
	                textBox.transferFocus();
	            }
	        });
	        textBox.addFocusListener(new FocusAdapter() {
	            public void focusLost(FocusEvent e) {
	                updateItem(0.0, 5, textBox);
	            }
	        });
	        textBox.addKeyListener(new KeyAdapter() {
	            public void focusLost(KeyEvent e) {
	                updateItem(0.0, 5, textBox);
	            }
	        });
		}

        updateAnswers();
		
	}
	
    
    

    // When the user types a new value into one of the quantity fields,
    // parse the input and update the ShoppingCart.  Display an error
    // message if text is not a number or is negative.
    private void updateItem(double help, int variable, JTextField quantity) {
        double number;
        String text = quantity.getText().trim();
        try {
            number = Double.parseDouble(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number < 0 && text.length() > 0) {
            Toolkit.getDefaultToolkit().beep();
            quantity.setText("0.0");
            number = 0;
            return;
        }
        if(variable == 1) {
        	currentGrade = number;
        } else if(variable == 4) {
        	possiblePointsCategory = number;
        } else if(variable == 5) {
        	currentPointsCategory = number;
        }
        
        updateAnswers();
        
    }
    //overload
    private void updateItem(int help, int variable, JTextField quantity) {
        int number;
        String text = quantity.getText().trim();
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number < 0 && text.length() > 0 || text.length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            quantity.setText("0");
            number = 0;
            return;
        }
        
        if(variable == 2) {
        	weight = number;
        } else if(variable == 3) {
        	possiblePointsAssignment = number;
        }
        
        updateAnswers();
        
    }
    	

    // reset the text field for order total
    private void updateAnswers() {
    	
    	
    	if(weight != 100)
    		otherGrades = currentGrade - (currentPointsCategory / possiblePointsCategory) * weight; 
		
    	
    	
    	double lowestPoints = possiblePointsAssignment;
		
		
		for(double i = possiblePointsAssignment; i >= 0; i -= 0.1) {
			
			double newGrade = calculatePercent(i);
			if(newGrade < 90) {
				break;
			}
			lowestPoints = i;
			
		}
		
		lowestPercent = calculatePercent(lowestPoints)/100;

		
		//finds the highest class percentage you can possibly achieve
		percentWithHighScore = calculatePercent(possiblePointsAssignment)/100;

		//round everything to two decimal places
		lowestPoints = (double)((int)(((double)lowestPoints)*100))/100;
		lowestPercent = (double)((int)(((double)(lowestPercent)*100)*10000))/10000;
		percentWithHighScore = (double)((int)(((double)(percentWithHighScore)*100)*10000))/10000;
		possiblePointsAssignment = (double)((int)(((double)possiblePointsAssignment)*100))/100;
		
    	
        LowPoints.setText(lowestPoints + "/" + possiblePointsAssignment);
        LowPointPercent.setText((int)lowestPercent + "%");
        HighPointPercent.setText((int)percentWithHighScore + "%");
        
    }
    
    public double calculatePercent(double points) {
		 double total = points + currentPointsCategory;
		 total /= possiblePointsAssignment + possiblePointsCategory;
		 total *= weight;
		 total += otherGrades;
		 return total;
	}
}
