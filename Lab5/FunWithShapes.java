import java.util.Arrays;

public class FunWithShapes {

	public static void main(String[] args) {
		
		GeometricShape[] gsCollection1 = new GeometricShape[5];
		gsCollection1[0] = new Circle("blue", false, 9.1);
		gsCollection1[1] = new Circle("yellow", true, 0);
		gsCollection1[2] = new Octagon("black", false, 100);
		gsCollection1[3] = new Octagon("red", false, 0);
		gsCollection1[4] = new Octagon("pink", false, 5);
		
		/**
		 * A test for max method
		 */
		System.out.println("**A test for max method**");
		System.out.println("Comparing " + gsCollection1[0].toString() + " Area: " + gsCollection1[0].getArea() + " and " + gsCollection1[1].toString() + " Area: " + gsCollection1[1].getArea() + ", ");
			
		System.out.println(GeometricShape.max(gsCollection1[0], gsCollection1[1]).toString() + " is larger" );
		
		System.out.println("Comparing " + gsCollection1[1].toString() + " Area: " + gsCollection1[1].getArea() + " and " + gsCollection1[2].toString() + " Area: " + gsCollection1[3].getArea() + ", ");
		System.out.println(GeometricShape.max(gsCollection1[1], gsCollection1[3]).toString() + " is larger" );

		System.out.println();
		/**
		 * A test for sumArea method
		 */
		System.out.println("**A test for sumArea method**");
		System.out.println("The total sum of the areas of a collection of GeometricShapes is " + GeometricShape.sumArea(gsCollection1));
		System.out.println();
		/**
		 * A test for compareTo method for Circle
		 */
		System.out.println("**A test for compareTo method for Circle**");
		System.out.println(gsCollection1[0].compareTo(gsCollection1[1]));
		/**
		 * A test for compareTo method for Octagon
		 */
		System.out.println("**A test for compareTo method for Octagon**");
		System.out.println(gsCollection1[3].compareTo(gsCollection1[4]));
		System.out.println();
		
		/**
		 * A test to demonstrate Array.sort by sorting the collection of shapes ascendingly by area
		 */
		System.out.println("**Array.sort demonstration**");
		System.out.println("Before sort: ");
		for (GeometricShape g : gsCollection1)
			System.out.println(g.toString() + " Area: " + g.getArea());
		Arrays.sort(gsCollection1);
		System.out.println("After sort: ");
		for (GeometricShape g : gsCollection1)
			System.out.println(g.toString() + " Area: " + g.getArea());
		System.out.println();
		
		/**
		 * A test for using the comparator to sort the collection in descending order.
		 */
		System.out.println("**The comparator demonstration**");
		System.out.println("Before sort: ");
		for (GeometricShape g : gsCollection1)
			System.out.println(g.toString() + " Perimeter: " + g.getPerimeter());
		Arrays.sort(gsCollection1, new ShapeComparator());
		System.out.println("After sort: ");
		for (GeometricShape g : gsCollection1)
			System.out.println(g.toString() + " Perimeter: " + g.getPerimeter());
		System.out.println();
		
		
		
	}

}
