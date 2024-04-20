package retrofitTest.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SupportResponse {
    private String url;
    private String text;
}