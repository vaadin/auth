/*-
 * Copyright (C) 2022 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
import type { SingleSignOnData } from "./SingleSignOnData.js";

export * from "./SingleSignOnContext.js";
export * from "./EndpointImportError.js";
export type * from "./AccessProps.js";
export type * from "./User.js";

declare global {
  interface Window {
    Vaadin: {
      SingleSignOnData?: SingleSignOnData;
      registrations?: {
        is: string;
        version: string;
      }[];
    };
  }
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.registrations = window.Vaadin.registrations || [];
window.Vaadin.registrations.push({
  is: "@hilla/sso-kit-client",
  version: "2.1.0",
});
