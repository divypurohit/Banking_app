    package com.example.Banking_App.controller;
    import com.example.Banking_App.dto.AccountDto;
    import com.example.Banking_App.service.AccountService;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;

    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;

    @RestController
    @RequestMapping("/api/account")
    public class AccountController {

        public AccountService accountService;

        public AccountController(AccountService accountService){
            this.accountService = accountService;
        }

        @PostMapping
        // Add account Rest API
        public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
            return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
        }

        // Get account Rest API
        @GetMapping("/{id}")
        public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
            AccountDto accountDto = accountService.getAccountById(id);
            return ResponseEntity.ok(accountDto);
        }

        //Deposite REST API
        @PutMapping("/{id}/deposite")
        public ResponseEntity<AccountDto> deposite(@PathVariable Long id ,
                                                   @RequestBody Map<String , Double> request){
            Double ammount =  request.get("ammount");
            AccountDto accountDto = accountService.deopsite(id , ammount);
            return ResponseEntity.ok(accountDto);
        }

        // WithDraw REST API
        @PutMapping("/{id}/withdraw")
        public ResponseEntity<AccountDto> withdraw(@PathVariable Long id ,
                                                   @RequestBody Map<String , Double> request){
            Double ammount =  request.get("ammount");
            AccountDto accountDto = accountService.withdraw(id , ammount);
            return ResponseEntity.ok(accountDto);
        }

        @GetMapping
        public ResponseEntity<List<AccountDto>> getAllAccount(){
            List<AccountDto> accounts = accountService.getAllAccount();
            return ResponseEntity.ok(accounts);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteAccount(@PathVariable Long id){
            accountService.deleteAccount(id);
            return ResponseEntity.ok("Account deleted sucessfully !");
        }
    }
