package sn.isi.impotspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.impotspring.dao.IDeclaration;
import sn.isi.impotspring.dao.IPaiement;
import sn.isi.impotspring.entities.Declaration;
import sn.isi.impotspring.entities.Paiement;

import java.util.Date;
import java.util.List;

@Controller
public class PaiementController {

    @Autowired
    private IPaiement paiementDao;

    @Autowired
    private IDeclaration declarationDao;

    @RequestMapping(value="/Paiement/liste")
    public String liste(ModelMap model){
        List<Paiement> paiements = paiementDao.findAll();
        List<Declaration> declarations = declarationDao.findAll();
        model.put("liste_paiements",paiements);
        model.put("liste_declarations",declarations);
        model.put("paiement", new Paiement());
        return "paiement/liste";
    }

    @RequestMapping(value= "/Paiement/add", method = RequestMethod.POST)
    public String add(int id, @DateTimeFormat(pattern = "yyyy-MM-dd") Date datePaiement, String montantPaiement, int idDeclaration) {
        ModelAndView modelAndView= new ModelAndView();
        Paiement paiement = new Paiement();
        paiement.setId(id);
        paiement.setDatePaiement(datePaiement);
        paiement.setMontantPaiement(Double.parseDouble(montantPaiement));
        Declaration declaration =new Declaration();
        declaration = declarationDao.getOne(idDeclaration);
        paiement.setDeclaration(declaration);

        try {
            paiementDao.save(paiement);
            paiementDao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/Paiement/liste";
    }

    @RequestMapping(value="/Paiement/delete", method = RequestMethod.GET)
    public String delete(int id) {
        try {
            paiementDao.delete(paiementDao.getOne(id));
            paiementDao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/Paiement/liste";
    }

    @RequestMapping(value="/Paiement/edit",method = RequestMethod.GET)
    public String edit(int id, ModelMap model) {
        List<Paiement> paiements = paiementDao.findAll();
        List<Declaration> declarations = declarationDao.findAll();
        model.put("liste_paiements", paiements);
        model.put("liste_declarations", declarations);
        Paiement paiement = paiementDao.getOne(id);
        model.put("paiement", paiement);

        return "paiement/liste";
    }
}

