package tw.com.rex.k8stester.backend.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.rex.k8stester.backend.service.ApiService;
import tw.com.rex.k8stester.backend.web.request.Name;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private ApiService apiService;

    @GetMapping("/hello/{username}")
    public HttpEntity<String> hello(@PathVariable("username") String username, HttpServletRequest request,
                                    HttpServletResponse response) {
        logger.info("username: {}", username);
        showCookies(request);
        response.addCookie(getTestCookie());
        return ResponseEntity.ok(apiService.sayHello(new Name(username)));
    }

    private void showCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            logger.info("backend have cookies:");
            Arrays.stream(cookies)
                  .map(c -> c.getName() + "=" + c.getValue())
                  .forEach(c -> logger.info("cookie: {}", c));
        }
    }

    private Cookie getTestCookie() {
        Cookie cookie = new Cookie("backend", "backend");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }

}
