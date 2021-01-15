package com.allchars.interfaces;

public interface Messages {
    //400
    String FIELD_VALIDATION = "400.001";
    String JSON_VALIDATION = "400.002";
    String REQUIRED_PARAM = "400.003";
    String REQUIRED_REQUEST_BODY = "400.005";

    //404
    String POKEMON_TEAM_NOT_FOUND = "404.001";

    //422
    String CONTACT_SYSTEM_ADMIN = "422.001";
    String CHARACTER_ALREADY_EXISTS = "422.002";
}
