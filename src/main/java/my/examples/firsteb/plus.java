package my.examples.firsteb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "plus", urlPatterns = "/plus") // star
public class plus extends HttpServlet {
    public plus(){
        System.out.println("HelloServlet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
       String heightStr = req.getParameter("height");
       int height = 10;
       try{
           height = Integer.parseInt(heightStr);
       }catch(Exception ignore){}
        */
        String numStr1 = req.getParameter("num1");
        String numStr2 = req.getParameter("num2");

        resp.setContentType("text/html");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
/*
        out.println("<html>");
        out.println("   <head><title>hello</title></head>");
        out.println("   <body>");
        out.println("      <h1> firstWeb </h1>");
*/
/*
        for(int i = 0; i < 10; i++ ) {
            for(int j=0; j<=i; j++) {
                out.println("*");
            }
            out.println("<br>");
        }

        */
        try {
            int num1 = Integer.parseInt(numStr1);
            int num2 = Integer.parseInt(numStr2);
            out.println(num1+num2);
        }
        catch(Exception ex){

        }
        /*
        out.println("   </body>");
        out.println("</html>");
        */
    }

    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }
}
