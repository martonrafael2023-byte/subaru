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
