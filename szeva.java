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