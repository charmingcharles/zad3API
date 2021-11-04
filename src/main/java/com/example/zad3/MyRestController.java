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

    @RequestMapping(value = "/xmlresult", produces=MediaType.APPLICATION_XML_VALUE) //example: http://localhost:8090/xmlresult?text=Karo
    public String xmlresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        final String uri = "http://localhost:8080/count?text=" + text;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return ResultConverter.jsonToXML(result);
    }

    @RequestMapping(value = "/textresult") //example: http://localhost:8090/textresult?text=Karo
    public String textresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        final String uri = "http://localhost:8080/count?text=" + text;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return ResultConverter.jsonToText(result);
    }

}
