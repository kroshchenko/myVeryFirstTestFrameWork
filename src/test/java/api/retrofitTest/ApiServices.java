package api.retrofitTest;

import lombok.Getter;
import api.retrofitTest.services.UserService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServices {
    private static final String BASE_URL = "https://reqres.in/";

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Getter
    private final UserService userService = retrofit.create(UserService.class);
}
