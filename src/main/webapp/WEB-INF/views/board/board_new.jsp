<%@ page import="com.trip.travel.vo.MemberVo" %>
<%@ page import="java.util.Objects" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Trip Travel</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">여행을 여행하다</a>
                <div class="navbar-nav">
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <%
                                session = request.getSession();
                                MemberVo member = (MemberVo) session.getAttribute("loginMember");
                                if (Objects.isNull(member)) {
                                    out.print("<li class='nav-item'>" +
                                            "<a class='nav-link active' aria-current='page' href='/join'>회원가입</a>" +
                                            "</li>");
                                    out.print("<li class='nav-item'>" +
                                            "<a class='nav-link active' aria-current='page' href='/login'>로그인</a>" +
                                            "</li>");
                                } else {
                                    out.print("<li class='nav-item'>" +
                                            "<a class='nav-link active' aria-current='page' href='#'>" +
                                            member.getNickname() +
                                            "</a>" +
                                            "</li>");
                                    out.print("<li class='nav-item'>" +
                                            "<a class='nav-link active' aria-current='page' href='/logout'>로그아웃</a>" +
                                            "</li>");
                                }
                            %>

                        </ul>
                    </div>

                </div>
            </div>
        </nav>

        <div class="blank pt-5"></div>
        <div class="blank pt-5"></div>

        <form method="post" action="/board/new">
            <div class="container">
                <h1>새 글 작성하기</h1>
                <div class="form-group">
                    <label for="inputTitle">제목</label>
                    <input type="text" class="form-control" id="inputTitle" name="title" placeholder="제목을 입력해 주세요.">
                </div>
                <div class="form-group">
                    <label for="inputContent">내용</label>
                    <textarea type="text" class="form-control" rows="5" id="inputContent" name="content"></textarea>
                </div>
                <div class="form-group">
                    <label for="inputPlaceTag">여행지 태그</label>
                    <textarea type="text" class="form-control" rows="3" id="inputPlaceTag" name="placeTag"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">작성 완료</button>
            </div>
        </form>
    </body>
</html>