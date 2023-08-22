package sn.isi.impotspring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sn.isi.impotspring.dao.IDeclarant;
import sn.isi.impotspring.entities.Declarant;

import java.util.List;

@Controller
public class DeclarantController {

    @Autowired
    private IDeclarant declarantdao;

    @RequestMapping(value="/Declarant/liste")
    public String liste(ModelMap model) {
        List<Declarant> declarants = declarantdao.findAll();
        model.put("liste_declarants", declarants);
        model.put("declarant", new Declarant());

        return "declarant/liste";
    }

    @RequestMapping(value="/Declarant/add", method = RequestMethod.POST)
    public String add(int id, String raisonSociale, String adresse, String email, String telephone) {
        Declarant declarant = new Declarant();
        declarant.setId(id);
        declarant.setRaisonSociale(raisonSociale);
        declarant.setAdresse(adresse);
        declarant.setEmail(email);
        declarant.setTelephone(telephone);

        try {
            declarantdao.save(declarant);
            declarantdao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/Declarant/liste";
    }

    @RequestMapping(value="/Declarant/delete", method = RequestMethod.GET)
    public String delete(int id) {
        try {
            declarantdao.delete(declarantdao.getOne(id));
            declarantdao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/Declarant/liste";
    }

    @RequestMapping(value="/Declarant/edit", method = RequestMethod.GET)
    public String edit(int id, ModelMap model) {
        List<Declarant> declarants = declarantdao.findAll();
        model.put("liste_declarants", declarants);
        Declarant declarant = declarantdao.getOne(id);
        model.put("declarant", declarant);
        return "declarant/liste";
    }
}
