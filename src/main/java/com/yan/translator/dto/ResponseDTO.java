package com.yan.translator.dto;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class ResponseDTO {

    @Override
    public String toString() {
        JsonElement jsonElement = new Gson().toJsonTree(this);

        return jsonElement.toString();
    }
}
