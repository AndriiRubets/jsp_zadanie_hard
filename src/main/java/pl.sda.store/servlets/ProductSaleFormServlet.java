package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Client;
import pl.sda.store.model.Invoice;
import pl.sda.store.model.ProductSale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/productSale/add")
public class ProductSaleFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String invoiceId = req.getParameter("invoiceId");

        req.setAttribute("invoiceId", invoiceId);
        req.getRequestDispatcher("/productSale/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String invoiceId = req.getParameter("invoiceId");
        Optional<Invoice> invoiceOptional = dao.findById(Invoice.class, Long.parseLong(invoiceId));


        if (invoiceOptional.isPresent()) {
            Invoice invoice=invoiceOptional.get();
            ProductSale productSale=new ProductSale();
            productSale.setQuantity(req.getParameter("quantity"));
            productSale.setPrice(req.getParameter("price"));
            productSale.setInvoice(invoice);
            dao.saveOrUpdate(productSale);

            invoice.getProductSales().add(productSale);
            dao.saveOrUpdate(invoice);
        }
        resp.sendRedirect("/productSale/list");
    }
}
