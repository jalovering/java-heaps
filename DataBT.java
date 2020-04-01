class DataBT implements IBinTree {
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	public int getDataIBin() {
		return data;
	}

	public IBinTree getLeftIBin() {
		return left;
	}

	public IBinTree getRightIBin() {
		return right;
	}

	public boolean validIBin() {
		return true;
	}

	// true if input is a heap
	public boolean isHeap(int data) {
		if (data == 0 || this.data >= data) {
			return this.left.isHeap(this.data) && this.right.isHeap(this.data);
		}
		return false;
	}
}