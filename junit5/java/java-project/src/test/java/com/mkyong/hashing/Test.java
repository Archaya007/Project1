package com.mkyong.hashing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Test {
    @ParameterizedTest
    @ValueSource(ints = {8,4,2,6,10})
    void test_int_arrays(int arg) {
      System.out.println("arg => "+arg);
        assertTrue(arg % 2 == 0);
    }   
    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @ValueSource(strings = {"Peter King", "Arthur King", "Martin King"})
    void test_string_arrays(String arg) {
      String searchKey = "King";
      
      System.out.println("arg => "+arg);
        assertTrue(arg.contains(searchKey));
    }  
    
    @ParameterizedTest(name="Test with argument - {arguments}")
    @NullSource
    void test_null_source(String arg) {
      
      System.out.println("arg => "+arg);
        assertTrue(arg == null);   
    }   
    
}
