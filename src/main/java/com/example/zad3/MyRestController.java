package com.example.zad3;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {

    static private final String URL = "http://localhost:8080/count?text=";

    private static String getFromURL(String text){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL + text, String.class);
    }

    @RequestMapping(value = "/itself") //example: http://localhost:8090/itself?text=Karol
    public String itself(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return text;
    } //can be used for testing connection

    @RequestMapping(value = "/jsonresult") //example: http://localhost:8090/jsonresult?text=Karol
    public String jsonresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return getFromURL(text);
    }

    @RequestMapping(value = "/xmlresult", produces=MediaType.APPLICATION_XML_VALUE) //example: http://localhost:8090/xmlresult?text=Karol
    public String xmlresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return ResultConverter.jsonToXML(getFromURL(text));
    }

    @RequestMapping(value = "/textresult") //example: http://localhost:8090/textresult?text=Karol
    public String textresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return ResultConverter.jsonToText(getFromURL(text));
    }

    @RequestMapping(value = "/csvresult") //example: http://localhost:8090/csvresult?text=Karol
    public String csvresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return ResultConverter.jsonToCSV(getFromURL(text));
    }

}
