package com.example.zad3;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {

    @RequestMapping(value = "/itself") //example: http://localhost:8090/itself?text=Karol
    public String itself(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return text;
    } //can be used for testing connection

    @RequestMapping(value = "/apiresult", produces=MediaType.APPLICATION_XML_VALUE) //example: http://localhost:8090/apiresult?text=Karol
    public String apiresult(@RequestParam(value = "text", defaultValue = "Karol") String text, @RequestParam(value = "text", defaultValue = "Karol") String format) {
        final String uri = "http://localhost:8080/count?text=" + text;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);



        return ResultConverter.jsonToXML(result);
    } //temporary function for local testing

}
