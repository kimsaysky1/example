<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery.min.js"></script>
<script type="text/javascript">
	var roomId = "t";
	
	$(document).ready(function() {
		$(".createGame").on("click",createGame);
		setInterval(function(){
			$.ajax({
				url : "checkTurn"
	            , method : "post"
	            , data : roomId
	            , dataType : "text"
	            , contentType: "application/json;charset=utf-8"
	            , success : function(k) {
	            	if(k!=null||k.length!=0)
	            		$(".turn").text(k);
	            }
			});
		},5000); 
	});

	function createGame(){
		$.ajax({
			url : "createRoom"
            , method : "post"
            , data : roomId
            , dataType : "text"
            , contentType: "application/json;charset=utf-8"
            , success : function() {
            	$(".turn").text("ready...");
            }
		});
	}
	</script>
</head>
<body>
<a href="#" class="createGame"><span>게임 만들기</span></a><br><br>

<span class="turn">Result</span>
</body>
</html>