<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[PostagemController].novaPostagem(null)}" method="post">
	<fieldset>
		<legend>Nova Postagem</legend>
		<div class="row">
			<div class="large-12 columns">
				<label>Titulo <input type="text" value="${postagem.titulo}" name="postagem.titulo" />
				</label> <small>${errors.from("postagem.titulo")}</small>
			</div>
			<div class="large-12 columns">
				<label>Postagem<input type="text" value="${postagem.postagem}" name="postagem.postagem" />
				</label> <small>${errors.from("postagem.postagem")}</small>
			</div>
		</div>
		<div class="large-12 columns">
			<input type="submit" value="Enviar" />
		</div>
	</fieldset>
</form>






<c:import url="/WEB-INF/jsp/footer.jsp" />