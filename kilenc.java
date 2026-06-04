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
