<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">공지사항 수정</h2>
<form method="post" action="noticeModifyPro?num=${notice.num}"  enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" name="title" id="title" class="form-control" value="${notice.title }">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="editor" class="form-control">
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
	</div>
	<table>
		<tr>
			<td rowspan="2">
				<c:if test="${file != null}">
					<img src="/resources/file/${requestScope.file}"  id="previewImg" width="150" />
				</c:if>
				<c:if test="${file == null}">
					<img src="/resources/sample/default.jpg" id="previewImg" width="150" />
				</c:if>
			</td>
			<td>
				<input type="file" name="file" id="file" onchange="preview(this)" class="file"/>
				<input type="hidden" id="exPhoto" name="exPhoto" value="${requestScope.file}" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="이미지 삭제" onclick="cancel()" class=""/>
				<input type="button" value="변경취소" onclick="exphoto()" class=""/>
			</td>
		</tr>
	</table>
	<div style='float: right;'>
		<input type="submit" class="btn btn-primary bg-dark" value="수정하기" >
		<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/noticeContent?num=${notice.num}'">취소</button>
	</div>
	<br >
</form>
<script>
	// 이미지 선택시 미리보기
	function preview(input) {
        if(input.files && input.files[0]) {
            const reader = new FileReader()
            reader.onload = e => {
                const previewImage = document.getElementById("previewImg")
                previewImage.src = e.target.result
            } 
            reader.readAsDataURL(input.files[0]) 
        }
    }
	// 이미지 삭제시 file, previewimg 초기화
	function cancel(){
		  var elem = document.getElementById("previewImg");
		  elem.src = "/resources/sample/default.jpg"; // img 초기화
		  
		  var file = document.getElementById("file");
		  file.value = ""; // file 초기화
	}
	// 변경 취소
	function exphoto(){
		var elem = document.getElementById("previewImg");
		elem.src = "/resources/file/${requestScope.file}" ; // 기존이미지 보여주기
		  /* var file = document.getElementById("file");
		  file.value = ${requestScope.file}; // file 초기화 */
	}
</script>