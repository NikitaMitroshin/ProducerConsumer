package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

    private static final  String[] PACKETS = {
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet",
            "End"
    };

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        for (String packet : PACKETS) { // ����������� ����� ���������� ���������� ������ �� �������  PACKETS

            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000)); // � �������� �� 1-3 ��� ����� ��������
            } catch (InterruptedException e)  {
                System.out.println("Thread interrupted");
            }
        }
    }
}
