<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[UsuarioController].novo(null)}" method="POST">
	<fieldset>
		<div class="row">
			<div class="medium-12 columns ">
				<label>Nome <input value="${usuario.nome}" type="text"
					placeholder="Seu Nome" name="usuario.nome" required> <small>${errors.from("usuario.nome")}</small>
				</label>
			</div>
			<div class="medium-12 columns">
				<label>E-mail <input value="${usuario.email}" type="email"
					placeholder="Seu E-mail" name="usuario.email" required> <small>${errors.from("usuario.email")}</small>
				</label>
			</div>
			<div class="medium-12 columns">
				<label>Senha <input type="password" placeholder="Sua senha"
					name="usuario.senha" required> <small>${errors.from("usuario.senha")}</small>
				</label>
			</div>

			<div class="medium-12 columns">
				<input type="submit" class="large button" value="Cadastrar" />
			</div>
		</div>
	</fieldset>
</form>











<c:import url="/WEB-INF/jsp/footer.jsp" />