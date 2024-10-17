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
            <h5 class="card-title">게시글 수정</h5>
        <form method="post" action="/board/modify">
            <input type="hidden" name="bno" value="${dto.bno}">
            <div class="mb-3">
                <label class="form-label">Title</label>
                <input type="text" class="form-control" name="title" value="${dto.title}">
            </div>
            <div class="mb-3">
                <label class="form-label">Content</label>
                <textarea class="form-control" name="content" rows="3"> value=${dto.content}</textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Writer</label>
                <input type="text" class="form-control" name="writer" value="${dto.writer}">
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Modify</button>
                <button type="button" class="btn btn-secondary">Board List</button>
<%--                서브밋은 폼에 액션에 가는데 리스트버튼은 스크립트리해줘야함--%>
            </div>
        </form>

        <script>
            document.querySelector(".btn-secondary").addEventListener("click", function (e){
                self.location="/board/list"
            })
        </script>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>

