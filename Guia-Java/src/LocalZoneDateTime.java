import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalZoneDateTime { // Local se refiere a la fecha y hora local. No se refiere a la zona horaria.

    public static void main(String[] args) {

        // now() devuelve la fecha y hora actual.
        LocalDate fechaLocal = LocalDate.now();

        System.out.println("La fecha y hora actual es: " + fechaLocal);

        fechaLocal = fechaLocal.plusDays(5);  // Se le suma 5 días a la fecha actual.

        System.out.println("La fecha y hora actual más 5 días es: " + fechaLocal);

        fechaLocal = fechaLocal.minusDays(2);  // Se le resta 2 días a la fecha actual.

        fechaLocal = fechaLocal.plusMonths(3);  // Se le suma 3 meses a la fecha actual.

        fechaLocal = fechaLocal.minusMonths(1);  // Se le resta 1 mes a la fecha actual.

        fechaLocal = fechaLocal.plusYears(2);  // Se le suma 2 años a la fecha actual.

        fechaLocal = fechaLocal.minusYears(1);  // Se le resta 1 año a la fecha actual.

        System.out.println("La fecha y hora actual quedaria: " + fechaLocal);

        System.out.println("------------------------");

        // Con LocalDate.of() se crea una fecha sin hora.

        fechaLocal = LocalDate.of(1997, 12, 18);

        System.out.println("La fecha y hora creada es: " + fechaLocal);

        System.out.println("------------------------");

        // Con LocalDate.parse() se crea una fecha sin hora a partir de un String.
        fechaLocal = LocalDate.parse("2000-08-20");

        System.out.println("La fecha y hora creada es: " + fechaLocal);

        System.out.println("------------------------");

        // minus() permite restar días, meses o años a una fecha.
        // ChronoUnit es un enumerado que permite indicar el tipo de unidad de tiempo a restar.

        LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        System.out.println("El mes anterior en el dia actual: " + mesAnteriorMismoDia);

        System.out.println("------------------------");

        // getDayOfWeek() devuelve el día de la semana de una fecha.
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();

        System.out.println("El dia de la semana actual es: " + diaSemana);

        Month mesActual = LocalDate.now().getMonth();

        System.out.println("El mes actual es: " + mesActual);

        System.out.println("------------------------");

        // getDayOfMonth() devuelve el día del mes de una fecha.
        // getDayOfYear() devuelve el día del año de una fecha.
        // getDayOfWeek() devuelve el día de la semana de una fecha.

        int mes = LocalDate.now().getDayOfMonth();

        System.out.println("El dia del mes actual es: " + mes);

        int year = LocalDate.now().getDayOfYear();

        System.out.println("El dia del año actual es: " + year);

        int dia = LocalDate.now().getDayOfWeek().getValue();

        System.out.println("El dia de la semana actual es: " + dia);

        System.out.println("------------------------");

        // isLeapYear() devuelve true si el año de la fecha es bisiesto.
        boolean esBisiesto = LocalDate.now().isLeapYear();

        System.out.println("El año actual es bisiesto: " + esBisiesto);

        System.out.println("------------------------");

        boolean esAnterior = LocalDate.now().isBefore(LocalDate.of(2022, 12, 24));

        System.out.println("La fecha actual es anterior a 2022-12-24: " + esAnterior);

        boolean esPosterior = LocalDate.now().isAfter(LocalDate.of(2022, 12, 24));

        boolean esIgual = LocalDate.now().isEqual(LocalDate.of(2022, 12, 24));

        System.out.println("------------------------");

        System.out.println("El mes actual es: " + LocalDate.now().getMonth());

        System.out.println("El año actual es: " + LocalDate.now().getYear());

        System.out.println("La era actual es: " + LocalDate.now().getEra());

        System.out.println("------------------------");

        LocalTime horaActual = LocalTime.now();

        System.out.println("La hora actual es: " + horaActual);

        System.out.println("------------------------");

        System.out.println("Solo la hora actual es: " + LocalTime.now().getHour());
        System.out.println("Solo los minutos actuales son: " + LocalTime.now().getMinute());
        System.out.println("Solo los segundos actuales son: " + LocalTime.now().getSecond());
        System.out.println("Solo los nanosegundos actuales son: " + LocalTime.now().getNano());

        System.out.println("------------------------");

        LocalTime horaSet = LocalTime.of(12, 30);

        System.out.println("La hora seteada es: " + horaSet);

        System.out.println("------------------------");

        // El método parse arroja una excepción si el String no tiene el formato correcto.
        LocalTime horaString = LocalTime.parse("23:30:45");

        System.out.println("La hora creada es: " + horaString);

        System.out.println("------------------------");

        System.out.println("La hora creada mas 2 horas es: " + horaString.plusHours(2));

        System.out.println("------------------------");

        boolean esAnteriorHora = LocalTime.now().isBefore(LocalTime.of(12, 30));

        System.out.println("La hora actual es anterior a 12:30: " + esAnteriorHora);

        boolean esPosteriorHora = LocalTime.now().isAfter(LocalTime.of(12, 30));

        System.out.println("------------------------");

        // La letra 'a' indica si es AM o PM.
        // Si se quiere mostrar la hora en formato de 24 horas se debe usar la letra 'H'.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm:ss a");

        String horaFormateada = LocalTime.now().format(formato);

        System.out.println("La hora actual formateada es: " + horaFormateada);

        System.out.println("------------------------");

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("La fecha y hora actual es: " + fechaHoraActual);

        System.out.println("------------------------");

        // Con LocalDateTime.of() se crea una fecha con hora a partir de parámetros.
        fechaHoraActual = LocalDateTime.of(2021, 12, 24, 12, 30, 45);

        System.out.println("La fecha y hora creada es: " + fechaHoraActual);

        System.out.println("------------------------");

        // Con LocalDateTime.parse() se crea una fecha con hora a partir de un String con formato estándar. T es tiempo.
        fechaHoraActual = LocalDateTime.parse("2021-12-24T12:30:45");

        System.out.println("La fecha y hora creada es: " + fechaHoraActual);

        System.out.println("------------------------");

        // Con los métodos plus() se puede sumar días, meses, años, horas, minutos o segundos a una fecha. Devuelve una
        // instancia de LocalDateTime distinta.
        // Los métodos minus() hacen lo mismo pero restan.

        LocalDateTime fechaTiempo = fechaHoraActual.plusDays(2).plusHours(3).plusMinutes(30).plusYears(4).minusMonths(2);

        System.out.println("La fecha y hora modificada es: " + fechaTiempo);

        System.out.println("------------------------");

        // Con el método format() se puede formatear una fecha con hora. Retorna un String.
        // ISO_DATE es un formato estándar de fecha.
        String formatoFecha = fechaTiempo.format(DateTimeFormatter.ISO_DATE);

        System.out.println("La fecha formateada es: " + formatoFecha);

        System.out.println("------------------------");

        // Con ofPattern() se puede crear un formato personalizado.
        String formatoFecha2 = fechaTiempo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("La fecha formateada es: " + formatoFecha2);

        System.out.println("------------------------");

        // Otra forma de crear un formato personalizado.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

        fechaTiempo.format(dtf);

        System.out.println("La fecha formateada es: " + fechaTiempo.format(dtf));

        // Se puede guardar el String formateado en una variable.
        String fechaTiempoFormateada = dtf.format(fechaTiempo);

        System.out.println("------------------------");

        // ZonedDateTime y ZoneId

        LocalDateTime fechaTiempo2 = LocalDateTime.now();

        // ZoneId es una clase que representa una zona horaria.
        // Con of() se crea una zona horaria a partir de un String con el nombre de la zona horaria.
        ZoneId newYork = ZoneId.of("America/New_York");

        // ZonedDateTime es una clase que representa una fecha con hora y zona horaria.
        // Con of() se crea una fecha con hora y zona horaria a partir de parámetros. El primer parámetro es una fecha
        // con hora y el segundo es una zona horaria.
        ZonedDateTime zonaNewYork= ZonedDateTime.of(fechaTiempo2, newYork);

        System.out.println("Zona horaria New York : " + zonaNewYork);

        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

        // withZoneSameInstant() devuelve una nueva instancia de ZonedDateTime con la zona horaria indicada pero
        // conservando la fecha y hora instantánea. La hora instantánea es la hora UTC, es decir, la hora real en esa
        // zona horaria.
        // withZoneSameLocal() devuelve una nueva instancia de ZonedDateTime con la zona horaria indicada pero
        // conservando la fecha y hora local.
        ZonedDateTime zonaTokyo = zonaNewYork.withZoneSameInstant(tokyo);

        System.out.println("Zona horaria Tokyo con UTC: " + zonaTokyo);

        System.out.println("------------------------");

        LocalDateTime salida = LocalDateTime.of(2023, 12, 18, 12, 30);

        ZoneId buenosAires = ZoneId.of("America/Argentina/Buenos_Aires");
        ZoneId madrid = ZoneId.of("Europe/Madrid");

        ZonedDateTime zonaBuenosAires = ZonedDateTime.of(salida, buenosAires);

        // Primero se pasa a la zona horaria de Madrid y luego se le suma 12 horas.
        ZonedDateTime zonaMadrid = zonaBuenosAires.withZoneSameInstant(madrid).plusHours(12);

        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

        System.out.println("Hora de salida en Buenos Aires: " + formatoFechaHora.format(zonaBuenosAires));
        System.out.println("Hora de llegada en Madrid: " + formatoFechaHora.format(zonaMadrid));

        System.out.println("------------------------");

        // Duration y Period

        LocalDateTime fechaNacimiento = LocalDateTime.of(1997, 12, 18, 20, 0);
        LocalDateTime fechaActual = LocalDateTime.now();

        // Duration es una clase que representa un intervalo de tiempo en segundos y nanosegundos.
        // between() devuelve una instancia de Duration con la diferencia entre dos fechas con hora.
        // El formato que muestra es: PTnHnMnS. PT significa periodo de tiempo, H significa horas, M significa minutos
        // y S significa segundos.
        Duration duracion = Duration.between(fechaNacimiento, fechaActual);

        System.out.println("La duración entre la fecha de nacimiento y la actual es: " + duracion);

        // toDays() devuelve la cantidad de días que hay en el intervalo de tiempo.
        // toHours() devuelve la cantidad de horas que hay en el intervalo de tiempo.
        System.out.println("Los dias que han pasado son: " + duracion.toDays());
        System.out.println("Las horas que han pasado son: " + duracion.toHours());

        System.out.println("------------------------");

        LocalDate fecha1 = LocalDate.of(2021, 12, 25);
        LocalDate fecha2 = LocalDate.of(2023, 4, 15);

        // withMonth() devuelve una nueva instancia de LocalDate con el mes indicado.
        // Hay métodos similares para cambiar el día, el año, etc.
        LocalDate fecha3 = fecha2.withMonth(12);

        // Period es una clase que representa un intervalo de tiempo en años, meses y días. No contiene tiempo.
        // between() devuelve una instancia de Period con la diferencia entre dos fechas sin hora.
        // El formato que muestra es: PnYnMnD. P significa periodo, Y significa años, M significa meses y D significa
        Period periodo = Period.between(fecha1, fecha2);

        System.out.println("El periodo entre las fechas es: " + periodo);

        // getYears() devuelve la cantidad de años que hay en el intervalo de tiempo.
        // getMonths() devuelve la cantidad de meses que hay en el intervalo de tiempo.
        System.out.println("Los años que han pasado son: " + periodo.getYears());
        System.out.println("Los meses que han pasado son: " + periodo.getMonths());

    }
}
