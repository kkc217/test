<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.trip.travel.vo.BoardVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trip.travel.vo.MemberVo" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.trip.travel.vo.BoardVo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>Trip Travel</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
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

        <form method="get" action="/board">
            <div class="row gy-2 g-3 align-items-center">
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="inputSearch" name="search" placeholder="여행지를 검색해보세요." value="<%=request.getAttribute("searchContent")%>">
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary">검색</button>
                </div>
            </div>
        </form>

        <div class="blank pt-5"></div>
        <div class="blank pt-5"></div>

        <a class="btn btn-secondary mb-3" href="/board/new">새 글 작성</a>

        <%
            List<BoardVo> boardList = (List<BoardVo>) request.getAttribute("boardList"); // 리스트 정보
        %>

        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col" class="text-center">제목</th>
                <th scope="col" class="text-center">글쓴이</th>
                <th scope="col" class="text-center">작성일</th>
                <th scope="col" class="text-center">여행지</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (boardList != null) {
                    for (int i = 0; i < boardList.size(); i++) {
                        String createdTime = boardList.get(i).getCreatedTime().format((DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            %>
            <tr onclick="location.href='/board/<%=boardList.get(i).getId()%>'">
                <td style="width: 10%" class="text-center"><%=boardList.get(i).getTitle() == null ? "" : boardList.get(i).getTitle()%></td>
                <td style="width: 10%" class="text-center"><%=boardList.get(i).getMemberVo() == null ? "익명" : boardList.get(i).getMemberVo().getNickname()%></td>
                <td style="width: 10%" class="text-center"><%=createdTime%></td>
                <td style="width: 10%" class="text-center"><%=boardList.get(i).getPlaceTag() == null ? "" : boardList.get(i).getPlaceTag()%></td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>


        <p class="text-center">
            <%
                int currentPage = (int) request.getAttribute("currentPage");
            %>
            <a class='btn btn-secondary btn-sm <%=Objects.equals(currentPage, 1) ? "disabled" : ""%>' href="/board?page=<%=currentPage - 1%>">이전</a>
            <%
                int totalPage = (int) request.getAttribute("totalPage");
                for (int j = 1; j <= totalPage; j++) {
            %>
                    <a class="text-reset" href="/board?page=<%=j%>"><%=j%></a>
            <%
                }
            %>
            <a class='btn btn-secondary btn-sm <%=Objects.equals(currentPage, totalPage) ? "disabled" : ""%>' href="/board?page=<%=currentPage + 1%>">다음</a>
        </p>

    </body>
</html>

