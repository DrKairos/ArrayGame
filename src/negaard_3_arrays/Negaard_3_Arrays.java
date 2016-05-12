/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negaard_3_arrays;
import java.util.ArrayList;
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
    public static Player player;
    public Itemwin ChestWin;
    public Enemy Bob;
    public ArrayList<Enemy> enemies = new ArrayList();
    public ArrayList<Item> stuff = new ArrayList();
    public ArrayList<Item1> stuff1 = new ArrayList();
    public ArrayList<Itemwin> stuffwin = new ArrayList();
    private boolean[][] hostiles;
    
    public static void main(String[] args) {
        game = true;
        char[][] map = new char[27][27];
    
        map[x][y] = '@'; 
        
        while (game) {
        grid(map);
        input(map);
        }
    }
public static void grid(char[][]map){
    for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (map[i][j] != 'x') {
                        System.out.print(".");
                    } else {
                        System.out.print(map[i][j]);
                    }
                } else {
                    if (map[i][j] != 'x') {
                        System.out.println(".");
                    } else {
                        System.out.println(map[i][j]);
                    }
                }
            }
        }
    }

    public static void input(char[][]map) {    
System.out.println("Select your direction (N, NE, E, SE, S, SW, W, NW)");
ar = sc.nextLine().toLowerCase();
if (ar.contains("N") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("NE") && y !=0) {
    map[y][x] = ' ';
    y--;

}
    if (ar.contains("E") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("SE") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("S") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("SW") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("W") && y !=0) {
    map[y][x] = ' ';
    y--;
}
    if (ar.contains("NW") && y !=0) {
    map[y][x] = ' ';
    y--;
}
}
}

    




