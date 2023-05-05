import java.util.Properties;

public class Sistema {

    public static void main(String[] args) {

        // System no se puede heredar ni instanciar
        String username = System.getProperty("user.name");  // Devuelve el nombre de usuario del sistema operativo
        System.out.println("username = " + username);

        String home = System.getProperty("user.home");  // Devuelve la ruta del usuario del sistema operativo
        System.out.println("home = " + home);

        String dir = System.getProperty("user.dir");  // Muestra la ruta del documento donde se está ejecutando
        System.out.println("dir = " + dir);

        Properties p = System.getProperties();
        //p.list(System.out);  // Recibe como parámetro un imprimible y lista todas las propiedades
    }
}
