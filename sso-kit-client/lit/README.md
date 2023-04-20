# @hilla/sso-kit-client-lit

The **SSO Kit Client Lit** is the client side library for the **[SSO Kit for Hilla](https://github.com/vaadin/sso-kit/tree/main/sso-kit-starter-hilla)** and depends on it.

Getting Started with the **SSO Kit for Hilla** using Lit [documentation](https://hilla.dev/docs/lit/acceleration-kits/sso-kit/getting-started/#frontend).

## Installation

Install the library for Hilla using Lit:

```sh
npm i @hilla/sso-kit-client-lit@2.1.0
```

Once installed, you can import the `SingleSignOnContext` class in your application:

```js
import singleSignOnContext from "@hilla/sso-kit-client-lit/SingleSignOnContext.js";
```

## Development

For the available scripts check the [package.json](./package.json) file.

Install npm packages:

```sh
npm install
```

Build the library:

```sh
npm run build
```

Pack the library locally:

```sh
npm pack
```

Publish the library to your registry:

```sh
npm publish --registry <your-registry>
```
