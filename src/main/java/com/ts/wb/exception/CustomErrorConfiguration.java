package com.ts.wb.exception;

import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.ts.wb.rest.CustomizeErrorController;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@AutoConfigureBefore({WebMvcAutoConfiguration.class})
@EnableConfigurationProperties({ResourceProperties.class})
public class CustomErrorConfiguration {
    private final ServerProperties serverProperties;
    private final List<ErrorViewResolver> errorViewResolvers;

    public CustomErrorConfiguration(ServerProperties serverProperties, ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        this.serverProperties = serverProperties;
        this.errorViewResolvers = (List)errorViewResolversProvider.getIfAvailable();
    }

    @Bean
    public CustomizeErrorController customizeErrorController(ErrorAttributes errorAttributes){
        return new CustomizeErrorController(errorAttributes, this.serverProperties.getError(),errorViewResolvers);
    }

}
