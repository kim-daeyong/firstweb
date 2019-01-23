<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 작성</title>
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

<h1 style="text-align:center">게시글 작성</h1>
<div class="container table-bordered" style="padding-top: 15px;">
    <form>
        <div class="form-group">
            <label for="Name">작성자</label>
            <input type="text" class="form-control" id="Name" placeholder="작성자 이름을 입력하세요. ">

        </div>
        <div class="form-group">
            <label for="Password">비밀번호</label>
            <input type="password" class="form-control" id="Password" placeholder="비밀번호를 입력하세요.">

        </div>
        <div class="form-group">
            <label for="Title">제목</label>
            <input type="text" class="form-control" id="Title" placeholder="제목을 입력하세요. ">

        </div>
        <div class="form-group">
            <label for="Comment">내용</label>
            <textarea class="form-control" rows="5" id="Comment"></textarea>
        </div>
        <button type="cancel" class="pull-right btn btn-default"><a href="/freeboard">취소</a></button>
        <button type="submit" class="pull-right btn btn-default"> <a href="/freeboard">올리기</a></button>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>



