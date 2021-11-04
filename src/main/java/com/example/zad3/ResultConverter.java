package com.example.zad3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class ResultConverter {

    public static String jsonToXML(String input){
        Map<String, Object> map = new Gson()
                .fromJson(input, new TypeToken<HashMap<String, Object>>() {
                }.getType());
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("map", java.util.Map.class);
        return xStream.toXML(map);
    }

    public static String jsonToText(String input){
        Map<String, Object> map = new Gson()
                .fromJson(input, new TypeToken<HashMap<String, Object>>() {
                }.getType());
        StringBuilder output = new StringBuilder();
        for (var entry : map.entrySet()) {
            output.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return output.toString();
    }

}
