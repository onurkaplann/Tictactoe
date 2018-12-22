package tictactoe;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.nio.file.Paths;

public class Proje4 {
       public static void main(String args[]) throws IOException{
		System.out.println("\t\t***Tic Tac Toe'ya hoşgeldiniz***\n\n");
		OyunTahtasi tahta = null;
		Scanner reader=new Scanner(System.in);
		int tahtaBoyutu;
		File tmpDir = new File("kayit.txt");
	    boolean exists = tmpDir.exists();
	    if (exists){
	    	System.out.println("Kaydedilen Oyundan Devam Etmek için '1' Yeni Oyun başlatmak için '0' giriniz");
	    	if(reader.nextInt()==1){
	    		reader.nextLine();
	    		BufferedReader reader1 = null;
	            reader1 = new BufferedReader(new FileReader(tmpDir));
	            tahtaBoyutu=reader1.read();
	            char[][] kayitMatris=new char[tahtaBoyutu][tahtaBoyutu];
	            String satir = reader1.readLine();
	            int k=1;
	            for (int i = 0; i < kayitMatris.length; i++) {
					for (int j = 0; j < kayitMatris.length; j++) {
						kayitMatris[i][j]=satir.charAt(k);
						k++;
					}
				}
	            tahta=new OyunTahtasi(kayitMatris);
	            //tahta.oyunTahtasiniYazdir();
	    	}
	    	else{
	    		do{
	    			System.out.print("Oynanacak Oyun Tahtasının Boyutu Giriniz:");
	    			tahtaBoyutu=reader.nextInt();
	    			reader.nextLine();
	    			}while(tahtaBoyutu!=3 && tahtaBoyutu!=5 && tahtaBoyutu!=7);
	    			tahta=new OyunTahtasi(tahtaBoyutu);
	    			for (int i = 0; i < tahta.oyunTahtasi.length; i++) {
	    				for (int j = 0; j < tahta.oyunTahtasi.length; j++) {
	    					tahta.oyunTahtasi[i][j]=' ';
	    				}
	    			}
	    	}
	    }
	    else{
		do{
		System.out.print("Oynanacak Oyun Tahtasının Boyutu Giriniz:");
		tahtaBoyutu=reader.nextInt();
		reader.nextLine();
		}while(tahtaBoyutu!=3 && tahtaBoyutu!=5 && tahtaBoyutu!=7);
		tahta=new OyunTahtasi(tahtaBoyutu);
		for (int i = 0; i < tahta.oyunTahtasi.length; i++) {
			for (int j = 0; j < tahta.oyunTahtasi.length; j++) {
				tahta.oyunTahtasi[i][j]=' ';
			}
		}
	    }
		System.out.print("Oyuncu Adı ve isterseniz Harf(X-O) Giriniz:");
		String userPlayerData=reader.nextLine();
		String parts[]=userPlayerData.split(" ");
		Oyuncu playerHuman=null;
		if(parts.length==1){
			playerHuman=new Oyuncu(true,parts[0]);
		}
		else{
			playerHuman=new Oyuncu(true,parts[1].charAt(0),parts[0]);
		}
                Oyuncu playerCom=null;
                if(playerHuman.harf=='X'){
                    	playerCom=new Oyuncu(false,'O',"Computer");
                }
                else if(playerHuman.harf=='O'){
                    	playerCom=new Oyuncu(false,'X',"Computer");
                }
		tahta.oyunTahtasiniYazdir();
		int move;
		boolean test=true;
		move=1;
		while(test){
			switch(move){
				case 0:{//Computer's Move
				do{
				   test=tahta.hamleyiYaz(playerCom.comActivator(tahtaBoyutu), playerCom);
				}while(!test);
				test=!(tahta.kazanan(playerCom));
				if(test){
				test=!(tahta.beraberlikKontrol());
				}
				tahta.oyunTahtasiniYazdir();
				   move=1;
				break;
				}
				case 1:{//Player's Move
					do{
						test=tahta.hamleyiYaz(playerHuman.playerActivator(tahtaBoyutu,tahta.oyunTahtasi),playerHuman);
					}while(!test);
					test=!(tahta.kazanan(playerHuman));
					if(test){
					test=!(tahta.beraberlikKontrol());
					}
					tahta.oyunTahtasiniYazdir();
					move=0;
				break;
				}
			}
		}
	}
}


