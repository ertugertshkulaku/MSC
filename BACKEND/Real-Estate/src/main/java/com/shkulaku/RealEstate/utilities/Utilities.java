package com.shkulaku.RealEstate.utilities;

import javax.servlet.http.HttpServletRequest;

public class Utilities {
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String getToken(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("Authorization");
    }
}
