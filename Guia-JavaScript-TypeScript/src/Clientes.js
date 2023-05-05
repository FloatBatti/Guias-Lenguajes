// Con export se pueden exportar variables, funciones, clases, etc. para que puedan ser utilizadas en otros archivos.

export const clientes = [
    {
      id: 1,
      nombre: "Juan",
      edad: 20,
  
      items: [
        { producto: "Teclado", precio: 1000, cantidad: 1, },
        { producto: "Mouse", precio: 500, cantidad: 1, },
        { producto: "Monitor", precio: 10000, cantidad: 2, },
      ]
    },
    {
      id: 2,
      nombre: "Pablo",
      edad: 30,
  
      items: [
        { producto: "Gabinete", precio: 5000, cantidad: 1, },
        { producto: "Fuente", precio: 3000, cantidad: 1, },
        { producto: "Placa de video", precio: 15000, cantidad: 1, },
        { producto: "Mouse", precio: 500, cantidad: 1, },
      ]
    },
    {
      id: 3,
      nombre: "Germán",
      edad: 40,
  
      items: [
        { producto: "Procesador", precio: 20000, cantidad: 1, },
        { producto: "Ram x 2", precio: 6000, cantidad: 1, },
        { producto: "Coolers x4", precio: 10000, cantidad: 1, },
      ]
    }
  ];

  // Con export default se exporta por defecto la variable, función, clase, etc. que se está exportando.
  export default (clientes) =>{

    return clientes.map((cliente) => {
        return "Hola soy " + cliente.nombre;
    });
  }
