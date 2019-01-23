package my.examples.firsteb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            // 여러개의 sql이 실행
            String sql = "insert into freepost (title, contents, username) values ('ttt333', 'ttt333', 'kim')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.clearParameters();
            if(1 == 1) throw new RuntimeException("-_-;"); // insert가 true 면 넘어감
            ps.executeUpdate();
            ps.clearParameters();
            conn.commit();
        }catch(Exception ex){
            try{ conn.rollback(); }catch(Exception ignore){}
            ex.printStackTrace();
        }finally{
            DBUtil.close(ps, conn);
        }
    }
}