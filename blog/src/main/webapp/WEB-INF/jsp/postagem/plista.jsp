<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<table class="hover">
		<thead>
			<tr>
				<th>id</th>
				<th>usuario</th>
				<th>Titulo</th>
				<th>Postagem</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postagem}" var="postagem">
				<tr>
					<td>${postagem.id}</td>
					<td>${postagem.usuario}</td>
					<td>${postagem.titulo}</td>
					<td>${postegem.postagem}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${linkTo[PostagemController].form()}">Nova Postagem</a>
</div>

