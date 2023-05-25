/*-
 * Copyright (C) 2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
/**
 * Type definition for the view routes that can be used to indicate that
 * authentication is needed to access that route.
 */
export type AccessProps = Readonly<{
  requireAuthentication?: boolean;
}>;
