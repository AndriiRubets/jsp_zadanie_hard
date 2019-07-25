package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/client/add")
public class ClientFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client=new Client();
        client.setName(req.getParameter("name"));
        client.setLastname(req.getParameter("lastname"));
        client.setNip(req.getParameter("nip"));

        dao.saveOrUpdate(client);
        resp.sendRedirect("/client/list");
    }
}
