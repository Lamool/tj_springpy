package example.task1;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString @Builder
public class AccountDto {
    private int num;
    private String explanation;
    private int price;
    private String date;

}
