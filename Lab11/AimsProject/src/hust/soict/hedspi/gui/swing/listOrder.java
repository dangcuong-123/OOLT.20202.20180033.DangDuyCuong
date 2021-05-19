package hust.soict.hedspi.gui.swing;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class listOrder extends JFrame { // JFrame instead of Frame

    public listOrder(Order anorder) {

        Container cp = getContentPane();
        ArrayList<Media> itemsOrdered = anorder.getItemsOrdered();
        cp.setLayout(new GridLayout(itemsOrdered.size(), 1)); 

        for (int i = 0 ; i < itemsOrdered.size() ; i++){
            cp.add(new JTextField(itemsOrdered.get(i).toString()));
        }

        setTitle("Display Media");  
        setSize(300, 100);          
        setVisible(true);        
    }


}
