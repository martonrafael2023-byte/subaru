chestEvent();
room++;

        break;

        case "go back":

        if (room > 1) {
room--;
        System.out.println("Visszamentel az elozo szobaba.");
                    } else {
                            System.out.println("Nem tudsz tovabb visszamenni!");
                    }

                            break;

                            case "save":
saveGame();
                    break;