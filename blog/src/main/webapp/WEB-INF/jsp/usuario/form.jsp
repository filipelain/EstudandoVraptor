<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[PessoaController].adciona(null)}" method="POST">
	<fieldset>
		<div class="row">
			<div class="medium-12 columns ">
				<label >Nome <input value="${pessoa.nome}"
					type="text" placeholder="Seu Nome" name="pessoa.nome" required>
					<small>${errors.from("pessoa.nome")}</small>
				</label>
			</div>
			<div class="medium-12 columns">
				<label>E-mail <input value="${pessoa.email}" type="email"
					placeholder="Seu E-mail" name="pessoa.email" required> <small>${errors.from("pessoa.email")}</small>
				</label>
			</div>
			<div class="medium-12 columns">
				<label>Usuario <input value="${pessoa.usuario}" type="text"
					placeholder="Seu Usuario" name="pessoa.usuario" required> <small>${errors.from("pessoa.usuario")}</small>
				</label>
			</div>
			<div class="medium-12 columns">
				<label>Senha <input type="password" placeholder="Sua senha"
					name="pessoa.senha" required> <small>${errors.from("pessoa.senha")}</small>
				</label>
			</div>

			<div class="medium-12 columns">
				<input type="submit" class="large button" value="Cadastrar"/>
			</div>
		</div>
	</fieldset>
</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />