package com.example.visit.tracker.test.utils;

import com.example.visit.tracker.ApplicationTests;
import com.example.visit.tracker.util.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringUtilsTest extends ApplicationTests {
    @Test
    void positive() {
        var splitStr = StringUtils.splitStringToListInts("12.58.96.35", "\\.");
        Assertions.assertEquals(List.of(12,58,96,35), splitStr);
    }
}
