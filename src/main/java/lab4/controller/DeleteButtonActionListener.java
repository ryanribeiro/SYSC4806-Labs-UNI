package lab4.controller;

import java.awt.event.ActionEvent;


public class DeleteButtonActionListener
        extends ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            // if there is no selected row, don't do anything
            return;
        }

        if (table.isEditing()) {
            // if we are editing the table, don't do anything
            return;
        }

        list.remove(selectedRow);
        table.revalidate();
    }
}