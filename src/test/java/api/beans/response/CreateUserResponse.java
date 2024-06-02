package api.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserResponse {
    private String name;
    private String job;
    private String id;
    private Date createdAt;
}
