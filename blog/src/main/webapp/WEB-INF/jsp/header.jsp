<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html class="no-js" lang="pt-br" dir="ltr">
<head>
<link href="<c:url value='/resources/css/foundation.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/app.css'/>" rel="stylesheet" />
<title>Blog</title>
</head>
<body>

	<ul class="menu">
		<li><a href="${linkTo[IndexController].index()}">Home</a></li>
		<li><a href="${linkTo[UsuarioController].form()}">Usuarios</a></li>
		<li><a href="${linkTo[UsuarioController].lista()}">Lista de usuario</a></li>
		<li><a href="${linkTo[PostagemController].form()}">Nova postagem</a></li>
		<li><a href="${linkTo[PostagemController].lista()}">Lista de pestogem</a> </li>
		<c:if test="${usuarioLogado.logged}">
		   <li><a href="${linkTo[LoginController].logout()}">SAIR</a></li>
		</c:if>
	</ul>
	<hr>
	