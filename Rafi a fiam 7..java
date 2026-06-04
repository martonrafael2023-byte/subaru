static void createCharacter() {

    System.out.print("Nev: ");
    String name = sc.nextLine();

    System.out.println("1 Harcos");
    System.out.println("2 Mágus");
    System.out.println("3 Tank");
    System.out.println("4 Lövész");
    System.out.println("5 Gyilkos");

    int c = getNumber();

    switch (c) {
        case 1: player = new Harcos(name); break;
        case 2: player = new Magus(name); break;
        case 3: player = new Tank(name); break;
        case 4: player = new Lovesz(name); break;
        case 5: player = new Gyilkos(name); break;
        default: player = new Harcos(name);
    }
}
