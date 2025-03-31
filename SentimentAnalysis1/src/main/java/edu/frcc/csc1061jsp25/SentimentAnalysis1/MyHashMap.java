package edu.frcc.csc1061jsp25.SentimentAnalysis1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap <K,V> implements Map<K,V> {
	private static final int INITIAL_NUM_BUCKETS = 4; 
	private static final double LOAD_FACTOR_THRESHOLD = 0.5;
	
	private LinkedList<Entry<K,V>>[] buckets;
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
		if (get(key) != null) {
			return true;
		}
		return false; 
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; ++i) {
			if (buckets[i] != null) {
				LinkedList<Entry<K,V>> bucket = buckets[i];
				for (Entry<K,V> entry : bucket) {
					if (entry.getValue().equals(value)) {
						return true; 
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K,V>> bucket = buckets[bucketIndex]; 
		for (Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry.getValue(); 
			}
		}
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
		if (size == LOAD_FACTOR_THRESHOLD) {
			this.rehash(); 
		}
		
		// If key does not exist, insert key and value 
		buckets[bucketIndex].add(new Entry<K,V>(key, value)); 
		size++; 
		return null; 
	}

	private void rehash(){
		LinkedList<Entry<K,V>>[] newArray = new LinkedList[buckets.length * 2]; 
		int newArraySize = 0; 
		int index = -1; 
		
		for (int i = 0; i < buckets.length; i++) { 
			for (Entry<K, V> entry : buckets[i]) {
				index = entry.getKey().hashCode() % newArray.length; 
				if (buckets[index] == null) {
					buckets[index] = new LinkedList<Entry<K,V>>();
				}
//				if (newArray[index] != null) {
//					newArray[index].add(entry);
//				}
//				else {
//					newArray[index].add(entry); 
//				}
				// TODO: check if this needs to be done
				newArray[index].add(entry); 
			}
		buckets = newArray; 
		}
	}
	
	public int getNumBuckets() {
		return buckets.length; 
	}
	
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
			buckets[bucketIndex].remove(buckets[bucketIndex].get(listIndex)); 
			size--; 
			return oldVal;
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
	
		for (int i = 0; i < otherMap.size(); i++) {
			Set<? extends Map.Entry<? extends K, ? extends V>> entries = otherMap.entrySet(); 
			for (Map.Entry<? extends K, ? extends V> entry: entries) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	@Override
	public void clear() {
		for (LinkedList<Entry<K,V>> bucket: buckets) {
			bucket = null; 
		}
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>(); 
		
		for (int i = 0; i < buckets.length; ++i) {
			if (buckets[i] != null) {
				LinkedList<Entry<K,V>> bucket = buckets[i];
				for (Entry<K,V> entry : bucket) {
					keySet.add(entry.getKey()); 
				}
			}
		}
		return keySet; 
	}

	@Override
	public Collection<V> values() {
		Collection<V> collection = new ArrayList<V>();
		
		for (int i = 0; i < buckets.length; ++i) {
			if (buckets[i] != null) {
				LinkedList<Entry<K,V>> bucket = buckets[i]; 
				for (Entry<K,V> entry : bucket) {
					collection.add(entry.getValue());
				}
			}
		}
		return collection; 	
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		
		for (int i = 0; i < buckets.length; ++i) {
			if (buckets[i] != null) {
				LinkedList<Entry<K,V>> bucket = buckets[i];
				for (Entry<K,V> entry : bucket) {
					set.add(entry); 
				}
			}
		}
		return set; 
	}
	
	
	
}
