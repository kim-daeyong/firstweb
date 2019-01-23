package my.examples.firsteb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formtagExam")
public class WebServletExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WebServletExam() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doPost");

        // [ 한글처리 ]
        // 1."post"로 사용자가 서버로 요청한 문자열을 utf-8로 인코딩
        request.setCharacterEncoding("utf-8");
        // 2."get"방식 요청에 따른 한글처리는
        /*
         * server.xml 수정필요
         * <Connector URIEncoding="utf-8" 부분을 추가 />
         */

        // form태그내의 name에 해당하는 값들을 가지고옴 return타입은 String
        // request.getParameter("name");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        // request.getParameterValues("name"); => return String[] : checkbox등에 사용
        String sex = request.getParameter("sex");
        String[] hobbys = request.getParameterValues("hobby");
        String major = request.getParameter("major");
        String blog = request.getParameter("blog");
        String blogname = request.getParameter("blogname");

        // request.getParameterNames() : 넘긴 name값을 Enumeration 타입으로 반환함
        Enumeration<String> values = request.getParameterNames();
        while(values.hasMoreElements()){
            String param = values.nextElement();
            System.out.println(request.getParameter(param));
        }

        // 응답 문서 인코딩 타입 지정
        response.setContentType("text/html;charset=utf-8");

        // 문서 출력 스트림 객체 얻기
        PrintWriter writer = response.getWriter();

        writer.println("<head></head>");
        writer.println("이름 : " + name + "<br/>");
        writer.println("아이디 : " + id + "<br/>");
        writer.println("비밀번호 : " + pw + "<br/>");
        writer.println("성별 : " + sex + "<br/>");
        writer.println("취미 : " + Arrays.toString(hobbys) + "<br/>");
        writer.println("주언어 : " + major + "<br/>");
        writer.println("블로그 : " + blog + " / " + "주소 :" + blogname + "<br/>");
        writer.println("");
        // 자원 해제
        writer.close();

    }

}