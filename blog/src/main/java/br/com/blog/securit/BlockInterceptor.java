package br.com.blog.securit;

import javax.inject.Inject;

import br.com.blog.controller.IndexController;
import br.com.blog.controller.LoginController;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;



@Intercepts
public class BlockInterceptor {

	private Result result;
	private UsuarioLogado logado;
	private ControllerMethod controllerMethod;

	@Inject
	public BlockInterceptor(Result result, UsuarioLogado logado, ControllerMethod controllerMethod) {
		this.result = result;
		this.logado = logado;
		this.controllerMethod = controllerMethod;
	}

	public BlockInterceptor() {
	}
	@Accepts
	public boolean blockopen() {
		return  !controllerMethod.containsAnnotation(Open.class);
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (logado.isLogged()) {
			stack.next();
		} else {
			result.redirectTo(IndexController.class).index();
		}
	}

}
