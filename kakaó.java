
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
