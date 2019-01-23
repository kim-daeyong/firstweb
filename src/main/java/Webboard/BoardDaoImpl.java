package Webboard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    @Override
    public Board getBoard(Long idParam) {

        Board board = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            // driver class가 로딩.
            // b. SELECT SQL 준비 - Connection
            String sql = "select id,title,userid,regdate,contents,view from freeboard.freepost where id = ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            //ps.setLong(1, idParam); // 첫번째 물음표에 1를 바인딩한다.
            ps.setLong(1, idParam);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.

            if(rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String userid = rs.getString(3);
                Date regdate = rs.getDate(4);
                String contents = rs.getString(5);
                long view = rs.getInt(6);

               board = new Board(id,userid,title,view,regdate,contents);

                System.out.println(id + "," + title + ", " + contents + ", " + userid + ", " + regdate + ", " + view);
            }else {
                System.out.println(idParam + "에 해당하는 값이 없습니다.");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            try{ rs.close(); } catch(Exception ignore){}
            try{ ps.close(); } catch(Exception ignore){}
            try{ conn.close(); } catch(Exception ignore){}
        }
        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> boards = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            // driver class가 로딩.

            if(conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            String sql = "select id,title,userid,regdate,contents,view from freepost ORDER BY id = ?, ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            //ps.setLong(1, idParam); // 첫번째 물음표에 1를 바인딩한다.
            ps.setInt(1, start);
            ps.setInt(2, limit);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.

            while(rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String userid = rs.getString(3);
                Date regdate = rs.getDate(4);
                String contents = rs.getString(5);
                long view = rs.getInt(6);

                System.out.println(id + "," + title + ", " + contents + ", " + userid + ", " + regdate + ", " + view);

                Board board = new Board(id,userid,title,view,regdate);
                boards.add(board);
                /*
                for(Board boarda : boards){
                    System.out.println(boarda);
                }
                */

            }


        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            try{ rs.close(); } catch(Exception ignore){}
            try{ ps.close(); } catch(Exception ignore){}
            try{ conn.close(); } catch(Exception ignore){}
        }
        return boards;
    }
}
