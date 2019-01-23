package Webboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FreeReadServlet", urlPatterns = "/read")
public class FreeReadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            // 오류 화면으로 redirect
            return;
        }
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(id);
        if(board == null){
            // 오류 화면으로 redirect
            return;
        }

        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/read.jsp");
        requestDispatcher.forward(req, resp);
    }
}

