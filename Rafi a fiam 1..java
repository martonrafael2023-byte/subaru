import java.util.*;
import java.io.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    static Character player;
    static int room = 1;
    static int potions = 3;
    static boolean running = true;

    static int gold = 0;


    static double playerCritChance = 0.20;
    static double enemyCritChance = 0.10;

    static String[] names = {
            "Alistar","Garen","Amumu","Ashe","Brand",
            "Caitlyn","Darius","Dr.Mundo","Ekko","Fizz",
            "Jinx","Katarina","Lee Sin","Lillia"
    };