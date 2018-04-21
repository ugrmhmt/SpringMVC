package com.springmvc.helper;

import java.util.List;

import org.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


public final class JsonHelper {
	public static String Json(String key, String val) {
		return "{"+key+":\""+val+"\"}";
	}
	
	public static String JsonList(List<String> val) {
		String d="";
		int index=0;
		for (String s : val){
			d=d+Json((index++)+"",s);
		}
		return d;
	}
	
	public static JSONObject resultJson(BindingResult result) {
		JSONObject obj = new JSONObject();
		List<FieldError> errors = result.getFieldErrors();
		int i=0;
        for (FieldError e : errors){
            obj.put((i++)+"", e.getDefaultMessage());
        }
        return obj;
	}
}
