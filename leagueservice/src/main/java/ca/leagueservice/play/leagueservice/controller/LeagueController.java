package ca.leagueservice.play.leagueservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/leagues")
public class LeagueController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${league.api.url}")
    private String leagueAPIEndpoint;

    @GetMapping("/{id}")
    public HttpEntity<String> processRequest(@PathVariable Long id){

        HttpEntity<String> response = restTemplate.exchange(leagueAPIEndpoint + "?league="+id+"&season="+2019, HttpMethod.GET, null, String.class);

        return response;

    }

}
