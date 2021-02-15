package com.company.model;

import java.util.ArrayList;

public class Dwarf extends Character implements ClassNormal {

    static ArrayList<Dwarf> dwarves = new ArrayList<>();

    /**
     * Método constructor para la subclase Enano, este personaje tiene como atributo principal "strength"
     */

    public Dwarf(String name) {
        super(name, 15, 12, 20, 15, 14);
        Dwarf.dwarves.add(this);
    }

    /**
     * Método para poder imprimir los enanos que se van añadiendo en el Arraylist
     */

    public static void displayCharacters() {
        for (Dwarf d : dwarves) {
            System.out.println(d.displayCharacter());
        }
    }

    /**
     * Método que implementa de la clase padre para mostrar los valores creados
     *
     * @return devuelve una String con los heredados
     */

    public String displayCharacter() {
        return "Dwarf {" + super.displayCharacter() + "}";
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
     * Método para comprobar si la ID que entra el usuario por teclado esté dentro del Array de enanos
     *
     * @param id es la id que entrará el usuario por teclado
     * @return devuelve null en caso de que la ID del enano no sea la misma que la ID de parámetro
     */

    public static Dwarf isIdIn(int id) {
        Dwarf founded = null;
        for (Dwarf d : dwarves) {
            if (d.getId() == id) {
                founded = d;
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
        System.out.println("For Khaz Modan!");
    }
}
