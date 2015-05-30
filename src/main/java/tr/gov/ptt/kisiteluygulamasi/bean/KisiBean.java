/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import tr.gov.ptt.kisiteluygulamasi.entity.Kisi;
import tr.gov.ptt.kisiteluygulamasi.entity.Telefon;
import tr.gov.ptt.kisiteluygulamasi.service.KisiService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class KisiBean implements Serializable{

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

    public String kisiEkle() {
        List<Telefon> telList = new ArrayList<Telefon>();

        evTel.setKisi(kisi);
        cepTel.setKisi(kisi);

        telList.add(evTel);
        telList.add(cepTel);

        kisi.setTelefonList(telList);

        kisiService.kisiEkle(this.kisi);

        return "kisiListele.xhtml?faces-redirect=true";
    }

    public String kisiListele() {
        if(kisiList.size()==0)
            kisiList = kisiService.kisiListele();
        return "kisiListele.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent event) {
        Kisi kisi = (Kisi) event.getObject();
        kisiService.kisiGuncelle(kisi);
        FacesMessage msg = new FacesMessage("Edited User Id : " + kisi.getNo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Kisi kisi = (Kisi) event.getObject();
        FacesMessage msg = new FacesMessage(
        "Editing Cancelled for User Id: "+ kisi.getNo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
