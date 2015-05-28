/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrator
 */
public class JSFUtil {
    public static void mesajEkle(String mesaj)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mesaj, mesaj));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public static void hataMesajiEkle(String mesaj)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mesaj, mesaj));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
}
