package pl.sda.store.servlets;

import pl.sda.store.database.EntityDao;
import pl.sda.store.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", dao.findAll(Product.class) );
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }
}
