import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor() {
    this.addSideBarFunctions();
  }

  addSideBarFunctions() {
    document.addEventListener("DOMContentLoaded", () => {
      const closeMenuButton: HTMLButtonElement | null = document.getElementById("closeMenuButton") as HTMLButtonElement | null;
      const mobileMenu: HTMLElement | null = document.getElementById("mobileMenu");
      const openMenuButton: HTMLButtonElement | null =  document.getElementById("openMenuButton") as HTMLButtonElement | null;

      if (closeMenuButton && mobileMenu && openMenuButton) {
        closeMenuButton.addEventListener("click", () => {
          mobileMenu.classList.add("hidden");
        });

        openMenuButton.addEventListener("click", () => {
          mobileMenu.classList.remove("hidden");
        });
      }
    });
  }
}
