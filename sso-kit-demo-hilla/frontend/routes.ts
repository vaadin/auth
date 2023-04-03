import type { Route } from '@vaadin/router';
import './views/helloworld/hello-world-view';
import './views/main-layout';
import { AccessProps } from '@hilla/sso-kit-client/AccessProps.js';

export type ViewRoute = Route & AccessProps & {
  title?: string;
  icon?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  // place routes below (more info https://hilla.dev/docs/routing)
  {
    path: '',
    component: 'hello-world-view',
    icon: '',
    title: '',
  },
  {
    path: 'hello',
    component: 'hello-world-view',
    icon: 'globe-solid',
    title: 'Hello World',
  },
  {
    path: 'about',
    component: 'about-view',
    icon: 'file',
    title: 'About',
    requiresLogin: true,
    action: async (_context, _command) => {
      await import('./views/about/about-view');
      return;
    },
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-layout',
    children: views,
  },
];
