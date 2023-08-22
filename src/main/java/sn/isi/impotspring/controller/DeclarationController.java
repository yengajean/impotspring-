
package sn.isi.impotspring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.impotspring.dao.IDeclarant;
import sn.isi.impotspring.dao.IDeclaration;
import sn.isi.impotspring.entities.Declarant;
import sn.isi.impotspring.entities.Declaration;

import java.util.Date;
import java.util.List;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclaration declarationdao;

    @Autowired
    private IDeclarant declarantdao;

    @RequestMapping(value="/Declaration/liste")
    public String liste(ModelMap model) {
        List<Declaration> declarations = declarationdao.findAll();
        List<Declarant> declarants = declarantdao.findAll();
        model.put("liste_declarations", declarations);
        model.put("liste_declarants", declarants);
        model.put("declaration", new Declaration());
        return "declaration/liste";
    }

    @RequestMapping(value="/Declaration/add", method = RequestMethod.POST)
    public String add(int  id, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeclaration, String montantDeclaration, int  idDeclarant) {
        ModelAndView modelAndView= new ModelAndView();
        Declaration declaration = new Declaration();
        declaration.setId(id);
        declaration.setDateDeclaration(dateDeclaration);
        declaration.setMontantDeclaration(Double.parseDouble(montantDeclaration));
        Declarant declarant = new Declarant();
        declarant  = declarantdao.getOne(idDeclarant);
        declaration.setDeclarant(declarant);

        try {
            declarationdao.save(declaration);
            declarationdao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/Declaration/liste";
    }

    @RequestMapping(value="/Declaration/delete", method = RequestMethod.GET)
    public String delete(int id) {
        try {
            declarationdao.delete(declarationdao.getOne(id));
            declarationdao.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/Declaration/liste";
    }


    @RequestMapping(value="/Declaration/edit", method = RequestMethod.GET)
    public String edit(int id, ModelMap model) {
        List<Declaration> declarations = declarationdao.findAll();
        List<Declarant> declarants = declarantdao.findAll();
        model.put("liste_declarations",declarations);
        model.put("liste_declarants",declarants);
        Declaration declaration = declarationdao.getOne(id);
        model.put("declaration", declaration);
        return "declaration/liste";
    }
}
