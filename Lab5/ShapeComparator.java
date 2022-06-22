import java.util.Comparator;

public class ShapeComparator implements Comparator<GeometricShape>{

	@Override
	public int compare(GeometricShape shape1, GeometricShape shape2) {
		return Double.compare(shape2.getPerimeter(), shape1.getPerimeter());
	}
	

}
