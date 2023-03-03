/*-
 * Copyright (C) 2022 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package dev.hilla.sso.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.client.ClientsConfiguredCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

/**
 * This configuration class provides default instances for the required beans.
 *
 * @author Vaadin Ltd
 * @since 1.0
 */
@AutoConfiguration
@Conditional(ClientsConfiguredCondition.class)
@ConditionalOnProperty(name = "auto-configure", prefix = SingleSignOnProperties.PREFIX, matchIfMissing = true)
@ComponentScan
public class SingleSignOnDefaultBeans {

    /**
     * Provides a default {@link SessionRegistry} bean.
     *
     * @return the session registry bean
     */
    @Bean
    @ConditionalOnMissingBean
    SessionRegistry getSessionRegistry() {
        return new SessionRegistryImpl();
    }
}
