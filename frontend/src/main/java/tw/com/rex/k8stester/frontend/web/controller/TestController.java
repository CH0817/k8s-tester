package tw.com.rex.k8stester.frontend.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${backend.server}")
    private String backendServiceUrl;

    @RequestMapping("/k8s/{username}")
    public HttpEntity<String> sayHelloFromK8sService(@PathVariable("username") String username,
                                                     HttpServletRequest request,
                                                     HttpServletResponse response) {
        logger.info("backend server URL: {}", backendServiceUrl);
        logger.info("username: {}", username);
        showCookies(request);
        response.addCookie(getTestCookie());
        return new RestTemplate().getForEntity(backendServiceUrl + "/test/hello/" + username, String.class);
    }

    private void showCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            logger.info("frontend have cookies:");
            Arrays.stream(cookies)
                  .map(c -> c.getName() + "=" + c.getValue())
                  .forEach(c -> logger.info("cookie: {}", c));
        }
    }

    private Cookie getTestCookie() {
        Cookie cookie = new Cookie("frontend", "frontend");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }

}
