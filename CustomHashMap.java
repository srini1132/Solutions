package dummy;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> {
	
	public class Node<K, V> {
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		public V getVaule() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node<K,V> other = (Node<K,V>) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		private CustomHashMap getOuterType() {
			return CustomHashMap.this;
		}

		@Override
		public String toString() {
			return "{" + key + "=" + value+ "}";
		}
		
	}

	List<Node<K,V>> li;
	
	public CustomHashMap() {
		li = new ArrayList<>();
	}
	
	public void put(K key, V value) {
		boolean set = false;
		for(Node<K,V> n : li) {
			if(n.getKey().equals(key)) {
				n.setValue(value);
				set = true;
			}
		}
		if(!set)
			li.add(new Node<K,V>(key, value));
	}
	
	public V get(K key) {
		for (Node<K, V> n : li) {
			if(n.getKey().equals(key)) {
				return n.getVaule();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "" +li;
	}
}
