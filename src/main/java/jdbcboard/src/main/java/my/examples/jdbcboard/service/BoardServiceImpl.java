package jdbcboard.src.main.java.my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService{
    public static final int SIZE = 3;

    @Override
    public List<Board> getBoards(int page) {
        BoardDao boardDao = new BoardDaoImpl();
        int start = page * SIZE -SIZE;
        int limit = SIZE;

        Connection conn = null;
        List<Board> boards = new ArrayList<>();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return boards;
    }

    @Override
    public Board getBoard(Long id) {
        Board board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(id);
            boardDao.updateReadCount(id);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.deleteBoard(id);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }
}
