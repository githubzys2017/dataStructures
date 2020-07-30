package com.atguigu.linkedlist;

import javax.swing.plaf.PanelUI;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江","及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用","智多星");
        HeroNode hero4 = new HeroNode(4, "林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
            //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);


        //按编号加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);

        HeroNode newHeroNode = new HeroNode(5, "小路", "小玉");
        //修改
        singleLinkedList.update(newHeroNode);
        System.out.println("*********************");
        singleLinkedList.list();
        System.out.println("=============");
        //删除节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(5);

        System.out.println("删除后");
        singleLinkedList.list();
    }
}


/**
 * 定义SingleLinkedList 管理我们的英雄
 */
class SingleLinkedList {
    //初始化头节点，头节点不动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 遍历到最后一个节点
     * 将最后一个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能懂，因此我们需要一个变量辅助遍历 temp
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 顺序添加英雄，如果英雄存在，提示英雄存在
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {

        //临时变量，辅助遍历
        HeroNode temp = head;
        //标记是否找到编号
        boolean flag;
        //遍历链表，查找需要添加元素的位置
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                System.out.println("该英雄已存在");
                return;
            }
            temp = temp.next;
        }

        //插入操作
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    /**
     * 修改节点信息，按编号修改，如果未查到就不修改
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空，不能修改");
            return;
        }
        //辅助变量
        HeroNode temp = head;
        //标记是否找到节点
        boolean flag = false;
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                System.out.printf("修改的节点编号为》》%d 《《", temp.no);
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("未找到该节点");
        }
    }

    /**
     * 按编号删除英雄
     * @param no
     */
    public void del(int no) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                System.out.printf("删除编号为%d的英雄", no);
                System.out.println();
                return;
            }
            temp = temp.next;
        }
        System.out.println("链表不存在该元素，不能删除");
    }

    /**
     * 显示链表（遍历）
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空～～");
            return;
        }
        HeroNode temp = head;
        while (temp != null) {

            System.out.println(temp);
            temp = temp.next;
        }
    }
}


/**
 * 节点对象
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;       //下一节点的引用

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
