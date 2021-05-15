package hust.soict.hedspi.gui.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static hust.soict.hedspi.gui.swing.MenuGui.anOrder;


public class addbook extends JDialog {

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
//			addbook dialog = new addbook();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public addbook() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(203, 23, 98, 20);
			textField.setText(" ");
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("id");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(175, 25, 18, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(145, 56, 48, 14);
		contentPanel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setText(" ");
		textField_1.setColumns(10);
		textField_1.setBounds(203, 54, 98, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(" ");
		textField_2.setColumns(10);
		textField_2.setBounds(203, 85, 98, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(134, 87, 59, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setText(" ");
		textField_3.setColumns(10);
		textField_3.setBounds(203, 116, 98, 20);
		contentPanel.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("cost");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(145, 118, 48, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setText(" ");
		textField_4.setColumns(10);
		textField_4.setBounds(203, 147, 98, 20);
		contentPanel.add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("numbers of authors");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(43, 149, 150, 14);
		contentPanel.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setText(" ");
		textField_5.setColumns(10);
		textField_5.setBounds(203, 178, 98, 20);
		contentPanel.add(textField_5);
		
		JLabel lblNewLabel_4 = new JLabel("author's name");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(95, 180, 98, 14);
		contentPanel.add(lblNewLabel_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id = Integer.parseInt(textField.getText().trim());
	                    String title = textField_1.getText();
	                    String category = textField_2.getText();
	                    float cost = Float.parseFloat(textField_3.getText());
	                    String names = textField_4.getText();
	                    String[] array_name = names.split(";");
	                    if(anOrder.searchById(id)!=null){
	                        JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
	                        dispose();
	                    }
	                    else{
	                        Book book = new Book(id, title, category, cost);
	                        for(int i = 0 ; i< array_name.length ; i++) {
	                            book.addAuthor(array_name[i]);
	                        }
	                        anOrder.addMedia(book);
	                        JOptionPane.showMessageDialog(null,"Them vao Book thanh cong");
	                        dispose();
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
