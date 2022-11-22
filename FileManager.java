package week13;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
	public static void makeFile() {
		try {
			Scanner sc = new Scanner(System.in);
			String id,pw;
			
			File f = new File("data.txt");
			if(!f.exists()) f.createNewFile();
			
			FileWriter fwr = new FileWriter(f,true);
			PrintWriter pwr = new PrintWriter(fwr);
			
			System.out.print("아이디 : ");
			id =sc.next();
			System.out.println("비밀번호 : ");
			pw = sc.next();
			
			pwr.println(id);
			pwr.println(pw);
			
			pwr.close();
			sc.close();
			
		}catch (IOException e) {e.printStackTrace();}
	}
	public static void readFile() {
		try {
			String id,pw;
			File f = new File("data.txt");
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				id=sc.next();
				pw = sc.next();
				System.out.println(id + " " + pw);
			}sc.close();
			
		}catch (IOException e) {e.printStackTrace();}
		
	}
	public static void main(String[] args) {
		makeFile();
		readFile();
}
}

