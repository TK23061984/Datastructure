package algorithms.singlyLinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LList02_Palindrome {

	Node left = null;
	
	@Test
	public void validatePalindrom_BestApproach(){
		SinglyLinkedList list = new SinglyLinkedList();
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		
		left = list.head;
		System.out.println("validatePalindrom_BestApproach :" + recursiveCheck(list.head));
	}
	
	//Solution 1
	private boolean recursiveCheck(Node currentNode){
		if(currentNode == null)
			return true;
		
		boolean isSublistPalindrome = recursiveCheck(currentNode.next);
		if(!isSublistPalindrome){
			return false;
		}
		
		boolean isEqual = left.value == currentNode.value;
		left = left.next;
		return isEqual;
	}
	
	@Test
	public void validatePalindrome_Approach2() {

		SinglyLinkedList list = new SinglyLinkedList();
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		list.push(new Node('B'));
		list.push(new Node('A'));
		
		Node middle = list.head;
		Node jumper = list.head;
		Node head2 = null;

		while (jumper != null && jumper.next != null) {
			jumper = jumper.next.next;
			middle = middle.next;
		}
		if (jumper != null) {
			head2 = middle.next; // For Odd number of nodes, we have to ignore the middle node
		} else {
			head2 = middle;   // For even number of nodes
		}

		Node reversed = getReverseList(head2);

		Assert.assertEquals(isPalindrome(list.head, reversed), true);

	}

	//Solution 2
	public boolean isPalindrome(Node head1, Node head2) {

		Boolean isValid = true;

		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {

			if (temp1.charValue == temp2.charValue) {

				temp1 = temp1.next;
				temp2 = temp2.next;
			} else {
				return false;
			}
		}

	

		return isValid;
	}

	public Node getReverseList(Node head) {

		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;

		}

		return prev;
	}

}