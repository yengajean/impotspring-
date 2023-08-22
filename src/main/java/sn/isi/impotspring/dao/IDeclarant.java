package sn.isi.impotspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.impotspring.entities.Declarant;

@Repository
public interface IDeclarant extends JpaRepository<Declarant, Integer> {
}
