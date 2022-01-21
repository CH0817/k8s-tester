package tw.com.rex.k8stester.backend.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tw.com.rex.k8stester.backend.web.request.Name;

@FeignClient(name = "k8s-api-service")
public interface ApiService {

    @PostMapping(value = "/api/say", produces = {MediaType.APPLICATION_JSON_VALUE})
    String sayHello(@RequestBody Name name);

}
