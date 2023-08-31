package cn.ws.blazefire.ip;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-08-10 11:11
 */
public class InterTest {

    // rose代理子账号最大值
    public static AtomicInteger RoseIndex = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 100; i++) {

            new Thread(
                    () ->
                    {
                        int time = new Random().nextInt(1000);
                        try {
                            Thread.sleep(time);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "_"+time+"_" + RoseIndex.getAndAdd(1));
                    }
            ).start();
        }






        Thread.sleep(5000);

        System.out.println(RoseIndex.get());



    }


}
