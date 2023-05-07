import { Component } from '@angular/core';

@Component({
  selector: 'app-root', // Etiqueta HTML
  templateUrl: './app.component.html', // Plantilla HTML que se va a utilizar cuado se llame al componente
  styleUrls: ['./app.component.css'] // Estilos CSS que se van a utilizar
})

export class AppComponent { // Esta clase se define como un componente, pudiendose llamarse desde HTML con {{}}
  title = "Mi primer app en Angular";
}
