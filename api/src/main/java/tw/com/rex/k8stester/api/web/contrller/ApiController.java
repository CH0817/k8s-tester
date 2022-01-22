package tw.com.rex.k8stester.api.web.contrller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.rex.k8stester.api.web.request.Name;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping(value = "/say", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> sayHello(@RequestBody Name name) {
        log.info("name: {}", name.getName());
        return ResponseEntity.ok("Hello " + name.getName());
    }

}
