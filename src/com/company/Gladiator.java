package com.company;

abstract class Gladiator {
    //главный класс, от которого будут наследоваться остальные классы гладиаторов
    protected String name;
    protected int hitPoints; // хит поинты
    protected int attacks = 0; //куда бьем
    protected int blocks = 0; // что блакируим
    protected int damage; // дамаг
    protected int ultimatesLeft = 3;

    //конструктор
    public Gladiator(String name, int hitPoints, int damage) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.damage = damage;
    }
    public Gladiator() {

    }

    //стандартная атака
    public Boolean attack (Gladiator enemy){
        // если атакуем не то, что заблокировано
        if (attacks != enemy.getBlocks()){
            switch (attacks){
                case 1:
                    System.out.println(name + " нанес успешный удар в голову");
                    break;
                case 2:
                    System.out.println(name + " нанес успешный удар по туловищу");
                    break;
                case 3:
                    System.out.println(name + " нанес успешный удар в пах");
                    break;
                case 4:
                    System.out.println(name + " нанес успешный удар по ногам");
                    break;
            }
            enemy.takeHits(damage); //то наносим урон
            System.out.println("Здоровье " + enemy.getName() + ": " + enemy.getHitPoints());
        }
        else switch (enemy.getBlocks()){
            case 1:
                System.out.println(enemy.getName() + " заблокировал удар в голову");
                break;
            case 2:
                System.out.println(enemy.getName() + " заблокировал удар по туловищу");
                break;
            case 3:
                System.out.println(enemy.getName() + " заблокировал удар в пах");
                break;
            case 4:
                System.out.println(enemy.getName() + " заблокировал удар по ногам");
                break;
        }



        if (enemy.getHitPoints() <= 0) return false;
        else return true; // если убили врага, возвращаем true
    }

    //суперудар, его перегружаем для каждого гладиатора
    public Boolean special (Gladiator enemy){
        if (enemy.getHitPoints() < 0) return false;
        else return true; // если убили врага, возвращаем true
    }


    //снимаем хит пониты
    public void takeHits (int hits){
        this.hitPoints -= hits;
    }

    //getters/setters
    public void setTactics (int attacks, int blocks){
        this.attacks = attacks;
        this.blocks = blocks;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttacks() {
        return attacks;
    }

    public int getBlocks() {
        return blocks;
    }

    public String getName() {
        return name;
    }

    public int getUltimates() {
        return ultimatesLeft;
    }
}
