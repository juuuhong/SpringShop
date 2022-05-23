<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">갤러리</h2>
<c:choose>
	<c:when test="${notices eq [] }">
		<h4 align="center">공지사항이 없습니다.</h4>
	</c:when>
	<c:otherwise>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#">Next</a>
				</li>
			</ul>
		</nav>
	</c:otherwise>
</c:choose>

<div style='width:80px;float: right;'>
	<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/galleryWrite'">글작성</button>
</div>
<br >

<div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
	<div class="col">
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

	<div class="col">
		<div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" style="background-image: url('unsplash-photo-2.jpg');">
			<div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
				<h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Much longer title that wraps to multiple lines</h2>
				<ul class="d-flex list-unstyled mt-auto">
					<li class="me-auto">
						<img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
					</li>
					<li class="d-flex align-items-center me-3">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"/></svg>
						<small>Pakistan</small>
					</li>
					<li class="d-flex align-items-center">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"/></svg>
						<small>4d</small>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="col">
		<div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" style="background-image: url('unsplash-photo-3.jpg');">
			<div class="d-flex flex-column h-100 p-5 pb-3 text-shadow-1">
				<h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Another longer title belongs here</h2>
				<ul class="d-flex list-unstyled mt-auto">
					<li class="me-auto">
						<img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
					</li>
					<li class="d-flex align-items-center me-3">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"/></svg>
						<small>California</small>
					</li>
					<li class="d-flex align-items-center">
						<svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"/></svg>
						<small>5d</small>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
