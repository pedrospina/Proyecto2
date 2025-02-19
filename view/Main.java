package Proyecto2.view;




import Proyecto2.model.Emergencia;
import Proyecto2.model.factory.FactoryEmergencias;
import Proyecto2.model.services.Ambulancia;
import Proyecto2.model.services.Bomberos;
import Proyecto2.model.services.Policia;
import Proyecto2.utils.NivelGravedad;
import Proyecto2.utils.TipoEmergencia;
import Proyecto2.controller.SistemaEmergencias;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        


        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = true;
        boolean emergenciaRegistrada = false;
        boolean nivelGravedadValido = false;
        var opcion = 0;
        var tipoEmergencia = 0;
        var nivelGravedadInput = 0;

        // Instancia del sistema de emergencias
        SistemaEmergencias sistemaEmergencias = SistemaEmergencias.getInstancia();
        

        // Crear recursos y registrarlos en el sistema
        Ambulancia ambulancia = new Ambulancia("A1", 5, 100);
        Bomberos bomberos = new Bomberos("B1", 10, 150);
        Policia policia = new Policia("P1", 8, 80);

        sistemaEmergencias.registrarRecurso(ambulancia);
        sistemaEmergencias.registrarRecurso(bomberos);
        sistemaEmergencias.registrarRecurso(policia);

        // Menú de interacción
        while (entradaValida) {
            try {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Registrar emergencia");
            System.out.println("2. Atender emergencia");
            System.out.println("3. Ver estado de recursos");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = scanner.nextInt();
            
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción inválida. Por favor, ingresa un número entre 1 y 4.");
                continue;
                
            }

            switch (opcion) {
                
                case 1:
                    // Registrar emergencia
                     while (!emergenciaRegistrada) {
                        try {

                            System.out.println("\n--- Registrar Emergencia ---");
                            System.out.println("\nSelecciona el tipo de emergencia:");
                            System.out.println("1. Accidente Vehicular");
                            System.out.println("2. Incendio");
                            System.out.println("3. Robo");
                            System.out.print("Elige una opción: ");
                            
                            
                            tipoEmergencia = scanner.nextInt();
                            
                            if (tipoEmergencia < 1 || tipoEmergencia > 3) {
                                System.out.println("Opción inválida. Por favor, ingresa un numero entre 1 y 3."); 
                                continue;  
                                
                            }
          
                            scanner.nextLine(); // Limpiar buffer
                            System.out.print("Ubicación de la emergencia: ");
                            String ubicacion = scanner.nextLine();

                        while (!nivelGravedadValido) {
                                System.out.print("Nivel de gravedad (1: Bajo, 2: Medio, 3: Alto): ");

                                try {
                                    nivelGravedadInput = scanner.nextInt();

                                    if (nivelGravedadInput < 1 || nivelGravedadInput > 3) {
                                        System.out.println("Opción inválida. Por favor, ingresa un número entre 1 y 3.");  
                                        continue;        
                                    }
                                    nivelGravedadValido = true;
                                } catch (InputMismatchException e) {
                                System.out.println("Opción inválida. Por favor, ingresa un número.");
                                scanner.nextLine();  // Limpiar buffer
                                }
                            }
                        
                            
                                    NivelGravedad nivelGravedad = NivelGravedad.values()[nivelGravedadInput - 1];
                                    System.out.print("Tiempo estimado de respuesta (en minutos): ");
                                    int tiempoRespuesta = scanner.nextInt();
                                    
                                    Emergencia emergencia = FactoryEmergencias.crearEmergencia( 
                                            TipoEmergencia.values()[tipoEmergencia - 1],
                                            ubicacion,
                                            nivelGravedad,
                                            tiempoRespuesta
                                    );
                                    
                                    // Registrar la emergencia en el sistema
                                sistemaEmergencias.registrarNuevaEmergencia(emergencia);
                                System.out.println("Emergencia registrada exitosamente.");
                                emergenciaRegistrada = false;
                                break;     
                                    
                                } catch (InputMismatchException e) {
                                System.out.println("Opción inválida. Por favor, ingresa un número.");
                                scanner.nextLine();  // Limpiar buffer
                                }
                            } 

                    case 2:   // antender emergencia

                    if (sistemaEmergencias.getEmergenciasPendientes().isEmpty()) {
                        System.out.println("No hay emergencias pendientes para atender.");
                    } else {
                        // Asignar recursos automáticamente a las emergencias pendientes
                        for (Emergencia emergencia : sistemaEmergencias.getEmergenciasPendientes()) {
                            sistemaEmergencias.asignarRecursosAEmergencia(emergencia);
                        }
                    }
                    break;

                case 3:
                    // Ver estado de los recursos
                    sistemaEmergencias.mostrarEstadoRecursos();
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
            
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Por favor, ingresa un número.");
                scanner.nextLine();  // Limpiar buffer
            }
        }
    }
            
         
}
            



 
            
        
    


