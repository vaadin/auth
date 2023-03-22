/*-
 * Copyright (C) 2022 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.sso.core;

/**
 * Definition of configuration properties for the SSO Kit starter.
 *
 * @author Vaadin Ltd
 * @since 1.0
 */
public abstract class AbstractSingleSignOnProperties {

    /**
     * The default login route. Unauthorized requests will be redirected to this
     * route. If there are no views mapped to this route, Spring's default login
     * page will be generated.
     */
    public static final String DEFAULT_LOGIN_ROUTE = "/login";

    /**
     * The default logout-redirect route. Web browsers will be redirected to
     * this route after the logout process has completed.
     */
    public static final String DEFAULT_LOGOUT_REDIRECT_ROUTE = "{baseUrl}";

    /**
     * The default Back-Channel Logout route. This should be the same as in the
     * OIDC provider's configuration to be able to accept logout notices as
     * described by the specification. It requires a URI variable to match the
     * client registration-id: {@code registrationId}.
     *
     * @see https://openid.net/specs/openid-connect-backchannel-1_0.html
     */
    public static final String DEFAULT_BACKCHANNEL_LOGOUT_ROUTE = "/logout/back-channel/{"
            + BackChannelLogoutFilter.REGISTRATION_ID_URI_VARIABLE_NAME + "}";

    /**
     * The default maximum number of concurrent sessions allowed per user: -1
     * means any number of concurrent sessions is allowed.
     */
    static final int DEFAULT_MAXIMUM_SESSIONS_PER_USER = -1;

    /**
     * The route to redirect unauthorized requests to.
     */
    private String loginRoute = DEFAULT_LOGIN_ROUTE;

    /**
     * The route to redirect to after successful logout.
     */
    private String logoutRedirectRoute = DEFAULT_LOGOUT_REDIRECT_ROUTE;

    /**
     * If set to {@code true} it enables support for Back-Channel logout.
     */
    private boolean backChannelLogout = false;

    /**
     * The route to match Back-Channel logout requests against. The default
     * value is {@code /logout/back-channel/{registration-id}}.
     */
    private String backChannelLogoutRoute = DEFAULT_BACKCHANNEL_LOGOUT_ROUTE;

    /**
     * The number of maximum concurrent sessions allowed per user. The default
     * value is -1 which means any number of concurrent sessions is allowed.
     */
    private int maximumConcurrentSessions = DEFAULT_MAXIMUM_SESSIONS_PER_USER;

    /**
     * Checks is auto-configuration of SingleSignOnConfiguration is enabled.
     *
     * @return always true, see deprecation tag
     * @deprecated to disable auto-configuration, use the
     *             {@code spring.autoconfigure.exclude} property
     * @see https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration.disabling-specific
     */
    @Deprecated(since = "2.1.0", forRemoval = true)
    public boolean isAutoConfigure() {
        return true;
    }

    /**
     * Enables or disables auto-configuration of SingleSignOnConfiguration.
     *
     * @param autoConfigure
     *            has no effect, see deprecation tag
     * @deprecated to disable auto-configuration, use the
     *             {@code spring.autoconfigure.exclude} property
     * @see https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration.disabling-specific
     */
    @Deprecated(since = "2.1.0", forRemoval = true)
    public void setAutoConfigure(boolean autoConfigure) {
        // Deprecated
    }

    /**
     * Gets the login-route property.
     *
     * @return the login-route property
     */
    public String getLoginRoute() {
        return loginRoute;
    }

    /**
     * Sets the login-route property.
     *
     * @param loginRoute
     *            the login-route property
     */
    public void setLoginRoute(String loginRoute) {
        this.loginRoute = loginRoute;
    }

    /**
     * Gets the logout-redirect route.
     *
     * @return the logout-redirect route
     */
    public String getLogoutRedirectRoute() {
        return logoutRedirectRoute;
    }

    /**
     * Sets the logout-redirect route.
     *
     * @param logoutRedirectRoute
     *            the logout-redirect route
     */
    public void setLogoutRedirectRoute(String logoutRedirectRoute) {
        this.logoutRedirectRoute = logoutRedirectRoute;
    }

    /**
     * Checks weather Back-Channel logout is enabled.
     *
     * @return {@code true} if Back-Channel logout is enabled, {@code false}
     *         otherwise
     */
    public boolean isBackChannelLogout() {
        return backChannelLogout;
    }

    /**
     * Sets is Back-Channel logout is enabled.
     *
     * @param backChannelLogout
     *            weather to enable or disable Back-Channel logout
     */
    public void setBackChannelLogout(boolean backChannelLogout) {
        this.backChannelLogout = backChannelLogout;
    }

    /**
     * Gets the Back-Channel Logout route.
     *
     * @return the Back-Channel Logout route
     */
    public String getBackChannelLogoutRoute() {
        return backChannelLogoutRoute;
    }

    /**
     * Sets the Back-Channel Logout route.
     *
     * @param backChannelLogoutRoute
     *            the Back-Channel Logout route
     */
    public void setBackChannelLogoutRoute(String backChannelLogoutRoute) {
        this.backChannelLogoutRoute = backChannelLogoutRoute;
    }

    /**
     * Gets the maximum number of concurrent sessions per user.
     *
     * @return the maximum number of concurrent sessions
     */
    public int getMaximumConcurrentSessions() {
        return maximumConcurrentSessions;
    }

    /**
     * Sets maximum number of concurrent sessions per user.
     *
     * @param maximumConcurrentSessions
     *            maximum number of concurrent sessions
     */
    public void setMaximumConcurrentSessions(int maximumConcurrentSessions) {
        this.maximumConcurrentSessions = maximumConcurrentSessions;
    }
}
