package kroshchenko.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}