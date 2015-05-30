
package tr.gov.ptt.kisiteluygulamasi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.kisiteluygulamasi.util.JSFUtil;



@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel model;
    
    

   public MenuBean() {
       model = new DefaultMenuModel();
       //First submenu
       DefaultSubMenu firstSubmenu = new DefaultSubMenu("Kişi İşlemleri");
       DefaultMenuItem item = new DefaultMenuItem("Kişi Ekle");
       item.setUrl("kisiEkle.xhtml?faces-redirect=true");
       //item.setIcon("ui-icon-home");
       firstSubmenu.addElement(item);
       
       item = new DefaultMenuItem("Kişi Listele");
       item.setUrl("kisiListele.xhtml?faces-redirect=true");
       //item.setIcon("ui-icon-home");
       firstSubmenu.addElement(item);
       
       model.addElement(firstSubmenu);

       //Second submenu
       DefaultSubMenu secondSubmenu = new DefaultSubMenu("Giriş-Çıkış İşlemleri");
       item = new DefaultMenuItem("Giriş");
       //item.setIcon("ui-icon-disk");
       item.setUrl("giris.xhtml?faces-redirect=true");
       //item.setUpdate("messages");
       secondSubmenu.addElement(item);
       item = new DefaultMenuItem("Çıkış");
       //item.setIcon("ui-icon-search");
       item.setCommand("#{girisBean.sessionBitir}");
       secondSubmenu.addElement(item);
       model.addElement(secondSubmenu);
   }

   public MenuModel getModel() {
       return model;
   }
   
   
    
    
    
    
}
