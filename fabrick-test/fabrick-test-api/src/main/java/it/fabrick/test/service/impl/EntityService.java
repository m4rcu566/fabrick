package it.fabrick.test.service.impl;

import it.fabrick.test.model.dtos.HistoryTransaction;
import it.fabrick.test.model.entities.HistoryTransactionEntity;
import it.fabrick.test.model.entities.HistoryTransactionTypeEntity;
import it.fabrick.test.model.entities.UserAccount;
import it.fabrick.test.model.repository.HistoryTransactionRepository;
import it.fabrick.test.model.repository.HistoryTransactionTypeRepository;
import it.fabrick.test.model.repository.UserAccountRepository;
import it.fabrick.test.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private HistoryTransactionRepository historyTransactionRepository;

    @Autowired
    private HistoryTransactionTypeRepository historyTransactionTypeRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Transactional
    public void saveAllHistoryTransaction(List<HistoryTransaction> historyTransactions, Long accountId){

        List<HistoryTransactionEntity> historyTransactionEntities = MapperUtils.historyDtoListToHistoryEntityList(historyTransactions, accountId);

        historyTransactionEntities.forEach(entity -> {
            if(historyTransactionRepository.findByTransactionId(entity.getTransactionId()).isEmpty()){
                Optional<HistoryTransactionTypeEntity> type = historyTransactionTypeRepository.findByValue(entity.getType().getValue());
                if(!type.isEmpty()) {
                    entity.setType(type.get());
                }

                Optional<UserAccount> user = userAccountRepository.findById(entity.getAccount().getAccountId());
                if(user.isEmpty()) {
                    historyTransactionRepository.save(entity);
                } else {
                    entity.setAccount(user.get());
                    historyTransactionRepository.save(entity);
                }
            }
        });

    }
}
