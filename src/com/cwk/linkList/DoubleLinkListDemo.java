package com.cwk.linkList;

public class DoubleLinkListDemo {


    public static void main(String[] args) {

        //测试双向链表的测试

        //进行测试
        //先创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "1", "1");
        HeroNode2 heroNode2 = new HeroNode2(2, "2", "2");
        HeroNode2 heroNode3 = new HeroNode2(3, "3", "3");
        HeroNode2 heroNode4 = new HeroNode2(4, "4", "4");


        //创建一个双向链表
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add(heroNode1);
        doubleLinkList.add(heroNode2);
        doubleLinkList.add(heroNode3);
        doubleLinkList.add(heroNode4);

        doubleLinkList.list();

        //修改
//        HeroNode2 heroNode5 = new HeroNode2(1, "cn", "m");
//
//        doubleLinkList.update(heroNode5);
//        System.out.println("修改后");
//        doubleLinkList.list();

        doubleLinkList.del(2);
        System.out.println("---");
        doubleLinkList.list();
    }

}

class DoubleLinkList {
    /**
     先初始化一个头节点，头节点不要动
     */
    private HeroNode2 head = new HeroNode2(0, "", "");


    /**
     *
     * @return 返回头节点
     */
    public  HeroNode2 getHead(){

        return head;
    }

    /**
     修改节点的信息，根据no编号来修改，即no编号不能改
     */
    public void update(HeroNode2 newherNode) {

        if (head.next == null
        ) {
            return;
        }
        //找到需要修改的节点，根据弄编号
        HeroNode2 temp = head.next;
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
    /**
     * 删除节点
     * 1.head不动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较时，是temp.next.no 和 需要删除的节点no比较
     * 3.对于双向链表可以直接找到删除的节点
     * 找到后自我删除即可
     */
    public void del(int no) {


        if (head.next == null) {
            System.out.println("链表为空无法删除");

            return;
        }
        //辅助指针
        HeroNode2 temp = head.next;
        //是否找到待删除节点的前一个节点
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            //找到了待删除节点的前一个节点temp
            if (temp.no == no) {
                flag = true;
                break;
            }


            temp = temp.next;

        }

        if (flag) {
//            temp.next = temp.next.next;

            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面这句，会空指针异常

            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }


        } else {
            System.out.printf("要删除的%d这个节点不存在\n", no);
        }
    }

    /**
     添加节点到单向链表
     思想，当不考虑编号顺序时
     1.找到当前链表的最后节点
     2.将最后这个节点的next指向新节点
     */
    public void add(HeroNode2 heroNode) {


        //因为head节点不能动，因此我们需要一个辅助遍历 tmp
        HeroNode2 temp = head;

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

        temp.next = heroNode;
        heroNode.pre = temp;


    }



    /**
     *遍历双向链表
     */
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
        HeroNode2 temp = head.next;

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





//创建一个双向链表的类
/**
 * 定义HeroNode,每个HeroNode对象就是一个节点
 */
class HeroNode2 {

    public int no;
    public String name;
    public String nickName;
    /**
     * 指向前一个节点
     */
    public HeroNode2 pre;
    /**
     指向下一个节点
     */
    public HeroNode2 next;

    /**
     * 构造器
     */
    public HeroNode2(int hNO, String hName, String nickName) {

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