package com.company.model;

import java.util.ArrayList;

public class Elf extends Character implements ClassNormal {

    static ArrayList<Elf> elves = new ArrayList<>();

    /**
     * Método constructor para la subclase Elfo, este personaje tiene como atributo principal "strength"
     */

    public Elf(String name) {
        super(name, 16, 22, 19, 18, 20);
        Elf.elves.add(this);
    }

    /**
     * Método para poder imprimir los elfos que se van añadiendo en el Arraylist
     */

    public static void displayCharacters() {
        for (Elf e : elves) {
            System.out.println(e.displayCharacter());
        }
    }

    /**
     * Método que implementa de la clase padre para mostrar los valores creados
     *
     * @return devuelve una String con los atributos heredados
     */

    public String displayCharacter() {
        return "Elf {" + super.displayCharacter() + "}";
    }

    /**
     * Sobreescritura del método "lose()", se hace una llamada del método "restarVidas()" para restar
     * el atributo "lives"
     */

    @Override
    public void lose() {
        this.restarVidas();
    }


    /**
     * Método para comprobar si la ID que entra el usuario por teclado esté dentro del Array de elfos
     *
     * @param id es la id que entrará el usuario por teclado
     * @return devuelve null en caso de que la ID del elfo no sea la misma que la ID de parámetro
     */

    public static Elf isIdIn(int id) {
        Elf founded = null;
        for (Elf e : elves) {
            if (e.getId() == id) {
                founded = e;
                System.out.println("ID encontrada");
                break;
            }
        }
        return founded;
    }

    /**
     * Sobreescritura del método "defend()" para este ejercicio no es necesario que exista pero si en un futuro
     * se desea que los oponentes se puedan defender se puede hacer uso de este método
     */

    @Override
    public void defend() {
        System.out.println("By the blood of the Highborne!");
    }
}
