package com.dmitrii.fintech.service;

import com.dmitrii.fintech.entity.Account;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import org.jboss.logging.Logger;

@ApplicationScoped
public class AccountService {

    private static final Logger LOG = Logger.getLogger(AccountService.class);

    @Inject
    @Channel("account-events-out")
    Emitter<String> accountEventEmitter;

    @Transactional
    public void createAccount(Account account) {
        LOG.info("Creating account: " + account);
        account.persist();
        accountEventEmitter.send("Account Created: " + account.toString());
    }

    public Account getAccount(Long id) {
        LOG.info("Fetching account with ID: " + id);
        Account account = Account.findById(id);
        LOG.info("Account found: " + account);
        return account;
    }

    @Transactional
    public void updateAccount(Long id, Account account) {
        LOG.info("Updating account with ID: " + id);
        Account entity = Account.findById(id);
        entity.name = account.getName();
        entity.balance = account.balance;
        entity.persist();
        accountEventEmitter.send("Account Updated: " + entity.toString());
    }

    @Transactional
    public void deleteAccount(Long id) {
        LOG.info("Deleting account with ID: " + id);
        Account account = Account.findById(id);
        account.delete();
        accountEventEmitter.send("Account Deleted: " + account.toString());
    }
}
