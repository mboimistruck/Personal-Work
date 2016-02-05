//NOTES:
//Fix strings for popups for 3x3s
//Add calculations for 4x4 *sigh*
//Cut out all the System.out.prints
//Compress file/clean up

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class MatrixCalculator extends JPanel {

    private static JComboBox operationsComboBox;
    private static JComboBox matrixComboBox;
	private static JTextField w1;//column 1
	private static JTextField w2;
	private static JTextField w3;
	private static JTextField w4;
	private static JTextField x1; //column 2
	private static JTextField x2;
	private static JTextField x3;
	private static JTextField x4;
	private static JTextField y1;//column 3
	private static JTextField y2;
	private static JTextField y3;
	private static JTextField y4;
	private static JTextField z1;//column 4
	private static JTextField z2;
	private static JTextField z3;
	private static JTextField z4;
	private static JTextField answer1;// column 5/answer
	private static JTextField answer2;
	private static JTextField answer3;
	private static JTextField answer4;
	public static int matrixSetting = 0;
	public static int operationsSetting = 0;
	public static int solved = 0;
	public static int switched = 0;

	public static JTextField w1Var;
	public static JTextField w2Var;
	public static JTextField w3Var;
	public static JTextField w4Var;
	
	public static JTextField x1Var;
	public static JTextField x2Var;
	public static JTextField x3Var;
	public static JTextField x4Var;
	
	public static JTextField y1Var;
	public static JTextField y2Var;
	public static JTextField y3Var;
	public static JTextField y4Var;
	
	public static JTextField z1Var;
	public static JTextField z2Var;
	public static JTextField z3Var;
	public static JTextField z4Var;
	
	public static JTextField answer1Var;
	public static JTextField answer2Var;
	public static JTextField answer3Var;
	public static JTextField answer4Var;
	
	//public static String w1Answer;
	//public static String w2Answer;
	public static String w3Answer;
	public static String w4Answer;
	
	public static String x1Answer;
	public static String x2Answer;
	
	public static String y1Answer;
		
	public static String z1Answer;
	
	public static String answer1Answer;
	public static String answer2Answer;

	
    // Create a form with the fields
    public MatrixCalculator() {
        super(new BorderLayout());
        // Panel for the labels
        JPanel labelPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        add(labelPanel, BorderLayout.WEST);

        // Panel for the fields
        JPanel fieldPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        add(fieldPanel, BorderLayout.CENTER);

        // Combobox
        JLabel labelOperationsCombo = new JLabel("Operation Type:");

        // Options in the combobox
        String[] operationsOptions = { "Gauss Jordan Elimination(Reduced Row Echelon)", "Matrix Multiplication" };
		String[] matrixOptions = { "2x2", "3x3", "4x4" };
        operationsComboBox = new JComboBox(operationsOptions);
		
		operationsComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                // Do something when you select a value

            }
        });

        // Textfield
        JLabel labelMatrixComboBox = new JLabel("Matrix Size");
        matrixComboBox = new JComboBox(matrixOptions);

        // Add labels
        labelPanel.add(labelOperationsCombo);
        labelPanel.add(labelMatrixComboBox);

        // Add fields
        fieldPanel.add(operationsComboBox);
        fieldPanel.add(matrixComboBox);
    }

    public static void main(String[] args) {

        final MatrixCalculator form = new MatrixCalculator();

        // Button
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             performAction((String) operationsComboBox.getSelectedItem(), (String)matrixComboBox.getSelectedItem()); 

		  
            }
        });


        // Frame 
        JFrame f = new JFrame("Matrix Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);

        // Panel with the button
        JPanel p = new JPanel();
        p.add(generateButton);
        f.getContentPane().add(p, BorderLayout.SOUTH);

        // Show the frame
        f.pack();
        f.setVisible(true);
    }
    private static void performAction(String selectedItem, String text) {

        // Do stuff with the data
        System.out.println("You selected to do:  " + selectedItem + " with a  " + text +" matrix.");
		if (matrixComboBox.getSelectedItem().equals("2x2")){
			matrixSetting = 1;
		}
		if (matrixComboBox.getSelectedItem().equals("3x3")){
			matrixSetting = 2;
		}
		if (matrixComboBox.getSelectedItem().equals("4x4")){
			matrixSetting = 3;
		}
		if (operationsComboBox.getSelectedItem().equals("Gauss Jordan Elimination(Reduced Row Echelon)")){
			operationsSetting = 1;
		}
		if (operationsComboBox.getSelectedItem().equals("Matrix Multiplication")){
			operationsSetting = 2;
		}
		// 2x2
		if (matrixSetting == 1 && operationsSetting == 1){
			JFrame inputFrame = new JFrame("2x2 Matrix - Gauss Jordan Elimination(Reduced Row Reduction)");
        	JPanel labelPanel2 = new JPanel(new GridLayout(2, 3));// 2 rows by 3 columns 
        	inputFrame.getContentPane().add(labelPanel2, BorderLayout.WEST);
        	JPanel fieldPanel2 = new JPanel(new GridLayout(2, 3)); 
        	inputFrame.getContentPane().add(fieldPanel2, BorderLayout.CENTER);

			JLabel inputLabelW1 = new JLabel("X1");
			JLabel inputLabelW2 = new JLabel("X2");
			JLabel inputLabelX1 = new JLabel("Y1");
			JLabel inputLabelX2 = new JLabel("Y2");
			JLabel inputLabelAnswer1 = new JLabel("= Z1");
			JLabel inputLabelAnswer2 = new JLabel("= Z2");

			x1 = new JTextField();
			x2 = new JTextField();
			w1 = new JTextField();
			w2 = new JTextField();	
			answer1 = new JTextField();
			answer2 = new JTextField();


			labelPanel2.add(inputLabelW1);
        	labelPanel2.add(inputLabelX1);
			labelPanel2.add(inputLabelAnswer1);
			labelPanel2.add(inputLabelW2);
			labelPanel2.add(inputLabelX2);
			labelPanel2.add(inputLabelAnswer2);

        	fieldPanel2.add(w1);
        	fieldPanel2.add(x1);
			fieldPanel2.add(answer1);
			fieldPanel2.add(w2);
			fieldPanel2.add(x2);
			fieldPanel2.add(answer2);

			JButton calculateButton = new JButton("Calculate");
			calculateButton.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent e) {
					System.out.print(w1.getText()+" ");
					System.out.print(x1.getText()+" | ");
					System.out.println(answer1.getText());
				
					System.out.print(w2.getText()+" ");
					System.out.print(x2.getText()+" | ");
					System.out.println(answer2.getText());
										
					String w1Answer = w1.getText();
					double w1Answers = Double.parseDouble(w1Answer);
					String w2Answer = w2.getText();
					double w2Answers = Double.parseDouble(w2Answer);
					
					String x1Answer = x1.getText();
					double x1Answers = Double.parseDouble(x1Answer);
					String x2Answer = x2.getText();
					double x2Answers = Double.parseDouble(x2Answer);
					
					String answer1Answer = answer1.getText();
					double answer1Answers = Double.parseDouble(answer1Answer);
					String answer2Answer = answer2.getText();
					double answer2Answers = Double.parseDouble(answer2Answer);
					double originalW1 = w1Answers;
					double originalW2 = w2Answers;
					double originalX1 = x1Answers;
					double originalX2 = x2Answers;
					double originalAnswer1 = answer1Answers;
					double originalAnswer2 = answer2Answers;
					System.out.println("Step 1 - Divide whole first row by X1");
					if (w1Answers != 1){
						w1Answers = w1Answers/originalW1;
						x1Answers = x1Answers/originalW1;
						answer1Answers = answer1Answers/originalW1;
					}
					final String step1 = new String ("STEP 1 - Pivot "+originalW1+" to 1 by dividing the first row by "+originalW1+"\n"+w1Answers+" "+x1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" | "+answer2Answers);

					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.println(" | "+ answer2Answers);
					//step 1
					if (w1Answers == 1){
						originalW2 = w2Answers;
						w2Answers = w2Answers-(w1Answers*originalW2);
						x2Answers = x2Answers-(x1Answers*originalW2);
						answer2Answers = answer2Answers-(answer1Answers*originalW2);
						System.out.println("____STEP 2____");
						System.out.println("Multiply Row 1 by Row 2 (temporarily), then subtract Row 2 by the new Row 1. Then revert Row 1 back to what it was originally\n");
						System.out.print(w1Answers+" ");
						System.out.print(x1Answers+" ");
						System.out.println(" | "+ answer1Answers);
				
						System.out.print(w2Answers+" ");
						System.out.print(x2Answers+" ");
						System.out.println(" | "+ answer2Answers);
						//step 2 done

						System.out.println("Turn Y2 into 1 by dividing it by "+x2Answers+", and divide rest of row by "+x2Answers+"\n");
					}
					final String step2 = new String ("STEP 2 - Multiply Row 1 by "+originalW2+" (temporarily), then subtract Row 2 by the new Row 1. Then revert Row 1 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" | "+answer2Answers);
						if((w2Answers == 0 && x2Answers == 0 && answer2Answers == 0)||(w1Answers == 0 && x1Answers == 0 && answer1Answers == 0)){
							System.out.println("SOLVED");
							System.out.println("Solution Set: ");
							System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
							JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
						} 
							System.out.println("____STEP 3____");
							originalX2 = x2Answers;
							x2Answers = x2Answers/x2Answers;
							if (x2Answers < 0 && x2Answers != 1){
								x2Answers = x2Answers*-1;
								answer2Answers = answer2Answers/originalX2;
							} else if (x2Answers == 1){
								answer2Answers = answer2Answers/originalX2;
							}
							final String step3 = new String ("STEP 3 - Pivot "+originalX2+" to 1 by dividing the first row by "+originalX2+"\n"+w1Answers+" "+x1Answers+" | "+answer1Answers+
									"\n"+w2Answers+" "+x2Answers+" | "+answer2Answers);
							//step 3 done
							System.out.print(w1Answers+" ");
							System.out.print(x1Answers+" ");
							System.out.println(" | "+ answer1Answers);
				
							System.out.print(w2Answers+" ");
							System.out.print(x2Answers+" ");
							System.out.println(" | "+ answer2Answers);
							System.out.println("____STEP 4____");
							System.out.println("Multiply Row 2 by Row 1 (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n");
							originalX1 = x1Answers;
							if (x1Answers != 0){
								x1Answers = x1Answers-(x2Answers*x1Answers);
								answer1Answers = answer1Answers-(originalX1*answer2Answers);
							}
							System.out.print(w1Answers+" ");
							System.out.print(x1Answers+" ");
							System.out.println(" | "+ answer1Answers);
				
							System.out.print(w2Answers+" ");
							System.out.print(x2Answers+" ");
							System.out.println(" | "+ answer2Answers);
							//step 4 done
							final String step4 = new String ("STEP 4 - Multiply Row 2 by "+originalX1+" (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" | "+answer1Answers+
									"\n"+w2Answers+" "+x2Answers+" | "+answer2Answers);
							if (w1Answers == 1 && w2Answers == 0 && x1Answers == 0 && x2Answers == 1){
								System.out.println("SOLVED");
								System.out.println("Solution Set: ");
								System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
								JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
							}
						
					

					JFrame outputFrame = new JFrame("2x2 Matrix - Gauss Jordan Elimination(Reduced Row Reduction) - SOLUTION");
					
        			JPanel fieldPanel3 = new JPanel(new GridLayout(2, 3));// 2 rows by 3 columns 
        			outputFrame.getContentPane().add(fieldPanel3, BorderLayout.WEST);
					
					x1Var = new JTextField(" "+x1Answers);
					x2Var = new JTextField(" "+x2Answers);
					w1Var = new JTextField(" "+w1Answers);
					w2Var = new JTextField(" "+w2Answers);	
					answer1Var = new JTextField(" "+answer1Answers);
					answer2Var = new JTextField(" "+answer2Answers);
					
					fieldPanel3.add(w1Var);
					fieldPanel3.add(x1Var);
					fieldPanel3.add(answer1Var);
					fieldPanel3.add(w2Var);
					fieldPanel3.add(x2Var);
					fieldPanel3.add(answer2Var);
					x1Var.setEditable(false);
					x2Var.setEditable(false);
					w1Var.setEditable(false);
					w2Var.setEditable(false);
					answer1Var.setEditable(false);
					answer2Var.setEditable(false);
	    			JButton stepsButton = new JButton("Show Steps");
	            	stepsButton.addActionListener(new ActionListener() {
	    				@Override
	    				public void actionPerformed(ActionEvent e) {
	    	        		JOptionPane.showMessageDialog(null," "+step1);
							JOptionPane.showMessageDialog(null," "+step2);
							JOptionPane.showMessageDialog(null," "+step3);
							JOptionPane.showMessageDialog(null," "+step4);
	    				}
	    				
	    			});
	            	outputFrame.add(stepsButton, BorderLayout.SOUTH);
					outputFrame.pack();
					outputFrame.setVisible(true);
					outputFrame.setSize(350,100);
					
				}
        	});
			
			inputFrame.add(calculateButton, BorderLayout.SOUTH);
			inputFrame.pack();
			inputFrame.setVisible(true);
			inputFrame.setSize(350,100);
		}
		// 3x3
		if (matrixSetting == 2 && operationsSetting == 1){

			JFrame inputFrame = new JFrame("3x3 Matrix - Gauss Jordan Elimination(Reduced Row Reduction)");
        	JPanel labelPanel2 = new JPanel(new GridLayout(3, 4));// 3 rows by 4 columns 
        	inputFrame.getContentPane().add(labelPanel2, BorderLayout.WEST);
        	JPanel fieldPanel2 = new JPanel(new GridLayout(3, 4)); 
        	inputFrame.getContentPane().add(fieldPanel2, BorderLayout.CENTER);

			JLabel inputLabelW1 = new JLabel("W1");
			JLabel inputLabelW2 = new JLabel("W2");
			JLabel inputLabelW3 = new JLabel("W3");
			JLabel inputLabelX1 = new JLabel("X1");
			JLabel inputLabelX2 = new JLabel("X2");
			JLabel inputLabelX3 = new JLabel("X3");
			JLabel inputLabelY1 = new JLabel("Y1");
			JLabel inputLabelY2 = new JLabel("Y2");
			JLabel inputLabelY3 = new JLabel("Y3");
			JLabel inputLabelAnswer1 = new JLabel("= Z1");
			JLabel inputLabelAnswer2 = new JLabel("= Z2");
			JLabel inputLabelAnswer3 = new JLabel("= Z3");

			y1 = new JTextField();
			y2 = new JTextField();
			y3 = new JTextField();
			x1 = new JTextField();
			x2 = new JTextField();
			x3 = new JTextField();
			w1 = new JTextField();
			w2 = new JTextField();
			w3 = new JTextField();	
			answer1 = new JTextField();
			answer2 = new JTextField();
			answer3 = new JTextField();


			labelPanel2.add(inputLabelW1);
        	labelPanel2.add(inputLabelX1);
			labelPanel2.add(inputLabelY1);
			labelPanel2.add(inputLabelAnswer1);
			labelPanel2.add(inputLabelW2);
			labelPanel2.add(inputLabelX2);
			labelPanel2.add(inputLabelY2);
			labelPanel2.add(inputLabelAnswer2);
			labelPanel2.add(inputLabelW3);
			labelPanel2.add(inputLabelX3);
			labelPanel2.add(inputLabelY3);
			labelPanel2.add(inputLabelAnswer3);


        	fieldPanel2.add(w1);
        	fieldPanel2.add(x1);
			fieldPanel2.add(y1);
			fieldPanel2.add(answer1);
			fieldPanel2.add(w2);
			fieldPanel2.add(x2);
			fieldPanel2.add(y2);
			fieldPanel2.add(answer2);
			fieldPanel2.add(w3);
			fieldPanel2.add(x3);
			fieldPanel2.add(y3);
			fieldPanel2.add(answer3);

			JButton calculateButton = new JButton("Calculate");
        	calculateButton.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent e) {
					solved = 0;	
					String w1Answer = w1.getText();
					double w1Answers = Double.parseDouble(w1Answer);
					String w2Answer = w2.getText();
					double w2Answers = Double.parseDouble(w2Answer);
					String w3Answer = w3.getText();
					double w3Answers = Double.parseDouble(w3Answer);
					
					String x1Answer = x1.getText();
					double x1Answers = Double.parseDouble(x1Answer);
					String x2Answer = x2.getText();
					double x2Answers = Double.parseDouble(x2Answer);
					String x3Answer = x3.getText();
					double x3Answers = Double.parseDouble(x3Answer);
					
					String answer1Answer = answer1.getText();
					double answer1Answers = Double.parseDouble(answer1Answer);
					String answer2Answer = answer2.getText();
					double answer2Answers = Double.parseDouble(answer2Answer);
					String answer3Answer = answer3.getText();
					double answer3Answers = Double.parseDouble(answer3Answer);

					String y1Answer = y1.getText();
					double y1Answers = Double.parseDouble(y1Answer);
					String y2Answer = y2.getText();
					double y2Answers = Double.parseDouble(y2Answer);
					String y3Answer = y3.getText();
					double y3Answers = Double.parseDouble(y3Answer);
					
					double originalW1 = w1Answers;
					double originalW2 = w2Answers;
					double originalW3 = w3Answers;
					double originalX1 = x1Answers;
					double originalX2 = x2Answers;
					double originalX3 = x3Answers;
					double originalY1 = y1Answers;
					double originalY2 = y2Answers;
					double originalY3 = y3Answers;
					double originalAnswer1 = answer1Answers;
					double originalAnswer2 = answer2Answers;
					double originalAnswer3 = answer3Answers;
					System.out.println();
					System.out.println("Your Matrix");
					System.out.println();	
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);
					System.out.println();
					System.out.println("____STEP 1____");
					System.out.println("Divide whole first row by X1");
					if (w1Answers == 0 && switched == 0){

						if (w2Answers != 0){

						w1Answers = w2Answers;
						x1Answers = x2Answers;
						y1Answers = y2Answers;
						answer1Answers = answer2Answers;

						w2Answers = originalW1;
						x2Answers = originalX1;
						y2Answers = originalY1;
						answer2Answers = originalAnswer1;
						switched = 1;
						}else if (w3Answers != 0){
				
						w1Answers = w3Answers;
						x1Answers = x3Answers;
						y1Answers = y3Answers;
						answer1Answers = answer3Answers;

						w3Answers = originalW1;
						x3Answers = originalX1;
						y3Answers = originalY1;
						answer3Answers = originalAnswer1;
						switched = 2;
						}
					System.out.println();
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);	
					}
					//if (w1Answers > 0){
					if (w1Answers != 1 && w1Answers != 0){
						if (switched == 1){
						w1Answers = w1Answers/originalW2;
						x1Answers = x1Answers/originalW2;
						y1Answers = y1Answers/originalW2;
						answer1Answers = answer1Answers/originalW2;
						}else if(switched == 2){
						w1Answers = w1Answers/originalW3;
						x1Answers = x1Answers/originalW3;
						y1Answers = y1Answers/originalW3;
						answer1Answers = answer1Answers/originalW3;
						}
					}
					final String step1 = new String ("STEP 1 - Divide the first row by "+originalW1+"\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					System.out.println();
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);
					System.out.println();
					//step 1
					if (w1Answers == 1 && w2Answers != 0){
						System.out.println("____STEP 2____");
						System.out.println("Multiply Row 1 by Row 2 (temporarily), then subtract Row 2 by the new Row 1. Then revert Row 1 back to what it was originally\n");
						w2Answers = w2Answers-(w1Answers*originalW2);
						x2Answers = x2Answers-(x1Answers*originalW2);
						y2Answers = y2Answers-(y1Answers*originalW2);
						answer2Answers = answer2Answers-(answer1Answers*originalW2);
						System.out.print(w1Answers+" ");
						System.out.print(x1Answers+" ");
						System.out.print(y1Answers+" ");
						System.out.println(" | "+ answer1Answers);
				
						System.out.print(w2Answers+" ");
						System.out.print(x2Answers+" ");
						System.out.print(y2Answers+" ");
						System.out.println(" | "+ answer2Answers);

						System.out.print(w3Answers+" ");
						System.out.print(x3Answers+" ");
						System.out.print(y3Answers+" ");
						System.out.println(" | "+ answer3Answers);
						System.out.println();

						//step 2 done
					}
					final String step2 = new String ("STEP 2 - Multiply Row 2 by "+w1Answers+" (temporarily), then subtract Row 3 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
						if((w2Answers == 0 && x2Answers == 0 && answer2Answers == 0)||(w1Answers == 0 && x1Answers == 0 && answer1Answers == 0)){
							System.out.println("SOLVED");
							System.out.println("Solution Set: ");
							System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
							JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
							solved++;
						}
						if(w3Answers != 0){
							System.out.println("____STEP 3____");
							System.out.println("Multiply Row 2 by Row 3 (temporarily), then subtract Row 3 by the new Row 2. Then revert Row 2 back to what it was originally\n");
							w3Answers = w3Answers-(w1Answers*originalW3);
							x3Answers = x3Answers-(x1Answers*originalW3);
							y3Answers = y3Answers-(y1Answers*originalW3);
							answer3Answers = answer3Answers-(answer1Answers*originalW3);
							System.out.print(w1Answers+" ");
							System.out.print(x1Answers+" ");
							System.out.print(y1Answers+" ");
							System.out.println(" | "+ answer1Answers);
				
							System.out.print(w2Answers+" ");
							System.out.print(x2Answers+" ");
							System.out.print(y2Answers+" ");
							System.out.println(" | "+ answer2Answers);

							System.out.print(w3Answers+" ");
							System.out.print(x3Answers+" ");
							System.out.print(y3Answers+" ");
							System.out.println(" | "+ answer3Answers);
							System.out.println();
						}
						final String step3 = new String ("STEP 3 - Multiply "+w2Answer+" by Row 3 (temporarily), then subtract Row 3 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
								"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
								"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
						System.out.println("____STEP 4____");
						System.out.println("Turn "+x2Answers+" into 1 by dividing the row by "+x2Answers+"\n");
						if(x2Answers != 1){
							originalX2 = x2Answers;
							x2Answers = x2Answers/x2Answers;
						}
						if (x2Answers < 0 && x2Answers != 1){
							x2Answers = x2Answers*-1;
							answer2Answers = answer2Answers/originalX2;
						} else if (x2Answers == 1){
							y2Answers = y2Answers/originalX2;
							answer2Answers = answer2Answers/originalX2;
						}
						final String step4 = new String ("STEP 4 - Pivot "+originalX2+" into 1 by dividing the row by "+originalX2+"\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
								"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
								"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
						//step 4 done
						System.out.print(w1Answers+" ");
						System.out.print(x1Answers+" ");
						System.out.print(y1Answers+" ");
						System.out.println(" | "+ answer1Answers);
				
						System.out.print(w2Answers+" ");
						System.out.print(x2Answers+" ");
						System.out.print(y2Answers+" ");
						System.out.println(" | "+ answer2Answers);

						System.out.print(w3Answers+" ");
						System.out.print(x3Answers+" ");
						System.out.print(y3Answers+" ");
						System.out.println(" | "+ answer3Answers);
						System.out.println();
						System.out.println("____STEP 5____");
						System.out.println("Multiply Row 2 by Row 1 (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n");
						originalX1 = x1Answers;
						if (x1Answers != 0){
							x1Answers = x1Answers-(x2Answers*x1Answers);
							y1Answers = y1Answers-(originalX1*y2Answers);
							answer1Answers = answer1Answers-(originalX1*answer2Answers);
						}
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);
					System.out.println();
					final String step5 = new String ("STEP 5 - Multiply "+originalX1+" by Row 1 (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					//step 5 done
					if((w2Answers == 0 && x2Answers == 0 && y2Answers == 0 && answer2Answers == 0)||(w1Answers == 0 && x1Answers == 0 && y1Answers == 0 && answer1Answers == 0)){
						System.out.println("SOLVED");
						System.out.println("Solution Set: ");
						System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
						JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n");
					}
					System.out.println("____STEP 6____");
					System.out.println("Multiply Row 2 by "+x3Answers+" (temporarily), then subtract Row 3 by the new Row 2. Then revert Row 2 back to what it was originally\n");
					if (x3Answers != 0){
						originalX3 = x3Answers;
						x3Answers = x3Answers-(x2Answers*x3Answers);
						y3Answers = y3Answers-(originalX3*y2Answers);
						answer3Answers = answer3Answers-(originalX3*answer2Answers);
					}
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);
					System.out.println();
					final String step6 = new String ("STEP 6 - Multiply Row 2 by "+x3Answers+" (temporarily), then subtract Row 3 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					if (w3Answers == 0 && x3Answers == 0 && y3Answers == 0 && answer3Answers == 0){
						solved++;
						System.out.println("SOLVED");
						System.out.println("Solution Set: ");
						System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n"+"X3 = "+answer3Answers+"\n");
						JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n"+"X3 = "+answer3Answers+"\n");
					}
					if(y3Answers != 1 && solved == 0){
						System.out.println("____STEP 7____");
						System.out.println("Pivot "+y3Answers+" to 1 by dividing the row by "+y3Answers+"\n");
						originalY3 = y3Answers;
						y3Answers = y3Answers/y3Answers;
					}
					if (y3Answers < 0 && y3Answers != 1){
						y3Answers = y3Answers*-1;
						answer3Answers = answer3Answers/originalY3;
					} else if (y3Answers == 1){
							answer3Answers = answer3Answers/originalY3;
					}
					final String step7 = new String ("STEP 7 - Pivot "+y3Answers+" to 1 by dividing the row by "+y3Answers+"\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					//step 7 done
					System.out.print(w1Answers+" ");
					System.out.print(x1Answers+" ");
					System.out.print(y1Answers+" ");
					System.out.println(" | "+ answer1Answers);
				
					System.out.print(w2Answers+" ");
					System.out.print(x2Answers+" ");
					System.out.print(y2Answers+" ");
					System.out.println(" | "+ answer2Answers);

					System.out.print(w3Answers+" ");
					System.out.print(x3Answers+" ");
					System.out.print(y3Answers+" ");
					System.out.println(" | "+ answer3Answers);
					System.out.println();
					if (y1Answers != 0 && solved == 0){
						System.out.println("____STEP 8____");
						System.out.println("Multiply Row 2 by "+y1Answers+" (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n");
						originalY1 = y1Answers;
						y1Answers = y1Answers-(y3Answers*y1Answers);
						answer1Answers = answer1Answers-(originalY1*answer3Answers);
						
						System.out.print(w1Answers+" ");
						System.out.print(x1Answers+" ");
						System.out.print(y1Answers+" ");
						System.out.println(" | "+ answer1Answers);
				
						System.out.print(w2Answers+" ");
						System.out.print(x2Answers+" ");
						System.out.print(y2Answers+" ");
						System.out.println(" | "+ answer2Answers);

						System.out.print(w3Answers+" ");
						System.out.print(x3Answers+" ");
						System.out.print(y3Answers+" ");
						System.out.println(" | "+ answer3Answers);
						System.out.println();
					}
					final String step8 = new String ("STEP 8 - Multiply Row 2 by "+y1Answers+" (temporarily), then subtract Row 1 by the new Row 2. Then revert Row 2 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					if (y2Answers != 0 && solved == 0){
						System.out.println("____STEP 9____");
						System.out.println("Multiply Row 3 by "+y2Answers+" (temporarily), then subtract Row 2 by the new Row 3. Then revert Row 3 back to what it was originally\n");
						originalY2 = y2Answers;
						y2Answers = y2Answers-(y3Answers*y2Answers);
						answer2Answers = answer2Answers-(originalY2*answer3Answers);
						
						System.out.print(w1Answers+" ");
						System.out.print(x1Answers+" ");
						System.out.print(y1Answers+" ");
						System.out.println(" | "+ answer1Answers);
				
						System.out.print(w2Answers+" ");
						System.out.print(x2Answers+" ");
						System.out.print(y2Answers+" ");
						System.out.println(" | "+ answer2Answers);

						System.out.print(w3Answers+" ");
						System.out.print(x3Answers+" ");
						System.out.print(y3Answers+" ");
						System.out.println(" | "+ answer3Answers);
						System.out.println();
					}
					final String step9 = new String ("STEP 9 - Multiply Row 3 by "+y2Answers+" (temporarily), then subtract Row 2 by the new Row 3. Then revert Row 3 back to what it was originally\n"+w1Answers+" "+x1Answers+" "+y1Answers+" | "+answer1Answers+
							"\n"+w2Answers+" "+x2Answers+" "+y2Answers+" | "+answer2Answers+
							"\n"+w3Answers+" "+x3Answers+" "+y3Answers+" | "+answer3Answers);
					if (w1Answers == 1 && w2Answers == 0 && w3Answers == 0 && x1Answers == 0 && x2Answers == 1 && x3Answers == 0 && y1Answers == 0 && y2Answers == 0 && y3Answers == 1){
						System.out.println("SOLVED");
						System.out.println("Solution Set: ");
						System.out.println("X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n"+"X3 = "+answer3Answers+"\n");
						JOptionPane.showMessageDialog(null,"Solved\n"+"Solution Set: \n"+"X1 = "+answer1Answers+"\n"+"X2 = "+answer2Answers+"\n"+"X3 = "+answer3Answers+"\n");
					}
					//}

				JFrame outputFrame = new JFrame("3x3 Matrix - Gauss Jordan Elimination(Reduced Row Reduction) - SOLUTION");
					
        		JPanel fieldPanel3 = new JPanel(new GridLayout(3, 4));// 3 rows by 4 columns 
        		outputFrame.getContentPane().add(fieldPanel3, BorderLayout.WEST);
					
				x1Var = new JTextField(" "+x1Answers);
				x2Var = new JTextField(" "+x2Answers);
				x3Var = new JTextField(" "+x3Answers);
				w1Var = new JTextField(" "+w1Answers);
				w2Var = new JTextField(" "+w2Answers);	
				w3Var = new JTextField(" "+w3Answers);
				y1Var = new JTextField(" "+y1Answers);
				y2Var = new JTextField(" "+y2Answers);	
				y3Var = new JTextField(" "+y3Answers);
				answer1Var = new JTextField(" "+answer1Answers);
				answer2Var = new JTextField(" "+answer2Answers);
				answer3Var = new JTextField(" "+answer3Answers);


				fieldPanel3.add(w1Var);
				fieldPanel3.add(x1Var);
				fieldPanel3.add(y1Var);
				fieldPanel3.add(answer1Var);
				fieldPanel3.add(w2Var);
				fieldPanel3.add(x2Var);
				fieldPanel3.add(y2Var);
				fieldPanel3.add(answer2Var);
				fieldPanel3.add(w3Var);
				fieldPanel3.add(x3Var);
				fieldPanel3.add(y3Var);
				fieldPanel3.add(answer3Var);
				x1Var.setEditable(false);
				x2Var.setEditable(false);
				x3Var.setEditable(false);
				w1Var.setEditable(false);
				w2Var.setEditable(false);
				w3Var.setEditable(false);
				y1Var.setEditable(false);
				y2Var.setEditable(false);
				y3Var.setEditable(false);
				answer1Var.setEditable(false);
				answer2Var.setEditable(false);
				answer3Var.setEditable(false);
    			JButton stepsButton = new JButton("Show Steps");
            	stepsButton.addActionListener(new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent e) {
    	        		JOptionPane.showMessageDialog(null," "+step1);
						JOptionPane.showMessageDialog(null," "+step2);
						JOptionPane.showMessageDialog(null," "+step3);
						JOptionPane.showMessageDialog(null," "+step4);
						JOptionPane.showMessageDialog(null," "+step5);
						JOptionPane.showMessageDialog(null," "+step6);
						JOptionPane.showMessageDialog(null," "+step7);
						JOptionPane.showMessageDialog(null," "+step8);
						JOptionPane.showMessageDialog(null," "+step9);
    				}
    				
    			});
            	outputFrame.add(stepsButton, BorderLayout.SOUTH);
				outputFrame.pack();
				outputFrame.setVisible(true);
				outputFrame.setSize(475,150);
					
				}
        	});

			inputFrame.add(calculateButton, BorderLayout.SOUTH);
			inputFrame.pack();
			inputFrame.setVisible(true);
			inputFrame.setSize(350,125);
		}

		//4x4
		if (matrixSetting == 3 && operationsSetting == 1){
			JFrame inputFrame = new JFrame("4x4 Matrix - Gauss Jordan Elimination(Reduced Row Reduction)");
        	JPanel labelPanel2 = new JPanel(new GridLayout(4, 5)); 
        	inputFrame.getContentPane().add(labelPanel2, BorderLayout.WEST);
        	JPanel fieldPanel2 = new JPanel(new GridLayout(4, 5)); 
        	inputFrame.getContentPane().add(fieldPanel2, BorderLayout.CENTER);


			JLabel inputLabelW1 = new JLabel("V1");
			JLabel inputLabelW2 = new JLabel("V2");
			JLabel inputLabelW3 = new JLabel("V3");
			JLabel inputLabelW4 = new JLabel("V4");
			JLabel inputLabelX1 = new JLabel("W1");
			JLabel inputLabelX2 = new JLabel("W2");
			JLabel inputLabelX3 = new JLabel("W3");
			JLabel inputLabelX4 = new JLabel("W4");
			JLabel inputLabelY1 = new JLabel("X1");
			JLabel inputLabelY2 = new JLabel("X2");
			JLabel inputLabelY3 = new JLabel("X3");
			JLabel inputLabelY4 = new JLabel("X4");
			JLabel inputLabelZ1 = new JLabel("Y1");
			JLabel inputLabelZ2 = new JLabel("Y2");
			JLabel inputLabelZ3 = new JLabel("Y3");
			JLabel inputLabelZ4 = new JLabel("Y4");
			JLabel inputLabelAnswer1 = new JLabel("= Z1");
			JLabel inputLabelAnswer2 = new JLabel("= Z2");
			JLabel inputLabelAnswer3 = new JLabel("= Z3");
			JLabel inputLabelAnswer4 = new JLabel("= Z4");

			z1 = new JTextField();
			z2 = new JTextField();
			z3 = new JTextField();
			z4 = new JTextField();
			y1 = new JTextField();
			y2 = new JTextField();
			y3 = new JTextField();
			y4 = new JTextField();
			x1 = new JTextField();
			x2 = new JTextField();
			x3 = new JTextField();
			x4 = new JTextField();
			w1 = new JTextField();
			w2 = new JTextField();
			w3 = new JTextField();	
			w4 = new JTextField();
			answer1 = new JTextField();
			answer2 = new JTextField();
			answer3 = new JTextField();
			answer4 = new JTextField();


			labelPanel2.add(inputLabelW1);
        	labelPanel2.add(inputLabelX1);
			labelPanel2.add(inputLabelY1);
			labelPanel2.add(inputLabelZ1);
			labelPanel2.add(inputLabelAnswer1);
			labelPanel2.add(inputLabelW2);
			labelPanel2.add(inputLabelX2);
			labelPanel2.add(inputLabelY2);
			labelPanel2.add(inputLabelZ2);
			labelPanel2.add(inputLabelAnswer2);
			labelPanel2.add(inputLabelW3);
			labelPanel2.add(inputLabelX3);
			labelPanel2.add(inputLabelY3);
			labelPanel2.add(inputLabelZ3);
			labelPanel2.add(inputLabelAnswer3);
			labelPanel2.add(inputLabelW4);
			labelPanel2.add(inputLabelX4);
			labelPanel2.add(inputLabelY4);
			labelPanel2.add(inputLabelZ4);
			labelPanel2.add(inputLabelAnswer4);


        	fieldPanel2.add(w1);
        	fieldPanel2.add(x1);
			fieldPanel2.add(y1);
			fieldPanel2.add(z1);
			fieldPanel2.add(answer1);
			fieldPanel2.add(w2);
			fieldPanel2.add(x2);
			fieldPanel2.add(y2);
			fieldPanel2.add(z2);
			fieldPanel2.add(answer2);
			fieldPanel2.add(w3);
			fieldPanel2.add(x3);
			fieldPanel2.add(y3);
			fieldPanel2.add(z3);
			fieldPanel2.add(answer3);
			fieldPanel2.add(w4);
			fieldPanel2.add(x4);
			fieldPanel2.add(y4);
			fieldPanel2.add(z4);
			fieldPanel2.add(answer4);

			JButton calculateButton = new JButton("Calculate");
			
        	calculateButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.print(w1.getText()+" ");
					System.out.print(x1.getText()+" | ");
					System.out.println(answer1.getText());
				
					System.out.print(w2.getText()+" ");
					System.out.print(x2.getText()+" | ");
					System.out.println(answer2.getText());
					
					System.out.print(w3.getText()+" ");
					System.out.print(x3.getText()+" | ");
					System.out.println(answer3.getText());

					System.out.print(w4.getText()+" ");
					System.out.print(x4.getText()+" | ");
					System.out.println(answer4.getText());

					JFrame outputFrame = new JFrame("4x4 Matrix - Gauss Jordan Elimination(Reduced Row Reduction) - SOLUTION");
					JPanel labelPanel3 = new JPanel(new GridLayout(4, 5));// 4 rows by 5 columns 
        			outputFrame.getContentPane().add(labelPanel3, BorderLayout.WEST);


					outputFrame.pack();
					outputFrame.setVisible(true);
				}
        	});

			inputFrame.add(calculateButton, BorderLayout.SOUTH);
			inputFrame.pack();
			inputFrame.setVisible(true);
			inputFrame.setSize(350,150);
		}
    }
}