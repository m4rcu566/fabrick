package it.fabrick.test.model.repository;

import it.fabrick.test.model.entities.HistoryTransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoryTransactionTypeRepository extends JpaRepository<HistoryTransactionTypeEntity, Long> {

    Optional<HistoryTransactionTypeEntity> findByValue(String value);
}
