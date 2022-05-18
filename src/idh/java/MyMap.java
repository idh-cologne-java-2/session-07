package idh.java;

import java.util.LinkedList;
import java.util.List;









public class MyMap<K, V> {
	int n = 16;
	List[] buckets;
	
	public MyMap()  {
		init();
	}
	
	public MyMap(int n) {
		this.n = n;
		init();
	}
	
	private void init() {
		buckets = new List[n];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<Node<K,V>>();
		}
	}
	
	public void put(K key, V value) {
		int keyHash = key.hashCode();
		int bucketIndex = keyHash & buckets.length-1;
		List<Node<K,V>> bucketList = buckets[bucketIndex];
		for (Node<K,V> node : bucketList) {
			if (node.key.equals(key)) {
				node.value = value;
				return;
			}
		}
		bucketList.add(new Node<K,V>(key, value));
		
	};
	
	static class Node<K,V> {
		K key;
		V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
