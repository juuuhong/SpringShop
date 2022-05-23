<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	#notice_wrapper {
		margin : 0 0 20px 0
	}
</style>

<h2 class="container px-4 py-4 pb-2">공지사항</h2>
	<div id = "notice_wrapper">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody class="notice_list">
				
			</tbody>
		</table>
		<div style='width:80px;float: right;'>
			<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/noticeWrite'">글작성</button>
		</div>
	</div>
<script>
	$(document).ready(function(){
		doSearch();
	});
	
	function doSearch(){
		$.ajax({
		    type : 'GET',
		    url : "/getNoticeList",
		    data : {},
		    error : function(error) {
		        alert("Error!");
		    },
		    success : function(value) {
		    	console.log(value);
		    	
		    	let html = "";
		    	for (let i = 0; i < value.length; i++) {
		    		html += '<tr><th scope="row">'+value[i].num+'</th>';
		    		html += '<td><a class="notices" href=/noticeContent?num='+value[i].num +'>' + value[i].title + '</a></td>';
		    		html += '<td>'+ value[i].userId + '</td>';
		    		html += '<td>' + value[i].createAt + '</td>';
		    		html += '<td>' + value[i].readcount + '</td></tr>';
				}
		    	$(".notice_list").append(html);
		    }
		});
	}
</script>

