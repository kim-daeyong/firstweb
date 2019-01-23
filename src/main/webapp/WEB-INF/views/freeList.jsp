<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko" xmlns:padding="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 목록</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">킴보드</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">공지사항</a></li>
            <li><a href="/freeboard">자유게시판</a></li>
            <li><a href="#">익명게시판</a></li>
        </ul>
    </div>
</nav>

<div class="container table-bordered" style="padding-top: 20px;">
    <table class="table table-striped">
        <thead>
        <h1 style="text-align:center" >자유 게시판</h1>
        <h1> </h1>
        <tr>
            <th scope="col" width="100">번호</th>
            <th scope="col" width="400">제목</th>
            <th scope="col" width="150">작성자</th>
            <th scope="col" width="150">날짜</th>
            <th scope="col" width="100">조회수</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${requestScope.boards}" var="board">
            <tr>
                <th scope="row">${board.id}</th>
                <td><a href="/read?id=${board.id}">${board.title}</a></td>
                <td>${board.userid}</td>
                <td>${board.regdate}</td>
                <td>${board.view}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn pull-right btn-default"  onclick = "location.href = 'write.html' ">글쓰기</a>

    <div class="col-xs-4">
        <div class="input-group">
            <input class="form-control" placeholder="검색" />
            <span class="input-group-addon">찾기</span>
        </div>
    </div>

        <ul class="pull-left pagination">
            <li><a href="#">이전</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">다음</a></li>
    </ul>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>