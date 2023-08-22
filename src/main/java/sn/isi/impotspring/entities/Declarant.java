package sn.isi.impotspring.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Declarant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String raisonSociale;
    @Column
    private String adresse;
    @Column
    private String email;
    @Column
    private String telephone;
    @OneToMany(mappedBy = "declarant", fetch= FetchType.LAZY)
    private List<Declaration> declarations = new ArrayList<>();
    public Declarant() {
        super();
    }


    public Declarant(int  id, String raisonSociale, String adresse, String email, String telephone, List<Declaration> declarations) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.declarations = declarations;
    }

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }
}
