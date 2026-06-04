player.hp -= dmg;

                System.out.println(e.name + " sebzett: " + dmg);
            }

                    if (player.hp <= 0) {
        System.out.println("MEGHALTAL!");
gameOver();
                System.exit(0);
            }
                    }