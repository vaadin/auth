import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../../views/view';
import { appStore } from "Frontend/stores/app-store.js";

@customElement('about-view')
export class AboutView extends View {
  render() {
    return html`<div>
      <img style="width: 200px;" src="images/empty-plant.png" />
      <h2 class="mt-xl mb-m">This place intentionally left empty</h2>
      <p>It’s a place where you can grow your own UI 🤗</p>

      <p>Username: ${appStore.ssoContext.user?.preferredUsername}</p>
      <p>Full name: ${appStore.ssoContext.user?.fullName}</p>
      <p>Email: ${appStore.ssoContext.user?.email}</p>
    </div>`;
  }

  connectedCallback() {
    super.connectedCallback();
    this.classList.add(
      'flex',
      'flex-col',
      'h-full',
      'items-center',
      'justify-center',
      'p-l',
      'text-center',
      'box-border'
    );
  }
}
