package my.examples.firsteb;

import java.util.List;

public interface BoardDao {
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);
    void addBoard(Board board);

    void deleteBoard(Long id);

    void updateReadCount(long id);
}
