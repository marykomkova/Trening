package com.mary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void simpleTest() {
        Assert.assertEquals(1+1, 2);
    }
}
