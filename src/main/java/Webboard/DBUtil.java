package Webboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtil {
    // DB연결과 close를 하는 클래스
    private static final String driverClassname = "com.mysql.cj.jdbc.Driver"; // driver class이름도 JDBC Driver에 다르다.
    private static final String driverURL = "jdbc:mysql://localhost:3306/freeboard?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8"; // driver URL형식 Database마다 다르다.
    private static final String dbUserId = "supervisor";
    private static final String dbUserPassword = "7604kdy";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driverClassname);
            conn = DriverManager.getConnection(driverURL, dbUserId,dbUserPassword);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("DB연결을 할 수 없습니다.");
        }
        return conn;
    }
public static void close(PreparedStatement ps, Connection conn){

        try{ps.close();} catch(Exception ignore){}
        try{conn.close();} catch(Exception ignore){}
}
}
