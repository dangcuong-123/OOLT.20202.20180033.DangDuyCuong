package hust.soict.hedspi.gui.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOrder extends JFrame {

	public JPanel contentPane;
	public static JFrame frame;
	/**
	 * Launch the application.
	 */
	public MenuOrder() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbook book = new addbook();
				book.setVisible(true);
			}
		});
		btnNewButton.setBounds(63, 81, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(31, 11, 176, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(36, 84, 17, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnDvd = new JButton("DVD");
		btnDvd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDvd dvd = new addDvd();
				dvd.setVisible(true);
			}	
		});
		btnDvd.setBounds(63, 115, 89, 23);
		getContentPane().add(btnDvd);
		
		JLabel lblNewLabel_2 = new JLabel("2.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(36, 118, 17, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("3.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(36, 153, 17, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnCd = new JButton("CD");
		btnCd.setBounds(63, 150, 89, 23);
		getContentPane().add(btnCd);
		
		JLabel lblNewLabel_4 = new JLabel("4.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(36, 189, 17, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(63, 186, 89, 23);
		getContentPane().add(btnExit);
	}

}
