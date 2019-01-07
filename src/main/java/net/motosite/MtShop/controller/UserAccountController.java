package net.motosite.MtShop.controller;

import net.motosite.MtShop.entity.UserAccount;
import net.motosite.MtShop.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAccountController {
    private final UserAccountRepository repository;

    public UserAccountController(UserAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<UserAccount> all(){
        return repository.findAll();
    }

}
