import java.util.Scanner;

/*public class Sample1 {
	public static void main(String args[]) {
		
		long i; 
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter order of square matrix.");
		int n = ob.nextInt();
		System.out.println("Enter the elements in the matrix.");
		int mat[][] = new int[n][n];

		for (int i = 0; i < n; i++)// Entering the matrix from user.
		{
			for (int j = 0; j < n; j++) {
				mat[i][j] = ob.nextInt();
			}
		}
		System.out.println("The matrix entered is-");
		for (int i = 0; i < n; i++)// Printing the matrix entered.
		{
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		int trace = 0;
		for (int i = 0; i < n; i++)// Calculate trace of the matrix
		{
			trace = trace + mat[i][i];
		}
		System.out.println("The trace of the matrix is " + trace);

		ob.close();
	}
}
*/

class Box{
	int w;
	int h;
	int l;
}

class Sample1{}