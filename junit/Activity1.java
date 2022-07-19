package examples;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    ArrayList<String> list;

    @BeforeEach
     void setup(){

        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");


    }
    @Test
    public void insertTest(){
        Assert.assertEquals(2, list.size());
        list.add("third");
        Assert.assertEquals(3, list.size());
        Assert.assertEquals("alpha", list.get(0));
        Assert.assertEquals("beta", list.get(1));
        Assert.assertEquals("third", list.get(2));
    }
    @Test
    public void replaceTest(){
        list.set(1,"third");
        assertEquals(2, list.size(), "Wrong size");

        assertEquals("alpha", list.get(0), "Wrong element");

        assertEquals("third", list.get(1), "Wrong element");
    }
}
