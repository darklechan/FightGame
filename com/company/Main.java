package com.company;

import com.company.model.*;
import com.company.model.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicio();
    }


    public void inicio() {
        int menu = 0;
        do {
            System.out.println("<<<Menú del juego>>>");
            System.out.println("¿Qué desea hacer?");
            System.out.println("[1] Crear personajes");
            System.out.println("[2] Mostrar personajes");
            System.out.println("[3] Luchar");
            System.out.println("[4] Salir");

            if (input.hasNextInt()) {
                int menuItem = input.nextInt();
                input.nextLine();
                switch (menuItem) {
                    case 1 -> createCharacter();
                    case 2 -> showCharacters();
                    case 3 -> battle();
                    case 4 -> {
                        System.out.println("Saliendo...");
                        return;
                    }
                }
            }

        } while (true);
    }

    /**
     * Método para crear un Personaje, se solicita un nombre y seguidamente se puede escoger entre los dos tipos
     * de personajes que existen "Normales" y "Luchadores". Una vez hecho esto, se añade el personaje a su ArrayList
     */

    public void createCharacter() {
        String name;
        int option = 0;

        do {
            System.out.println("Name: ");
            name = input.nextLine();
        } while (name.equals(" "));

        do {
            System.out.println("Selecciona tipos de personaje: ");
            System.out.println("****Personajes normales****");
            System.out.println("[1] Elf");
            System.out.println("[2] Dwarf");
            System.out.println("****Personajes luchadores****");
            System.out.println("[3] Human");
            System.out.println("[4] Orc");
            if (input.hasNextInt()) {
                int menuCharacter = input.nextInt();
                input.nextLine();
                switch (menuCharacter) {
                    case 1 -> {
                        new Elf(name);
                        return;
                    }
                    case 2 -> {
                        new Dwarf(name);
                        return;
                    }
                    case 3 -> {
                        new Human(name);
                        return;
                    }
                    case 4 -> {
                        new Orc(name);
                        return;
                    }
                }
            }

        } while (true);


    }

    /**
     * Método para imprimir los diferentes personajes cuando se seleccione dicha opción en el menú
     */

    public void showCharacters() {
        Human.displayCharacters();
        Orc.displayCharacters();
        Elf.displayCharacters();
        Dwarf.displayCharacters();
    }

    /**
     * Método para buscador un personaje que sea "Fighter", para este ejercicio sólo pueden ser de este tipo los
     * humanos y los orcos.
     *
     * @param id es el parámetro que introducirá el usuario por teclado
     * @return devuelve si el Orco ha sido encontrado en caso de que el humano no se haya encontrado
     */

    private ClassFighter searchFighter(int id) {
//        int id = 0;
//        ClassFighter = null;
        Human human = Human.isIdIn(id);

        if (human != null) {
            return human;
        }
        return Orc.isIdIn(id);
    }

    /**
     * Método para buscar al oponente, en este caso también se incluyen los de tipo "Fighter" y "Normal"
     *
     * @param id es el parámetro que introducirá el usuario por teclado
     * @return devuelve un elfo en caso de que no se hayan encontrado ninguno de los anteriores personajes
     */

    private Character searchOponent(int id) {
//        Character  = null;

        Human human = Human.isIdIn(id);
        if (human != null) {
            return human;
        }

        Orc orc = Orc.isIdIn(id);
        if (orc != null) {
            return orc;
        }

        Dwarf dwarf = Dwarf.isIdIn(id);
        if (dwarf != null) {
            return dwarf;
        }
        return Elf.isIdIn(id);
    }

    /**
     * Método para iniciar el combate entre dos personajes, se solicita la ID de ambos, en caso de que una ID no exista
     * se pedirá nuevamente.
     * En este método también se hace uso de los métodos "searchOponent" y "searchFighter" para poder buscar en cada
     * uno de ellos si la ID introducida pertenece a alguno de esos personajes.
     * Si ambos contrincantes existen, se hace el llamado al método "fight"
     */


    public void battle() {
        boolean found = false;
        int id;
        ClassFighter fighter = null;

        do {
            System.out.println("Introduce la ID del luchador: ");
            Human.displayCharacters();
            Orc.displayCharacters();

            if (input.hasNextInt()) {
                id = input.nextInt();
                fighter = searchFighter(id);

                if (fighter != null) {
                    found = true;
                    System.out.println("READY!");
                } else {
                    System.out.println("ID no encontrada");
                }
            } else {
                System.out.println("Valor de ID no válido");
            }
            input.nextLine();
        } while (!found);

        found = false;

        do {
            System.out.println("Introduce la ID del oponente: ");
            showCharacters();

            if (input.hasNextInt()) {
                id = input.nextInt();

                Character oponent = searchOponent(id);
                if (oponent != null) {
                    fighter.fight(oponent);
                    found = true;
                } else {
                    System.out.println("ID no encontrada. Introduce una ID existente");
                }
            } else {
                System.out.println("Valor de ID no válido");
            }
            input.nextLine();
        } while (!found);

    }
}


