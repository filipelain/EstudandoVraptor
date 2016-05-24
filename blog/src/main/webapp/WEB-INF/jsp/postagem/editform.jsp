<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[PostagemController].editapostagem(null)}"
	method="post">
	<fieldset>
		<legend>Edita Postagem</legend>
		<div class="row">
			<input type="hidden" name="postagem.id" value="${postagem.id}" />
			<div class="large-12 columns">
				<label>Titulo <input type="text" value="${postagem.titulo}"
					name="postagem.titulo" />
				</label> <small>${errors.from("postagem.titulo")}</small>
			</div>
			<div class="large-12 columns">
				<label>Postagem<input type="text"
					value="${postagem.postagem}" name="postagem.postagem" />
				</label> <small>${errors.from("postagem.postagem")}</small>
			</div>
			<div class="large-6">
				<label>Data<input type="text" name="postagem.dataPost" value="<fmt:formatDate pattern="dd-MM-yyyy" value='${postagem.dataPost.getTime()}' />"/>
				
				</label>
			</div>

		</div>
		<div class="large-12 columns">
			<input type="submit" value="Alterar" />
		</div>
	</fieldset>
</form>






<c:import url="/WEB-INF/jsp/footer.jsp" />