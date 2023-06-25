package org.kmjs.springcloudserviceconsumer.service.impl;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;
import org.kmjs.springcloudserviceconsumer.feigns.ConsumerFeign;
import org.kmjs.springcloudserviceconsumer.result.Result;
import org.kmjs.springcloudserviceconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
//    private RestTemplate restTemplate;
    private ConsumerFeign consumerFeign;

//    @Override
//    public DomainUser getUserFromProvider(int id) {
//        ResultDomainUser result = null;
//        try {
//            result = restTemplate.getForObject("http://SERVICE-PROVIDER/user/" + id, ResultDomainUser.class);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//        if (result.getResultCode() == 200) {
//            return (DomainUser) result.getData();
//        } else {
//            return null;
//        }
//    }
//    @Override
//    public DomainUser getUserFromProvider(int id) {
//        ParameterizedTypeReference<Result<DomainUser>> resposeTrpe = new ParameterizedTypeReference<>(){};
//        ResponseEntity<Result<DomainUser>> resp = restTemplate.exchange(
//                "http://SERVICE-PROVIDER/user/" + id, HttpMethod.GET, null, resposeTrpe);
//        Result<DomainUser> result = resp.getBody();
//        if (result.getResultCode() == 200) {
//            return (DomainUser) result.getData();
//        } else {
//            return null;
//        }
//    }
    @Override
    public DomainUser getUserFromProvider(int id) {
        Result<DomainUser> result = consumerFeign.getUser(id);
        if (result.getResultCode() == 200) {
            return (DomainUser) result.getData();
        } else {
            return null;
        }
    }

    @Override
    public int saveUserToProvider(DomainUser user) {
        Result<String> result = consumerFeign.addUser(user);
        if (result.getResultCode() == 200) {
            return 1;
        } else {
            return 0;
        }
    }
}
