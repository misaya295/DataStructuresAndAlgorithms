package com.cwk.linkList;

import java.util.concurrent.TimeUnit;

public class SingleLinkedListDemo {


    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "1", "1");
        HeroNode heroNode2 = new HeroNode(2, "2", "2");
        HeroNode heroNode3 = new HeroNode(3, "3", "3");
        HeroNode heroNode4 = new HeroNode(4, "4", "4");


        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode3);

        HeroNode newHeroNode = new HeroNode(2, "1", "1");
        singleLinkedList.update(newHeroNode);


        //显示
        singleLinkedList.list();

    }





}



/**
 * 定义SingleLinkedList
 */
class SingleLinkedList {

    /**
    先初始化一个头节点，头节点不要动
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
    添加节点到单向链表
    思想，当不考虑编号顺序时
    1.找到当前链表的最后节点
    2.将最后这个节点的next指向新节点
     */
    public void add(HeroNode heroNode) {


        //因为head节点不能动，因此我们需要一个辅助遍历 tmp
        HeroNode temp = head;

            /*
             遍历链表，找到最后

             */
        while (true) {
            //找到链表的最后
            if (temp.next == null) {

                break;
            }
            //如果有找到最后，就将temp后移
            temp = temp.next;

        }

        //当退出while循环时，temp就指向链表的最后
        //将最后这个节点的next，指向新的的节点
        temp.next = heroNode;

    }


    /**
    修改节点的信息，根据no编号来修改，即no编号不能改

     */
    public void update(HeroNode newherNode) {

        if (head.next == null
        ) {
            return;
        }
        //找到需要修改的节点，根据弄编号
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {

                break;//到链表的最后
            }
            if (temp.no == newherNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (false) {
            temp.no = newherNode.no;
            temp.nickName = newherNode.nickName;
        } else {
            System.out.printf("没有找到编号%d 的节点",newherNode.no);
        }


    }









    /*
    第二种添加英雄的方式，根据排名将英雄插入到指定位置
     （如果有这排名，则添加失败，并给出提示）
     */

    public void addByOrder(HeroNode heroNode) {

        /*
        因为头节点不懂动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
         */
        HeroNode tmp = head;
        /*
        标实添加的编号是否存在
        默认false
         */
        boolean flag = false;

        while (true) {
            //说明tmp已经在链表的最后
            if (tmp.next == null) {
                break;
            }
            //位置找到，就在tmp的后面插入
            if (tmp.next.no > heroNode.no) {

                break; } else if (tmp.next.no == heroNode.no) {
                //说明希望添加的heroNode的编号已经存在

                flag = true;
                break;

            }

            //后移，遍历当前链表
            tmp = tmp.next;


        }


        /*
        判断flag的值
         */
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d 已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表冲
            heroNode.next = tmp.next;
            tmp.next = heroNode;

        }





    }






    /**
     * 显示链表
     */

    public void  list() {

             /*
             判断链表是否为空
             */
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
            /*
            因为头节点，不能动，因此我们需要一个辅助变量来遍历
             */
        HeroNode temp = head.next;

        while (true) {
            /*
             * 判断链表是否到最后
             */
            if (temp == null) {
                break;
            }


            //输出节点信息
            System.out.println(temp);

            //将next后移动
            temp = temp.next;
        }



    }



}




/**
 * 定义HeroNode,每个HeroNode对象就是一个节点
 */
class HeroNode {

    public int no;
    public String name;
    public String nickName;
    /**
    指向下一个节点
     */
    public HeroNode next;

    /**
     * 构造器
     */
    public HeroNode(int hNO, String hName, String nickName) {

        this.no = hNO;
        this.name = hName;
        this.nickName = nickName;


    }

    /*
     * 为了显示方便重写tostring
     */

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
