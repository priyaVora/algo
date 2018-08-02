import static org.junit.Assert.*;

import org.junit.Test;

import vora.priya.kastas.Kata2;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class JohnannTest {

    private static void testJohn(long n, String res) {
        assertEquals(res, Arrays.toString(Kata2.john(n).toArray())); 
    }
    @Test
    public void test1() {
        testJohn(11, "[0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6]");
    }
    private static void testAnn(long n, String res) {
        assertEquals(res, Arrays.toString(Kata2.ann(n).toArray())); 
    }
    @Test
    public void test2() {
        testAnn(6, "[1, 1, 2, 2, 3, 3]");
    }
    private static void testSumAnn(long n, long res) {
        assertEquals(res, Kata2.sumAnn(n)); 
    }
    @Test
    public void test3() {
        testSumAnn(115, 4070);
    }
    
    private static void testSumJohn(long n, long res) {
    	System.out.println("\n");
    	System.out.println("Res for John is : " + res);
    	long calculatedValue = Kata2.sumJohn(n);
    	
    	System.out.println("Calculated Value for John is : " + calculatedValue);
        assertEquals(res, Kata2.sumJohn(n)); 
    }
    @Test
    public void test4() {
        testSumJohn(75, 1720);
    }
}
