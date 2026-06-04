import java.util.*;
import java.io.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    static Character player;
    static int room = 1;
    static int potions = 3;
    static boolean running = true;

    static int gold = 0;


    static double playerCritChance = 0.20;
    static double enemyCritChance = 0.10;

    static String[] names = {
            "Alistar","Garen","Amumu","Ashe","Brand",
            "Caitlyn","Darius","Dr.Mundo","Ekko","Fizz",
            "Jinx","Katarina","Lee Sin","Lillia"
    };

    static int[] enemyHp = {
            120, 100, 80, 70, 90,
            67, 100, 170, 80, 76,
            67, 60, 120, 90
    };

    static int[] enemyDmg = {
            18, 22, 20, 30, 35,
            33, 28, 18, 30, 38,
            36, 40, 34, 32
    };

    public static void main(String[] args) {

        System.out.println("===== SZOVEGES KALANDJATEK =====");

        createCharacter();

        while (running) {

            if (player.hp <= 0) {
                gameOver();
                return;
            }

            if (room > 15) {
                System.out.println("\n=========================");
                System.out.println("LEGYOZTED YASUOT!");
                System.out.println("NYERTEL!");
                System.out.println("=========================");
                return;
            }

            showRoom();

            if (room % 5 == 0) {
                shop();
            }

            System.out.println("\nParancsok:");
            System.out.println("go next");
            System.out.println("go back");
            System.out.println("save");
            System.out.println("exit");

            String cmd = sc.nextLine().toLowerCase();

            switch (cmd) {

                case "go next":

                    Enemy enemy = getEnemy(room);
                    System.out.println("\nEllenfel: " + enemy.name);

                    battle(enemy);

                    if (player.hp <= 0) {
                        System.out.println("\nMEGHALTAL!");
                        gameOver();
                        return;
                    }

                    chestEvent();
                    room++;

                    break;

                case "go back":

                    if (room > 1) {
                        room--;
                        System.out.println("Visszamentel az elozo szobaba.");
                    } else {
                        System.out.println("Nem tudsz tovabb visszamenni!");
                    }

                    break;

                case "save":
                    saveGame();
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Hibas parancs!");
            }
        }
    }

    static void showRoom() {
        System.out.println("\n====================");
        System.out.println(room + ". SZOBA");
        System.out.println("💰 Gold: " + gold);
        System.out.println("====================");
    }

    static void createCharacter() {

        System.out.print("Nev: ");
        String name = sc.nextLine();

        System.out.println("1 Harcos");
        System.out.println("2 Mágus");
        System.out.println("3 Tank");
        System.out.println("4 Lövész");
        System.out.println("5 Gyilkos");

        int c = getNumber();

        switch (c) {
            case 1: player = new Harcos(name); break;
            case 2: player = new Magus(name); break;
            case 3: player = new Tank(name); break;
            case 4: player = new Lovesz(name); break;
            case 5: player = new Gyilkos(name); break;
            default: player = new Harcos(name);
        }
    }

    static Enemy getEnemy(int r) {

        if (r == 15) {
            return new Enemy("Yasuo", 500, 50);
        }

        int index = r - 1;

        if (index >= names.length) {
            index = rnd.nextInt(names.length);
        }

        return new Enemy(
                names[index],
                enemyHp[index],
                enemyDmg[index]
        );
    }

    static void battle(Enemy e) {

        boolean skipEnemy;

        while (e.hp > 0 && player.hp > 0) {

            skipEnemy = false;

            System.out.println("\nHP: " + player.hp);
            System.out.println("Gyogyital: " + potions);
            System.out.println(e.name + " HP: " + e.hp);
            System.out.println("💰 Gold: " + gold);
            System.out.println("Crit esely: " + (int)(playerCritChance * 100) + "%");

            System.out.println("1 Tamadas");
            System.out.println("2 Gyogyitas");
            System.out.println("3 Mentes");

            int c = getNumber();

            if (c == 1) {

                boolean crit = rnd.nextDouble() < playerCritChance;

                int dmg = player.damage;

                if (crit) {
                    dmg *= 2;
                    System.out.println("💥 KRITIKUS TALÁLAT!");
                }

                e.hp -= dmg;

                System.out.println("Te sebztél: " + dmg);
            }

            else if (c == 2) {

                if (potions > 0) {
                    player.hp += 25;
                    potions--;
                    skipEnemy = true;
                    System.out.println("Gyogyitas!");
                } else {
                    System.out.println("Nincs ital!");
                }
            }

            else if (c == 3) {
                saveGame();
            }

            if (e.hp > 0 && !skipEnemy) {

                boolean crit = rnd.nextDouble() < enemyCritChance;

                int dmg = e.damage;

                if (crit) {
                    dmg *= 2;
                    System.out.println("💥 ENEMY KRIT!");
                }

                player.hp -= dmg;

                System.out.println(e.name + " sebzett: " + dmg);
            }

            if (player.hp <= 0) {
                System.out.println("MEGHALTAL!");
                gameOver();
                System.exit(0);
            }
        }

        System.out.println("Legyozted: " + e.name);

        int reward = 10 + room * 2;
        gold += reward;

        System.out.println("💰 +" + reward + " gold");
        System.out.println("Összes gold: " + gold);
    }

    static void shop() {

        System.out.println("\n🛒 SHOP");
        System.out.println("Gold: " + gold);

        System.out.println("1 Potion (20)");
        System.out.println("2 +10 HP (30)");
        System.out.println("3 +5 DMG (40)");
        System.out.println("4 +5% Crit (60)");
        System.out.println("5 Exit");

        int c = getNumber();

        if (c == 1 && gold >= 20) {
            gold -= 20;
            potions++;
            System.out.println("Potion +1");
        }

        else if (c == 2 && gold >= 30) {
            gold -= 30;
            player.hp += 10;
            System.out.println("+10 HP");
        }

        else if (c == 3 && gold >= 40) {
            gold -= 40;
            player.damage += 5;
            System.out.println("+5 DMG");
        }

        else if (c == 4 && gold >= 60) {
            gold -= 60;
            playerCritChance += 0.05;
            System.out.println("+5% Crit");
        }

        else {
            System.out.println("Nincs eleg gold vagy exit.");
        }
    }

    static void chestEvent() {

        System.out.println("\nLada!");
        System.out.println("1 kinyit 2 nem");

        int c = getNumber();
        if (c != 1) return;

        int r = rnd.nextInt(100);

        if (r < 20) {
            System.out.println("MIMIC!");
            battle(new Enemy("Mimic", 120, 25));
            return;
        }

        if (r < 40) {
            System.out.println("CSAPDA!");

            if (rnd.nextBoolean()) {
                player.hp -= 20;
            } else {
                player.damage -= 5;
            }
            return;
        }

        int loot = rnd.nextInt(5);

        if (loot == 4) potions++;
        else if (loot == 3) player.hp += 40;
        else if (loot == 2) player.hp += 20;
        else if (loot == 1) player.damage += 10;
        else player.damage += 5;
    }

    static void saveGame() {

        try {
            PrintWriter pw = new PrintWriter("save.txt");

            pw.println(player.name);
            pw.println(player.hp);
            pw.println(player.damage);
            pw.println(room);
            pw.println(potions);
            pw.println(gold);

            pw.close();

            System.out.println("Mentve!");

        } catch (Exception e) {
            System.out.println("Hiba!");
        }
    }

    static int getNumber() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Szamot!");
            }
        }
    }

    static void gameOver() {
        try {
            PrintWriter pw = new PrintWriter("gameover.txt");
            pw.println("GAME OVER");
            pw.println(player.name);
            pw.println("Room: " + room);
            pw.close();
        } catch (Exception e) {
            System.out.println("Hiba gameover");
        }
    }
}

class Character {
    String name;
    int hp;
    int damage;

    Character(String n, int h, int d) {
        name = n;
        hp = h;
        damage = d;
    }
}

class Harcos extends Character { Harcos(String n) { super(n, 120, 20); } }
class Magus extends Character { Magus(String n) { super(n, 80, 15); } }
class Tank extends Character { Tank(String n) { super(n, 180, 10); } }
class Lovesz extends Character { Lovesz(String n) { super(n, 90, 30); } }
class Gyilkos extends Character { Gyilkos(String n) { super(n, 70, 45); } }

class Enemy {
    String name;
    int hp;
    int damage;

    Enemy(String n, int h, int d) {
        name = n;
        hp = h;
        damage = d;
    }
}