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

@WebServlet("/inventory/add")
public class InventoryFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");

        req.setAttribute("productId", productId);
        req.getRequestDispatcher("/inventory/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productId = req.getParameter("productId");

        Optional<Product> productOptional = dao.findById(Product.class, Long.parseLong(productId));

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Inventory inventory = new Inventory();
            inventory.setQuantity(req.getParameter("quantity"));
            inventory.setValue(req.getParameter("value"));
            inventory.setProduct(product);
            dao.saveOrUpdate(inventory);

            product.getInventories().add(inventory);
            dao.saveOrUpdate(product);

        }

        resp.sendRedirect("/inventory/list");
    }
}
