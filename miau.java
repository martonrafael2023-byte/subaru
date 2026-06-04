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
