package com.guiahibernate;

import com.guiahibernate.DTO.ClienteDTO;
import com.guiahibernate.entity.Cliente;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;


public class HibernateQueryLanguage {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("=========== CONSULTAR TODOS ===========");
        entityManager.createQuery("select c from Cliente c", Cliente.class).
                getResultList().forEach(System.out::println);

        System.out.println("=========== CONSULTAR POR ID ===========");
        System.out.println(entityManager.find(Cliente.class, 1));

        System.out.println("=========== CONSULTAR POR NOMBRE ===========");
        entityManager.createQuery("select c from Cliente c where c.nombre = :nombre ", Cliente.class).
                setParameter("nombre", "Pedro").getResultList().forEach(System.out::println);

        System.out.println("=========== CONSULTAR SOLO LOS NOMBRES ===========");
        entityManager.createQuery("select c.nombre from Cliente c", String.class).
                getResultList().forEach(System.out::println);

        System.out.println("=========== CONSULTAR POR NOMBRE Y APELLIDO ===========");
        Cliente cliente = entityManager.createQuery("select c from Cliente c where c.nombre = :nombre and " +
                        "c.apellido = :apellido", Cliente.class).
                setParameter("nombre", "Pedro").setParameter("apellido", "Gonzalez").
                getSingleResult();

        System.out.println(cliente);

        System.out.println("=========== CONSULTAR CAMPOS PERSONALIZADOS ===========");
        // Ya que no se pide un Objeto ni un atributo en particular, se debe usar Object[].
        Object[] cliente2 = (Object[]) entityManager.createQuery("select c.nombre, c.apellido from Cliente c where " +
                        "c.id= :id", Object[].class).setParameter("id", 1).getSingleResult();

        System.out.println("Nombre: " + cliente2[0] + " - Apellido: " + cliente2[1]);

        System.out.println("=========== CONSULTAR LISTA DE CAMPOS PERSONALIZADOS ===========");
        List<Object[]> registros = entityManager.createQuery("select c.id, c.nombre, c.apellido from Cliente c",
                        Object[].class).getResultList();

        registros.forEach(reg -> System.out.println("Id: " + reg[0] + " - Nombre: " + reg[1] + " - Apellido: " + reg[2]));

        System.out.println("=========== CONSULTAR POR CLIENTE Y FORMA DE PAGO ===========");
        registros = entityManager.createQuery("select c, c.formaPago from Cliente c",
                Object[].class).getResultList();

        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            System.out.println("Cliente: " + c + " - Forma de pago: " + reg[1]);
        });

        System.out.println("=========== CONSULTA QUE DEVUELVE INSTANCIAS PERSONALIZADAS DE CLIENTE ===========");

        // Como ClienteDTO no es una entidad, se debe escribir toda la ruta del paquete.
        List<ClienteDTO> clientes = entityManager.createQuery("select new com.guiahibernate.DTO.ClienteDTO" +
                "(c.nombre, c.apellido) from Cliente c", ClienteDTO.class).getResultList();

        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTA CON NOMBRES UNICOS ===========");

        List<String> nombres = entityManager.createQuery("select distinct c.nombre from Cliente c", String.class).
                getResultList();

        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CANTIDAD DE FORMAS DE PAGO UNICOS ===========");

        long cantidad = entityManager.createQuery("select count(distinct c.formaPago) from Cliente c", Long.class).
                getSingleResult();

        System.out.println("Cantidad de formas de pago: " + cantidad);

        System.out.println("=========== CONSULTA CON NOMBRE Y APELLIDO CONCATENADOS ===========");

        List<String> nombreApellido = entityManager.createQuery("select concat(c.nombre, ' ', c.apellido) from Cliente c",
                String.class).getResultList();

        nombreApellido.forEach(System.out::println);

        System.out.println("=========== CONSULTA CON NOMBRE Y APELLIDO CONCATENADOS EN MAYÚSCULAS ===========");

        // El character || concatena los campos.
        nombreApellido = entityManager.createQuery("select upper(c.nombre || ' ' || c.apellido) from Cliente c",
                String.class).getResultList();

        nombreApellido.forEach(System.out::println);

        System.out.println("=========== CONSULTA PARA BUSCAR POR ACERCAMIENTO DE NOMBRE ===========");

        // El character % es un comodín que permite buscar por acercamiento.
        nombreApellido = entityManager.createQuery("select c.nombre from Cliente c where c.nombre like 'J%'",
                String.class).getResultList();

        nombreApellido.forEach(System.out::println);

        System.out.println("=========== CONSULTA POR RANGOS DE ID ===========");

        List<Cliente> clientesRango = entityManager.createQuery("select c from Cliente c where c.id between 2 and 4",
                Cliente.class).getResultList();

        clientesRango.forEach(System.out::println);

        System.out.println("=========== CONSULTA POR ORDEN ASCENDENTE ===========");

        List<Cliente> clientesAsc = entityManager.createQuery("select c from Cliente c order by c.nombre asc",
                Cliente.class).getResultList();

        clientesAsc.forEach(System.out::println);

        System.out.println("=========== CONSULTAR TOTAL DE REGISTROS ===========");

        long total = entityManager.createQuery("select count(c) as total from Cliente c", Long.class).getSingleResult();

        System.out.println("Total de registros: " + total);

        System.out.println("=========== CONSULTAR EL MÍNIMO ID USADO ===========");

        int minId = entityManager.createQuery("select min(c.id) as minId from Cliente c", Integer.class).
                getSingleResult();

        System.out.println("Mínimo id: " + minId);

        System.out.println("=========== CONSULTAR EL MÁXIMO ID USADO ===========");

        int maxId = entityManager.createQuery("select max(c.id) as maxId from Cliente c", Integer.class).
                getSingleResult();

        System.out.println("Máximo id: " + maxId);

        System.out.println("=========== CONSULTAR EL PROMEDIO DE LOS IDs ===========");

        double promedioId = entityManager.createQuery("select avg(c.id) as promedioId from Cliente c", Double.class).
                getSingleResult();

        System.out.println("Promedio id: " + promedioId);

        System.out.println("=========== CONSULTAR LA SUMA DE LOS IDs ===========");

        long sumaId = entityManager.createQuery("select sum(c.id) as sumaId from Cliente c", Long.class).
                getSingleResult();

        System.out.println("Suma id: " + sumaId);

        System.out.println("=========== CONSULTAR POR NOMBRE Y SU LARGO ===========");

        List<Object[]> nombreLargo = entityManager.createQuery("select c.nombre, length(c.nombre) as largo from Cliente c",
                Object[].class).getResultList();

        nombreLargo.forEach(reg -> System.out.println("Nombre: " + reg[0] + " - Largo: " + reg[1]));

        System.out.println("=========== CONSULTAR EL NOMBRE MÁS CORTO ===========");

        List<String> nombreCorto = entityManager.createQuery("select  c.nombre from Cliente c where" +
                        " length(c.nombre) = (select min(length(c.nombre)) from Cliente c)", String.class)
                .setMaxResults(1).getResultList();

        System.out.println("Nombre más corto: " + nombreCorto);

        System.out.println("=========== CONSULTA PARA OBTENER EL ULTIMO REGISTRO ===========");

        Cliente clienteUltimo = entityManager.createQuery("select c from Cliente c order by c.id desc", Cliente.class).
                setMaxResults(1).getSingleResult();

        System.out.println("Último registro: " + clienteUltimo);

        System.out.println("=========== CONSULTA WHERE IN ===========");

        List<Cliente> clientesIn = entityManager.createQuery("select c from Cliente c where c.id in (1, 3, 6)",
                Cliente.class).getResultList();

        clientesIn.forEach(System.out::println);

        entityManager.close();


    }



}
