import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class testEntrySet {
    public static void main(String[] args) {
        //创建hashmap集合对象
        Map<String,Integer> map =new HashMap<>();

        //向创建好的hashmap集合类中存取元素
        map.put("ISO", 10000);
        map.put("java", 20000);
        map.put("golang", 30000);
        map.put("c++", 40000);

        //获取元素中的某一个值
        System.out.println("key =golang的薪资为"+map.get("golang"));

        //遍历得到所有的entry,或得所有entryset的集合
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        //方法一
        for(Map.Entry<String, Integer> entry :entrySet ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("=============================");
        //方法二，通过迭代器，先迭代出来所有的entry

        Iterator iter = entrySet.iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
