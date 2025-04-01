package edu.frcc.csc1061jsp25.SentimentAnalysis1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap <K,V> implements Map<K,V> {
	// Constants 
	private static final int INITIAL_NUM_BUCKETS = 4; 
	private static final double LOAD_FACTOR_THRESHOLD = 0.5; // Ensures as few 
															 // Collisions as possible
	// Array of linked lists 
	private LinkedList<Entry<K,V>>[] buckets;
	private int size = 0; 
	
	// Entry is the node that is stored in the linked list 
	private class Entry<K,V> implements Map.Entry<K,V> {
		K key;   // Used to find the value
		V value; // The data itself 
		
		// Constructor 
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
	@SuppressWarnings("unchecked")
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
	public boolean containsKey(Object key) { // Checks if the key is used 
		if (get(key) != null) {
			return true;
		}
		return false; 
	}

	@Override
	public boolean containsValue(Object value) { // Parses list for the value 
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

	// Uses key to retrieve an object 
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

	// Equivalent to an add method 
	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; 
		// Initialization of list if necessary 
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
		
		// Checks the load factor to minimize collisions 
		if (size == LOAD_FACTOR_THRESHOLD) {
			this.rehash(); 
		}
		
		// If key does not exist, insert key and value 
		buckets[bucketIndex].add(new Entry<K,V>(key, value)); 
		size++; 
		return null; 
	}

	// If there are too many elements in the map and collisions are more likely;
	// The program will create a new hashmap, with bigger size and reallocate the 
	// Elements 
	private void rehash(){
		// New array with double the size as the old array 
		LinkedList<Entry<K,V>>[] newArray = new LinkedList[buckets.length * 2]; 
		int index = -1; 
		
		// Actual reallocation of the elements 
		for (int i = 0; i < buckets.length; i++) { 
			for (Entry<K, V> entry : buckets[i]) { 
				index = entry.getKey().hashCode() % newArray.length; 
				if (buckets[index] == null) {
					buckets[index] = new LinkedList<Entry<K,V>>();
				}

				newArray[index].add(entry); 
			}
		buckets = newArray; 
		}
	}
	
	public int getNumBuckets() {
		return buckets.length; 
	}
	
	// Removes the Entry if the key points to anything 
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

	// Adds all the elements of one list to another 
	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
	
		for (int i = 0; i < otherMap.size(); i++) {
			Set<? extends Map.Entry<? extends K, ? extends V>> entries = otherMap.entrySet(); 
			for (Map.Entry<? extends K, ? extends V> entry: entries) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	// Deletes all elements in the map 
	@Override
	public void clear() {
		for (LinkedList<Entry<K,V>> bucket: buckets) {
			bucket = null; 
		}
	}
	
	// Returns a set of keys 
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

	// Returns a Collection of values 
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
