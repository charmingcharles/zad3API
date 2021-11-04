package com.example.zad3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.enterprise.inject.Produces;

@RestController
public class MyRestController {

    @RequestMapping(value = "/itself") //example: http://localhost:8090/itself?text=Karol
    public String itself(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        return text;
    } //can be used for testing connection

    @RequestMapping(value = "/apiresult", produces=MediaType.APPLICATION_XML_VALUE) //example: http://localhost:8090/apiresult?text=Karol
    public String apiresult(@RequestParam(value = "text", defaultValue = "Karol") String text) {
        final String uri = "http://localhost:8080/jsonitself?text=" + text;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        XStream xStream = new XStream(new DomDriver());
        xStream.alias("map", java.util.Map.class);
        String xml = xStream.toXML(result);
        System.out.println(xml);
        return xml;
    } //temporary function for local testing

}
