<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Album">
    <label for="direccion">Artista:</label><br>
  <input type="number" id="idArtista" name="idArtista" value="${artista}"><br><br>
    
    <label for="direccion">Album:</label><br>
  <input type="number" id="idAlbum" name="idAlbum" value = "${album}"><br><br>
  
  <input type="submit" value="Enviar">
</form>
</body>
</html>