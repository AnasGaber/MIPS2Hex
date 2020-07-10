
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInteractiveMode = new JButton("Interactive mode");
		btnInteractiveMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intMode nIM =new intMode();
				nIM.setVisible(true);
			}
		});
		btnInteractiveMode.setForeground(new Color(255, 255, 224));
		btnInteractiveMode.setBackground(new Color(178, 34, 34));
		btnInteractiveMode.setBounds(178, 122, 152, 51);
		contentPane.add(btnInteractiveMode);
		
		JButton btnBatchMode = new JButton("Batch mode");
		btnBatchMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bMode bm=new bMode();
				bm.setVisible(true);
			}
		});
		btnBatchMode.setForeground(new Color(255, 255, 224));
		btnBatchMode.setBackground(new Color(178, 34, 34));
		btnBatchMode.setBounds(178, 250, 152, 51);
		contentPane.add(btnBatchMode);
		
		JLabel lblWelcomeToMipshex = new JLabel("Welcome to MIPS2Hex");
		lblWelcomeToMipshex.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcomeToMipshex.setForeground(new Color(178, 34, 34));
		lblWelcomeToMipshex.setBounds(139, 11, 249, 40);
		contentPane.add(lblWelcomeToMipshex);
		
		JLabel lblByUtku = new JLabel("By Utku & Anas");
		lblByUtku.setForeground(new Color(178, 34, 34));
		lblByUtku.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblByUtku.setBounds(426, 361, 81, 40);
		contentPane.add(lblByUtku);
	}
}
