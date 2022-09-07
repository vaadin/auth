package com.vaadin.auth.starter;

import java.util.Optional;

/**
 * An interface to access the authentication context of the application.
 * <p>
 * An instance of this interface is available for injection as bean in view and
 * layout classes.
 *
 * @author Vaadin Ltd
 * @since 1.0
 */
public interface VaadinAuthContext {

    /**
     * Gets an {@link Optional} with an instance of the current user if it has
     * been authenticated by a OpenID Connect provider, or empty if the user is
     * not authenticated or has been authenticated by other means.
     *
     * @return an {@link Optional} with the current OIDC authenticated user, or
     *         empty if none available
     */
    Optional<VaadinUser> getAuthenticatedUser();

    /**
     * Initiates the logout process of the current OIDC authenticated user by
     * invalidating the local session and then notifying the OIDC provider of
     * the logout.
     */
    void logout();
}
