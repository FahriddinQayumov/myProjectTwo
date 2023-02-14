package com.example.backendcar;

import com.example.backendcar.exceptions.BadRequest;

public class Tools {
    private Tools(){};
    public static void checkString(String field , String error){
        field=field.trim();
        if(field.isEmpty()){
            throw new BadRequest(String.format("invalid %s",error));
        }
    }
}
