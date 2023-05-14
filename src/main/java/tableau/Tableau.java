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
        populateTable();

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
            String st = String.format("<input type='radio' name='r%d'>",i);

            for (int j = 0; j < getColumnCount(); j++) {
                sb.append("<td>");
                //sb.append(st);faudra rajouter la colonne modifier
                sb.append(getValueAt(i, j));
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private void populateTable() {

        // Establish a connection to the H2 database
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            // Execute a SELECT query to retrieve data from the table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Rdv");
            // Iterate over the result set and add the data to the table model
            DefaultTableModel model = (DefaultTableModel) tableau.getModel();
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getDate("date");
                row[1] = rs.getString("heure");
                row[2] = rs.getString("client");
                row[3] = rs.getString("employe");
                model.addRow(row);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
