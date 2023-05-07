import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonasComponent } from './personas/personas.component';

// El siguiente le agrega configuraciones extra a la clase
@NgModule({
  declarations: [
    AppComponent, // Componente por defecto
    PersonasComponent // Componente creado por nosotros
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]  // Indica como es que se levanta la aplicacion
})

export class AppModule { } // Clase que se carga en main.ts
