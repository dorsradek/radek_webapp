package pl.radek.managed.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ManagedBean
@RequestScoped
public class LoginBean {

	public String doLogin() throws IOException, ServletException {
		System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	public String doLogout() throws IOException, ServletException {
		System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return "logout";
	}

	public String doAsdasd() {

		String asd = "asdasd";
		System.out.println(asd);

		return null;
	}

	public String doRegister() {

		return "home" + "?faces-redirect=true";
	}
}