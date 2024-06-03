package api.restAssuredTest;

import api.beans.request.LoginRegisterUserRequest;
import api.beans.request.UserRequest;
import api.beans.response.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static api.restAssuredTest.Specifications.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleRestAssuredTest {

    private final static String BASE_URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        installSpecifications(requestSpec(BASE_URL), responseSpecOk200());

        List<UserResponse> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserResponse.class);

        users.forEach(user -> {
                    assertTrue(user.getAvatar().contains(String.valueOf(user.getId())));
                    assertTrue(user.getEmail().endsWith("@reqres.in"));
                }
        );
    }

    @Test
    public void successRegisterTest() {
        installSpecifications(requestSpec(BASE_URL), responseSpecOk200());

        LoginRegisterUserRequest requestBean = new LoginRegisterUserRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse expectedResponse = new RegisterResponse(4, "QpwL5tke4Pnpja7X4");

        RegisterResponse response = given()
                .body(requestBean)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().body().as(RegisterResponse.class);

        Assert.assertEquals(response.getToken(), expectedResponse.getToken());
        Assert.assertEquals(response.getId(), expectedResponse.getId());
    }

    @Test
    public void failedRegisterTest() {
        installSpecifications(requestSpec(BASE_URL), responseSpecError400());

        LoginRegisterUserRequest requestBean = new LoginRegisterUserRequest();
        requestBean.setEmail("sydney@fife");

        String expectedError = "Missing password";

        ResponseError response = given()
                .body(requestBean)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().body().as(ResponseError.class);

        Assert.assertEquals(response.getError(), expectedError);
    }

    @Test
    public void checkResourcesOrder() {
        installSpecifications(requestSpec(BASE_URL), responseSpecOk200());

        List<ResourceResponse> resources = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ResourceResponse.class);

        List<Integer> resourcesYear = resources.stream().map(ResourceResponse::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = new ArrayList<>(resourcesYear);
        Collections.sort(sortedYears);

        assertEquals(sortedYears, resourcesYear);
    }

    @Test
    public void deleteUserTest() {
        installSpecifications(requestSpec(BASE_URL), responseSpecCustomCode(204));

        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void updateUserInfoTest() {
        installSpecifications(requestSpec(BASE_URL), responseSpecOk200());

        UserRequest userRequest = new UserRequest("morpheus", "zion resident");

        UpdateUserResponse response = given()
                .body(userRequest)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().body().as(UpdateUserResponse.class);

        String currTime = Clock.systemUTC().instant().toString().replaceAll(".{5}$", "");

        Assert.assertEquals(response.getName(), userRequest.getName());
        Assert.assertEquals(response.getJob(), userRequest.getJob());

        String responseTime = response.getUpdatedAt().replaceAll(".{5}$", "");

        assertEquals(currTime, responseTime);
    }
}
