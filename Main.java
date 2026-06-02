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