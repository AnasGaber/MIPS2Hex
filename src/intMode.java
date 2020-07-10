import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractListModel;

public class intMode extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intMode frame = new intMode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public intMode() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInteractiveMode = new JLabel("Interactive mode");
		lblInteractiveMode.setForeground(new Color(178, 34, 34));
		lblInteractiveMode.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInteractiveMode.setBounds(156, 11, 191, 40);
		contentPane.add(lblInteractiveMode);
		
		textField = new JTextField();
		textField.setBackground(new Color(233, 150, 122));
		textField.setBounds(21, 82, 333, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textPane = new JTextField();
				textPane.setBackground(new Color(255, 239, 213));
				textPane.setBounds(21, 179, 475, 222);
				contentPane.add(textPane);
				textPane.setColumns(10);
				textPane.setEditable(false);
				String outPut="";
				int i;
				String enteredIns=textField.getText();
				if(enteredIns.contains("addi")||enteredIns.contains("beq")||enteredIns.contains("bne")||enteredIns.contains("lw")||enteredIns.contains("sw")||enteredIns.contains("andi")||enteredIns.contains("ori")||enteredIns.contains("xori")||enteredIns.contains("slti"))
				{
					
					IType iIns=new IType(enteredIns);
					MIPS2Hex.eInst.add(iIns);
					for(i=0;i<MIPS2Hex.eInst.size();i++)
					{	
						outPut+="\n\r"+MIPS2Hex.eInst.get(i).getBi();
					}
					MIPS2Hex.iCp();
					textPane.setText(outPut);
						
				}
				else if (enteredIns.contains("jal")||enteredIns.contains("j"))
				{
					JType jIns=new JType(enteredIns);
					MIPS2Hex.eInst.add(jIns);
					for(i=0;i<MIPS2Hex.eInst.size();i++)
					{	
						outPut+="\n\r"+MIPS2Hex.eInst.get(i).getBi();
					}
					MIPS2Hex.iCp();
					textPane.setText(outPut);
				}
				else 
				{
					
					RType rIns=new RType(enteredIns);
					MIPS2Hex.eInst.add(rIns);
					for(i=0;i<MIPS2Hex.eInst.size();i++)
					{	
						outPut+="\n\r"+MIPS2Hex.eInst.get(i).getBi();
					}
					MIPS2Hex.iCp();
					textPane.setText(outPut);
				}
//				for(i=0;i<MIPS2Hex.eInst.size();i++)
//				{
//					System.out.println(MIPS2Hex.eInst.get(i).getBi());
//				}
				
				
			}
		});
		btnEnter.setForeground(new Color(255, 255, 224));
		btnEnter.setBackground(new Color(178, 34, 34));
		btnEnter.setBounds(364, 82, 132, 51);
		contentPane.add(btnEnter);
		
		JLabel lblMipsInstruction = new JLabel("MIPS Instruction");
		lblMipsInstruction.setForeground(new Color(178, 34, 34));
		lblMipsInstruction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMipsInstruction.setBackground(new Color(255, 255, 255));
		lblMipsInstruction.setBounds(22, 46, 101, 25);
		contentPane.add(lblMipsInstruction);
		
		JLabel lblHexValue = new JLabel("Hex value");
		lblHexValue.setForeground(new Color(178, 34, 34));
		lblHexValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHexValue.setBackground(Color.WHITE);
		lblHexValue.setBounds(21, 143, 101, 25);
		contentPane.add(lblHexValue);
		


		
		
		
		
		
		
	}
}
