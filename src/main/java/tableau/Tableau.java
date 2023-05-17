package tableau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.*;

public class Tableau {

    private final JTable tableau;

    public Tableau(DefaultTableModel model) {
        // Create a new table model with 0 rows and 4 columns
   //     DefaultTableModel model = new DefaultTableModel(new Object[][] {},
      //          new String[] { "Date ", "Heure", "Client", "Employé" });
        // Create a new JTable with the custom table model
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

    public String AfficherJSP() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
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
        // Print the table data
        for (int i = 0; i < getRowCount(); i++) {
            sb.append("<tr>");
            String st = String.format("<td><input type='radio' name='r%d'></td>",i);
            sb.append(st);//faudra rajouter la colonne modifier
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
