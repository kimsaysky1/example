<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	var roomId = "t";
	
	$(document).ready(function() {
		$(".createGame").on("click",createGame);
		setInterval(function(){
			$.ajax({
				url : "checkTurn"
	            , method : "post"
	            , data:roomID
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
            , data:roomID
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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="#" class="createGame"><span>게임 만들기</span></a>

<span class="turn">Result</span>

</body>
</html>
