package lab4.controller;

import java.awt.event.ActionEvent;


public class AddNewButtonActionListener extends
        ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        list.add("Name: Temp Address: Temp Phonenumber: Temp");
        table.revalidate();
    }
}