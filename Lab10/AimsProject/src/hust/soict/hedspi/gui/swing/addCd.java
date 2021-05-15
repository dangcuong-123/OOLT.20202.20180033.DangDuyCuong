package hust.soict.hedspi.gui.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.AddMediaException;
import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static hust.soict.hedspi.gui.swing.MenuGui.anOrder;

public class addCd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addCd dialog = new addCd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addCd() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_5 = new JLabel("id");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(179, 28, 18, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			textField = new JTextField();
			textField.setText(" ");
			textField.setColumns(10);
			textField.setBounds(207, 26, 98, 20);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabel = new JLabel("title");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(149, 59, 48, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField_1 = new JTextField();
			textField_1.setText(" ");
			textField_1.setColumns(10);
			textField_1.setBounds(207, 57, 98, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("category");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(138, 90, 59, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setText(" ");
			textField_2.setColumns(10);
			textField_2.setBounds(207, 88, 98, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("artist");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_2.setBounds(47, 121, 150, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setText(" ");
			textField_3.setColumns(10);
			textField_3.setBounds(207, 119, 98, 20);
			contentPanel.add(textField_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("cost");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_3.setBounds(47, 152, 150, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setText(" ");
			textField_4.setColumns(10);
			textField_4.setBounds(207, 150, 98, 20);
			contentPanel.add(textField_4);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("title of track");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(10, 183, 187, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField_5 = new JTextField();
			textField_5.setText(" ");
			textField_5.setColumns(10);
			textField_5.setBounds(207, 181, 98, 20);
			contentPanel.add(textField_5);
		}
		{
			textField_6 = new JTextField();
			textField_6.setText(" ");
			textField_6.setColumns(10);
			textField_6.setBounds(207, 209, 98, 20);
			contentPanel.add(textField_6);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("length of track");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(10, 211, 187, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().isEmpty() || textField_1.getText().isEmpty()|| textField_2.getText().isEmpty()|| textField_3.getText().isEmpty() 
								|| textField_4.getText().isEmpty()  || textField_5.getText().isEmpty() || textField_6.getText().isEmpty()){
		                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
		                }
						int id = Integer.parseInt(textField.getText().trim());
	                    String title = textField_1.getText();
	                    String category = textField_2.getText();
	                    String artist = textField_3.getText();
	                    float cost = Float.parseFloat(textField_4.getText());
	                    String length_arr[] =  textField_5.getText().split(";");
	                    String title_arr[] = textField_6.getText().split(";");
	                    if(anOrder.searchById(id)!=null){
	                        JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
	                    }
	                    else{
	                        if(length_arr.length != title_arr.length)
	                            JOptionPane.showMessageDialog(null,"length va title khong khop nhau !");
	                        else{
	                            CompactDisc cd = new CompactDisc(id, title, category,cost ,artist);
	                            Track track = null;
	                            for(int i = 0 ; i < length_arr.length;i++){
	                                track = new Track(title_arr[i], Integer.parseInt(length_arr[i].trim()));
	                                cd.addTrack(track);
	                            }
	                            try {
	                            	anOrder.addMedia(cd);
	                            } catch (AddMediaException e1) {
	                                e1.printStackTrace();
	                            }
	                            JOptionPane.showMessageDialog(null,"Them vao CD thanh cong");
	                            int c = JOptionPane.showConfirmDialog(null,"Do you want to play ? ");
	                            dispose();
	                            if(c == 0){
	                                try {
										cd.play();
									} catch (PlayerException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
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
