import { RouterLocation } from '@vaadin/router';
import { makeAutoObservable } from 'mobx';
import singleSignOnContext from "@hilla/sso-kit-client/SingleSignOnContext.js";

export class AppStore {
  applicationName = 'sso-kit-demo-hilla-lit';

  // The location, relative to the base path, e.g. "hello" when viewing "/hello"
  location = '';

  currentViewTitle = '';

  ssoContext = singleSignOnContext();

  isLoggedOut = false;

  constructor() {
    makeAutoObservable(this);
    this.ssoContext.onBackChannelLogout(() => {
      this.isLoggedOut = true;
    });
  }

  setLocation(location: RouterLocation) {
    const serverSideRoute = location.route?.path == '(.*)';
    if (location.route && !serverSideRoute) {
      this.location = location.route.path;
    } else if (location.pathname.startsWith(location.baseUrl)) {
      this.location = location.pathname.substr(location.baseUrl.length);
    } else {
      this.location = location.pathname;
    }
    if (serverSideRoute) {
      this.currentViewTitle = document.title; // Title set by server
    } else {
      this.currentViewTitle = (location?.route as any)?.title || '';
    }
  }
}

export const appStore = new AppStore();
