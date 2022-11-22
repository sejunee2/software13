package week132;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void regUser() {
		try {
			Scanner sc = new Scanner(System.in);
			String id,pw,pw1;
			
			File f =new File("data.txt");
			if (!f.exists())f.createNewFile();
			
			FileWriter fwr = new FileWriter(f,true);
			PrintWriter pwr = new PrintWriter(fwr);
			
			System.out.print("아이디 : ");
			id =sc.next();
			System.out.println("비밀번호 : ");
			pw = sc.next();
			System.out.println("비밀번호 확인 : ");
			pw1 = sc.next();
			
			if (ul.isExistID(id)) {
				System.out.println("이미 사용하고 있는 아이디");
			}else {
				if (!pw.equals(pw1)) System.out.println("비밀번호 불일치");
				else {
					pwr.println(id);
					pwr.println(pw);
					System.out.println("사용자 등록 완료");
				}
			}
			
			pwr.println(id);
			pwr.println(pw);
			
			pwr.close();
			sc.close();
			
		}catch (IOException e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile();
		regUser();
	}
	public static void readFile() {
		User u;
		UserList ul = new UserList();
		
		try {
			String id,pw;
			
			File f = new File("data.txt");
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				id= sc.next();
				pw = sc.next();
				
				u=new User(id,pw);
				ul.addUser(u);
			}
			ul.print();
			sc.close();
		}catch(IOException e) {e.printStackTrace();}
	}
}
class User{
	String id;
	String pw;
	
	User(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	void print() {System.out.println(id + " " + pw);}
}
class UserList{
	ArrayList<User>ul = new ArrayList<>();
	
	void addUser(User u) {ul.add(u);}
	void print() {
		System.out.println("==print using class==");
		for(User u : ul)u.print();
	}
}
	
	
	
	
	