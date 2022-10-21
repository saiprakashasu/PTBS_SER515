import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProductIterator {

	private classProductList classProductList;
	//public ProductIterator() {

	//}

	public static Iterator<Integer> range(int start, int end) {
		return new Iterator<>() {
			private int index = start;

			@Override
			public boolean hasNext() {
				return index<end;
			}

			@Override
			public Integer next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return index++;
			}

		};
	}


	public Product Next() {
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

	//Iterating through meat and produce product names and displaying them
	public static void productIterate(ArrayList<String> productname) {
		var iterator = range(0, productname.toArray().length);
		int i=1;
		System.out.println("....Iterator pattern....");
		while (iterator.hasNext()) {
			System.out.println(i+"."+productname.get(iterator.next()));
			i++;
		}
	}


}
