package retrofit;

import retrofit.beans.response.UserListResponse;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ApiServices apiServices = new ApiServices();
        UserListResponse response = apiServices.getUserService()
                .getUserList(2)
                .execute()
                .body();
    }
}