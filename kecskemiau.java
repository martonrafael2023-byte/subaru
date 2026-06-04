if (e.hp > 0 && !skipEnemy) {

boolean crit = rnd.nextDouble() < enemyCritChance;

int dmg = e.damage;

                if (crit) {
dmg *= 2;
        System.out.println("💥 ENEMY KRIT!");
                }
