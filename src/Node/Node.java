package Node;

public class Node<T extends Comparable<T>> {
	public Node<T> left, right;
	public Color leftLink, rightLink; // true if left
	public T data;
	public boolean deleteFlag;
	
	public Node(T data) {
		this.data = data;
		leftLink = Color.BLACK;
		rightLink = Color.BLACK;
		left = null;
		right = null;
		deleteFlag = false;
	}
	
	public boolean twoRedLinks() {
		return leftLink == Color.RED && rightLink == Color.RED;
	}
	
	public void setTwoBlack() {
		leftLink = Color.BLACK;
		rightLink = Color.BLACK;
	}
	
	public Node<T> rotateLeft() {
		Node<T> newHead = this.right;
		right = right.left;
		newHead.left = this;
		
		newHead.leftLink = Color.RED;
		this.rightLink = Color.BLACK;
		
		return newHead;
	}

	public Node<T> rotateRight() {
		Node<T> newHead = this.left;
		left = left.right;
		newHead.right = this;
		
		newHead.rightLink = Color.RED;
		this.leftLink = Color.BLACK;
		
		return newHead;
	}
	
	public Node<T> add(T element) {
		if(element.compareTo(data) == 0) {
			return this;
		}
		else if(element.compareTo(data) < 0) {
			if(left == null) {
				left = new Node<T>(element);
				leftLink = Color.RED;
				return this;
			}
			else {
				left = left.add(element);
				if(left.twoRedLinks()) {
					leftLink = Color.RED;
					left.setTwoBlack();
				}
				
				if(leftLink == Color.RED && left.leftLink == Color.RED) {
					return rotateRight();
				}
				return this;
			}
		}
		else {
			if(right == null) {
				right = new Node<T>(element);
				rightLink = Color.RED;
				
				if(leftLink == Color.BLACK) {
					return rotateLeft();
				}
				
				return this;
			}
			else {
				right = right.add(element);
				if(right.twoRedLinks()) {
					rightLink = Color.RED;
					right.setTwoBlack();
					
					if(leftLink == Color.BLACK) {
						return rotateLeft();
					}
				}

				return this;
			}
		}
	}
	
	public boolean remove(T element) {
		if(element.compareTo(data) == 0) {
			if(deleteFlag) { // Already deleted
				return false;
			}
			deleteFlag = true;
			return true;
		}
		else if(element.compareTo(data) < 0) {
			return left != null ? left.remove(element) : false;
		}
		else {
			return right != null ? right.remove(element) : false;
		}
	}
	
	public String toString() {
		return data.toString();
	}
}
