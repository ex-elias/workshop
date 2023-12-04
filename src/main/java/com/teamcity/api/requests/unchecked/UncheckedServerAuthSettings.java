package com.teamcity.api.requests.unchecked;

import com.teamcity.api.requests.CrudInterface;
import com.teamcity.api.requests.Request;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UncheckedServerAuthSettings extends Request implements CrudInterface {

    private static final String SERVER_AUTH_SETTINGS_ENDPOINT = "/app/rest/server/authSettings";

    public UncheckedServerAuthSettings(RequestSpecification spec) {
        super(spec);
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Response read(String id) {
        return RestAssured.given()
                .spec(spec)
                .get(SERVER_AUTH_SETTINGS_ENDPOINT);
    }

    @Override
    public Response update(String id, Object obj) {
        return RestAssured.given()
                .spec(spec)
                .body(obj)
                .put(SERVER_AUTH_SETTINGS_ENDPOINT);
    }

    @Override
    public Object delete(String id) {
        return null;
    }

}
