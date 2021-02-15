package com.company.model;

import java.util.ArrayList;

public class Human extends Character implements ClassFighter {

    static ArrayList<Human> humans = new ArrayList<>();
    private int victories;
    private int defeats;

    /**
     * Método constructor para la subclase Human con sus atributos predefinidos. Este personaje tiene como atributo
     * principal "strength". Incluye también sus atributos propios que son "victories" y "defeats"
     *
     * @param name nombre del personaje
     */

    public Human(String name) {
        super(name, 18, 20, 17, 22, 21);
        this.defeats = 0;
        this.victories = 0;
        //se podría poner this pero no es "bonito":
        Human.humans.add(this);
    }

    /**
     * Método para poder imprimir los humanos que se van añadiendo en el Arraylist
     */

    public static void displayCharacters() {
        for (Human h : humans) {
            System.out.println(h.displayCharacter());
        }
    }

    /**
     * Método que implementa de la clase padre para mostrar los valores creados
     *
     * @return devuelve una String con los atributos propios y los heredados
     */

    public String displayCharacter() {
        return "Human {" + super.displayCharacter() + ", " + "victories=" + this.victories + ","
                + " defeats=" + this.defeats + "}";
    }

    /**
     * Sobreescritura del método "win()" para poder aplicar las consecuencias del método "fight()"
     * Si gana, se aumentará el atributo "victories"
     */

    @Override
    public void win() {
        super.win();
        this.victories++;
    }

    /**
     * Sobreescritura del método "lose()" para poder aplicar las consecuencias del método "fight()"
     * Si pierde, se aumentará el atributo "defeats" y se hace una llamada del método "restarVidas()" para restar
     * el atributo "lives"
     */

    @Override
    public void lose() {
        super.lose();
        this.defeats++;
        this.restarVidas();
    }

    /**
     * Método para comprobar si la ID que entra el usuario por teclado esté dentro del Array de humanos
     *
     * @param id es la id que entrará el usuario por teclado
     * @return devuelve null en caso de que la ID del humano no sea la misma que la ID de parámetro
     */

    //    Cada método devuelve un tipo:
    public static Human isIdIn(int id) {
        Human founded = null;
        for (Human h : humans) {
            if (h.getId() == id) {
                founded = h;
                System.out.println("ID encontrada");
                break;
            }
        }
        return founded;
    }

    /**
     * Sobreescritura del método "fight()" que se encarga de establecer la lógica de los combates, implementa los métodos
     * "win()" y "lose()" para establecer las consecuencias de los combates.
     *
     * @param oponent es el oponente contra el que luchará durante el combate
     */

    @Override
    public void fight(Character oponent) {
        System.out.println("Fight!");
        if (this.getStrength() > oponent.getStrength()) {
            win();
            oponent.lose();
        } else if (this.getStrength() < oponent.getStrength()) {
            lose();
            oponent.win();
        } else if (this.getStrength() == oponent.getStrength()) {
            win();
            oponent.lose();
        }
    }


}


