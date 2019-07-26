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

@WebServlet("/productSale/list")
public class ProductSaleListServlet extends HttpServlet {
    private EntityDao  dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String invoiceId = req.getParameter("invoiceId");

        if(invoiceId != null){ // w zależności od tego czy parametr jest (został przekazany) czy nie.
            // logika szukania studenta i jego ocen
            Optional<Invoice> invoiceOptional = dao.findById(Invoice.class, Long.parseLong(invoiceId));
            if(invoiceOptional.isPresent()){
                req.setAttribute("productSaleList", invoiceOptional.get().getProductSales());
            }else{
                System.err.println("don't find any productSale");
            }
        }else {
            // jeśli nie chcemy ocen konkretnego studenta
            // to znaczy że chcemy wszystkie oceny, dlatego używamy findAll
            req.setAttribute("productSaleList", dao.findAll(ProductSale.class));
        }

        req.getRequestDispatcher("/productSale/list.jsp").forward(req, resp);
    }
}
