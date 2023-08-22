package sn.isi.impotspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.impotspring.entities.Paiement;

@Repository
public interface IPaiement extends JpaRepository<Paiement, Integer> {
}
