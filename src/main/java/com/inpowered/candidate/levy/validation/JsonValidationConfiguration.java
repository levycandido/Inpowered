package com.inpowered.candidate.levy.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
public class JsonValidationConfiguration implements WebMvcConfigurer {

    //private final ObjectMapper objectMapper;
    //private final ResourcePatternResolver resourcePatternResolver;

//    public JsonValidationConfiguration(ObjectMapper objectMapper, ResourcePatternResolver resourcePatternResolver) {
//        this.objectMapper = objectMapper;
//        this.resourcePatternResolver = resourcePatternResolver;
//    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
      //  resolvers.add(new JsonSchemaValidatingArgumentResolver(objectMapper, resourcePatternResolver));
    }
}
