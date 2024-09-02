package example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountService accountService;

    // [C] 1. 등록
    @PostMapping("/add")    // http://localhost:8080/account/add?explanation=책&price=10000&date=2024-08-20 13:02:58
    public int listAdd(AccountDto accountDto) {
        System.out.println("accountDto = " + accountDto);
        return accountService.listAdd(accountDto);
    }

    // [R] 2. 전체 출력
    @GetMapping("/printall")
    public List<AccountDto> printAll() {
        System.out.println("AccountController.printAll");
        List<AccountDto> result = accountService.printAll();
        System.out.println("AccountController - printAll");
        System.out.println(result);
        return result;
    }

    // [U] 3. 수정
    @PutMapping("/modify")
    public boolean modify(AccountDto accountDto) {
        System.out.println("AccountController.modify");
        System.out.println("accountDto = " + accountDto);
        return accountService.modify(accountDto);
    }

    // [D] 4. 삭제
    @DeleteMapping("remove")
    public boolean remove(int num) {
        System.out.println("AccountController.remove");
        System.out.println("num = " + num);
        return accountService.remove(num);
    }

}
