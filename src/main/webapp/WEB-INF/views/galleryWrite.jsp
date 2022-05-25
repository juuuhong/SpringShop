<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/UploadAdapter.js"></script>

<h2 class="container px-4 py-4 pb-2"></h2>
<form method="post" action="galleryWritePro" enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" name="title" id="title" class="form-control" placeholder="제목입력">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="editor" class="form-control" placeholder="내용작성"></textarea>
		<script>
		ClassicEditor
		.create( document.querySelector( '#editor' ), {
			/* ckfinder: {
				uploadUrl: '/ajax/image'
			}, */
			language: 'ko' //언어설정
		}).then(ditor => {
			window.editor = editor
		})
		.catch( error => {
			console.error( error );
		} );
</script>

	</div>
	<table>
		<tr>
			<td rowspan="2">
				<img src="/resources/sample/default.jpg" id="previewImg" width="150" />
			</td>
			<td>
				<input type="file" name="file" id="file" onchange="preview(this)" class="file"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="삭제" onclick="cancel()" class=""/>
			</td>
		</tr>
	</table>
	<div style='float: right;'>
		<input type="submit" class="btn btn-primary bg-dark" value="저장하기" >
		<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/gallery'">목록</button>
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
</script>