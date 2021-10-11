package com.bookspriorityqueue;

public class PriorityQueueMain {

	public static void main(String[] args) {
		PriorityQueueImpl priorityQueueImpl = new PriorityQueueImpl();
		priorityQueueImpl.insert(new Books(1, "abc", 50, "Xyz", 200));
		priorityQueueImpl.insert(new Books(2, "abcd", 40, "Xyz1", 300));
		priorityQueueImpl.insert(new Books(3, "abc1", 20, "Xyz2", 400));
		priorityQueueImpl.insert(new Books(4, "abc2", 70, "Xyz3", 200));
		priorityQueueImpl.traverse();
		System.out.println("------------------------------");
		priorityQueueImpl.delete();
		System.out.println();
		priorityQueueImpl.traverse();
		System.out.println("------------------------------");
		priorityQueueImpl.delete();
		System.out.println();
		priorityQueueImpl.traverse();
		System.out.println("------------------------------");
		priorityQueueImpl.delete();
		System.out.println();
		priorityQueueImpl.traverse();
		System.out.println("------------------------------");
		priorityQueueImpl.delete();
		System.out.println();
		priorityQueueImpl.traverse();
	}

}
