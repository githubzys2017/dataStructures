package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        //创建队列
        CircleArray queue = new CircleArray(4);
        char key = ' ';      //接收用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输入一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray {

    private int maxSize;    //表示数组的最大容量
    private int front;      //指向队列的第一个元素，初始值为0
    private int rear;       //指向队列的最后一个元素的后一个位置，初始值为0，因为希望空出一个位置
    private int[] arr;      //该数组用于存放数组，模拟队列

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是满的
    public boolean isFull() {
        return (rear + 1)%maxSize == front;
    }

    //判断队列是空的
    public boolean isEmpty() {
        return rear == front;
    }

    //队列添加数据
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据～");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //  rear后移
    }

    //获取队列数据
    public int getQueue() {
        //判斷隊列是为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据");
        }
        int ff = front;
        front = (front + 1) % maxSize;    //front后移
        return arr[ff];
    }

    //显示队列所有的数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据～～");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 获取队列的有效数据数量
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据");
        }
        return arr[front];
    }
}
