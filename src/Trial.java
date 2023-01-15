import java.util.*;

public class Trial { //https://medium.com/tapu-com-bak%C4%B1%C5%9F-a%C3%A7%C4%B1s%C4%B1/bfs-breath-first-search-geni%C5%9F-%C3%B6ncelikli-arama-algoritmas%C4%B1n%C4%B1-tan%C4%B1yal%C4%B1m-ec7050a41af
    // Labirent görselini bir String olarak tanımlayın
    // Bu örnekte, labirent görseli labirent.txt dosyasından okunmuştur
    private static String labirent =
            "11000000000000000000\n" +
                    "01110000000000000000\n" +
                    "00011110000000010000\n" +
                    "00010010000000010000\n" +
                    "00011010000000010000\n" +
                    "00001001000000011100\n" +
                    "00111000100000000100\n" +
                    "00100000000000000100\n" +
                    "00111111111111111100\n" +
                    "00100000000000100000\n" +
                    "00100000000000100000\n" +
                    "01110000000000111100\n" +
                    "00011110000000100100\n" +
                    "00010010000000100100\n" +
                    "00011011111111100100\n" +
                    "00001001000000000000\n" +
                    "00111001111111100000\n" +
                    "00100000010000100000\n" +
                    "00110000011000111900\n" +
                    "00000000000000000000\n";
    private static int[][] diziLabirent = new int[20][20];
    private static int[][] ziyaret = new int[20][20];
    private static int[] yon = {-1, 0, 1, 0};
    private static int[] xon = {0, 1, 0, -1};

    public static void main(String[] args) {
        // Labirent görselini diziLabirent dizisine atayın
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                diziLabirent[i][j] = labirent.charAt(i * 20 + j) - '0';
            }
        }

        // BFS algoritmasını kullanarak çıkışı bulun
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(0);
        qy.add(0);
        ziyaret[0][0] = 1;

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            if (diziLabirent[x][y] == 9) {
                // Çıkış bulundu
                for (int j = 0; j < ziyaret[x].length; j++) {
                    for (int k = 0; k < ziyaret[y].length; k++) {
                        if (qy.size()== 1) {
                            System.out.println("1");
                        }else{ System.out.println("");}}}

                System.out.println("Çıkış bulundu!");

                break;
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + xon[i];
                int dy = y + yon[i];

                if (dx >= 0 && dx < 20 && dy >= 0 && dy < 20 && ziyaret[dx][dy] == 0 && diziLabirent[dx][dy] != 1) {
                    ziyaret[dx][dy] = 1;
                    qx.add(dx);
                    qy.add(dy);
                }
            }
        }
    }
}
