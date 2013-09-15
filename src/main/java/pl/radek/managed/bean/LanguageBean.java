package pl.radek.managed.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "languageBean", eager = true)
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = -816338188282732955L;

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	private String localeCode;

	private static Map<String, Object> countries;
	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH); // label, value
		countries.put("French", Locale.FRENCH);
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void changeLanguage() {
		System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());
		locale = new Locale(localeCode);

		for (Map.Entry<String, Object> entry : countries.entrySet()) {

			if (entry.getValue().toString().equals(localeCode)) {

				FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			}
		}
		System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}