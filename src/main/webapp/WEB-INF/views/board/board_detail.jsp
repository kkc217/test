<%@ page import="com.trip.travel.vo.BoardVo" %>
<%@ page import="com.trip.travel.vo.MemberVo" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="com.trip.travel.vo.PlaceVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trip.travel.vo.BoardCommentVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    session = request.getSession();
    MemberVo member = (MemberVo) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Trip Travel</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            .profile-img {
                width: 50px;
                height: 50px;
            }

            .like-img {
                width: 20px;
                height: 20px;
            }
        </style>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script>
            function checkLogin(isNull) {
                if (isNull) {
                    alert("로그인이 필요합니다.");
                    return false;
                }
                return true;
            }

            function changeLike(isNull, boardId, changedLike) {
                if (isNull) {
                    alert("로그인이 필요합니다.");
                    return;
                }

                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "/board/like");

                var likeInfo = document.createElement("input");
                likeInfo.setAttribute("type", "hidden");
                likeInfo.setAttribute("name", "changedLike");
                likeInfo.setAttribute("value", changedLike);
                form.appendChild(likeInfo);

                var boardIdInfo = document.createElement("input");
                boardIdInfo.setAttribute("type", "hidden");
                boardIdInfo.setAttribute("name", "boardId");
                boardIdInfo.setAttribute("value", boardId);
                form.appendChild(boardIdInfo);

                document.body.appendChild(form);
                form.submit();
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">여행을 여행하다</a>
                <div class="navbar-nav">
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <%
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

        <%
            BoardVo board = (BoardVo) request.getAttribute("board");
            String createdTime = board.getCreatedTime().format((DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        %>
        <div class="container">
            <div class="container">

            <h2><%=board.getTitle()%></h2>

            <div class="blank pt-3"></div>

                <div class="row gy-2 g-3 align-items-center">
                    <div class="col-sm-5">
                        <span style="font-size: 1.1em; font-weight: bold">작성자</span>&nbsp;&nbsp;
                        <%=board.getMemberVo() == null ? "익명" : board.getMemberVo().getNickname()%>

                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <span style="font-size: 1.1em; font-weight: bold">작성일</span>&nbsp;&nbsp;
                        <%=createdTime%>
                    </div>
                </div>

                <div class="blank pt-5"></div>
                <div class="blank pt-5"></div>

                <h3>본문</h3>
                <p><%=board.getContent()%></p>

                <div class="blank pt-5"></div>
                <div class="blank pt-5"></div>

                <h3>여행지 태그</h3>
                <p><%=board.getPlaceTag()%></p>

                <%
                    List<PlaceVo> placeList = (List<PlaceVo>) request.getAttribute("placeList");
                    if (placeList.size() > 0) {
                %>

                <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel" style="max-width: 700px">
                    <div class="carousel-indicators">
                        <%
                            for (int i = 0; i < placeList.size(); i++) {
                        %>
                        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="<%=i%>" class="active" aria-current="true" aria-label="Slide <%=i%>"></button>

                        <%
                            }
                        %>
                    </div>
                    <div class="carousel-inner">
                        <%
                            for (int i = 0; i < placeList.size(); i++) {
                                PlaceVo place = placeList.get(i);
                        %>
                        <div class="carousel-item <%=i == 0 ? "active" : ""%>" data-bs-interval="10000">
                            <img src="<%=place.getImageUrl()%>" class="d-block w-100">
                            <div class="carousel-caption d-none d-md-block" style="background-color: black; opacity: 80%">
                                <h5 style="color: white"><%=place.getTitle()%></h5>
                                <p style="color: white"><%=place.getShortIntroduction()%></p>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
                <%
                    }
                %>
            </div>

            <div class="blank pt-5"></div>

            <%
                boolean boardLike = (boolean) request.getAttribute("boardLike");
            %>
            <div style="min-width: 100px; max-width: 700px; text-align: center">

                    <%
                        if (boardLike) {
                    %>
                    <button type="button" class="btn btn-outline-danger" onclick="changeLike(<%=Objects.isNull(member)%>, <%=board.getId()%>, <%=!boardLike%>)">
                        <img class="like-img" src="/resources/image/like.png">
                        &nbsp;&nbsp;&nbsp;좋아요
                    </button>
                    <%
                    } else {
                    %>
                    <button type="button" class="btn btn-outline-secondary" onclick="changeLike(<%=Objects.isNull(member)%>, <%=board.getId()%>, <%=!boardLike%>)">
                        <img class="like-img" src="/resources/image/not_like.png">
                        &nbsp;&nbsp;&nbsp;좋아요
                    </button>
                    <%
                        }
                    %>
            </div>

        </div>

        <div class="blank pt-5"></div>

        <div class="container">

            <h2>댓글</h2>

            <section class="mb-5">
                <div class="card bg-light">
                    <div class="card-body">
                        <form class="mb-4" method="post" action="/board/comment" onsubmit="return checkLogin(<%=Objects.isNull(member)%>)">
                            <textarea class="form-control" rows="3" name="content" placeholder="댓글을 작성해 주세요."></textarea>
                            <input type="hidden" name="boardId" value="<%=board.getId()%>">
                            <div class="blank pt-1"></div>
                            <button type="submit" class="btn btn-primary">등록</button>
                        </form>

                        <%
                            List<BoardCommentVo> commentList = (List<BoardCommentVo>) request.getAttribute("commentList");
                            for (BoardCommentVo comment : commentList) {
                                String commentCreatedTime = comment.getCreatedTime().format((DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
                        %>
                        <div class="d-flex mb-4">
                            <div class="flex-shrink-0">
                                <img class="rounded-circle profile-img" src="/resources/image/default_profile.png">
                            </div>
                            <div class="ms-3">
                                <div class="fw-bold">
                                    <%=comment.getMemberVo() == null ? "익명" : comment.getMemberVo().getNickname()%>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span style="font-size: 0.8em"><%=commentCreatedTime%></span>
                                </div>

                                <%=comment.getContent()%>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>