package com.leobooth.practice.framework.waits;

import java.time.Duration;

public class WaitHard {

    private static void hardWait(Duration waitTime) {
        try {
            Thread.sleep(waitTime.toMillis());
        } catch (InterruptedException e) {
            System.out.println("Unable to sleep execution thread: \n" + e.getMessage());
        }
    }

    public static void forSeconds(long seconds) {
        hardWait(Duration.ofSeconds(seconds));
    }

    public static void forMillis(long milliseconds) {
        hardWait(Duration.ofMillis(milliseconds));
    }
}

