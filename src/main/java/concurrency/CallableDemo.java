package concurrency;

import basic.CatalogResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/28 19:29
 */
public class CallableDemo implements Callable<CatalogResult> {

    private CountDownLatch countDownLatch;

    private CatalogResult catalogResult;

    public CallableDemo(CountDownLatch countDownLatch, CatalogResult catalogResult) {
        this.countDownLatch = countDownLatch;
        this.catalogResult = catalogResult;
    }

    @Override
    public CatalogResult call() throws Exception {
        new ServiceA(catalogResult,countDownLatch);
        new ServiceB(catalogResult,countDownLatch);
        new ServiceC(catalogResult,countDownLatch);
        return catalogResult;
    }


    static class ServiceA implements Runnable {

        CatalogResult catalogResult;

        CountDownLatch countDownLatch;

        public ServiceA(CatalogResult catalogResult, CountDownLatch countDownLatch) {
            this.catalogResult = catalogResult;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String aResult = get1Result();
            catalogResult.setResult1(aResult);
            countDownLatch.countDown();
        }

        String get1Result() {
            return "getAResult 完成";
        }
    }

    static class ServiceB implements Runnable {

        CatalogResult catalogResult;

        CountDownLatch countDownLatch;

        public ServiceB(CatalogResult catalogResult, CountDownLatch countDownLatch) {
            this.catalogResult = catalogResult;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(600L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer aResult = getResult();
            catalogResult.setResult2(aResult);
            countDownLatch.countDown();
        }

        Integer getResult() {
            return 111111;
        }
    }

    static class ServiceC implements Runnable {

        CatalogResult catalogResult;

        CountDownLatch countDownLatch;

        public ServiceC(CatalogResult catalogResult, CountDownLatch countDownLatch) {
            this.catalogResult = catalogResult;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(700L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Long aResult = getResult();
            catalogResult.setResult3(aResult);
            countDownLatch.countDown();
        }

        Long getResult() {
            return 999999L;
        }
    }


}
