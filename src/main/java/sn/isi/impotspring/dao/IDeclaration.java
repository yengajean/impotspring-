package sn.isi.impotspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.impotspring.entities.Declaration;

@Repository
public interface IDeclaration extends JpaRepository<Declaration, Integer> {
}
