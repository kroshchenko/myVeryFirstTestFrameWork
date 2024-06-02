package api.retrofitTest.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenResponse {

    private String token;

    @Override
    public String toString() {
        return "TokenPOJO{" +
                "token='" + token + '\'' +
                '}';
    }
}
