package level5_right.pritice.pritice0804;

import java.util.HashMap;

//Ëæ»ú³Ø
public class Code01_RandomPool {
    public static class Pool {
        private HashMap<String, Integer> keyIndex;
        private HashMap<Integer, String> indexKey;
        private int size;

        public Pool() {
            this.keyIndex = new HashMap<String, Integer>();
            this.indexKey = new HashMap<Integer, String>();
            this.size = 0;
        }

        public void insert(String target) {
            if (!this.keyIndex.containsKey(target)) {
                keyIndex.put(target, size);
                indexKey.put(size++, target);
            }
        }

        public void delete(String key) {
            if (keyIndex.containsKey(key)) {
                int curIndex = keyIndex.get(key);
                int lastIndex = size--;
                String lastKey = indexKey.get(lastIndex);
                keyIndex.remove(lastKey);
                indexKey.remove(lastIndex);
                keyIndex.put(lastKey,curIndex);
                indexKey.put(curIndex,lastKey);
            }
        }

        public String getRandom() {
            if (size == 0) {
               return null;
            }
            return indexKey.get((int)(Math.random() * size));
        }
    }

     public static void main(String[] args) {
            Pool pool = new Pool();
            pool.insert("zuo");
            pool.insert("cheng");
            pool.insert("yun");
            pool.delete("yun");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
	    }



}
