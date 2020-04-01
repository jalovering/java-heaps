import java.util.LinkedList;

public class HeapChecker {

	LinkedList<Integer> list = new LinkedList<Integer>();
	int track;

	// check if hAdded is hOrig with value elt added
	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		if (hAdded.isHeap(0)) {
			heapToList(hOrig);
			list.add(elt);
			if (includesAll(hAdded)) {
				if (list.size() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	// true if hRemoved is hOrig with smallest element removed
	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		if (hRemoved.isHeap(-1)) {
			track = 0;
			heapToListForRemoval(hOrig);
			return includesAll(hRemoved);
		}
		return false;
	}

	// turn heap into list of values, recursive
	void heapToList(IHeap root) {
		if (!root.isEmpty()) {
			list.add(root.getData());
			heapToList(root.getLeft());
			heapToList(root.getRight());
		}
	}

	// turn heap into list of values for removal, recursive
	void heapToListForRemoval(IHeap root) {
		if (!root.isEmpty()) {
			if (track == 0) {
				track += 1;
				heapToList(root.getLeft());
				heapToList(root.getRight());
			}

			if (track > 0) {
				list.add(root.getData());
				heapToList(root.getLeft());
				heapToList(root.getRight());
			}
		}
	}

	// true if given heap contains value
			boolean heapContains(IBinTree root) {
				if (root.validIBin()) {
					for (int i = 0; i < list.size(); i++) {
						if (root.getDataIBin() == list.get(i)) {
							list.remove(i);
							return false;
						}
					}
				}
				return true;
			}
			
	// true if all items in list are in given heap
	boolean includesAll(IBinTree obj) {
		if (obj.validIBin()) {
			if (heapContains(obj)) {
				return false;
			}
			return includesAll(obj.getLeftIBin()) && includesAll(obj.getRightIBin());
		}
		return true;
	}
}
