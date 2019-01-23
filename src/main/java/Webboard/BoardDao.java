package Webboard;

import java.util.List;

public interface BoardDao {
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);
}
