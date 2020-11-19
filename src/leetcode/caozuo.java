package leetcode;


class LMK
{
    String lname;
    int number=0;
    int lsize=10;
}

class Producer implements Runnable
{
    LMK mk;
    Producer(LMK mk)
    {
        this.mk = mk;
        this.mk.lname="producer";
    }
    public void run()
    {
        while(true)
        {
            synchronized(mk)
            {
                if(mk.number<mk.lsize)
                {
                    mk.number++;
                    System.out.println("生产者（producer）已生产第："+mk.number+"个产品!");
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mk.notify();
                }
                else
                {
                    try {
                        System.out.println("生产者停止!");
                        mk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
class Consumer implements Runnable
{
    LMK mk;
    Consumer(LMK mk)
    {
        this.mk = mk;
        this.mk.lname="consumer";
    }
    public void run()
    {
        while(true)
        {
            synchronized(mk)
            {
                if(mk.number>0)
                {
                    System.out.println("消费者（consumer）要消费第："+mk.number+"个产品!");
                    mk.number--;
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mk.notifyAll();
                }
                else
                {
                    try {
                        System.out.println("消费者停止!");
                        mk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class caozuo {
    public static void main(String[] args) {
        LMK mk = new LMK();
        new Thread(new Producer(mk)).start();
        new Thread(new Consumer(mk)).start();
    }
}
