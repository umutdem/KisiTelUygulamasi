/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.kisiteluygulamasi.entity.Kisi;
import tr.gov.ptt.kisiteluygulamasi.entity.Telefon;
import tr.gov.ptt.kisiteluygulamasi.service.KisiService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class KisiBean {
    
    private Kisi kisi;
    private List<Kisi> kisiList;
    private Telefon evTel;    
    private Telefon cepTel;
    
    @EJB
    private KisiService kisiService;

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }
    
    public List<Kisi> getKisiList() {
        kisiListele();
        return kisiList;
    }

    public void setKisiList(List<Kisi> kisiList) {
        this.kisiList = kisiList;
    }

    public KisiBean() {
        kisi = new Kisi();
        evTel = new Telefon();
        cepTel = new Telefon();
        kisiList = new ArrayList<Kisi>();
    }
    
    public String kisiEkle()
    {
        List<Telefon> telList = new ArrayList<Telefon>();      
        
        evTel.setKisi(kisi);
        cepTel.setKisi(kisi);
        
        telList.add(evTel);
        telList.add(cepTel);
        
        kisi.setTelefonList(telList);
        
        kisiService.kisiEkle(this.kisi);
        
        return "kisiListele.xhtml?faces-redirect=true";
    }
    
    public String kisiListele()
    {
        kisiList = kisiService.kisiListele();
        return "kisiListele.xhtml?faces-redirect=true";
    }
}
