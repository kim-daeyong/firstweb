package my.examples.firsteb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForwardServlet", urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str1 = "hello";
        String str2 = "world";

        req.setAttribute("str1", str1);
        req.setAttribute("str2", str2);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result");
        requestDispatcher.forward(req, resp);
    }

}
