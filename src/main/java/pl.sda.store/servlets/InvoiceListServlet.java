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

@WebServlet("/invoice/list")
public class InvoiceListServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("clientId");
        if(clientId != null){ // w zależności od tego czy parametr jest (został przekazany) czy nie.
            // logika szukania studenta i jego ocen
            Optional<Client> clientOptional = dao.findById(Client.class, Long.parseLong(clientId));
            if(clientOptional.isPresent()){
                req.setAttribute("invoiceList", clientOptional.get().getInvoices());
            }else{
                System.err.println("don't find any invoices");
            }
        }else {
            // jeśli nie chcemy ocen konkretnego studenta
            // to znaczy że chcemy wszystkie oceny, dlatego używamy findAll
            req.setAttribute("invoiceList", dao.findAll(Invoice.class));
        }

        req.getRequestDispatcher("/invoice/list.jsp").forward(req, resp);
    }
}
