<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div class="row">
	<div class="medium-12 columns">
		<form action="${linkTo[LoginController].autentica(null,null)}"
			method="post">
			<fieldset>
			
				<small>${errors.from("login_invalido")}</small>
				<div class="medium-10 columns">
					<label>Nome<input type="text" placeholder="Seu Usuario"
						name="usuario">
					</label>
				</div>
				<div class="medium-10 columns">
					<label>Senha <input type="password" placeholder="Sua senha"
						name="senha">
					</label>
				</div>
				<div class="medium-10 columns">
					<input type="submit" class="expanded button" value="ENTRAR" />
				</div>
			</fieldset>
		</form>
	</div>
</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />