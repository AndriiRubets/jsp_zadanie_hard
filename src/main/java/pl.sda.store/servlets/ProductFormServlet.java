package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/add")
public class ProductFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product=new Product();
        product.setName(req.getParameter("name"));

        dao.saveOrUpdate(product);
        resp.sendRedirect("/product/list");
    }
}
