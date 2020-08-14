package com.lams1989.mergetwosortedlinkedlist;

public class MergeTwoSorteDLinkedList {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

	}

	public static void main(String args[]) {

		SinglyLinkedList llist1 = new SinglyLinkedList();
		SinglyLinkedList llist2 = new SinglyLinkedList();
		int[] llistItem1 = { 2,4,6,8 };
		int[] llistItem2 = { 1,3,5,7,9 };

		for (int i = 0; i < llistItem1.length; i++) {
			SinglyLinkedListNode llist_head1 = insertNodeAtHead(llist1.head, llistItem1[i]);
			llist1.head = llist_head1;
		}
		for (int i = 0; i < llistItem2.length; i++) {
			SinglyLinkedListNode llist_head2 = insertNodeAtHead(llist2.head, llistItem2[i]);
			llist2.head = llist_head2;
		}

		printLinkedList(mergeLists(llist1.head, llist2.head)); 
		

	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
		
		    if (headA == null)
		        return headB;
		    else if (headB == null)
		        return headA;
		    else if (headA.data >= headB.data){
		        headA.next = mergeLists(headA.next, headB);
		        return headA;
		    } else {
		        headB.next = mergeLists(headA, headB.next);
		        return headB;
		    }
		}
	

	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode nodeInsert = new SinglyLinkedListNode(data);
		if (head == null) {
			return nodeInsert;
		}
		nodeInsert.next = head;
		return nodeInsert;
	}

	static void printLinkedList(SinglyLinkedListNode head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}
}
