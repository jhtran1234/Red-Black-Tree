package Tree;

import Node.Color;
import Node.Node;

public class Tree<T extends Comparable<T>> {
	public Node<T> rootNode; 
	
	
	public Tree() {
		
	}
	
	public Tree(T element) {
		rootNode = new Node<T>(element);
	}
	
	public boolean search(T element) {
		return false;
	}
	
	public boolean add(T element) {
		if(search(element)) {
			return false;
		}
		
		if(rootNode == null) {
			rootNode = new Node<T>(element);
			return true;
		}
		
		rootNode = rootNode.add(element);
		
		if(rootNode.twoRedLinks()) {
			rootNode.setTwoBlack();
		}
		else if(rootNode.rightLink == Color.RED) {
			rootNode = rootNode.rotateLeft();
		}
		
		return true;
	}

	public boolean delete(T element) {
		return remove(element);
	}
	
	public boolean remove(T element) {
		return rootNode.remove(element);
	}	
}
