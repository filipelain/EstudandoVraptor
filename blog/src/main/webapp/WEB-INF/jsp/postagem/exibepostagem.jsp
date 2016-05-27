<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="row medium-8 large-7 columns">
		<div class="blog-post">
			<input type="hidden" name="postagem.id" value="${postagem.id}" />
			<h3>${postagem.titulo}
				<small><fmt:formatDate pattern="dd-MM-yyyy"
						value="${postagem.dataPost.getTime()}" /></small>
			</h3>
			<!-- <img class="thumbnail" src="http://placehold.it/850x350"> -->
			<img class="thumbnail" src="${linkTo[PostagemController].capa}?id=${postagem.id}">
			<p>${postagem.postagem}</p>
			<div class="callout">
				<ul class="menu simple">
					<li><a href="#">Author: ${postagem.usuario.nome}</a></li>
					<li><a href="#">Comments: Implementar depois</a></li>
					<li><c:if
						test="${usuarioLogado.usuario.nome == postagem.usuario.nome}">
						<li class="right"><a class="button small" href="${linkTo[PostagemController].editform(null)}?${postagem.id}">Editar: ${postagem.id}</a></li>
					</c:if></li>
				</ul>
			</div>
		</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />