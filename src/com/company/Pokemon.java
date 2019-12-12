package com.company;

public class Pokemon extends Gladiator {
    //секутор, наносит двойной урон

    public Pokemon(String name) {
        super (name, 10, 2);
    }

    @Override
    public Boolean special(Gladiator enemy) {
        System.out.println(name + " нанес двойной урон!");
        damage = 4;
        Boolean f;
        f = attack(enemy);
        damage = 2;
        return f;
    }
}