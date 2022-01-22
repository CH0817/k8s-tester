package tw.com.rex.k8stester.backend.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Configuration
public class CorsConfig {

    @Value("${frontend.server}")
    private String frontendServerUrl;

    @Bean
    public CorsFilter corsFilter() {
        log.info("allow origins: {}", frontendServerUrl);
        CorsConfiguration config = new CorsConfiguration();
        // 允許跨域請求的 client url
        config.setAllowedOrigins(Collections.singletonList(frontendServerUrl));
        // 允許跨域請求的 method
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        // 允許跨域請求的 header
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 是否允許請求帶有驗證訊息
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }

}
