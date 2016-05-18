<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="row">
	<table class="hover">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuario}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${linkTo[UsuarioController].form()}">Novo Usuario</a>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />