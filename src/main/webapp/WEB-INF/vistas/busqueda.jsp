<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar</title>
</head>
<body>

<h1>Buscar</h1>

<form action="realizarBusqueda">
  <label for="tipoBusqueda">Elegir tipo de busqueda:</label>
  <select name="tipoBusqueda" id="tipoBusqueda">
    <option value="Genero" name="Genero">Genero</option>
    <option value="Artista">Artista</option>
    <option value="Album">Album</option>
    <option value="Lista">Lista</option>
    <option value="Cancion">Cancion</option>
  </select>
  <br><br>
  
  <label for="busqueda"></label>
  <input type=text name="busqueda" id="busqueda" >
  <input type="submit" value="Submit">
</form>

</body>
</html>