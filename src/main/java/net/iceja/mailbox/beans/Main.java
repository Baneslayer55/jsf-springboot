/*
Copyright (c) 2019 Ekaterina Alexeevna Ivanova  (iceja.moscow). All rights reserved.
PROPRIETARY. For demo purposes only, not for redistribution or any commercial use.
*/
package net.iceja.mailbox.beans;

import net.iceja.util.Mailer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import net.iceja.dao.UserManagementDAO;

/*
    @author Ekaterina (iceja.net) Ivanova


 */
@ManagedBean(name = "main",eager = true)
@SessionScoped
public class Main {
    private String message = "";
    private String sender = "";
    @Inject
    UserManagementDAO theUserDao;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return this method called form the webpage, it is for sending me an e-mail
     */
    public String sendmessage(){
        System.out.println("sendmessage " + this.message);
        Mailer.send(sender, message);
        sender = "";
        message="отправлено";
        return "";
    }

    private String locale;

    private static Map<String,Object> countries;
    static {

        countries = new LinkedHashMap<String,Object>();
        countries.put("English", Locale.ENGLISH);
        countries.put("Русский", new Locale("ru", "RU"));
    }

    public Map<String, Object> getCountries() {
        return countries;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
        setLanguageLocale(locale);
    }

    //value change event listener
    public void localeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();

        setLanguageLocale(newLocaleValue);
    }

    /**
     * @param - the new local name
     *
     * this method
     */
    private void setLanguageLocale(String newLocaleValue) {
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
