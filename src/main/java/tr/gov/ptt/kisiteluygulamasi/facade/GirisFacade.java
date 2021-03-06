/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.kisiteluygulamasi.entity.Giris;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "KisiTelUygulamasiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }

    public boolean girisKontrol(Giris p_giris) {
        boolean result = false;
        Giris g = null;
        try {
            
            g = (Giris) em.createNamedQuery("Giris.girisKontrol").setParameter("ad", p_giris.getAd()).setParameter("sifre", p_giris.getSifre()).getSingleResult();
        } catch (NoResultException nre) {
            System.out.println(nre.getMessage());
            return result;
        }
        if (g != null) {
            result = true;
        }
        return result;
    }

}
