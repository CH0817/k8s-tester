package tw.com.rex.k8stester.frontend.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${backend.server}")
    private String backendServiceUrl;

    @RequestMapping("/k8s")
    public HttpEntity<String> sayHelloFromK8sService() {
        System.out.println("backend server URL: " + backendServiceUrl);
        return new RestTemplate().getForEntity(backendServiceUrl + "/backend/test/hello/rex", String.class);
    }

}
