<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="pt-br" dir="ltr">
<head>
<link href="<c:url value='/resources/css/foundation.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/app.css'/>" rel="stylesheet" />
<title>Sistema de horas</title>
</head>
<body>
	<div class="row">
		<ul class="menu">
			<li><a href="${linkTo[IndexController].index()}">Home</a></li>
			<li><a href="${linkTo[UsuarioController].form()}">Novo
					Usuario</a></li>
			<li><a href="${linkTo[UsuarioController].lista()}">Lista de
					Usuario</a></li>
			<li><a href="${linkTo[PostagemController].lista()}">Lista
					Postagem</a></li>
			<c:if test="${usuarioLogado.logged}">
				<li><a href="${linkTo[LoginController].logout()}">SAIR</a></li>
			</c:if>
			<c:if test="${!usuarioLogado.logged}">
				<li><a data-toggle="log">Login</a></li>
			</c:if>
		</ul>
	</div>
	<c:import url="/WEB-INF/jsp/login/form.jsp" />
	<hr>