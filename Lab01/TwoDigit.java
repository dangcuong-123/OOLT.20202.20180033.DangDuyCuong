import java.util.Scanner;

public class TwoDigit {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("nhap so a: ");
		double a = scanner.nextDouble();
		System.out.print("nhap so b: ");
		double b = scanner.nextDouble();
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		if(b == 0) {
			System.out.println("Khong the tinh thuong cua a, b (b phai khac 0)");
		}
		else {
			System.out.println("a / b = " + (a / b));
		}
	}
}
