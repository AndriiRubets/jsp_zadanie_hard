package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Inventory;
import pl.sda.store.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/inventory/list")
public class InventoryListServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String productId = req.getParameter("productId");
        if(productId != null){ // w zależności od tego czy parametr jest (został przekazany) czy nie.
            // logika szukania studenta i jego ocen
            Optional<Product> productOptional = dao.findById(Product.class, Long.parseLong(productId));
            if(productOptional.isPresent()){

                req.setAttribute("inventoryList", productOptional.get().getInventories());
            }else{
                System.err.println("don't find any inventory");
            }
        }else {
            // jeśli nie chcemy ocen konkretnego studenta
            // to znaczy że chcemy wszystkie oceny, dlatego używamy findAll
            req.setAttribute("inventoryList", dao.findAll(Inventory.class));
        }

        req.getRequestDispatcher("/inventory/list.jsp").forward(req, resp);
    }
}
