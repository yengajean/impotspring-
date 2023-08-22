package sn.isi.impotspring.entities;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Declaration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeclaration;
    @Column
    private double montantDeclaration;
    @OneToMany(mappedBy = "declaration", fetch= FetchType.LAZY)
    private List<Paiement> paiements = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "declarant_id")
    private Declarant declarant= new  Declarant();

    public Declaration() {
        super();
    }

    public Declaration(int id, Date dateDeclaration, double montantDeclaration) {
        this.id = id;
        this.dateDeclaration = dateDeclaration;
        this.montantDeclaration = montantDeclaration;
    }

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public double getMontantDeclaration() {
        return montantDeclaration;
    }

    public void setMontantDeclaration(double montantDeclaration) {
        this.montantDeclaration = montantDeclaration;
    }

    public Declarant getDeclarant() {
        return declarant;
    }

    public void setDeclarant(Declarant declarant) {
        this.declarant = declarant;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}
