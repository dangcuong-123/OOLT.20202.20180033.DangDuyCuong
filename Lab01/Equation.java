import java.util.Scanner;
import java.math.*;

public class Equation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Giai phuong trinh bac nhat ax + b = 0 (a khac 0)");
		System.out.println("nhap so a: ");
		double a = scanner.nextDouble();
		System.out.println("nhap so b: ");
		double b = scanner.nextDouble();
		System.out.println("x = " + -b/a);
		
		System.out.println("Giai he phuong trinh bac nhat a11x1 + a12x2 = b1 | a21x1 + a22x2 = b2");
		System.out.println("nhap so a11: ");
		double a11 = scanner.nextDouble();
		System.out.println("nhap so a12: ");
		double a12 = scanner.nextDouble();
		System.out.println("nhap so b1: ");
		double b1 = scanner.nextDouble();
		System.out.println("nhap so a21: ");
		double a21 = scanner.nextDouble();
		System.out.println("nhap so a22: ");
		double a22 = scanner.nextDouble();
		System.out.println("nhap so b2: ");
		double b2 = scanner.nextDouble();
		
		double d = a11*a22 - a21*a12;
		double d1 = b1*a22 - b2*a12;
		double d2 = a11*b2 - a21*b1;
		if(d != 0) {
			System.out.println("x1 = " + d1/d);
			System.out.println("x2 = " + d2/d);
		}
		else {
			if(d == d1 && d1 == d2) {
				System.out.println("infinitely");
			}
			else {
				System.out.println("no solution");
			}
		}
		
		System.out.println("Giai phuong trinh bac hai ax^2 + bx + c = 0");
		System.out.println("nhap so a: ");
		a = scanner.nextDouble();
		System.out.println("nhap so b: ");
		b = scanner.nextDouble();
		System.out.println("nhap so c: ");
		double c = scanner.nextDouble();
		double delta = b*b - 4*a*c;
		if(delta == 0) {
			System.out.println("x1 = x2 = " + -b/(2*a));
		}
		else if(delta > 0) {
			System.out.println("x1 = " + (-b + Math.sqrt(delta))/(2*a));
			System.out.println("x2 = " + (-b - Math.sqrt(delta))/(2*a));
		}
		else {
			System.out.println("No solution");
		}
		System.exit(0);
	}
}
