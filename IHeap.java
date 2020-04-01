interface IHeap extends IBinTree {

	IHeap addElt(int e);

	IHeap remMinElt();

	IHeap merge(IHeap withHeap);

	boolean isBigger(int e);

	int getData();

	boolean isEmpty();

	IHeap getRight();

	IHeap getLeft();

}