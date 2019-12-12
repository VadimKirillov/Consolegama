package com.company;

public class Human extends Gladiator {
    // ретиарий, закидывает соперниа сеткой, тот один ход всегда пропускает удар


    public Human(String name) {
        super (name, 20, 1);
    }

    @Override
    public Boolean special(Gladiator enemy) {
        System.out.println( name + " закинул сеть на соперника");
        enemy.takeHits(damage);
        if (enemy.getHitPoints() < 0) return false;
        else return true; // если убили врага, возвращаем true
    }
}