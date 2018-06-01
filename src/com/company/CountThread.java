package com.company;

import java.util.concurrent.locks.ReentrantLock;

class CountThread implements Runnable {

    private CommonResource res;
    private ReentrantLock locker;

    CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }

    public void run() {
        /*
        «десь также используетс€ общий ресурс CommonResource, дл€ управлени€ которым создаетс€ п€ть потоков.
        Ќа входе в критическую секцию устанавливаетс€ заглушка:
         */
        locker.lock();
        /*
        ѕосле этого только один поток имеет доступ к критической секции, а остальные потоки ожидают сн€ти€ блокировки.
        ¬ блоке finally после всей окончани€ основной работы потока эта блокировка снимаетс€.
        ѕричем делаетс€ это об€зательно в блоке finally, так как в случае возникновени€ ошибки все остальные потоки окажутс€ заблокированными.
         */
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}
