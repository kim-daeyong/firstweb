package my.examples.firsteb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
    @WebServlet(name = "WriteformServlet", urlPatterns = "/write")
    public class WriteformServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/WEB-INF/views/write.jsp");
            requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            String userid = req.getParameter("name");
            String title = req.getParameter("title");
            String contents = req.getParameter("content");

            BoardDao boardDao = new BoardDaoImpl();
            Board board = new Board(userid, title, contents);
            boardDao.addBoard(board);
            resp.sendRedirect("/freeboard");
        }

}
