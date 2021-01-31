<%--
  Created by IntelliJ IDEA.
  User: chlwl
  Date: 2019-12-26
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/rest/form" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <div class="container">
            <h1>휴가 신청</h1>
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>기간</th>
                        <th>휴가 시작일</th>
                        <td><input type="date" class="form-control"></td>
                        <th>휴가 종료일</th>
                        <td><input type="date" class="form-control"></td>
                    </tr>
                    <tr>
                        <th>남은 일수</th>
                        <th>근속 년수</th>
                        <td>1년</td>
                        <th>남은 휴가 일수</th>
                        <td>8일</td>
                    </tr>
                    <tr>
                        <th>구분</th>
                        <td colspan="4">
                            <select name="rest" class="form-control" style="width: 130px !important;">
                                <option value="0" selected="selected">선택</option>
                                <option value="1">연차</option>
                                <option value="2">생리</option>
                                <option value="3">경조</option>
                                <option value="4">출산전후</option>
                                <option value="5">복리</option>
                                <option value="6">기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>사유</th>                                     <!-- 내용 입력 -->
                        <td colspan="4"><textarea rows="5" class="form-control" name="content" placeholder="사유를 입력해주세요." style="resize: none;"></textarea></td>
                    </tr>
                    <tr>
                        <th>작성자</th>                                    <!-- 작성자 입력 -->
                        <td colspan="4">홍길동</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td colspan="4">2019-12-26</td>
                    </tr>
                </table>
        </div>
    </div>
    <div class="btn-wrap">
        <button type="button" class="btn btn-default" onclick="">작성</button>
        <button type="button" class="btn btn-default" onclick="location.href='/rest/'">목록</button>
    </div>
</form>
<input type="file" id="multipleFile" class="hidden" name="multipleFile" multiple>
