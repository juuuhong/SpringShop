<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#gallery_wrapper {
		margin : 0 0 20px 0
	}
</style>

<h2 class="container px-4 py-4 pb-2">갤러리</h2>
<div style='width:80px;float: right;'>
	<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/galleryWrite'">글작성</button>
</div>

<div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
	<div class="col" id="gallery_wrapper">
		<div class="gallery_List">
		
		<div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" style="background-image: url('unsplash-photo-1.jpg');">
			<div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
				<h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Short title, long jacket</h2>
				<ul class="d-flex list-unstyled mt-auto">
					<li class="d-flex align-items-center me-3">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"/></svg>
						<small>Earth</small>
					</li>
					<li class="d-flex align-items-center">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"/></svg>
						<small>3d</small>
					</li>
				</ul>
			</div>
		</div>
		
		</div>
	</div>
</div>
<script>
/* 	$(document).ready(function(){
		doSearch();
	})
	function doSearch(){
		$ajax({
			type : 'GET',
			url : "/getGalleryList",
		    data : {},
		    error : function(error){
		    	alert("Error!");
		    },
		    success : function(value){
		    	console.log(value);
		    	
		    	let html="";
		    	for(let i = 0; i < value.length; i++){
		    		html += 
		    	}
		    }
		    
		})
	} */
</script>