package example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired private AccountDao accountDao;

    // [C] 1. 등록
    public int listAdd(AccountDto accountDto) {
        return accountDao.listAdd(accountDto);
    }

    // [R] 2. 전체 출력
    public List<AccountDto> printAll() {
        System.out.println("AccountService.printAll");
        List<AccountDto> result = accountDao.printAll();
        System.out.println("AccountController - printAll");
        System.out.println(result);
        return result;
    }

    // [U] 3. 수정
    public boolean modify(AccountDto accountDto) {
        System.out.println("AccountService.modify");
        System.out.println("accountDto = " + accountDto);
        return accountDao.modify(accountDto);
    }

    // [D] 4. 삭제
    public boolean remove(int num) {
        System.out.println("AccountController.remove");
        System.out.println("num = " + num);
        return accountDao.remove(num);
    }

}
