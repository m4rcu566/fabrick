package it.fabrick.test.model.repository;

import it.fabrick.test.model.entities.HistoryTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryTransactionRepository extends JpaRepository<HistoryTransactionEntity, Long> {

    Optional<HistoryTransactionEntity> findByTransactionId(String transactionId);
}
