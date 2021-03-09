import java.util.Scanner;
import java.util.Arrays;

public class SortArray {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap so n: ");
		int n = scanner.nextInt();
		double arr[] = new double[n];
		for (int i=0; i<n; i++) {
			System.out.print("nhap so a[" + (i+1) + "]:");
			arr[i] = scanner.nextDouble();
		}
		Arrays.sort(arr);
		double sum = 0;
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
			sum += arr[i];
		}
		System.out.println("tong cac phan tu trong mang: " + sum);
		System.out.println("trung binh cac phan tu trong mang: " + (sum/n));
	}

}
