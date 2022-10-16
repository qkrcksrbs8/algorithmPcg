package cg.park.algorithmpcg.mytest;

import java.util.HashMap;
import java.util.Map;

public class test2 {
    static int count = 0;
    static String memcall = "";
    public static int toFilterCount(String key){
        return stringCount(key, 0);
    }

    public static int stringCount(String key, int pos){
        int index = 0;
        if(key == null || key.length() == 0)
            return 0;
        if((index = memcall.indexOf(key, pos)) != -1) { // word.indexOf(s, pos) -> word에 저장된 "hello java world hello java world"에서 "hello"를 pos번째부터 찾고 그 값을 index에 저장. 그 값이 -1이 아닌지(찾았는지) 확인.
            count++; // 찾을 때마다 count를 1 증가.
            stringCount(key, index + key.length()); // 재귀함수. s는 그대로 두고 index에 찾으려는 문자열의 길이를 더해서 같은 작업을 stringCount(String s, int pos)에서 재시작.
        }
        return count;
    }

    public static String removeDuplicate(String call) {
        memcall = call;
        String[] arr = call.split("");
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();

        int leng = call.length();
        int halfLeng = leng/2;
        int cnt = 0;
        for (int i = 0; i < halfLeng; i++) {
            for (int j = i; j < leng; j++) {
                cnt = toFilterCount(call.substring(i, j+1));
                if (max <= cnt) {
                    max = cnt;
                    map.put(call.substring(i, j+1), cnt);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            call.replace(entry.getKey(), "");
        }
        return call;
    }

    public static void main(String[] args) {
        String call = "abcabcdefabc";
        System.out.println(removeDuplicate(call));
    }

}
