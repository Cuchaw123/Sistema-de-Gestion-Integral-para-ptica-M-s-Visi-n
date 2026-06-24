package main.java.optica;

import main.java.optica.view.MenuPrincipalView;

/**
 * Punto de entrada del sistema Óptica Más Visión.
 * Inicia la interfaz de consola (capa View).
 */
public class Main {
    public static void main(String[] args) {
        new MenuPrincipalView().iniciar();
    }
}