/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.kisiteluygulamasi.entity.Giris;
import tr.gov.ptt.kisiteluygulamasi.service.GirisService;
import tr.gov.ptt.kisiteluygulamasi.util.JSFUtil;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class GirisBean {
    
    private Giris giris;
    @EJB
    private GirisService girisService;

    public GirisBean() {
        giris = new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
        boolean kontrol = girisService.girisKontrol(giris);
        
        if(kontrol)
        {
            HttpSession session = JSFUtil.getSession();
            session.setAttribute("username", giris.getAd());
            session.setAttribute("userid", giris.getSifre());
            JSFUtil.mesajEkle("Hoşgeldin " + giris.getAd() + ",");
            return "menu.xhtml?faces-redirect=true";
        }
            
        else
        {
            JSFUtil.hataMesajiEkle("Hatalı kullanıcı adı ve/veya şifre.");
            return "giris.xhtml?faces-redirect=true";
        }            
    }
    
    public String sessionBitir()
    {
        HttpSession session = JSFUtil.getSession();
        session.invalidate();
        return "giris.xhtml?faces-redirect=true";
    }
}
