package my.examples.firsteb;

import java.util.Date;

// VO or DTO - 하나의 값을 가지는 객체
public class Board {
    // 필드
    private Long id;
    private String userid;
    private String title;
    private String contents;
    private Date regdate;
    private Long view;

    // 자기 자신의 생성자를 호출하는 방법
    // LocaDateTime 에 대하여 공부.

    public Board(){
        this.regdate = new Date();
        this.view = 0L;
    }

    public Board(String title, String content, String userid) {
        this();
        this.title = title;
        this.contents = content;
        this.userid = userid;
    }

    public Board(long id, String userid, String title, Long view, Date regdate) {
        this.userid = userid;
        this.title = title;
        this.view = view;
        this.id = id;
        this.regdate = regdate;

    }

    public Board(long id, String userid, String title, Long view, Date regdate, String contents) {
        this(id,userid, title,view, regdate);
        this.contents= contents;

    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    // getter , setter 메소드
    // id 프로퍼티
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String content) {
        this.contents = contents;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", regdate=" + regdate +
                ", view=" + view +
                '}';
    }
}
