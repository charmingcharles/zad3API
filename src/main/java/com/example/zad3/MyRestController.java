package com.example.zad3;

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

    @RequestMapping(value = "/apiresult") //example: http://localhost:8090/apiresult?text=Karol
    public String apiresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        final String uri = "http://localhost:8080/jsonitself?text=" + text;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }

}
