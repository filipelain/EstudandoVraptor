<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[PostagemController].novapostagem(null,null)}"
	method="post" enctype="multipart/form-data">

	<legend>Nova Postagem</legend>
	<div class="row">
		<fieldset>
			<div class="large-12 columns">
				<label>Titulo <input type="text" value="${postagem.titulo}"
					name="postagem.titulo" />
				</label> <small>${errors.from("postagem.titulo")}</small>
			</div>
			<div class="large-12 columns">
				<label><textarea id="mytextarea" name="postagem.postagem">${postagem.postagem}</textarea>
				</label> <small>${errors.from("postagem.postagem")}</small>
			</div>
		</fieldset>
		<div class="large-6 columns">
			<fieldset>
				<legend>Upload de Imagem</legend>
				<input type="file" name="capa" />
				
			</fieldset>
		</div>
	</div>
	<div class="large-12 columns">
		<input class="button" type="submit" value="Enviar" />
	</div>

</form>






<c:import url="/WEB-INF/jsp/footer.jsp" />