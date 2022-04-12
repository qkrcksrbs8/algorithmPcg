package cg.park.algorithmpcg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapEx01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<String, String> hm= new HashMap<String, String>();
        hm.put("1", "양유덕");
        hm.put("2", "장효준");
        hm.put("3", "김막룡");

        System.out.println(hm.toString());
        System.out.println(hm.size());

        System.out.println(hm.get("1")); //인덱스처럼 사용 1의 데이터를 가져왕

        hm.put("4", "임꺽룡");
        System.out.println(hm.toString());

        //같은 키를 사용하면 수정

        hm.put("2", "천재봉");
        System.out.println(hm.toString());

        hm.remove("1");
        System.out.println(hm.toString());

        // key만 갖고 나오는것

        Set<String> keys= hm.keySet();  // 키셋은 셋으로 받어야 한다
        for( String key : keys ) {
            System.out.println(key +" : " + hm.get(key));

            //값
            Collection<String> values = hm.values();
            for(String value: values ) {
                System.out.println(value);
            }
        }

    }

}