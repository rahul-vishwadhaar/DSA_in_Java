public class Abstract {

	public static void main(String args[]) {

		String pool1 = "pool";
		String pool2 = "pool";

		String obj1 = new String("pool");
		String obj2 = new String("pool");

		if (obj1 == obj2)
			System.out.println("ob1 == obj2");
		else
			System.out.println("ob1 != obj2");

		if (obj1 == pool1)
			System.out.println("obj1 == pool1");
		else
			System.out.println("obj1 != pool1");

		if (pool1 == pool2)
			System.out.println("pool1 == pool2");
		else
			System.out.println("pool1 != pool2");

	}

}
