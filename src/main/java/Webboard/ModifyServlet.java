package Webboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FreeReadServlet", urlPatterns = "/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String readTitle = "뜨거운";
        String readName = "남겨";
        String readContent = "바래지고";


        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String passwor = req.getParameter("pw");
        String content = req.getParameter("content");

        req.setAttribute("readTitle",readTitle);
        req.setAttribute("readName",readName);
        req.setAttribute("readContent",readContent);


        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);
    }
}

