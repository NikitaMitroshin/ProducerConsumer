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
        ����� ����� ������������ ����� ������ CommonResource, ��� ���������� ������� ��������� ���� �������.
        �� ����� � ����������� ������ ��������������� ��������:
         */
        locker.lock();
        /*
        ����� ����� ������ ���� ����� ����� ������ � ����������� ������, � ��������� ������ ������� ������ ����������.
        � ����� finally ����� ���� ��������� �������� ������ ������ ��� ���������� ���������.
        ������ �������� ��� ����������� � ����� finally, ��� ��� � ������ ������������� ������ ��� ��������� ������ �������� ����������������.
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
            locker.unlock(); // ������� ����������
        }
    }
}
