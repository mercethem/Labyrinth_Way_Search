import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Integer[][] arrayLabyrinth = new Integer[20][20];
        int[][] visit = new int[20][20];
        int[] yDirectory = {-1, 0, 1, 0};
        int[] xDirectory = {0, 1, 0, -1};
        ArrayList<Integer> dataList = new ArrayList<Integer>();

        try {
            File readedFile = new File("E:\\Labyrinth\\src\\data.txt");
            Scanner scan = new Scanner(readedFile);
            int i = 0;
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                for (int j = 0; j < 20; j++) {
                    int x = data.charAt(j);
                    if (x == 49) {
                        x = 1;
                    } else if (x == 48) {
                        x = 0;
                    } else x = 9;
                    dataList.add(x);
                    arrayLabyrinth[i][j] = x;
                }
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("LABİRENT ÇÖZÜMSÜZ!");
            e.printStackTrace();
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(0);
        qy.add(0);
        visit[0][0] = 1;

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            if (arrayLabyrinth[x][y] == 9) {
                // Çıkış bulundu
                System.out.println("LABİRENT ÇÖZÜLDÜ!" + " \n" + "x : " + x + " " + " y:  " + y);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + xDirectory[i];
                int dy = y + yDirectory[i];

                if (dx >= 0 && dx < 20 && dy >= 0 && dy < 20 && visit[dx][dy] == 0 && arrayLabyrinth[dx][dy] != 1) {
                    visit[dx][dy] = 1;
                    qx.add(dx);
                    qy.add(dy);
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (arrayLabyrinth[i][j] == 1) {
                    System.out.print(" 1 ");
                } else if (arrayLabyrinth[i][j] == 9) {
                    System.out.println(" 9 ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }
}

