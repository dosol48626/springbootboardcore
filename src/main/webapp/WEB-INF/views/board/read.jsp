<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-10-11
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-header">
            Featured
        </div>
        <div class="card-body">
            <h5 class="card-title">게시글 상세보기</h5>
            <div class="mb-3">
                <label class="form-label">Bno</label>
                <input type="text" class="form-control" name="bno" value="${dto.bno}" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">Title</label>
                <input type="text" class="form-control" name="title" value="${dto.title}" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">Content</label>
                <textarea class="form-control" name="content" row="3" readonly>${dto.content}</textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Writer</label>
                <input type="text" class="form-control" name="writer" value="${dto.writer}" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">PostDate</label>
                <input type="text" class="form-control" name="postdate" value="${dto.postdate}" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">VisitCount</label>
                <input type="text" class="form-control" name="visitcount" value="${dto.visitcount}" readonly>
            </div>


            <div class="mb-3">
                <button type="button" class="btn btn-primary">Modify</button>
                <button type="button" class="btn btn-danger">Remove</button>
                <button type="button" class="btn btn-secondary">Board List</button>
            </div>

        <script>
            document.querySelector(".btn-primary").addEventListener("click", function (e){
                self.location=`/board/modify?bno=${dto.bno}`
            })

            document.querySelector(".btn-danger").addEventListener("click", function (e){
                self.location=`/board/remove?bno=${dto.bno}`
                //근데 dto.bno를 어떻게 가져오는거지?
                //이거 self.location으로 위치 잡을때, =이거를 띄어쓰기를 하면 공백으로 잡아버려서
                //에러가 떠버리네. 그러니 띄어쓰기를 쓰면 안되네. 그리고 오류 확인할때,
                //주소 창을 봐야겠다. 주소창에도 정보가 있네. 뭐가 문제인지.
            })

            document.querySelector(".btn-secondary").addEventListener("click", function (e){
                self.location="/board/list"
            })
        </script>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>

