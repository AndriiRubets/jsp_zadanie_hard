package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Client;
import pl.sda.store.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/invoice/add")
public class InvoiceFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("clientId");

        req.setAttribute("clientId", clientId);
        req.getRequestDispatcher("/invoice/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("clientId");

        Optional<Client> clientOptional = dao.findById(Client.class, Long.parseLong(clientId));

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            Invoice invoice = new Invoice();
            invoice.setInvoicecol(req.getParameter("invoicecol"));
            invoice.setClient(client);
            dao.saveOrUpdate(invoice);

            client.getInvoices().add(invoice);
            dao.saveOrUpdate(client);

        }

        resp.sendRedirect("/invoice/list");
    }
}
