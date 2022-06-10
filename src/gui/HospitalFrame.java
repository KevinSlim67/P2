package gui;

import gui.panels.Form;

import javax.swing.JFrame;
import java.awt.*; //to use Color class

public class HospitalFrame extends JFrame {
    public HospitalFrame() {
        this.setTitle("Hospital"); //sets a title for the frame
        this.setSize(700, 700); //default frame size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*kills the application instead of hiding it
         when pressing on the "X" button*/
        this.getContentPane().setBackground(new Color(0x8b55ab)); //changes background color

        Form form = new Form();
        this.add(form);

        this.setVisible(true); //makes frame visible

    }
}

