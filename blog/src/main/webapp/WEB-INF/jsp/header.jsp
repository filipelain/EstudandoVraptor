<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html class="no-js" lang="pt-br" dir="ltr">
<head>
<link href="<c:url value='/resources/css/foundation.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/app.css'/>" rel="stylesheet" />
<script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
<title>Blog</title>
</head>
<body>
	<div class="top-bar">
		<div class="top-bar-left">
			<ul class="menu">
				<li class="menu-text"><a
					href="${linkTo[IndexController].index()}">Home</a></li>
				<li><a href="${linkTo[UsuarioController].form()}">Usuarios</a></li>
				<li><a href="${linkTo[UsuarioController].lista()}">Lista de
						usuario</a></li>
				<li><a href="${linkTo[PostagemController].form()}">Nova
						postagem</a></li>
				<li><a href="${linkTo[PostagemController].lista()}">Lista
						de pestogem</a></li>
			</ul>
		</div>
		<div class="top-bar-right">
			<ul class="menu">
				<c:if test="${usuarioLogado.logged}">
					<li><a href="${linkTo[LoginController].logout()}">SAIR</a></li>
					<li>Ola ${usuarioLogado.usuario.nome}</li>
				</c:if>
				<c:if test="${!usuarioLogado.logged}">
				<li><a class="button" href="${linkTo[LoginController].form()}">Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>