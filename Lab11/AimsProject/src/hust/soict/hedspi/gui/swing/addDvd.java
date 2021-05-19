package hust.soict.hedspi.gui.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.AddMediaException;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static hust.soict.hedspi.gui.swing.MenuGui.anOrder;

public class addDvd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			addDvd dialog = new addDvd();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public addDvd() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("length");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(-28, 179, 98, 14);
		contentPanel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setText(" ");
		textField.setColumns(10);
		textField.setBounds(80, 177, 98, 20);
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText(" ");
		textField_1.setColumns(10);
		textField_1.setBounds(80, 146, 98, 20);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("cost");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(-80, 148, 150, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("director");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(-80, 117, 150, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText(" ");
		textField_2.setColumns(10);
		textField_2.setBounds(80, 115, 98, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(11, 86, 59, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setText(" ");
		textField_3.setColumns(10);
		textField_3.setBounds(80, 84, 98, 20);
		contentPanel.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(22, 55, 48, 14);
		contentPanel.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setText(" ");
		textField_4.setColumns(10);
		textField_4.setBounds(80, 53, 98, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(" ");
		textField_5.setColumns(10);
		textField_5.setBounds(80, 22, 98, 20);
		contentPanel.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("id");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(52, 24, 18, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(248, 25, 150, 168);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().isEmpty() || textField_1.getText().isEmpty()|| textField_2.getText().isEmpty()|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()  || textField_5.getText().isEmpty()){
		                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
		                }
		                else{
		                    int id = Integer.parseInt(textField_5.getText().trim());
		                    System.out.print(id);
		                    String title = textField_4.getText();
		                    System.out.print(title);
		                    String category = textField_3.getText();
		                    String director = textField_2.getText();
		                    float cost = Float.parseFloat(textField_1.getText());
		                    int length = Integer.parseInt(textField.getText().trim());
		                    if(anOrder.searchById(id) != null){
		                        JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
		                    }
		                    else{
		                        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,director, length, cost);
		                        try {
									anOrder.addMedia(dvd);
								} catch (AddMediaException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		                        JOptionPane.showMessageDialog(null,"Them vao DVD thanh cong");
		                        int c = JOptionPane.showConfirmDialog(null,"Do you want to play ? ");
		                        if(c == 0){
		                        	lblNewLabel_6.setText(dvd.getTitle());
		                        	lblNewLabel_6.setText(""+dvd.getLength());
		                        }
		                    }
		                }
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
