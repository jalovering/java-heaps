class MtBT implements IBinTree {
	MtBT() {
	}

	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
	}

	// returns 0 since empty tree has no elements
	public int size() {
		return 0;
	}

	// returns 0 since empty tree has no branches
	public int height() {
		return 0;
	}

	public boolean isHeap(int Data) {
		return true;
	}

	public int getDataIBin() {
		return -1;
	}

	public IBinTree getLeftIBin() {
		return new MtBT();
	}

	public IBinTree getRightIBin() {
		return new MtBT();
	}

	public boolean validIBin() {
		return false;
	}
}
