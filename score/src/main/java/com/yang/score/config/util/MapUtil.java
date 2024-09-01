package com.yang.score.config.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String,String> getErrorMap(String errMsg){
        return  new HashMap<String,String>(){
            {
                put("error",errMsg);
            }
        };
    }
}
