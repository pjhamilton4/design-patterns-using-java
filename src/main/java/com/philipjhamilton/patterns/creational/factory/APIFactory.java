package com.philipjhamilton.patterns.creational.factory;

public class APIFactory {

    public static API getApiInstance(String version){
        if("v1".equalsIgnoreCase(version)) {
            return new ApiV1();
        }else if ("v2".equalsIgnoreCase(version)){
            return new ApiV2();
        }else
            throw new IllegalArgumentException("Passed API version does not exist.");
    }
}
