package com;

public class ThreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread tm=new MyThread();
        Thread t1=new Thread(tm);
        Thread t2=new Thread(tm);
        Thread t3=new Thread(tm);
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThread implements  Runnable{
    private int ticket=10;
    public void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
};
