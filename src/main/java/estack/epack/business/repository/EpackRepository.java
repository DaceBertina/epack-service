package estack.epack.business.repository;

import estack.epack.business.repository.model.EpackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpackRepository extends JpaRepository<EpackEntity, Long> {

}
