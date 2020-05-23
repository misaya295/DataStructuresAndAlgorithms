package com.cwk.linkList;

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
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);

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
