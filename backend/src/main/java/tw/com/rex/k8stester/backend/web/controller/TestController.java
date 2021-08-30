package tw.com.rex.k8stester.backend.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello/{name}")
    public HttpEntity<String> hello(@PathVariable("name") String name) {
        return ResponseEntity.ok("hello~ " + name);
    }

}
