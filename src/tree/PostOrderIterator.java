package tree;

import java.util.Stack;

public class PostOrderIterator {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(10);
		root.right= new Node(30);
		root.left.left= new Node(24);
		root.left.right= new Node(25);
		root.left.left.left= new Node(28);
		root.left.left.right= new Node(27);
		root.left.right.left= new Node(32);
		root.left.right.right= new Node(34);
		root.right.left= new Node(42);
		root.right.right= new Node(45);
		root.right.right.left= new Node(50);
		root.right.right.right= new Node(60);
		
		postOrderIterator(root);
		
		System.out.println("\n ***************");
		printPostOrder(root);

	}
	
	static void printPostOrder(Node root) {
		if(root== null) return;
		Stack<Node> s= new Stack<>();
		while(true) {
			if(root!= null) {
				s.push(root);
				root= root.left;
			} else {
				if(s.isEmpty()) break;
				Node top= s.peek();
				if(top.right!= null) {
					root= top.right;
				} else {
					System.out.print(top.data+" ");
					s.pop();
					while(top!= null && !s.isEmpty() && s.peek().right.data== top.data) {
						top= s.pop();
						System.out.print(top.data+" ");
					}
				}
			}
		}
	
	}
	
	private static void postOrderIterator(Node root) {
		if(root== null) return;
		Stack<Node> s= new Stack<>();
		while(true) {
			if(root!= null) {
				s.push(root);
				root= root.left;
			} else {
				if(s.isEmpty()) break;
				Node tmp= s.peek().right;
				if(tmp== null) {
					tmp= s.pop();
					System.out.print(tmp.data+" ");
					while(!s.isEmpty() && s.peek().right.data== tmp.data) {
						tmp= s.pop();
						System.out.print(tmp.data+" ");
					}
				} else {
					root= tmp;
				}
			}
		}
	}

}
