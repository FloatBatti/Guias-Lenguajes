public class Ejercicios {

    public static void main(String[] args) {

        // INVERTIR UN STRING

        String name = "Agustin";
        char[] array = name.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = name.length()-1; i >= 0 ; i--) {
            builder.append(array[i]);
        }

        String revers = String.valueOf(builder);
        System.out.println("revers = " + revers);

        // CONTAR LAS VECES QUE SE REPITE UNA LETRA

        String text = "sdghpajkdgasjdgasodhjfdfhdlkpfjlkha";

        char[] array2 = text.toCharArray();
        int cont = 0;

        for (char word:array2) {

            if (word == 'p'){

                cont++;
            }
        }

        System.out.println("La letra a se repite la siguiente cantidad de veces: " + cont);

        // DISTANCIA DE HUMMING, CONTAR LA CANTIDAD DE DIFERENCIAS ENTRE DOS STRINGS DE IGUAL LONGITUD

        String text2 = "abcde";
        String text3 = "agcey";

        char[] array3 = text2.toCharArray();
        char[] array4 = text3.toCharArray();

        int distancia = 0;

        for (int i = 0; i < text2.length(); i++) {

            if (array3[i] != array4[i]){

                distancia++;
            }
        }

        System.out.println("La distancia entre los dos Strings es de: " + distancia);

        // Traducir a lenguaje robot

        String path = "^^vv>><<^v>";

        System.out.println(walk(path));

    }

    private static String walk (String path){

        String up = "up";
        String down = "down";
        String right = "right";
        String left = "left";

        StringBuilder builder = new StringBuilder();

        char[] array = path.toCharArray();

        for (int i = 0; i < path.length(); i++) {

            int cont = 0;

            for (int j = i; j == i ; j++) {

                if (array[i] == array[j]){
                    cont++;
                }
            }

            String step = (cont == 1) ? "step" : "steps";

            switch1:
            switch (array[i]) {
                case '^' -> builder.append("Take ").append(cont).append(" ").append(step).append(" ").append(up).append("\n");
                case 'v' -> builder.append("Take ").append(cont).append(" ").append(step).append(" ").append(down).append("\n");
                case '>' -> builder.append("Take ").append(cont).append(" ").append(step).append(" ").append(right).append("\n");
                case '<' -> builder.append("Take ").append(cont).append(" ").append(step).append(" ").append(left).append("\n");
            }
        }

        return String.valueOf(builder);
    }
}
