package tableau;

import com.example.tomcattraining.metiers.RendezVous;
import com.example.tomcattraining.metiers.TableauView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javafx.scene.control.TableView;

import java.io.IOException;


public class TableauRdvServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TableView<RendezVous> table = new TableauView().getTbl();
        request.setAttribute("table", table);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
