package Tree;

import Node.Node;

/**
 * Tree class responsible for storing the root node and all tree-oriented operations.
 * @author Jeffrey Tran
 *
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {
	public Node<T> rootNode; 
	
	
	public Tree() {
		rootNode = null;
	}
	
	public Tree(T element) {
		rootNode = new Node<T>(element);
	}
	
	public T search(T element) {
		return rootNode == null? null : rootNode.search(element).getData();
	}
	
	public boolean add(T element) {		
		if(rootNode == null) {
			rootNode = new Node<T>(element);
			return true;
		}
		
		rootNode = rootNode.add(element);
		if(rootNode.twoRedLinks()) {
			rootNode.setTwoBlack();
		}
		
		return true;
	}

	public boolean delete(T element) {
		return remove(element);
	}
	
	public boolean remove(T element) {
		return rootNode.remove(element);
	}
	
	public String toString() {
		return rootNode == null? "null tree" : rootNode.toString();
	}
}
