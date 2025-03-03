package com.example.visit.tracker.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<Integer> splitStringToListInts(String str, String symbol){
        var Ints = new ArrayList<Integer>();
        if (str != null) {
            Ints = Arrays.stream(str.split(symbol))
                    .map(Integer::parseInt)
                    .collect(Collectors
                            .toCollection(ArrayList::new)
                    );
        }

        return Ints;
    }
}
