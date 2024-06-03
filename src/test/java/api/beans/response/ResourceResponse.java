package api.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;

}
