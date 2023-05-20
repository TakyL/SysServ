package com.example.tomcattraining.tableau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.*;

public class Tableau {

    private final JTable tableau;

    public Tableau(DefaultTableModel model) {
        tableau = new JTable(model);
    }

    public JTable getTableau() {
        return tableau;
    }

    public TableColumnModel getColumnModel() {
        return tableau.getColumnModel();
    }

    public TableColumn getColumn(int index) {
        return tableau.getColumnModel().getColumn(index);
    }

    public String getColumnName(int index) {
        return tableau.getColumnName(index);
    }

    public int getRowCount() {
        return tableau.getRowCount();
    }

    public int getColumnCount() {
        return tableau.getColumnCount();
    }

    public Object getValueAt(int row, int col) {
        return tableau.getValueAt(row, col);
    }

    public JTableHeader getTableHeader() {
        return tableau.getTableHeader();
    }

    /**
     * Conversion du tableau au format d'un tableau html
     * @return : tableau balisé
     */
    public String AfficherJSP() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table class='table'>");
        // Print the column headers
        sb.append("<tr>");
        TableColumnModel columnModel = getColumnModel();
        sb.append("<th> Modifier </th>");
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            String columnName = (String) column.getHeaderValue();
            sb.append("<th>");
            sb.append(columnName);
            sb.append("</th>");
        }
        sb.append("</tr>");
        // Affichage des données des rdv
        for (int i = 0; i < getRowCount(); i++) {
            sb.append("<tr>");
            String st = String.format("<td><input type='radio' id='r%d'></td>",i);
            sb.append(st);
            for (int j = 0; j < getColumnCount(); j++) {

                sb.append("<td>");

                sb.append(getValueAt(i, j));
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

}
