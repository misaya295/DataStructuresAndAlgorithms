package com.cwk.dataStructures.linkList;

import java.util.Stack;

/**
 * @author chenwenkang
 */
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
//        singleLinkedList.addByOrder(heroNode3);

//        HeroNode newHeroNode = new HeroNode(2, "1", "1");
//        singleLinkedList.update(newHeroNode);


        //显示
//        singleLinkedList.list();
//
//        System.out.println("删除后");
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        singleLinkedList.list();
//        System.out.println(getLength(singleLinkedList.getHead()));


        //倒数第K个
//        int index = 5;
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), index);
//        System.out.println("倒数第"+ index +"是"+res);

        singleLinkedList.list();

        System.out.println("--------");
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();

        reversePrint(singleLinkedList.getHead());


    }

    /**
     * 方式2：可以利用栈这个数据结构，将各个节点压入栈中，然后利用栈的先进后出，就实现了逆序打印的效果
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }


        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null) {


            stack.push(cur);
            cur = cur.next;

        }

        while (stack.size() > 0) {



            //stack特点是先进后出
            System.out.println(stack.pop());

        }


    }



    /**
     * @param head 链表头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        //空链表
        if (head.next == null) {
            return 0;
        }

        int len = 0;

        //定义一个辅助的变量
        HeroNode cur = head.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        return len;

    }


    /**
     * 将单链表反转
     */
    public static void reversetList(HeroNode head) {


            //如果当前链表为空 或者只有一个节点 无需反转 直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        /*
         *定义一个辅助指针（变量），帮助遍历原来的链表
         */
        HeroNode cur = head.next;
        /*
        指向当前节点的下一个节点
         */
        HeroNode next = null;


        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端

        while (cur != null) {

            //先暂时保存当前节点的下一个节点
            next = cur.next;

            //将cur后面一个节点指向，新的链表的头部
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            cur = next;
        }
        //将head.nex 指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
















    }




    /**
     * 查找单链表的倒数第k个节点
     * 编写一个方法，接收head节点，同时接收一个index
     * index表示的是倒数第index个节点
     * 先把链表从头到尾遍历，得到链表总的长度
     * 得到len之后，从链表第一个开始遍历len-index
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {

        if (head.next == null) {

            return null;
        }

        int length = getLength(head);

        //第二次遍历 len-index位置，就是我们倒数的第k
        //先做一个index的校验
        if (index <= 0 || index > length) {


            return null;

        }

        HeroNode cur = head.next;
        for (int i = 0; i < length - index; i ++) {

            cur = cur.next;

        }

        return cur;

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
     *
     * @return 返回头节点
     */
    public  HeroNode getHead(){

        return head;
    }









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
     * 删除节点
     * 1.head不动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较时，是temp.next.no 和 需要删除的节点no比较
     */
    public void del(int no) {
        HeroNode temp = head;
        //是否找到待删除节点的前一个节点
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            //找到了待删除节点的前一个节点temp
            if (temp.next.no == no) {
                flag = true;
                break;
            }


            temp = temp.next;

        }

        if (flag) {
            temp.next = temp.next.next;

        } else {
            System.out.printf("要删除的%d这个节点不存在\n", no);
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
