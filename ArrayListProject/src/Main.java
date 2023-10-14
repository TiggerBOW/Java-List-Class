import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		List<Object> liste = new List<Object>();
		
		liste.add(2);	
		liste.add(4);
		liste.add("Ömer");
		liste.add("Bilal");
		
		liste.removeAt(0);
		liste.removeAt(0);

		
		System.out.println(liste.findObjectsWithTypeReturnList(String.class).printedArray());
	}
}
