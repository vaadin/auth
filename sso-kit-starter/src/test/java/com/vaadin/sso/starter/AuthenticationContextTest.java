package com.vaadin.sso.starter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.internal.CurrentInstance;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinResponse;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinServletResponse;
import com.vaadin.sso.starter.SingleSignOnConfiguration.DefaultAuthenticationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthenticationContextTest {

    @Test
    public void unauthenticatedContextReturnsEmptyOptional() {
        var authentication = mock(AnonymousAuthenticationToken.class);
        var securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        SecurityContextHolder.setContext(securityContext);
        var authContext = new DefaultAuthenticationContext();

        assertTrue(authContext.getAuthenticatedUser().isEmpty());

        SecurityContextHolder.clearContext();
    }

    @Test
    public void authenticatedContextReturnsUserPrincipal() {
        var principal = mock(OidcUser.class);
        var authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(principal);
        var securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        SecurityContextHolder.setContext(securityContext);
        var authContext = new DefaultAuthenticationContext();

        var user = authContext.getAuthenticatedUser().get();
        assertInstanceOf(OidcUser.class, user);

        SecurityContextHolder.clearContext();
    }

    @Test
    public void logoutInvokesHandlersOnCurrentUI()
            throws IOException, ServletException {
        var req = mock(VaadinServletRequest.class);
        var httpReq = mock(HttpServletRequest.class);
        when(req.getHttpServletRequest()).thenReturn(httpReq);
        CurrentInstance.set(VaadinRequest.class, req);

        var res = mock(VaadinServletResponse.class);
        var httpRes = mock(HttpServletResponse.class);
        when(res.getHttpServletResponse()).thenReturn(httpRes);
        CurrentInstance.set(VaadinResponse.class, res);

        var ui = mock(UI.class, Answers.RETURNS_DEEP_STUBS);
        doCallRealMethod().when(ui).accessSynchronously(any());
        CurrentInstance.set(UI.class, ui);

        var auth = mock(Authentication.class);
        SecurityContextHolder.setContext(new SecurityContextImpl(auth));

        var logoutSuccessHandler = spy(LogoutSuccessHandler.class);
        var logoutHandler = spy(LogoutHandler.class);
        var authContext = new DefaultAuthenticationContext();
        authContext.setLogoutHandlers(logoutSuccessHandler,
                List.of(logoutHandler));

        authContext.logout();

        verify(logoutSuccessHandler).onLogoutSuccess(httpReq, httpRes, auth);
        verify(logoutHandler).logout(httpReq, httpRes, auth);

        SecurityContextHolder.clearContext();
        CurrentInstance.clearAll();
    }
}