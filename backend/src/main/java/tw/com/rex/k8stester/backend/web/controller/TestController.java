package tw.com.rex.k8stester.backend.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.rex.k8stester.backend.service.ApiService;
import tw.com.rex.k8stester.backend.web.request.Name;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final ApiService apiService;

    public TestController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/hello/{username}")
    public HttpEntity<String> hello(@PathVariable("username") String username) {
        logger.info("username: {}", username);
        return ResponseEntity.ok(apiService.sayHello(new Name(username)));
    }

}
