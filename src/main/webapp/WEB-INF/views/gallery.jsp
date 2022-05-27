<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	#gallery_wrapper {
	}
</style>

<h2 class="container px-4 py-4 pb-2">갤러리</h2>
	<div style='width:80px;float: right;'>
		<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/galleryWrite'">글작성</button>
	</div>

<div class="row mb-2">
	 <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">World</strong>
          <h3 class="mb-0">Featured post</h3>
          <div class="mb-1 text-muted">Nov 12</div>
          <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
          <a href="#" class="stretched-link">Continue reading</a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

        </div>
      </div>
    </div>
    
    
	<div class="gallery"></div>
		
</div>
    
<script>
	$(document).ready(function(){
		doSearch();
	});
	
	function doSearch(){
		$.ajax({
		    type : 'GET',
		    url : "/getGalleryList",
		    data : {},
		    error : function(error) {
		        alert("Error!");
		    },
		    success : function(value) {
		    	console.log(value);
		    	
		    	let html = "";
		    	for (let i = 0; i < value.length; i++) {
		    		//html +=  '<li><img src="/resources/file/'+value[i].saved_file_name+'"  class="img-thumbnail"></li>';
		    		html +=  '<div class="col-md-6">';
		    		html +=  '<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">';
		    		html +=  '<div class="col p-4 d-flex flex-column position-static">';
		    		html +=  '<strong class="d-inline-block mb-2 text-success">'+value[i].userId+'</strong>';
		    		html +=  '<h3 class="mb-0">'+value[i].title+'</h3>';
		    		html +=  '<div class="mb-1 text-muted">'+value[i].createAt+'</div>';
		    		html +=  '<a href="#" class="stretched-link">Continue reading</a>';
		    		html +=  '</div>';
		    		html +=  '<div class="col-auto d-none d-lg-block">';
		    		html +=  '<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">';
		    		html +=  '<title>Placeholder</title>';
		    		html +=  '<rect width="100%" height="100%" fill="#55595c"/>';
		    		html +=  '<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>';
		    		html +=  '</svg>';
		    		html +=  '</div>';
		    		html +=  '</div>';
		    		html +=  '</div>';
				}
		    	$(".gallery").append(html);
		    }
		});
	}
</script>