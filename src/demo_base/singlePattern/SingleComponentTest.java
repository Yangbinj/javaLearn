package demo_base.singlePattern;

import org.junit.Test;

public class SingleComponentTest {
    @Test
    public void testLazyPattern() {
        for (int a = 0; a < 200; a++) {
            new Thread(() -> {
                LazyPattern.getSimpleInstance();
                HungryPattern.getSimpleInstance();
            }).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /*
       結果如下：
        LazyPattern initialization :1
        LazyPattern initialization :4
        LazyPattern initialization :3
        LazyPattern initialization :2
        HungryPattern initialization :1
        */
    }

    @Test
    public void testNumAdd() {
        int num = 1;
        System.out.println("++num: " + ++num + "\t num:" + num); //2,2
        num = 1;
        System.out.println("num++: " + num++ + "\t num:" + num);//1,2
    }
}
