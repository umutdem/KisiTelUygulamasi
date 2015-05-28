/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluygulamasi.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.kisiteluygulamasi.entity.Giris;
import tr.gov.ptt.kisiteluygulamasi.facade.GirisFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisService {
    
    @EJB
    private GirisFacade girisFacade;
    
    public boolean girisKontrol(Giris p_giris)
    {
        boolean result = false;
        
        result = girisFacade.girisKontrol(p_giris);
        
        return result;
    }
}
