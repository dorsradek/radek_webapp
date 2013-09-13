package pl.radek.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RegisterBean {

	public String doRegister() {

		return "home" + "?faces-redirect=true";
	}

}
