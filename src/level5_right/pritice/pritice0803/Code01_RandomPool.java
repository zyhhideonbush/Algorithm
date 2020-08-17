package level5_right.pritice.pritice0803;

import java.util.HashMap;

public class Code01_RandomPool {
    public static class Pool {
        private HashMap<String, Integer> keyIndexMap;
        private HashMap<Integer, String> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<String, Integer>();
            this.indexKeyMap = new HashMap<Integer, String>();
            this.size = 0;
        }

        public void insert(String key) {
            if (!keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }


        public void delete(String key) {
            if (this.keyIndexMap.containsKey(key)) {
                int curIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                String lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.remove(key,lastKey);
                this.indexKeyMap.remove(curIndex,lastIndex);
                this.keyIndexMap.put(lastKey, lastIndex);
                this.indexKeyMap.put(lastIndex, lastKey);

            }
        }

        public String getRandom() {
            if (this.size == 0) {
               return null;
            }
            return this.indexKeyMap.get((int)(this.size * Math.random()));
        }

        public static void main(String[] args) {
            Pool pool = new Pool();
            pool.insert("zuo");
            pool.insert("cheng");
            pool.insert("yun");
            pool.delete("yun");
            pool.delete("cheng");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
	    }
    }
}
