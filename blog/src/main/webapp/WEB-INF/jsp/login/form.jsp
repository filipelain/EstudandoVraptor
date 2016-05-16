<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="reveal" id="log" data-reveal data-overlay="false">
	<div class="row">
		<div class="medium-12 columns">
			<form action="${linkTo[LoginController].autentica(null,null)}"
				method="post">
				<fieldset>
					<legend>Login</legend>
					<small>${errors.from("login_invalido")}</small>
					<div class="medium-10 columns">
						<label>Nome<input type="text" placeholder="Seu Usuario"
							name="nome">
						</label>
					</div>
					<div class="medium-10 columns">
						<label>Senha <input type="password"
							placeholder="Sua senha" name="senha">
						</label>
					</div>
					<div class="medium-10 columns">
						<input type="submit" class="large button" value="ENTRAR" />
					</div>
				</fieldset>
			</form>
		</div>
	</div>

</div>



