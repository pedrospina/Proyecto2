package Proyecto2.view;

import java.util.List;
import java.util.Scanner;

import Proyecto2.controller.Proyecto2.SistemaEmergencias;
import Proyecto2.model.Emergencia;
import Proyecto2.model.factory.FactoryEmergencias;
import Proyecto2.model.services.Ambulancia;
import Proyecto2.model.services.Bomberos;
import Proyecto2.model.services.Policia;
import Proyecto2.utils.NivelGravedad;
import Proyecto2.utils.TipoEmergencia;

public class Main {

     static final String BLUE = "\u001B[34m";    // Color rojo
     static final String YELLOW = "\u001B[33m";  // Color verde
     static final String RESET = "\u001B[0m";   // Reset de color

    public static void main(String[] args) {

        SistemaEmergencias sistema = SistemaEmergencias.getInstancia();

        inicializarRecursosDemo(sistema);

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            String title = "SISTEMA DE EMERGENCIAS";
        
      // Imprimir el logo de "Sistemas de Emergencias" usando caracteres especiales
       // Imprimir cada línea del logo por separado 
       System.out.printf("%s==============================================================%s%n", BLUE, RESET);
       System.out.printf("%s=      _____ _        _   _             _                    =%s%n", YELLOW, RESET);
       System.out.printf("%s=     / ____| |      | | (_)           | |                   =%s%n", YELLOW, RESET);
       System.out.printf("%s=    | (___ | |_ __ _| |_ _  ___  _ __| |_ ___ _ __ ___      =%s%n", YELLOW, RESET);
       System.out.printf("%s=    \\___ \\| __/ _` | __| |/ _ \\| '__| __/ _ \\ '__/ _ \\      =%s%n", YELLOW, RESET);
       System.out.printf("%s=     ____) | || (_| | |_| | (_) | |  | ||  __/ | |  __/     =%s%n", YELLOW, RESET);
       System.out.printf("%s=    |_____/ \\__\\__,_|\\__|_|\\___/|_|   \\__\\___|_|  \\___|     =%s%n", YELLOW, RESET);
       System.out.printf("%s=                                                            =%s%n", YELLOW, RESET);
       System.out.printf("%s==============================================================%s%n", BLUE, RESET);
       System.out.printf("%s                   SISTEMA DE EMERGENCIAS      %s%n", YELLOW, RESET);
       System.out.printf("%s==============================================================%s%n", BLUE, RESET);

            
      System.out.println("1. Registrar una nueva emergencia");
      System.out.println("2. Ver estado de recursos disponibles");
      System.out.println("3. Atender una emergencia");
      System.out.println("4. Mostrar estadísticas del día");
      System.out.println("5. Finalizar jornada (cerrar sistema)");
      System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarEmergenciaMenu(sistema, sc);
                    break;
                case 2:
                    sistema.mostrarEstadoRecursos();
                    break;
                case 3:
                    atenderEmergenciaMenu(sistema, sc);
                    break;
                case 4:
                    sistema.mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Finalizando jornada...");
                    sistema.finalizarJornada();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }

    private static void inicializarRecursosDemo(SistemaEmergencias sistema) {
        sistema.registrarRecurso(new Bomberos("Camión-B1", 5, 100));
        sistema.registrarRecurso(new Bomberos("Furgoneta-B2", 3, 80));
        sistema.registrarRecurso(new Ambulancia("AMB_Basica-A1", 2, 100));
        sistema.registrarRecurso(new Ambulancia("AMB_Medicalizada-A2", 2, 60));
        sistema.registrarRecurso(new Policia("Patrulla-P1", 4, 100));
        sistema.registrarRecurso(new Policia("Patrulla-P2", 2, 70));
    }

    private static void registrarEmergenciaMenu(SistemaEmergencias sistema, Scanner sc) {
        System.out.println("\n=== REGISTRAR NUEVA EMERGENCIA ===");
        System.out.println("1. Incendio");
        System.out.println("2. Accidente Vehicular");
        System.out.println("3. Robo");
        System.out.print("Seleccione el tipo: ");
        TipoEmergencia tipo = null;
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                tipo = TipoEmergencia.INCENDIO;
                break;
            case 2:
                tipo = TipoEmergencia.ACCIDENTE_VEHICULAR;
                break;
            case 3:
                tipo = TipoEmergencia.ROBO;
                break;
        }

        System.out
                .print("Ingrese ubicación (ejemplo: Zona-Norte,Zona-Sur, Zona-Centro, Zona-Oriente, Zona-Occidente): ");
        String ubicacion = sc.nextLine();

        System.out.print("Ingrese nivel de gravedad (1. bajo, 2. medio, 3. alto): ");

        NivelGravedad nivelGravedad = null;
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                nivelGravedad = NivelGravedad.BAJO;
                break;
            case 2:
                nivelGravedad = NivelGravedad.MEDIO;
                break;
            case 3:
                nivelGravedad = NivelGravedad.ALTO;
                break;
            default:
                nivelGravedad = NivelGravedad.BAJO;
                break;

        }

        System.out.print("Ingrese tiempo estimado de atención (minutos): ");
        int tiempoEstimado = Integer.parseInt(sc.nextLine());

        Emergencia nueva = FactoryEmergencias.crearEmergencia(tipo, ubicacion, nivelGravedad, tiempoEstimado);
        if (nueva == null) {
            System.out.println("Tipo de emergencia inválido.");
            return;
        }

        sistema.registrarNuevaEmergencia(nueva);
        System.out.println("Emergencia registrada: " + nueva);
    }

    private static void atenderEmergenciaMenu(SistemaEmergencias sistema, Scanner sc) {
        List<Emergencia> pendientes = sistema.getEmergenciasPendientes();
        if (pendientes.isEmpty()) {
            System.out.println("No hay emergencias pendientes.");
            return;
        }

        System.out.println("\n=== ATENDER EMERGENCIA ===");
        for (int i = 0; i < pendientes.size(); i++) {
            System.out.println((i + 1) + ". " + pendientes.get(i).getDescripcion());
        }
        System.out.print("Seleccione el número de la emergencia a atender: ");
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice < 0 || indice >= pendientes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Emergencia emergencia = pendientes.get(indice);
        sistema.asignarRecursosAEmergencia(emergencia);
        sistema.atenderEmergencia(emergencia);
    }
}
