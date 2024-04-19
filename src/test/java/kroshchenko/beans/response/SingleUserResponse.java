package kroshchenko.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SingleUserResponse {
    private UserResponse data;
    private SupportResponse support;
}
