package api.retrofitTest.services;

import api.beans.response.SingleUserResponse;
import api.beans.request.UserRequest;
import api.beans.response.CreateUserResponse;
import api.beans.response.UpdateUserResponse;
import api.beans.response.UserListResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @GET("api/users")
    Call<UserListResponse> getUserList(@Query("page") int page);

    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id);

    @POST("/api/users")
    Call<CreateUserResponse> addUser(@Body UserRequest request);

    @PUT("/api/users/{id}")
    Call<UpdateUserResponse> updateUserById(@Path("id") int id,
                                            @Body UserRequest request);

    @DELETE("/api/users/{id}")
    Call<Void> deleteUserById(@Path("id") int id);
}
