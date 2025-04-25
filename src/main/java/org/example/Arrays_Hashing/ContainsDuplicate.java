package org.example.Arrays_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Hash Set - Solution
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Hash Set Length - Solution
    public boolean hasDuplicateLength(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }


    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.hasDuplicate(new int[]{1,2,3,4}));


    }
}


/*
Set i HashMap u Javi – Kratak Pregled
        U Javi, Set i HashMap su dve različite kolekcije koje se koriste za čuvanje podataka:

Set – Kolekcija koja ne dozvoljava duplikate i ne garantuje redosled elemenata.

Najčešće korišćene implementacije su:
HashSet – Koristi HashMap u pozadini i ne garantuje redosled elemenata.
        TreeSet – Održava elemente sortiranim koristeći TreeMap.
        LinkedHashSet – Pamti redosled ubacivanja elemenata.
HashMap – Kolekcija koja skladišti ključeve i vrednosti u parovima (key-value).

Ključevi su jedinstveni, dok vrednosti mogu biti duplikati.
Koristi hashing za brzo pretraživanje (O(1) u većini slučajeva).


*/
