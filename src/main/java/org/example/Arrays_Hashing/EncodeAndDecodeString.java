package org.example.Arrays_Hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    //Solution Encoding & Decoding
    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append("#");
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while(str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for(int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }


    //Solution2 Encoding & Decoding(Optimal)
    public String encode2(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode2(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i,j));
            i = j;
        }
        return res;
    }



    public static void main(String[] args) {
        //Solution Encoding & Decoding
        EncodeAndDecodeString ead = new EncodeAndDecodeString();
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        System.out.println(ead.encode(strs));
        System.out.println(ead.decode(ead.encode(strs)));

        //Solution2 Encoding & Decoding(Optimal)
        System.out.println(ead.encode2(strs));
        System.out.println(ead.decode2(ead.encode2(strs)));
    }
}
