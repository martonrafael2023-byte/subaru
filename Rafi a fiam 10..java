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
