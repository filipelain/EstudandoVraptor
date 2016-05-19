<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="row medium-8 large-7 columns">
	<c:forEach items="${postagems}" var="postagems">
		<div class="blog-post">
			<h3>${postagems.titulo} <small><fmt:formatDate
						pattern="dd-MM-yyyy" value="${postagems.dataPost.getTime()}" /></small>
			</h3>
			<img class="thumbnail" src="http://placehold.it/850x350">
			<p>${postagems.postagem}</p>
			<div class="callout">
				<ul class="menu simple">
					<li><a href="#">Author: ${postagems.usuario.nome}</a></li>
					<li><a href="#">Comments: Implementar depois</a></li>
				</ul>
			</div>
		</div>
	</c:forEach>

	<a href="${linkTo[PostagemController].form()}">Nova Postagem</a>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />