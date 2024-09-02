package example.mybatis;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString@Builder
public class UserDto {
    private int id;
    private String name;
    private int age;
}
