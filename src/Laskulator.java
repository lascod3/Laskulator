import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Laskulator extends JFrame implements ActionListener{
	JFrame frame = new JFrame("Laskulator");
	private JTextField textfield = new JTextField(12);

	Operations ope = new Operations(0,0);

	private JButton[] buttonNos = new JButton[15];
	private JButton[] buttonOps = new JButton[4];
	private String[] labels = new String[3];
	private JLabel label[] = label = null;
	

	private JPanel panelTop = new JPanel();
	private JPanel panelTop2 = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelBottom = new JPanel();
	
	private Dimension dim = new Dimension(100, 45);
	
	public Laskulator() {
		frame.setSize(410, 550);
		frame.setLocationRelativeTo(frame);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textfield.setEditable(false);
		frame.setResizable(false);
	
		GridBagConstraints gbc = new GridBagConstraints();

		//Top Panel
		
		frame.add(panelTop, BorderLayout.NORTH);
		panelTop.setBackground(new Color(220,237,250,255));
		panelTop.setLayout(new GridBagLayout());
		panelTop.setPreferredSize(new Dimension(410, 150));
		
		
		label = new JLabel[labels.length];
		for(int i=0; i<label.length; i++) {
			label[i] = new JLabel(labels[i]);
			label[i].setFont(new Font("SansSerif", Font.BOLD, 25));
			label[i].setForeground(new Color(230,242,250));
		}
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelTop2.setPreferredSize(new Dimension(200, 40));
		
		panelTop2.setLayout(new FlowLayout());
		panelTop2.setBackground(new Color(25,48,65,255));
		panelTop2.add(label[0]);
		panelTop2.add(label[1]);
		panelTop2.add(label[2]);
		panelTop.add(panelTop2,gbc);

		gbc.insets = new Insets(30,0, 0,0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		textfield.setFont(new Font("SansSerif", Font.BOLD,26));
		textfield.setForeground(new Color(39,115,169,255));
		textfield.setBorder(BorderFactory.createLineBorder(new Color(39,115,169,255), 5));
		panelTop.add(textfield,gbc);
		

		// panelTop.setPreferredSize(new Dimension(410, 55));
		// panelTop.add(textfield).setFont(new Font("SansSerif", Font.BOLD, 30));
		// textfield.setBackground(Color.white);
		
		// Centre Panel
		frame.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(new Color(220,237,250,255));
//		panelCenter.setPreferredSize(new Dimension(410, 400));
		String[] nameNos = {"1","2","+","3","4","-","5","6","x","7","8","÷","9","0","."};
		for(int i = 0; i< buttonNos.length; i++) {
			buttonNos[i] = new JButton(nameNos[i]);
			buttonNos[i].addActionListener(this);
			buttonNos[i].setPreferredSize(dim);
			buttonNos[i].setFont(new Font("SansSerif", Font.BOLD, 25));
			buttonNos[i].setBackground(new Color(48,49,54,255));
			buttonNos[i].setForeground(new Color(39,115,169,255));
			panelCenter.add(buttonNos[i]);
		}
		
//Bottom Panel
		frame.add(panelBottom, BorderLayout.SOUTH);
		
		panelBottom.setLayout(new GridBagLayout());
		panelBottom.setPreferredSize(new Dimension(410, 110));
		

		String[] nameOps = {"C","(-)", "DEL", "="};
		for(int i= 0; i< buttonOps.length; i++) {
			buttonOps[i] = new JButton(nameOps[i]);
			buttonOps[i].addActionListener(this);
			buttonOps[i].setPreferredSize(new Dimension(70, 40));
			buttonOps[i].setFont(new Font("SansSerif", Font.BOLD, 18));
			buttonOps[i].setBackground(new Color(96,96,96,255));
			buttonOps[i].setForeground(new Color(39,115,169,255));
			buttonOps[i].setBorderPainted(true);
		}
		gbc.insets = new Insets(0, 5,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBottom.add(buttonOps[0], gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panelBottom.add(buttonOps[1], gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		panelBottom.add(buttonOps[2], gbc);

		gbc.gridx = 4;
		gbc.gridy = 0;
		
		buttonOps[3].setPreferredSize(new Dimension(78, 95));
		buttonOps[3].setBackground(new Color(18,29,38,255));
		buttonOps[3].setBorderPainted(true);
		panelBottom.add(buttonOps[3], gbc);
		
		panelBottom.setBackground(new Color(220,237,250,255));

		frame.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		String firstNum = textfield.getText();
		String secondNum = textfield.getText();
		String signs = textfield.getText();
	
		
		for(int i=0; i<buttonNos.length; i++ ) {
			if(e.getSource()==buttonNos[i]){
				textfield.setText(textfield.getText() + buttonNos[i].getText());
				
			}
		}	
		
/** The operations **/		
		
		if(e.getSource() == buttonNos[2])
		{
			//Addition
			textfield.setText(null);	
			if(firstNum.isEmpty() || secondNum.isEmpty()|| signs.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Field cannot be empty");
				System.out.println("Field cannot be empty");
				textfield.setText(null);	
			}
			else {
			ope.setFirst(Double.parseDouble(firstNum));
			System.out.println("First Number " +ope.getFirst());
			
			label[0].setText(Double.toString(ope.getFirst()));
			String fz = checkingFirstZero();
			ope.setSign("+");
			label[1].setText(ope.getSign());
			
			}
		}
		
		if(e.getSource() == buttonNos[5]) 
		{
			//Subtraction
			textfield.setText(null);
			if(firstNum.isEmpty() || secondNum.isEmpty()|| signs.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Field cannot be empty");
				System.out.println("Field cannot be empty");
				textfield.setText(null);	
			}
			else 
			{
			
			ope.setFirst(Double.parseDouble(firstNum));
			System.out.println("First Number " +ope.getFirst());
			
			
			label[0].setText(Double.toString(ope.getFirst()));
			String fz = checkingFirstZero();
			ope.setSign("-");
			label[1].setText(ope.getSign());

			}
		}
		
		
	
		
		if(e.getSource() == buttonNos[8]) 
		{
			//Multiplication
			textfield.setText(null);
			if(firstNum.isEmpty() || secondNum.isEmpty()|| signs.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Field cannot be empty");
				System.out.println("Field cannot be empty");
				textfield.setText(null);	
			}
			else 
			{
			ope.setFirst(Double.parseDouble(firstNum));
			System.out.println("First Number " +ope.getFirst());
			
			
			label[0].setText(Double.toString(ope.getFirst()));
			String fz = checkingFirstZero();
			ope.setSign("*");
			label[1].setText(ope.getSign());
			}
		}
		
		if(e.getSource() == buttonNos[11]) 
		{
			
			//Division
			textfield.setText(null);
			if(firstNum.isEmpty() || secondNum.isEmpty()|| signs.isEmpty()) 
			{
				JOptionPane.showMessageDialog(this, "Field cannot be empty");
				System.out.println("Field cannot be empty");
				textfield.setText(null);	
			}
			else 
			{
			ope.setFirst(Double.parseDouble(firstNum));
			System.out.println("First Number " +ope.getFirst());
			
			label[0].setText(Double.toString(ope.getFirst()));
			String fz = checkingFirstZero();
			ope.setSign("/");
			label[1].setText(ope.getSign());
			}
		}
		 
		
	/***** Operations *******/
		
		if(e.getSource() == buttonOps[0]) //Clear button
		{
			textfield.setText(null);
//			label[0].setText(null);
//			label = new JLabel[labels.length];
			for(int i=0; i<labels.length; i++) {
				label[i].setText(null);
			}
			
		}
		
		if(e.getSource() == buttonOps[3]) // Equal Button
		{
			String answer= null;;
			textfield.setText(null);
			
			if(firstNum.isEmpty() || secondNum.isEmpty()) 
			{
				System.out.println("Field cannot be empty");
				JOptionPane.showMessageDialog(this, "First Number has not been entered");
			}
				else 
					{
					ope.setSecond(Double.parseDouble(secondNum));
					
					System.out.println("Second Number " +ope.getSecond());
					ope.equalOps(ope.getSign());
					System.out.println(ope.equalOps(ope.getSign()));
					
					String sz = checkingSecondZero();
					
						switch(ope.getSign())
						{
							case "+": 
								answer = Double.toString(ope.addition()); 
								if(answer.endsWith(".0")) 
								{
									textfield.setText(answer.replace(".0", ""));
									System.out.println(answer.replace(".0", ""));	
								}
								else 
								{
									System.out.println(answer);
									textfield.setText("" + answer);
								}
									break;
							case "-":answer = Double.toString(ope.subtraction()); 
								if(answer.endsWith(".0")) 
								{
									textfield.setText(answer.replace(".0", ""));
									System.out.println(answer.replace(".0", ""));
										
								}
								else 
								{
									System.out.println(answer);
									textfield.setText("" + answer);
								} 
									break;
							case "*":  
								 answer = Double.toString(ope.multiplication()); 
								if(answer.endsWith(".0")) 
								{
									textfield.setText(answer.replace(".0", ""));
									System.out.println(answer.replace(".0", ""));		
								}
								else 
								{
									System.out.println(answer);
									textfield.setText("" + answer);
								}
									break;
													
							case "/":  
								answer = Double.toString(ope.division());
								if(answer.endsWith(".0")) 
								{
									textfield.setText(answer.replace(".0", ""));
									System.out.println(answer.replace(".0", ""));
								}
								else 
								{
									System.out.println(answer);
									textfield.setText("" + answer);
								}
													
									break;
							default: System.out.println("No Such Case");
						
						}

					}
							
		}
		
		
		if(e.getSource() == buttonOps[1]) // Negative sign button
		{
				textfield.setText("-");
			
		}
		
		if(e.getSource() == buttonOps[2]) //Delete button 
		{
			
			if(textfield.getText().length()>0) 
			{	
			StringBuilder sb = new StringBuilder(textfield.getText());
			sb.deleteCharAt(textfield.getText().length()-1);
			String text = sb.toString();
			textfield.setText(text);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Nothing to delete");

			}
		}
			
	}
	
	
public String checkingFirstZero() {
		
		String labelSt  = new String(Double.toString(ope.getFirst()));
		
		if(labelSt.endsWith(".0")) 
		{
			label[0].setText(labelSt .replace(".0", ""));
		}
		else 
		{
			label[0].setText(Double.toString(ope.getFirst()));
		}
		return labelSt;
	}

	public String checkingSecondZero() {
		
		String labelSt  = new String(Double.toString(ope.getSecond()));
		
		if(labelSt.endsWith(".0")) 
		{
			label[2].setText(labelSt .replace(".0", ""));
		}
		else 
		{
			label[2].setText(Double.toString(ope.getSecond()));
		}
		return labelSt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Laskulator();
	}


	

}
