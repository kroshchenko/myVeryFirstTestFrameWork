package kroshchenko.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserListResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserResponse> data;
    private SupportResponse support;
}
