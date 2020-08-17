import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class testEntrySet {
    public static void main(String[] args) {
        //����hashmap���϶���
        Map<String,Integer> map =new HashMap<>();

        //�򴴽��õ�hashmap�������д�ȡԪ��
        map.put("ISO", 10000);
        map.put("java", 20000);
        map.put("golang", 30000);
        map.put("c++", 40000);

        //��ȡԪ���е�ĳһ��ֵ
        System.out.println("key =golang��н��Ϊ"+map.get("golang"));

        //�����õ����е�entry,�������entryset�ļ���
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        //����һ
        for(Map.Entry<String, Integer> entry :entrySet ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("=============================");
        //��������ͨ�����������ȵ����������е�entry

        Iterator iter = entrySet.iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
