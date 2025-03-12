package edu.frcc.csc1061jsp25.MyHashMap;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap <K,V> implements Map<K,V> {
	private static final int INITIAL_NUM_BUCKETS = 4; 
	private static final double LOAD_FACTOR_THRESHOLD = 0.5;
	
	private List<Entry<K,V>>[] buckets;
	private int size = 0; 
	
	private class Entry<K,V> implements Map.Entry<K,V> {
		K key; 
		V value; 
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value; 
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldVal = this.value;
			this.value = value; 
			return oldVal; 
		}
	}
	
	// Constructor
	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS]; 
	}

	@Override
	public int size() {
		return size; 
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

	@Override
	public boolean containsKey(Object key) {
		
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; 
		
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = new LinkedList<Entry<K,V>>();
		}
		
		// If key already exists in Map, replace value and return old value. 
		for (Entry<K,V> entry: buckets[bucketIndex]) {
			if (entry.key.equals(key)) {
				V oldVal = entry.getValue();
				entry.value = value;
				return oldVal; 
			}
		}
		
		// Check load factor 
		// Load factor = num entries in map / number of buckets 
		// int loadFactor = 
		// if (loadFactor > LOAD_FACTOR_THRESHOLD) rehash();
		
		// If key does not exist, insert key and value 
		buckets[bucketIndex].add(new Entry<K,V>(key, value)); 
		size++; 
		return null; 
	}

	// public void rehash(){}
	
	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; 
		int listIndex = -1;

		if (buckets[bucketIndex] != null) {
			for (Entry<K,V> entry: buckets[bucketIndex]) {
				listIndex++; 
				if (entry.key.equals(key)) {
					break; 
				}
			}
			V oldVal = buckets[bucketIndex].get(listIndex).value;
			buckets[bucketIndex].remove(buckets[bucketIndex].get(listIndex); 
			size--; 
			return val;
			return null;
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
