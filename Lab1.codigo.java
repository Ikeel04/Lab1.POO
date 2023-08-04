import static java.lang.System.*;
import java.util.*;

public class PigGame {

public static Scanner scan = new Scanner (in);
public static Random generator = new Random ();

public static int j1Puntaje = 0;
public static int j2Puntaje = 0;
public static int contador;

public static void main(String args[]){
    out.println("Bienvenido a Pig. El juego del dado para 2 jugadores!");
    out.println("Jugador 1 va primero. ");
    j1Mecanicas ();
}

public static int Tirar() {
    int Bajo = 1;
    int Alto = 7;
    int Tirar = generator.nextInt (Alto - Bajo) + Bajo;
    return Tirar;
}
public static void j1Mecanicas() {
    contador = 0;
    out.println("Quieres jugar este turno? (S/N)");
    String respuesta = scan.nextLine ();
    respuesta = respuesta.replaceAll (" ", "") ;
    respuesta = respuesta.toUpperCase ();
    if (respuesta.equals("N")) {
        out.println ("Jugador 1 salta su turno.");
        out.println ("Jugador 2 salta su turno");
        j2Mecanicas ();
    }
    int Tirar = Tirar();
    out.println ("Te sale un " + Tirar);
    while (j1Puntaje + contador < 100) {
        while (Tirar != 1) {
            contador += Tirar;
            out.println ("Quieres tirar mas? (S/N)");
            respuesta = scan.nextLine ();
            respuesta = respuesta.replaceAll (" ", "") ;
            respuesta = respuesta.toUpperCase ();
            while(!(respuesta.equals("S")) && !(respuesta.equals("N"))){
                out.println("Por favor solo ingresa S/N:");
                respuesta = scan.nextLine ();
                respuesta = respuesta.replaceAll (" ", "") ;
                respuesta = respuesta.toUpperCase ();
            }
            if (respuesta.equals("N")) {
                j1Puntaje += contador;
                out.println ("Jugador 1 ha terminado su turno. ");
                out.println ("J1 vs J2: " + j1Puntaje + "-" + j2Puntaje);
                out.println ("Le toca tirar a Jugador 2");
                j2Mecanicas ();
            }
            Tirar = Tirar ();
            out.println ("Te sale un " + Tirar);

        }
        if (Tirar == 1) {
            contador = 0;
        }
        out.println ("Al jugador 1 le ha salido un '1'. ");
        out.println (" J1 vs J2: " + j1Puntaje + "-" + j2Puntaje);
        out.println ("Le toca tirar al jugador 2. ");
        j2Mecanicas ();
    }
    out.println("Jugador 1 ha obtenido 100 puntos!");
    out.println("J1 gana por " + (j1Puntaje - j2Puntaje) + " puntos!");
    exit (0);
}

public static void j2Mecanicas() {
    contador = 0;
    out.println("Quieres jugar este turno? (S/N) ");
    String respuesta = scan.nextLine ();
    respuesta = respuesta.replaceAll (" ", "") ;
    respuesta = respuesta.toUpperCase ();
    if (respuesta.equals("N")) {
        out.println ("Jugador 2 ha saltado su turno. ");
        out.println ("Le toca tirar al jugador 1");
        j1Mecanicas ();
    }
    int Tirar = Tirar();
    out.println ("Te sale un " + Tirar);
    maxPuntaje: while (j2Puntaje < 100) {
        while (Tirar != 1) {
            contador += Tirar;
            out.println ("Quieres tirar mas? (S/N) ");
            respuesta = scan.nextLine ();
            respuesta = respuesta.replaceAll (" ", "") ;
            respuesta = respuesta.toUpperCase ();
            while(!(respuesta.equals("S")) && !(respuesta.equals("N"))){
                out.println("Por favor ingresa solo S/N:");
                respuesta = scan.nextLine ();
                respuesta = respuesta.replaceAll (" ", "") ;
                respuesta = respuesta.toUpperCase ();
            }
            if (respuesta.equals("N")) {
                j2Puntaje += contador;
                out.println ("Jugador 2 ha terminado su turno. ");
                out.println ("J1 vs J2: " + j1Puntaje + "-" + j2Puntaje);
                out.println ("Le toca tirar al jugador 2. ");
                j1Mecanicas ();
            }
            Tirar = Tirar ();
            out.println ("Te sale un " + Tirar);

        }
        if (Tirar == 1) {
            contador = 0;
        }
        out.println ("Al jugador 2 le ha salido un '1'. ");
        out.println ("J1 vs J2: " + j1Puntaje + "-" + j2Puntaje);
        out.println ("Le toca tirar a jugador 1. ");
        j1Mecanicas ();
    }
    out.println("Jugador 2 ha llegado a los 100 puntos! ");
    out.println("J2 gana por " + (j2Puntaje - j1Puntaje) + " puntos!");
    exit (0);
}

