package api.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {

    private String token;

    @Override
    public String toString() {
        return "TokenPOJO{" +
                "token='" + token + '\'' +
                '}';
    }
}
