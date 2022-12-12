<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Trip Travel</title>
    </head>
    <body>
    <form method="post" action="/join">
        <div class="container">
            <h1>회원가입</h1>
            <div class="form-group">
                <label for="inputEmail">이메일</label>
                <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="inputPassword">비밀번호</label>
                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="숫자, 영어, 특수문자 포함 8자 이상">
            </div>
            <div class="form-group">
                <label for="confirmPassword">비밀번호 확인</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="비밀번호를 한 번 더 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="inputNickname">닉네임</label>
                <input type="text" class="form-control" id="inputNickname" name="nickname" placeholder="영어, 한글, 숫자 최대 12자">
            </div>
            <div class="form-group">
                <label for="inputGender">성별</label>
                <div class="radio" id="inputGender">
                    <label>
                        <input type="radio" name="gender" id="optionsRadios1"value="MALE" checked>
                        남성
                    </label>
                    <label>
                        <input type="radio" name="gender" id="optionsRadios2"value="FEMALE">
                        여성
                    </label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">가입 완료</button>
        </div>
    </form>
    </body>
</html>