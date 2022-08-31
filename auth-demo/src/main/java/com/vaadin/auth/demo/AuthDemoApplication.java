package com.vaadin.auth.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

/**
 * The entry point of the Spring Boot application.
 */
@Theme("auth-demo")
@NpmPackage(value = "line-awesome", version = "1.3.0")
@NpmPackage(value = "@vaadin-component-factory/vcf-nav", version = "1.0.6")
@SpringBootApplication
public class AuthDemoApplication extends SpringBootServletInitializer
        implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(AuthDemoApplication.class, args);
    }
}
