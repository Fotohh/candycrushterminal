package game;

import java.util.Random;

public class CandyCrush {

    private boolean running;

    private int[][] array = new int[5][5];/* = {{1,2,4,3,2,1},
                             {3,5,3,4,5,2},
                             {4,2,1,3,1,1},
                             {5,1,2,4,5,4},
                             {2,4,3,5,4,2},
                             {1,4,2,4,5,3}};*/

    private final String[] types = {" ", "🍇","🍉","🍎","🍒","🥥"};
    
    private int score = 0;

    public CandyCrush() {
        running = true;
    }

    public void printBoard() {
        int cx = 0;
        int cy = 0;
        for(int a = 0; a < array.length; a++) {
            System.out.print("  "+cx + "  ");
            cx++;
        }
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(cy + " ");
            cy++;
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(types[array[i][j]] + "    ");
            }
            System.out.print(" \n\n"); 
        }
    }
    
    public void swapNumbers(int x1, int y1, int x2, int y2) {
        int value = array[y1][x1];
        int value2 = array[y2][x2];
        array[y1][x1] = value2;
        array[y2][x2] = value;
    }
    
    public boolean swap(int x1, int y1, String direction) {
        switch(direction) {
            case "up":
                if((y1 - 1) < 0) return false;
                swapNumbers(x1, y1, x1, y1 - 1);
                return true;
            case "down":
                if(y1 + 1 > array.length - 1) return false;
                swapNumbers(x1, y1, x1, y1 + 1);
                return true;
            case "left":
                if(x1 + 1 > array[y1].length - 1) return false;
                swapNumbers(x1, y1, x1 - 1, y1);
                return true;
            case "right":
                if(x1 - 1 < 0) return false;
                swapNumbers(x1, y1, x1 + 1, y1);
                return true;
        }
        return false;
    }
    
    private void p(String s) {
        System.out.println(s);
    }
    
    public void fill(){
        Random rand = new Random();
        for(int i = 0; i < array.length; i++) {
            for(int j =0; j < array[i].length; j++) {
                if(array[i][j] == 0) {
                    int val = rand.nextInt(5);
                    array[i][j] = val + 1;
                }
            }
        }
    }
    
    public void gravity() {
        for(int x = 0; x < array[0].length; x++) {
            int bottom = array.length;
            for(int y = array.length - 1; y >= 0; y--) {
                if(array[y][x] != 0) bottom = y;
                else {
                    for(int a = y; a >= 0; a--) {
                        if(array[a][x] == 0) continue;
                        else{
                            int val = array[a][x];
                            array[a][x] = 0;
                            array[bottom - 1][x] = val;
                            bottom--;
                        }
                    }
                }
            }
        }
    }
    
    public void crush(){
        for(int i = 0; i < array.length; i++) {
            int currentType = 0;
            int count = 0;
            for(int j = 0; j < array[i].length; j++) {
                if(array[i][j] == currentType) count++;
                if(array[i][j] != currentType || j == array[i].length - 1) {
                    int x = (j - 1) - count;
                    if(j == array.length - 1 && array[i][j] == currentType) {
                        x = j - count;
                    }
                    if(count >= 2) {
                        if(x < 0) x = 0;
                        for(int a = 0; a < count + 1; a++) {
                            array[i][x] = 0;
                            x++;
                        }
                    }
                    currentType = array[i][j];
                    count = 0;
                }
                if(array[i][j] == 0) {
                    count = 0;
                    currentType = 0;
                    continue;
                }}}
        for(int x = 0; x < array[0].length; x++) {
            int currentType = 0;
            int count = 0;
            for(int y = 0; y < array.length; y++) {
                if(array[y][x] == 0) continue;
                if(array[y][x] == currentType) count++;
                if(array[y][x] != currentType || y == array.length - 1) {
                    int b = (y - 1) - count;
                    if(y == array.length - 1 && array[y][x] == currentType) {
                        b = y - count;
                    }
                    if(count >= 2) {
                        if(b < 0) b = 0;
                        for(int a = 0; a < count + 1; a++) {
                            array[b][x] = 0;
                            b++;
                        }
                    }
                    currentType = array[y][x];
                    count = 0;
                }}}}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean validateCoords(int row, int col) {
        if(row > array.length || row < 0) return false;
        if(col > array[row].length || col < 0) return false;
        return true;
    }
}
