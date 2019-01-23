<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 읽기</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
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

<div class="container table-bordered" style="padding-top: 15px;">
    <h1 style="text-align:center"> 게시글</h1>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">제목</h3>
        </div>
        <div class="panel-body">
            ${board.title}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">작성자</h3>
        </div>
        <div class="panel-body">
            ${board.userid}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">작성 시간</h3>
        </div>
        <div class="panel-body">
            ${board.regdate}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">내용</h3>
        </div>
        <div class="panel-body">
            ${board.contents}
        </div>
    </div>
    <button type="cancel" class="pull-right btn btn-default"><a href="/freeboard">목록</a></button>
    <button type="cancel" class="pull-right btn btn-default"><a href="/modify">수정</a></button>
    <button type="submit" class="pull-right btn btn-default" data-toggle="modal" data-target="#myModal">삭제</button>

    <!-- Modal  -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">비밀번호 확인</h4>
                </div>
                <div class="modal-body">
                    </form>
                    <div class="form-group">
                        <label for="Password">비밀번호 입력창</label>
                        <input type="password" class="form-control" id="Password" placeholder="비밀번호를 입력하세요.">

                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"><a href="/freeboard">확인</a></button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>