<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">공지사항 수정</h2>
<form method="post" action="noticeModifyPro?num=${notice.num}">
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" name="title" id="title" class="form-control" value="${notice.title }">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="editor" class="form-control">
			<c:if test="${file != null}">
				<img src="/resources/file/${requestScope.file}"/>
			</c:if>
			${notice.content}
		</textarea>
		<script>
			ClassicEditor
				.create( document.querySelector( '#editor' ), {
					language: 'ko' //언어설정
				})
				.catch( error => {
					console.error( error );
				} );
		</script>
		<input type="file" name="file" style="margin: 10px 0 0 0">
	</div>
	<div style='float: right;'>
		<input type="submit" class="btn btn-primary bg-dark" value="수정하기" >
		<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/noticeContent?num=${notice.num}'">취소</button>
	</div>
	<br >
</form>