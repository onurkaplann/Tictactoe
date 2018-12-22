package tictactoe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Oyuncu {

    public char harf;
    public boolean HumanOrCom;
    public String userID;
    static String entranceValueindex;

    public Oyuncu(String gelenUserID) {
        this.HumanOrCom = true;
        this.harf = 'X';
        this.userID = gelenUserID;
    }

    public Oyuncu(boolean HumanOrComTest, String gelenUserID) {
        this.userID = gelenUserID;
        this.HumanOrCom = HumanOrComTest;
        if (HumanOrComTest == true) {
            this.harf = 'X';
        } else {
            this.harf = 'O';
        }
    }

    public Oyuncu(boolean HumanOrComTest, char gelenHarf, String gelenUserID) {
        this.HumanOrCom = HumanOrComTest;
        this.harf = gelenHarf;
        this.userID = gelenUserID;
    }

    char harfAl() {
        return this.harf;
    }

    boolean HumanOrComCheck() {
        return this.HumanOrCom;
    }

    String playerActivator(int length, char[][] tahta) throws IOException {
        String x, y;
        do {
            Scanner oku = new Scanner(System.in);
            System.out.println("Hamle Giriniz: (Satir Boşluk Sütun)(Çıkış Yapmak İçin 9 Boşluk 9)(" + 0 + "-" + (length - 1) + ")");
            entranceValueindex = oku.nextLine();
            x = "" + entranceValueindex.charAt(0);
            y = "" + entranceValueindex.charAt(2);
            if (Integer.parseInt(x) == 9 && Integer.parseInt(y) == 9) {
                File file = new File("kayit.txt");
                FileWriter yaz = new FileWriter(file);
                yaz.write(length);
                for (int i = 0; i < tahta.length; i++) {
                    for (int j = 0; j < tahta.length; j++) {
                        yaz.write(tahta[i][j]);
                    }
                }
                yaz.write(" ");
                yaz.close();
                System.exit(0);
            }
        } while (Integer.parseInt(x) > length || Integer.parseInt(x) < 0 || Integer.parseInt(y) > length || Integer.parseInt(y) < 0);
        return entranceValueindex;
    }

    String getMoveinfo() {
        return this.entranceValueindex;
    }

    String comActivator(int max) {
        Random rand = new Random();
        int satir = rand.nextInt(max);
        int sutun = rand.nextInt(max);
        String comMove;
        comMove = Integer.toString(satir) + " " + Integer.toString(sutun);
        entranceValueindex = comMove;
        return comMove;
    }
}
