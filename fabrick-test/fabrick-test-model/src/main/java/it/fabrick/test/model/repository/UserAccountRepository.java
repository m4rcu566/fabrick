package it.fabrick.test.model.repository;

import it.fabrick.test.model.entities.HistoryTransactionEntity;
import it.fabrick.test.model.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
