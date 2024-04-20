package retrofit.tests;

import retrofit.ApiServices;
import retrofit.beans.request.UserRequest;
import retrofit.beans.response.CreateUserResponse;
import retrofit.beans.response.SingleUserResponse;
import retrofit.beans.response.UpdateUserResponse;
import retrofit.beans.response.UserListResponse;
import retrofit.services.UserService;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTests {

    UserService service = new ApiServices().getUserService();

    @Test
    public void userListTest() throws IOException {
        int page = 2;

        Response<UserListResponse> response = service.getUserList(page).execute();
        assertTrue(response.isSuccessful());

        UserListResponse userListResponse = response.body();
        assertEquals("Запрашиваемая страница", userListResponse.getPage(), page);
        assertTrue("Наличие users", !userListResponse.getData().isEmpty());
    }

    @Test
    public void getUserById() throws IOException {
        int userId = 2;

        Response<SingleUserResponse> response = service.getUserById(userId).execute();
        assertTrue(response.isSuccessful());

        SingleUserResponse singleUserResponse = response.body();
        assertEquals("Проверка userId", userId, singleUserResponse.getData().getId());
    }

    @Test
    public void createUser() throws IOException {

        String name = "Igor";
        String job = "QA";
        UserRequest userRequest = new UserRequest(name, job);

        Response<CreateUserResponse> response = service.addUser(userRequest).execute();
        assertTrue(response.isSuccessful());

        CreateUserResponse createUserResponse = response.body();
        assertEquals(201, response.code());
        assertEquals("Name", name, createUserResponse.getName());
        assertEquals("Job", job, createUserResponse.getJob());
    }

    @Test
    public void updateUser() throws IOException {

        int userId = 2;
        String name = "Igor";
        String job = "QA";
        UserRequest userRequest = new UserRequest(name, job);

        Response<UpdateUserResponse> response = service.updateUserById(userId, userRequest).execute();
        assertTrue(response.isSuccessful());

        UpdateUserResponse updateUserResponse = response.body();
        assertEquals(200, response.code());
        assertEquals("Name", name, updateUserResponse.getName());
        assertEquals("Job", job, updateUserResponse.getJob());
    }

    @Test
    public void deleteUser() throws IOException {

        int userId = 4;

        Response<Void> response = service.deleteUserById(userId).execute();
        assertTrue(response.isSuccessful());
        assertEquals(204, response.code());
    }
}