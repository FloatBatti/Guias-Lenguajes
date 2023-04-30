public class ConvertirDatos {

    public static void main(String[] args) {

        String numeroStr = "50";

        int numeroInt = Integer.parseInt(numeroStr);
        System.out.println("numeroInt = " + numeroInt);

        String realStr = "9894.43e-3";

        float floatNumber = 4.50f;  // Si no se pone la 'f' se toma como si fuese un double por default

        double realDouble = Double.parseDouble(realStr);

        System.out.println("realDouble = " + realDouble);

        String booleanStr = "tRuE";

        boolean realBoolean = Boolean.parseBoolean(booleanStr);

        if(realBoolean){

            System.out.println(realBoolean);
        }

        boolean instance = booleanStr instanceof String;

        System.out.println("instance = " + instance);
        
        String parseInt = Integer.toString(50);

        String sobrecargaStr = String.valueOf(90);
    }
}
