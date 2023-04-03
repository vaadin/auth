# SSO Kit Demo Hilla

[Getting Started](https://hilla.dev/docs/lit/acceleration-kits/sso-kit/getting-started/#frontend) with the SSO Kit Hilla documentation.

## Project structure

<table style="width:100%; text-align: left;">
  <tr><th>Directory</th><th>Description</th></tr>
  <tr><td><code>frontend/</code></td><td>Client-side source directory</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.html</code></td><td>HTML template</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.ts</code></td><td>Frontend entrypoint, contains the client-side routing setup using <a href="https://hilla.dev/docs/routing/router">Hilla Router</a></td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>main-layout.ts</code></td><td>Main layout Web Component, contains the navigation menu, uses <a href="https://vaadin.com/docs/latest/ds/components/app-layout">App Layout</a></td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>views/</code></td><td>UI views Web Components (TypeScript)</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>themes/</code></td><td>Custom  
CSS styles</td></tr>
  <tr><td><code>src/main/java/&lt;groupId&gt;/</code></td><td>Server-side 
source directory, contains the server-side Java views</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>Application.java</code></td><td>Server entry-point</td></tr>
</table>

## Development

### Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

### Install npm packages

```sh
npm install
```
