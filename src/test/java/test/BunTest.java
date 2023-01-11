package test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;
    private String bunName="bunName";
    private float bunPrice=100.0f;

    @Test
    public void getPriceForBun() {
        bun = new Bun(bunName, bunPrice);
        float expected = bunPrice;
        float actual  = bun.getPrice();
        Assert.assertEquals(expected, actual,0);
    }

    @Test
    public void getNameForBun() {
        bun = new Bun(bunName, bunPrice);
        String expected = bunName;
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }


}
