package api.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UpdateUserResponse {
    private String name;
    private String job;
    private Date updatedAt;
}
