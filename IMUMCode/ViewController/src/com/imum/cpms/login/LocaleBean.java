package com.imum.cpms.login;

import java.io.Serializable;

import java.util.Locale;

import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.common.DefLocaleContext;

public class LocaleBean implements Serializable {

    private HtmlSelectOneListbox language;
    String selectedLang = "en";
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    // setting to true - this will create session if doesn't exist
    HttpSession httpSession = (HttpSession) externalContext.getSession(true);
    public LocaleBean() {
    }


    public void setLanguage(HtmlSelectOneListbox language) {
        this.language = language;
    }

    public HtmlSelectOneListbox getLanguage() {
        return language;
    }

    public void languageSelection(ValueChangeEvent valueChangeEvent) {
        selectedLang = valueChangeEvent.getNewValue().toString();
        httpSession.setAttribute("language", selectedLang);
        BindingContext.getCurrent().setLocaleContext(new DefLocaleContext(new Locale(selectedLang)));
        ADFContext.getCurrent().setLocale(new Locale(selectedLang));
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(selectedLang));
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale(selectedLang));
        System.out.println("Locale in Bean" +
                           FacesContext.getCurrentInstance().getViewRoot().getLocale());
        AdfFacesContext context = AdfFacesContext.getCurrentInstance();
        
    }

    public void setSelectedLang(String selectedLang) {
        this.selectedLang = selectedLang;
    }

    public String getSelectedLang() {
        return selectedLang;
    }
}
