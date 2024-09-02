package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MyController {
    @Autowired private MyService myService;

    // [C] 1. 등록 http://localhost:8080/mybatis/save?name=손흥민&age=31
    @PostMapping("/save")
    public int save(UserDto userDto) {
        return myService.save(userDto);
    }

    // [R] 2. 전체 출력
    @GetMapping("/findall")
    public List<UserDto> findAll() {
        return myService.findAll();
    }

   // [R] 2-2. 개별 출력
    @GetMapping("/find")
    public UserDto findById(int id) {
        return myService.findById(id);
    }

    // [U] 3. 수정
    @PutMapping("/update")
    public int update(UserDto userDto) {
        return myService.update(userDto);
    }

    // [D] 4. 삭제
    @DeleteMapping("/delete")
    public int delete(int id) {
        return myService.delete(id);
    }

}
