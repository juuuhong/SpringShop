<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2"></h2>
<form method="post" action="galleryWritePro">
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" name="title" id="title" class="form-control" placeholder="제목입력">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="editor" class="form-control" placeholder="내용작성"></textarea>
		<script>
		ClassicEditor
		.create( editorElement, {
			ckfinder: {
				options: {
					resourceType: 'Images'
				}
			}
		} )
		.then( ... )
		.catch( ... );
</script>

	</div>
	<div style='float: right;'>
		<input type="submit" class="btn btn-primary bg-dark" value="저장하기" >
		<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/gallery'">목록</button>
	</div>
	<br >
</form>
<script>
function MyCustomUploadAdapterPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
        return new UploadAdapter(loader)
    }
}
</script>