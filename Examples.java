import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


// Josh Lovering
// CS 2102
// Homework 4

public class Examples {
	HeapChecker Tester = new HeapChecker();

	DataHeap myHeap = new DataHeap(3);
	DataBT myBT = new DataBT(3);
	DataBT myHeapLose3 = new DataBT(3);
	
	DataBT myHeapMissingFirstElement = new DataBT(6);
	MtHeap emptyHeap = new MtHeap();
	DataHeap myHeapAdded = new DataHeap(15);
	DataHeap oneValue = new DataHeap(4);
	
	DataHeap myHeap2 = new DataHeap(98);
	DataBT myBT2 = new DataBT(98);

	DataHeap myHeap3 = new DataHeap(4);
	DataBT myBT3 = new DataBT(4);

	public Examples() {

		myHeap.left = new DataHeap(4);
		myHeap.right = new DataHeap(3);
		myHeapLose3.left = new DataBT(4);
		myBT.left = new DataBT(4);
		myBT.right = new DataBT(3);
		((DataBT) myBT.left).left = new DataBT(5); 

		myBT2.right = new DataBT(99);
		myHeap2.left = new DataHeap(99);
		myHeap2.right = new DataHeap(98);

		myHeap3.left = new DataHeap(4);
		myHeap3.right = new DataHeap(4);
		myBT3.right = new DataBT(4);
	}


	// element 5 is added to heap
	@Test
	public void addElt1() {
		assertTrue(Tester.addEltTester(myHeap, 5, myBT));
	}

	// second heap is missing an element
	@Test
	public void addElt2() {
		assertFalse(Tester.addEltTester(myHeap, 6, myHeapMissingFirstElement));
	}

	// second heap is empty
	@Test
	public void addElt3() {
		assertFalse(Tester.addEltTester(myHeap, 7, emptyHeap));
	}

	// add to empty heap
	@Test
	public void addElt4() {
		assertTrue(Tester.addEltTester(emptyHeap, 15, myHeapAdded));
	}
	@Test
	public void addElt40() {
		assertTrue(Tester.addEltTester(emptyHeap, 15, emptyHeap.addElt(15)));
	}

	// remove min element
	@Test
	public void remMinElt1() {
		assertTrue(Tester.remMinEltTester(myHeap, myHeapLose3));
	}

	// remove the one and only item from heap
	@Test
	public void remMinElt2() {
		assertTrue(Tester.remMinEltTester(oneValue, emptyHeap));
	}

	// empty left heap, non empty right heap
	@Test
	public void remMinElt3() {
		assertFalse(Tester.remMinEltTester(emptyHeap, myHeap));
	}

	// two of min element before removal
	@Test
	public void remMinElt4() {
		assertTrue(Tester.remMinEltTester(myHeap2, myBT2));
	}

	// all values are the same
	@Test
	public void remMinElt5() {
		assertTrue(Tester.remMinEltTester(myHeap3, myBT3));
	}

}
