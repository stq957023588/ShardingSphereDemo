package com.fool.shardingspheredemo;

/**
 * @author fool
 * @date 2022/5/16 11:36
 */
public class VisibleTest {
    private static boolean ready;

    private static int number;

    private static class RenderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new RenderThread().start();
        number = 42;
        ready = true;
    }

}
