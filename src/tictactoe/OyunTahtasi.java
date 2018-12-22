package tictactoe;

import java.util.*;

public class OyunTahtasi {

    public char[][] oyunTahtasi;
    public static int counter = 0;

    public OyunTahtasi(int gelenBoyut) {
        this.oyunTahtasi = new char[gelenBoyut][gelenBoyut];
    }

    public OyunTahtasi(char[][] gelenoyunTahtasi) {
        this.oyunTahtasi = new char[gelenoyunTahtasi.length][gelenoyunTahtasi.length];
        for (int i = 0; i < gelenoyunTahtasi.length; i++) {
            for (int j = 0; j < gelenoyunTahtasi.length; j++) {
                this.oyunTahtasi[i][j] = gelenoyunTahtasi[i][j];
            }
        }
    }

    public char[][] oyunTahtasiniAl() {
        return this.oyunTahtasi;
    }

    public void oyunTahtasiniYazdir() {
        for (int l = 0; l < oyunTahtasi.length; l++) {
            System.out.print(" " + l);
        }
        System.out.println();
        for (int i = 0; i < this.oyunTahtasi.length; i++) {
            for (int j = 0; j < this.oyunTahtasi.length; j++) {
                System.out.print(this.oyunTahtasi[i][j]);
                if (j != this.oyunTahtasi.length - 1) {
                    System.out.print("|");
                    continue;
                }
                System.out.print(" " + i);
            }
            System.out.print("\n");
            if (i != this.oyunTahtasi.length - 1) {
                for (int k = 0; k < 2 * this.oyunTahtasi.length - 1; k++) {
                    System.out.print("-");
                    continue;
                }
            }
            System.out.print("\n");
        }

    }

    boolean hamleyiYaz(String koordinat, Oyuncu gelenOyuncu) {
        String Abc;
        Abc = "" + koordinat.charAt(0);
        int koordinatx = Integer.parseInt(Abc);
        Abc = "" + koordinat.charAt(2);
        int koordinaty = Integer.parseInt(Abc);
        if (oyunTahtasi[koordinatx][koordinaty] != 'X' && oyunTahtasi[koordinatx][koordinaty] != 'O') {
            oyunTahtasi[koordinatx][koordinaty] = gelenOyuncu.harf;
            counter++;
            return true;
        }
        return false;
    }

    boolean kazanan(Oyuncu Player) {
        String geçici = new String();
        String geçici2 = new String();
        geçici = "" + Player.harf;
        for (int i = 0; i < oyunTahtasi.length - 2; i++) { // dikey
            for (int j = 0; j < oyunTahtasi.length; j++) {
                geçici2 = "" + this.oyunTahtasi[i][j];
                if (geçici.equals(geçici2)) {
                    geçici2 = "" + this.oyunTahtasi[i + 1][j];
                    if (geçici.equals(geçici2)) {
                        geçici2 = "" + this.oyunTahtasi[i + 2][j];
                        if (geçici.equals(geçici2)) {
                            System.out.println(Player.userID + " kazandı.");
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < oyunTahtasi.length; i++) { //yatay
            for (int j = 0; j < oyunTahtasi.length - 2; j++) {
                geçici2 = "" + this.oyunTahtasi[i][j];
                if (geçici.equals(geçici2)) {
                    geçici2 = "" + this.oyunTahtasi[i][j + 1];
                    if (geçici.equals(geçici2)) {
                        geçici2 = "" + this.oyunTahtasi[i][j + 2];
                        if (geçici.equals(geçici2)) {
                            System.out.println(Player.userID + " kazandı.");
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < oyunTahtasi.length - 2; i++) { //çapraz
            for (int j = 0; j < oyunTahtasi.length - 2; j++) {
                geçici2 = "" + this.oyunTahtasi[i][j];
                if (geçici.equals(geçici2)) {
                    geçici2 = "" + this.oyunTahtasi[i + 1][j + 1];
                    if (geçici.equals(geçici2)) {
                        geçici2 = "" + this.oyunTahtasi[i + 2][j + 2];
                        if (geçici.equals(geçici2)) {
                            System.out.println(Player.userID + " kazandı.");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean beraberlikKontrol() {
        if (counter == (this.oyunTahtasi.length) * (this.oyunTahtasi.length)) {
            return true;
        } else {
            return false;
        }
    }
}
