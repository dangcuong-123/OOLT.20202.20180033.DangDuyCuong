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
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JButton btn;
    public luckyItem(Order anOrder){
        formattedTextField1 = new JFormattedTextField(anOrder.getThresholdsOrders());
        formattedTextField2 = new JFormattedTextField(anOrder.getThresholdsSale());
        formattedTextField3 = new JFormattedTextField(anOrder.getThresholdsTotal());
        btn = new JButton("Get Lucky Item ");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4,2));
        cp.add(new JTextField(" thresholds numbers of orders (default) : " ));
        cp.add(formattedTextField1);
        cp.add(new JTextField(" thresholds sale (default) : " ));
        cp.add(formattedTextField2);
        cp.add(new JTextField(" thresholds total (default) : " ));
        cp.add(formattedTextField3);
        cp.add(btn);
        cp.add(new JTextField(" You can change the default value"));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int err = 0 ;
                if(!formattedTextField1.getText().isEmpty()) {
                    try{
                        int thresholdsNumOfOrders = Integer.parseInt(formattedTextField1.getText());
                        if(thresholdsNumOfOrders <= 0 || thresholdsNumOfOrders > anOrder.MAX_NUMBERS_ORDERED){
                            JOptionPane.showMessageDialog(null,"Ngưỡng số lượng sản phẩm không được <=0 hoặc vượt max numbers ordered ! ");
                            err = 1;
                        }
                        else{
                            anOrder.setThresholdsOrders(thresholdsNumOfOrders);
                        }
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(!formattedTextField2.getText().isEmpty()) {
                    try{
                        float thresholdsSale = Float.parseFloat(formattedTextField2.getText());
                        if(thresholdsSale <= 0 ) {
                            JOptionPane.showMessageDialog(null, "Ngưỡng sale không được <= 0! ");
                            err = 1;
                        }else{
                            anOrder.setThresholdsSale(thresholdsSale);
                        }
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(!formattedTextField3.getText().isEmpty()) {
                    try{
                        float thresholdsTotal = Float.parseFloat(formattedTextField3.getText());
                        if(thresholdsTotal <= 0 ) {
                            err = 1;
                            JOptionPane.showMessageDialog(null, "Ngưỡng tổng giá không được <= 0! ");
                        }else{
                            anOrder.setThresholdsTotal(thresholdsTotal);
                        }
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(err == 0 ) {
                    try {
                        Media luckyItem = anOrder.getLuckyItem();
                        JOptionPane.showMessageDialog(null, "Chọn được sản phẩm may mắn có ID : " + luckyItem.getId() + " |title: " + luckyItem.getTitle() + " |cost : " + luckyItem.getCost());
                    } catch (hust.soict.hedspi.aims.LuckyItemException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        setTitle("Get Lucky Item");  // "super" JFrame sets title
        setSize(457, 252);          // "super" JFrame sets initial size
        setVisible(true);           // "super" JFrame shows
    }
}