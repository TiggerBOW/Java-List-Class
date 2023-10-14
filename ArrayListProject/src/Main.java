import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		List<Object> liste = new List<Object>();
		
		liste.add(2);	
		liste.add(4);
		liste.set(1,12);

		System.out.println(liste.findObjectsWithTypeReturnList(Integer.class).printedArray());
	}
}
