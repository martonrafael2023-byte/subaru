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