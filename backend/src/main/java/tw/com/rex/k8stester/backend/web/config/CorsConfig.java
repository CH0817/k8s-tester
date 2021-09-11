package tw.com.rex.k8stester.backend.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {

    private final Logger logger = LoggerFactory.getLogger(CorsConfig.class);

    @Value("${frontend.server}")
    private String frontendServerUrl;

    @Bean
    public CorsFilter corsFilter() {
        logger.info("allow origins: {}", frontendServerUrl);
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
