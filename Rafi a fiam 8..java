static Enemy getEnemy(int r) {

    if (r == 15) {
        return new Enemy("Yasuo", 500, 50);
    }

    int index = r - 1;

    if (index >= names.length) {
        index = rnd.nextInt(names.length);
    }

    return new Enemy(
            names[index],
            enemyHp[index],
            enemyDmg[index]
    );
}

static void battle(Enemy e) {

    boolean skipEnemy;