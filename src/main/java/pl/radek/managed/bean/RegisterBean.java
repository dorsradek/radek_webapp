package pl.radek.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@ManagedBean
@RequestScoped
public class RegisterBean {

	public String doRegister() {

		return "home" + "?faces-redirect=true";
	}

}
