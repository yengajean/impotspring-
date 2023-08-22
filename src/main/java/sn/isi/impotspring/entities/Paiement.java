package sn.isi.impotspring.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Paiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePaiement;
    @Column
    private double montantPaiement;
    @ManyToOne
    @JoinColumn(name = "declaration_id")
    private Declaration declaration= new Declaration();
    public Paiement() {
        super();
    }

    public Paiement(int id, Date datePaiement, double montantPaiement, Declaration declaration) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montantPaiement = montantPaiement;
        this.declaration = declaration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(double montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
}
