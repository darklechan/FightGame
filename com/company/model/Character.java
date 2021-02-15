package com.company.model;

public abstract class Character {
    private int id;
    private int lives = 3;
    private String name;
    private int strength;
    private int agility;
    private int endurance;
    private int intellect;
    private int spirit;
    public static int generateID = 1; //generar una id consecutiva

    /**
     * Constructor principal de la clase padre con los atributos que se definirán en las subclases
     *
     * @param name      nombre del personaje
     * @param strength  fuerza del personaje
     * @param agility   agilidad del personaje
     * @param endurance resistencia del personaje
     * @param intellect inteligencia del personaje
     * @param spirit    espíritu del personaje
     */

    public Character(String name, int strength, int agility,
                     int endurance, int intellect, int spirit) {
        this.id = generateID++;
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
        this.intellect = intellect;
        this.spirit = spirit;
    }

    /**
     * Método para imprimir los atributos de los personajes
     *
     * @return devuelve una String con los atributos
     */


    public String displayCharacter() {
        return "id=" + id +
                ", lives=" + lives +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", endurance=" + endurance +
                ", intellect=" + intellect +
                ", spirit=" + spirit;
    }

    /**
     * Método para poder restar el atributo vida si alguno de los contrincantes pierde
     * En caso de que algún personaje llegue a un valor de 0, estará muerto
     */

    public void restarVidas() {
        lives--;
        if (this.getLives() == 0) {
            System.out.println(this.name + " is DEAD");
        }
    }

    /**
     * Método que muestra qué jugador ha ganado. Este se sobreescribirá, en caso de ser necesario,
     * en cada una de las subclases
     */

    public void win() {
        System.out.println(this.name + " WIN!");
    }

    /**
     * Método que muestra qué jugador ha perdido. Este se sobreescribirá, en caso de ser necesario,
     * en cada una de las subclases
     */

    public void lose() {
        System.out.println(this.name + " LOSE!");
    }

    //Getters:

    public int getStrength() {
        return strength;
    }

    public int getId() {
        return id;
    }

    public int getLives() {
        return lives;
    }


//    public static int isIdIn(int id) {
//        return id;
//    }

}
