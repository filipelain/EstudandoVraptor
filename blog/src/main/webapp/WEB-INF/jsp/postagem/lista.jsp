<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<table class="hover">
	<thead>
		<tr>
			<th>id</th>
			<th>Titulo</th>
			<th>Postagem</th>
			
			
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${postagens}" var="postagens">
		<tr>
		<td>${postagens.id}</td>
		<td>${postagens.titulo}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${linkTo[PostagemController].form()}">Nova Postagem</a>

<c:import url="/WEB-INF/jsp/footer.jsp" />