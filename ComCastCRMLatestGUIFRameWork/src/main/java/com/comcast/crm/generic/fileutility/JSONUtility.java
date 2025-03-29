package com.comcast.crm.generic.fileutility;


import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONUtility {
	public String getDataFromJSON(String key) throws IOException, ParseException {
		FileReader reader = new FileReader(IPathConstatnt.JSON_path);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject json = (JSONObject)obj;
		String value =(String) json.get(key);
		return value;
	}

}
