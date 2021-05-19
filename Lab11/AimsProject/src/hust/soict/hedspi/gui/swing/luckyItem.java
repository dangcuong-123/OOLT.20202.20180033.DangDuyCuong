package hust.soict.hedspi.gui.swing;

import hust.soict.hedspi.aims.LuckyItemException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class luckyItem extends JFrame {
    private JFormattedTextField textField1;
    private JFormattedTextField textField2;
    private JFormattedTextField textField3;
    private JButton btn;
    public luckyItem(Order anOrder){
    	textField1 = new JFormattedTextField(anOrder.getThresholdsOrders());
    	textField2 = new JFormattedTextField(anOrder.getThresholdsSale());
    	textField3 = new JFormattedTextField(anOrder.getThresholdsTotal());
        btn = new JButton("Get Lucky Item ");
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,2));
        contentPane.add(new JTextField(" thresholds numbers of orders (default) : " ));
        contentPane.add(textField1);
        
        contentPane.add(new JTextField(" thresholds sale (default) : " ));
        contentPane.add(textField2);
        
        contentPane.add(new JTextField(" thresholds total (default) : " ));
        contentPane.add(textField3);
        
        contentPane.add(btn);
        contentPane.add(new JTextField(" You can change the default value"));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int error = 0 ;
                if(!textField1.getText().isEmpty()) {
                    try{
                        int thresholdsNumOfOrders = Integer.parseInt(textField1.getText());
                        if(thresholdsNumOfOrders <= 0 || thresholdsNumOfOrders > anOrder.MAX_NUMBERS_ORDERED){
                            JOptionPane.showMessageDialog(null,"Threshold for the number of order must not be <=0 or exceed max numbers ordered ! ");
                            error = 1;
                        }
                        else{
                            anOrder.setThresholdsOrders(thresholdsNumOfOrders);
                        }
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(!textField2.getText().isEmpty()) {
                    try{
                        float thresholdsSale = Float.parseFloat(textField2.getText());
                        if(thresholdsSale <= 0 ) {
                            JOptionPane.showMessageDialog(null, "Sales threshold cannot be <= 0! ");
                            error = 1;
                        }else{
                            anOrder.setThresholdsSale(thresholdsSale);
                        }
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(!textField3.getText().isEmpty()) {
                    try{
                        float thresholdsTotal = Float.parseFloat(textField3.getText());
                        if(thresholdsTotal <= 0 ) {
                        	error = 1;
                            JOptionPane.showMessageDialog(null, "The total threshold cannot be <= 0! ");
                        }else
                            anOrder.setThresholdsTotal(thresholdsTotal);
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(error == 0 ) {
                    try {
                        Media luckyItem = anOrder.getLuckyItem();
                        JOptionPane.showMessageDialog(null, "Choose a lucky order with ID : " + luckyItem.getId() + " |title: " + luckyItem.getTitle() + " |cost : " + luckyItem.getCost());
                    } catch (hust.soict.hedspi.aims.LuckyItemException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        setSize(457, 252);          
        setVisible(true);           
    }
}