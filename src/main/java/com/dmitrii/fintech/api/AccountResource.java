package com.dmitrii.fintech.api;

import com.dmitrii.fintech.entity.Account;
import com.dmitrii.fintech.service.AccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    public Response create(Account account) {
        accountService.createAccount(account);
        return Response.status(Response.Status.CREATED).build();
    }
}
