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

public class MatrixCalculator extends JPanel {

    private static JComboBox operationsComboBox;
    private static JComboBox matrixComboBox;
	private static JTextField x1;
	private static JTextField x2;
	private static JTextField x3;
	private static JTextField x4;
	public static int matrixSetting = 0;
	public static int operationsSetting = 0;

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

        // Button submit
        JButton submit = new JButton("Generate");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             performAction((String) operationsComboBox.getSelectedItem(), (String)matrixComboBox.getSelectedItem()); 

		  
            }
        });

        // Frame for our test
        JFrame f = new JFrame("Matrix Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);

        // Panel with the button
        JPanel p = new JPanel();
        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);

        // Show the frame
        f.pack();
        f.setVisible(true);
    }

    private static void performAction(String selectedItem, String text) {
        // Do stuff with your data
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
				System.out.println(matrixSetting);

		if (matrixSetting == 2){
        		JPanel labelPanel2 = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        		add(labelPanel2, BorderLayout.WEST);
        		JPanel fieldPanel2 = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        		add(fieldPanel2, BorderLayout.CENTER);
			JFrame outPutFrame = new JFrame("3x3 Matrix - Gauss Jordon Elimination(Reduced Row Reduction)");
			JLabel outPutLabelX1 = new JLabel("x1");
			JLabel outPutLabelX2 = new JLabel("x2");
			JLabel outPutLabelX3 = new JLabel("X3");
			x1 = new JTextField();	
			outPutFrame.getContentPane().add(x1, BorderLayout.NORTH);
			outPutFrame.getContentPane().add(outPutLabelX1, BorderLayout.NORTH);
			outPutFrame.getContentPane().add(outPutLabelX2, BorderLayout.CENTER);
			outPutFrame.getContentPane().add(outPutLabelX3, BorderLayout.SOUTH);	
			outPutFrame.pack();
			outPutFrame.setVisible(true);
		}
    }
}