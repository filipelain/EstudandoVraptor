<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="row medium-8 large-7 columns">
	<c:forEach items="${postagens}" var="postagens">
		<div class="blog-post">
			<h3>${postagens.titulo}
				<small><fmt:formatDate pattern="dd-MM-yyyy"
						value="${postagens.dataPost.getTime()}" /></small>
			</h3>
			<c:if test="${!linkTo[PostagemController].capa}">
			<img class="thumbnail" src="http://placehold.it/850x350"> 
			</c:if>
			<img class="thumbnail" src="${linkTo[PostagemController].capa}?id=${postagens.id}">
			<p>${postagens.postagem}</p>
			<div class="callout">
				<ul class="menu simple">
					<li><a href="#">Author: ${postagens.usuario.nome}</a></li>
					<li><a href="#">Comments: Implementar depois</a></li>
					<li><c:if
						test="${usuarioLogado.usuario.nome == postagens.usuario.nome}">
						<li class="right"><a class="button small" href="${linkTo[PostagemController].editform(null)}?${postagens.id}">Editar: ${postagens.id}</a></li>
					</c:if></li>
				</ul>
			</div>
		</div>
	</c:forEach>

	<a href="${linkTo[PostagemController].form()}">Nova Postagem</a>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />