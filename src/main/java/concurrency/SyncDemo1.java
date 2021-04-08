package concurrency;

import cn.hutool.crypto.digest.MD5;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/8
 */
public class SyncDemo1 {

    public static void main(String[] args) {
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new MyThread("test"));
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        System.out.println(new StringBuffer().toString()==null);
    }


}

class MyThread implements Runnable {

    private String ruleString;

    public MyThread(String ruleString) {
        this.ruleString = ruleString;
    }

    @Override
    public void run() {
        String lockString = genStringLock(this.ruleString);
        synchronized (lockString.intern()) {
            System.out.println("[" + Thread.currentThread().getName() + "]开始运行了");
            // 休眠2秒模拟加载规则集
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]结束运行了");
        }
    }


    private String genStringLock(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String lock = MD5.create().digestHex(sb.toString());

        System.out.println("[" + Thread.currentThread().getName() + "]构建了锁[" + lock + "]");
        return lock;
    }
}