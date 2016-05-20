 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negaard_3_arrays;
import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author DrKairos
 */
public class Negaard_3_Arrays {

    static Scanner sc = new Scanner(System.in);
    static String ar;
    public static boolean game;
    public static int x = 13;
    public static int y = 13;
    public static int nx = x;
    public static int ny = y;
    static int maxY = 42;
    static int maxX = 42;
    public static boolean[][] trap = new boolean[maxX][maxY];
    public static boolean[][] treasure = new boolean[maxX][maxY];
    public static int e1x, e1y, e2x, e2y;
    public static int score;
    public static boolean e1, e2;
    
//    public static String[][] map = new String[41][41];
//    public static Player player;
//    public Itemwin ChestWin;
//    public Enemy Bob;
//    public ArrayList<Enemy> enemies = new ArrayList();
//    public ArrayList<Item> treasure = new ArrayList();
//    public ArrayList<Item1> treasure1 = new ArrayList();
//    public ArrayList<Itemwin> ChestWin = new ArrayList();
//    private boolean[][] hostiles;
    
    public static void main(String[] args) {
        game = true;
        e1 = true;
        e2 = true;
        char[][] map = new char[maxX][maxY];

        map[x][y] = '|';

        for (int t = 0; t < 50; t++) {

            int trapx = (int) Math.floor(Math.random() * maxX);
            int trapy = (int) Math.floor(Math.random() * maxY);

            trap[trapx][trapy] = true;
        }
        for (int t = 0; t < 3; t++) {

            int treasurex = (int) Math.floor(Math.random() * maxX);
            int treasurey = (int) Math.floor(Math.random() * maxY);

            treasure[treasurex][treasurey] = true; if(trap [treasurex][treasurey]){
                trap [treasurex][treasurey] = false;
            }
        }
        
        e1x = (int) Math.floor(Math.random() * maxX);
        e1y = (int) Math.floor(Math.random() * maxX);
        e2x = (int) Math.floor(Math.random() * maxX);
        e2y = (int) Math.floor(Math.random() * maxX);

        if (trap[e1x][e1y]) {
            trap[e1x][e1y] = false;
        }
        if (trap[e2x][e2y]) {
            trap[e2x][e2y] = false;
        }
      
            
        
        while (game) {
            grid(map);
            input(map);
            enemy(map);
        }
    }

    public static void grid(char[][] map) {
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (trap[j][i]) {
                        map[i][j] = '#';
                    }
                    if (treasure[j][i]) {
                        map[i][j] = '$';
                    }
                    if (map[i][j] != '@' && map[i][j] != '#' && map[i][j] != 'E' && map[i][j] != '$') {
                        System.out.print(".");
                    } else {
                        System.out.print(map[i][j]);
                    }
                } else {
                    if (map[i][j] != '@') {
                        System.out.println(".");
                    } else {
                        System.out.println(map[i][j]);

                    }
                }
            }
        }
    }

    public static void move(int movex, int movey) {
        nx += movex;
        ny += movey;
        if (trap[nx][ny]) {
            System.out.println("\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }
        x += movex;
        y += movey;
        if (treasure[x][y]) {
            treasure[x][y] = false;
            score++;
        }
        
            
    }

    public static void enemy(char[][] map) {
        if (e1x > x && e1 ) {
            map[e1y][e1x] = '.';
            e1x--;

        }
        if (e2x > x && e2) {
            map[e2y][e2x] = '.';
            e2x--;

        }
        if (e1y > y && e1) {
            map[e1y][e1x] = '.';
            e1y--;

        }
        if (e2y > y && e2) {
            map[e2y][e2x] = '.';
            e2y--;

        }
        if (e1x < x && e1) {
            map[e1y][e1x] = '.';
            e1x++;

        }
        if (e2x < x && e2) {
            map[e2y][e2x] = '.';
            e2x++;

        }
        if (e1y < y && e1) {
            map[e1y][e1x] = '.';
            e1y++;

        }
        if (e2y < y && e2) {
            map[e2y][e2x] = '.';
            e2y++;

        }
        if(e1){
           map[e1y][e1x] = 'E'; 
        }
        if(e2){
        map[e2y][e2x] = 'E';
        }
        if (trap[e1x][e1y]) {
            e1 = false;
        }
        if (trap[e2x][e2y]) {
            e2 = false;
        }

        if (e1x == x && e1y == y && e1) {
            System.out.println("\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }
        if (e2x == x && e2y == y && e2) {
            System.out.println("\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }
        if (score == 3) {
            System.out.println("\\ \\ / /__  _   _  \\ \\      / (_)_ __  \n" +
" \\ V / _ \\| | | |  \\ \\ /\\ / /| | '_ \\ \n" +
"  | | (_) | |_| |   \\ V  V / | | | | |\n" +
"  |_|\\___/ \\__,_|    \\_/\\_/  |_|_| |_|");
            game = false;
        }
        
    }

    public static void input(char[][] map) {
        System.out.println("Your score is: " + score);
        System.out.println("Choose a direction (N, NE, E, SE, S, SW, W, NW");
        ar = sc.nextLine().toLowerCase();
        if (ar.contains("N") && y != 0) {
            map[y][x] = '.';
//            y--;
            move(0, -1);
        }
        if (ar.contains("NE") && x != 0) {
            map[y][x] = '.';
//            x--;
            move(-1, 0);
        }
        if (ar.contains("E") && y != 41) {
            map[y][x] = '.';
//            y++;
            move(0, 1);
        }
        if (ar.contains("SE") && x != 41) {
            map[y][x] = '.';
//            x++;
            move(1, 0);
        }
//        if (ar.contains("S") && y !=?) {
//            map[y][x] = '.';
//            move(?,?);
//        }
//        if (ar.contains("SW") && y !=?) {
//            map[y][x] = '.';
//            move(?,?);
//        }
//        if (ar.contains("W") && y !=?) {
//            map[y][x] = '.';
//            move(?,?);
//        }
//         if (ar.contains("NW") && y !=?) {
//            map[y][x] = '.';
//            move(?,?);
//        }

        map[y][x] = '@';

    }

}
    




