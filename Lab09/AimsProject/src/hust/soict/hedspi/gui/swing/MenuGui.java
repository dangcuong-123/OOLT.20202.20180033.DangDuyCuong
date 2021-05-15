package hust.soict.hedspi.gui.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.order.Order;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuGui extends JFrame {

	/**
	 * Launch the application.
	 */
	static Order anOrder = null;
	int check = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGui frame = new MenuGui();
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
	public MenuGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblShow = new JLabel("");
		lblShow.setBounds(267, 75, 146, 154);
		getContentPane().add(lblShow);
		
		JButton btnNewButton = new JButton("Create new order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anOrder = new Order();
				lblShow.setText("An Order is created!!!");
				check = 1;
			}
		});
		btnNewButton.setBounds(45, 75, 185, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblMenuOrder = new JLabel("Menu Order");
		lblMenuOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMenuOrder.setBounds(24, 11, 228, 36);
		getContentPane().add(lblMenuOrder);
		
		JLabel label_1 = new JLabel("1.");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(24, 78, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(24, 112, 46, 14);
		getContentPane().add(label_2);
		
		JButton btnAddItemTo = new JButton("Add item to the order");
		btnAddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check == 0) {
					lblShow.setText("Please create new order!");
			    }
				else {
					MenuOrder menu = new MenuOrder();
					menu.setVisible(true);
				}
			}

		});
		btnAddItemTo.setBounds(45, 109, 185, 23);
		getContentPane().add(btnAddItemTo);
		
		JLabel label_3 = new JLabel("3.");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(24, 146, 46, 14);
		getContentPane().add(label_3);
		
		JButton btnDeleteItemBy = new JButton("Delete item by id");
		btnDeleteItemBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check==0)
                    JOptionPane.showMessageDialog(null,"The Media list is empty !");
                else{
                    String s =(String) JOptionPane.showInputDialog(null,"Nhap id san pham muon xoa");
                    if(s != null && (s.length()>0) ){
                        Integer id = Integer.parseInt(s);
                        if(anOrder.searchById(id)==null)
                            JOptionPane.showMessageDialog(null,"ID khong ton tai !");
                        else {
                            anOrder.removeMedia(id);
                            JOptionPane.showMessageDialog(null,"Deleted");
                        }
                    }
                }
			}
		});
		btnDeleteItemBy.setBounds(45, 143, 185, 23);
		getContentPane().add(btnDeleteItemBy);
		
		JLabel label_4 = new JLabel("4.");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(24, 177, 46, 14);
		getContentPane().add(label_4);
		
		JButton btnDisplayTheItems = new JButton("Display the items list of order");
		btnDisplayTheItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check == 0)
                    JOptionPane.showMessageDialog(null,"The Media list is empty !");
                else{
                	JFrame frame2;
                    frame2 = new JFrame("media list");
                    frame2.setContentPane(new listOrder(anOrder));
                    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.pack();
                    frame2.setVisible(true);

                }
			}
		});
		btnDisplayTheItems.setBounds(45, 174, 185, 23);
		getContentPane().add(btnDisplayTheItems);
		
		JLabel label_5 = new JLabel("5.");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(24, 214, 46, 14);
		getContentPane().add(label_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(45, 211, 185, 23);
		getContentPane().add(btnExit);
		
	}
}
