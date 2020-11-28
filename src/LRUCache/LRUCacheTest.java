package LRUCache;

public class LRUCacheTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache<String, String> cache = new LRUCache<String, String>(4, 0.75f);
		
		cache.put("1", "1");
		cache.put("2", "2");
		cache.put("3", "3");
		cache.put("4", "4");
		
		System.out.println("insertion: "+cache);
		
		cache.get("2");
		System.out.println("after get(\"2\"): "+cache);
		
		cache.put("5","5");
		System.out.println("after put(\"5\"): "+cache);
	}

}
