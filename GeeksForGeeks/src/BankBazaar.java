import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class BankBazaar {

	/**
	 * @param args
	 */

	private static HashSet<Point> set = null;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		char[][] grid = null;
		// int testCases = in.nextInt();
		Point root = null;

		/*
		 * * while (testCases-- > 0) { int N = in.nextInt(); int M =
		 * in.nextInt(); grid = new char[N][M];
		 * 
		 * for (int i = 0; i < N; i++) { char[] row = in.next().toCharArray();
		 * for (int j = 0; j < M; j++) { char ch = row[j]; grid[i][j] = ch; if
		 * (ch == 'B') { root = new BankBazaar().new Point(i, j); } } }
		 * 
		 * System.out.println(getDistance(grid, root, N, M)); }
		 */

		char[][] matrix = new char[][] {
				new char[] { '.', 'B', '.', '.', '.' },
				new char[] { '.', '.', 'D', '.', '.' },
				new char[] { '.', 'D', '.', '.', '.' },
				new char[] { '.', '.', 'D', '.', '.' },
				new char[] { '.', '.', '.', '.', 'C' } };

		root = new BankBazaar().new Point(0, 1);
		System.out.println(getDistance(matrix, root, 5, 5));
	}

	private static int getDistance(char[][] grid, Point root, int row, int col) {

		set = new HashSet<Point>();
		int distance = 0;
		int len = 0;
		boolean flag = false;
		Point current = null;
		Point tempPoint = null;
		if (root == null)
			return 0;

		ArrayList<Point> queue = new ArrayList<Point>();

		queue.add(root);
		len = queue.size();

		while (queue.size() != 0) {

			if (len == 0) {
				len = queue.size();
				distance++;
			}

			current = queue.get(0);
			if (grid[current.x][current.y] == 'C') {
				flag = true;
				break;
			}

			queue.remove(0);
			len--;

			tempPoint = getPoint(current.x, current.y + 1, grid, row, col);
			if (tempPoint != null) {
				queue.add(tempPoint);
				set.add(tempPoint);
			}

			tempPoint = getPoint(current.x, current.y - 1, grid, row, col);
			if (tempPoint != null) {
				queue.add(tempPoint);
				set.add(tempPoint);
			}

			tempPoint = getPoint(current.x + 1, current.y, grid, row, col);
			if (tempPoint != null) {
				queue.add(tempPoint);
				set.add(tempPoint);
			}

			tempPoint = getPoint(current.x - 1, current.y, grid, row, col);
			if (tempPoint != null) {
				queue.add(tempPoint);
				set.add(tempPoint);
			}
		}

		if (flag)
			return distance;
		return -1;
	}

	private static Point getPoint(int x, int y, char[][] grid, int row, int col) {

		if ((x >= row) || (y >= col))
			return null;

		if ((x < 0) || (y < 0))
			return null;

		if (grid[x][y] == 'D')
			return null;

		return new BankBazaar().new Point(x, y);

	}

	private class Point {

		int x = 0;
		int y = 0;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = x * prime;
			result += y * prime;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
