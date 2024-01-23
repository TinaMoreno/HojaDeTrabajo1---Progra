
//********************
// UNIVERSIDAD DEL VALLE DE GUATEMALA
// Departamento de Ciencias De La Computacion
// CC2016 - 20
// Autores: Alvaro Jose Leon Aguilar
//          Valentina Moreno Moreno
//          Milton Giovanni Polanco Serrano 
//			Isabella Recinos RodrÃ­guez
// Fecha: Enero 23 2024
// Descripcion: Hoja de trabajo 1 - Main (Interaccion con el usuario)
//********************
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Radio class
        IRadio radio = new Radio();

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {

            if (radio.getState()) {
                System.out.println("===== RADIO =====");
                System.out.println("1. Boton de encendido");
                System.out.println("2. AM/FM");
                System.out.println("3. Siguiente frecuencia");
                System.out.println("4. Anterior frecuencia");
                System.out.println("5. Marcar como favorita");
                System.out.println("6. Mostrar favoritos");
                System.out.println("7. Salir");
                System.out.print("Ingrese la opcion: ");
            } else {

                System.out.println("===== RADIO =====");
                System.out.println("1. Boton de encendido");
                System.out.println("7. Salir");
                System.out.print("Ingrese la opcion: ");
            }

            // Read user choice
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    radio.togglePowerOffOn();
                    System.out.println("Radio is " + (radio.getState() ? "ON" : "OFF"));
                    break;
                case 2:
                    if (radio.getState()) {
                        radio.toggleAMFM();
                        System.out.println("Current Mode: " + (radio.getStateAMFM() ? "AM" : "FM"));
                    } else {
                        System.out.println("Radio is OFF. Please turn it ON to change the mode.");
                    }
                    break;
                case 3:
                    if (radio.getState()) {
                        radio.nextFrequency();
                        System.out.println("Current Frequency: " + radio.getCurrentFrequency());
                    } else {
                        System.out.println("Radio is OFF. Please turn it ON to change the frequency.");
                    }
                    break;
                case 4:
                    if (radio.getState()) {
                        radio.previousFrequency();
                        System.out.println("Current Frequency: " + radio.getCurrentFrequency());
                    } else {
                        System.out.println("Radio is OFF. Please turn it ON to change the frequency.");
                    }
                    break;
                case 5:
                    if (radio.getState()) {
                        System.out.print("Enter the button number (1-12): ");
                        int buttonNumber = scanner.nextInt();
                        radio.setFavFrequency(buttonNumber);
                        System.out.println("Favorite Frequency set for Button " + buttonNumber);
                    } else {
                        System.out.println("Radio is OFF. Please turn it ON to set a favorite frequency.");
                    }
                    break;
                case 6:
                    if (radio.getState()) {
                        System.out.print("Enter the button number (1-12): ");
                        int favButton = scanner.nextInt();
                        System.out.println("Favorite Frequency at Button " + favButton + ": " +
                                radio.getFavFrequency(favButton));
                    } else {
                        System.out.println("Radio is OFF. Please turn it ON to get a favorite frequency.");
                    }
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the Radio Menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }

        // Close the Scanner
        scanner.close();
    }
}
