package com.laioffer.section22.exerciseVI;
import java.util.*;

public class MaximumValuesOfSizeKSlidingWindows {
	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> result = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < array.length; i++) {
			while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if(!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if(i >= k - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		return result;
	}
}
