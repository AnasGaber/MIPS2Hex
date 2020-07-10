import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bMode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bMode frame = new bMode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bMode() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBatchMode = new JLabel("Batch mode");
		lblBatchMode.setForeground(new Color(178, 34, 34));
		lblBatchMode.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBatchMode.setBounds(189, 11, 191, 40);
		contentPane.add(lblBatchMode);
		
		JButton button = new JButton("Select File");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 

				JButton open =new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setDialogTitle("Choose .txt file");
				if(fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION)
				{
					
				}
				File file = new File(fc.getSelectedFile().getAbsolutePath());
				Scanner input = null;
				try {
					input = new Scanner(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (input.hasNextLine()) {
				    MIPS2Hex.list.add(input.nextLine());
				}

				
				JTextField textPane = new JTextField();
				textPane.setBackground(new Color(255, 239, 213));
				textPane.setBounds(21, 179, 475, 222);
				contentPane.add(textPane);
				textPane.setColumns(10);
				textPane.setEditable(false);
				String outPut="";
				int i;
				for(i=0;i<MIPS2Hex.list.size();i++)
				{
					
					
					

					String enteredIns=MIPS2Hex.list.get(i);
					if(enteredIns.contains("addi")||enteredIns.contains("beq")||enteredIns.contains("bne")||enteredIns.contains("lw")||enteredIns.contains("sw")||enteredIns.contains("andi")||enteredIns.contains("ori")||enteredIns.contains("xori")||enteredIns.contains("slti"))
					{
						
						IType iIns=new IType(enteredIns);
						MIPS2Hex.eInst.add(iIns);
//						for(i=0;i<MIPS2Hex.eInst.size();i++)
//						{	
//							MIPS2Hex.biList.add(MIPS2Hex.eInst.get(i).getBi());
//						}
						MIPS2Hex.iCp();
							
					}
					else if (enteredIns.contains("jal")||enteredIns.contains("j"))
					{
						JType jIns=new JType(enteredIns);
						MIPS2Hex.eInst.add(jIns);
//						for(i=0;i<MIPS2Hex.eInst.size();i++)
//						{	
//							MIPS2Hex.biList.add(MIPS2Hex.eInst.get(i).getBi());
//						}
						MIPS2Hex.iCp();
					}
					else 
					{
						
						RType rIns=new RType(enteredIns);
						MIPS2Hex.eInst.add(rIns);
//						for(i=0;i<MIPS2Hex.eInst.size();i++)
//						{	
//							MIPS2Hex.biList.add(MIPS2Hex.eInst.get(i).getBi());
//						}
						MIPS2Hex.iCp();

					}
//					for(i=0;i<MIPS2Hex.biList.size();i++)
//					{
//						outPut+=MIPS2Hex.biList.get(i)+" ";
//					}
//					System.out.println(outPut);
			}
				for(i=0;i<MIPS2Hex.eInst.size();i++)
					MIPS2Hex.biList.add(MIPS2Hex.eInst.get(i).getBi());
				for(i=0;i<MIPS2Hex.eInst.size();i++)
					outPut+=MIPS2Hex.biList.get(i)+"\n\r";
				textPane.setText(outPut+"\n\r");
				}

				
				
		});
		button.setForeground(new Color(255, 255, 224));
		button.setBackground(new Color(178, 34, 34));
		button.setBounds(186, 62, 132, 51);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("Hex value");
		label_1.setForeground(new Color(178, 34, 34));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(21, 145, 101, 25);
		contentPane.add(label_1);
	}
}
