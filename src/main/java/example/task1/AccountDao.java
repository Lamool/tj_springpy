package example.task1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {
    // [1] 추상메소드
    // [C] 1. 등록
    int listAdd(AccountDto accountDto);

    // [R] 2. 전체 출력
    List<AccountDto> printAll();

    // [U] 3. 수정
    boolean modify(AccountDto accountDto);

    // [D] 4. 삭제
    boolean remove(int id);

}
