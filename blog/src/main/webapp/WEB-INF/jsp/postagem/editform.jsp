<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[PostagemController].editapostagem(null,null)}"
	method="post" enctype="multipart/form-data">
	<div class="row">
		<fieldset>
			<legend>Edita Postagem</legend>

			<input type="hidden" name="postagem.id" value="${postagem.id}" />
			<div class="large-12 columns">
				<label>Titulo <input type="text" value="${postagem.titulo}"
					name="postagem.titulo" />
				</label> <small>${errors.from("postagem.titulo")}</small>
			</div>

			<div class="large-12 columns">
				<label>Postagem<textarea id="mytextarea"
						name="postagem.postagem">${postagem.postagem}</textarea>
				</label> <small>${errors.from("postagem.postagem")}</small>
			</div>
			<div class="large-6 columns">
				<label>Data<input type="text" name="postagem.dataPost"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value='${postagem.dataPost.getTime()}' />" />
				</label>
			</div>
		</fieldset>
		<div class="large-6 columns">
			<fieldset>
				<legend>Upload de Imagem</legend>
				<input type="file" name="capa" />
			
			</fieldset>
		</div>
		<div class="large-6 columns">
			<input class="button" type="submit" value="Alterar" />
		</div>
	</div>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />