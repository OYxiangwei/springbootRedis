package com.test;

import static org.junit.Assert.assertTrue;

import com.test.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
{
   @Autowired
    private RedisUtil redisUtil;
    @Test
    public void setGetTest()
    {
        redisUtil.set("name1","yxw");
        Assert.assertEquals("yxw",redisUtil.get("name1"));
        redisUtil.delete("name1");
    }
    @Test
    public void delkeyTest(){
        redisUtil.set("name","oy");
        redisUtil.delete("name");
        Assert.assertNull(redisUtil.get("name"));
    }
    @Test
    public void updateTest(){
        redisUtil.set("old","old");
        Assert.assertEquals(redisUtil.getSet("old","new"),"old");
        Assert.assertEquals(redisUtil.get("old"),"new");
        redisUtil.delete("old");
    }
    @Test
    public void expireTest(){
        redisUtil.set("expireTest","expireTest");
        redisUtil.expire("expireTest",1000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(redisUtil.getttl("expire",TimeUnit.MILLISECONDS)<1000);
        redisUtil.delete("expire");
    }
    @Test
    public void hgetAndHsetTest() {
        redisUtil.hset("y", "x", "w");
        Assert.assertEquals(redisUtil.hget("y", "x"), "w");
        redisUtil.delete("y");
    }
}
