package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Gladiator player = new Gladiator() {
        };
        Gladiator enemy= new Gladiator() {
        };;


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input1 = "";
        String input2 = "";
        Boolean flag = true; // защита от неправильного ввода


        System.out.println("Выберите гладиатора: 1 - покемон, 2 - человек");
        while (flag){
            input1 = bf.readLine();
            switch (input1){
                case "1":
                    player = new Human("Пикачу");
                    enemy = new Pokemon("Параскеволупа");
                    System.out.println("Ваш противник человек Параскеволупа,у него мало хп, но очень большой урон");
                    flag = false;
                    break;
                case "2":
                    player = new Pokemon("Параскеволупа");
                    enemy = new Human("Пикачу");
                    System.out.println("Ваш противник покемон Пикачу,у него много хп и он при попадании блокирует ваш ход");
                    flag = false;
                    break;
                default:
                    System.out.println("Ошибка ввода");
                    System.out.println("Выберите воина: 1 - человек, 2 - покемон");
                    flag = true;
            }
        }

        // выбрали гладиатора, начали бой!
        int round = 1;
        while (true){
            // атакуем
            System.out.println("Выберите куда бить: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
            flag = true;
            while (flag){
                input1 = bf.readLine();
                switch (input1){
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        flag = false;
                        break;
                    default:
                        System.out.println("Ошибка ввода");
                        System.out.println("Выберите куда бить: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
                        flag = true;
                }
            }
            // защищаемся
            System.out.println("Выберите что защищать: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
            flag = true;
            while (flag){
                input2 = bf.readLine();
                switch (input2){
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        flag = false;
                        break;
                    default:
                        System.out.println("Ошибка ввода");
                        System.out.println("Выберите куда бить: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
                        flag = true;
                }
            }
            player.setTactics(Integer.parseInt(input1), Integer.parseInt(input2));
            enemy.setTactics((int)(Math.random() * 4 + 1), (int)(Math.random() * 4 + 1));
            if (!player.attack(enemy)){
                System.out.println("Вы победили");
                break;
            }
            if (!enemy.attack(player)){
                System.out.println("Вы проиграли");
                break;
            }
        }
    }
}