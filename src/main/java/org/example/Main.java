package org.example;
//今回のプロジェクトはJavaの基本です
//java基本用法
// 1：for (数据类型 变量名 : 数组或集合)
// 2：Labelled break
// 3：if, whiel ,do while, for, switch，Try-Catch-Finally等
// 4：Java 有个很爽的语法糖，允许你传入任意数量的参数 eg：public static void printAll(String... names)
//
//


import java.util.*;

class Animanation{
 String name;
 int lovepoint;
 public Animanation(String name,int lovepoint)
 {
     this.name=name;
     this.lovepoint = lovepoint;

 }
    @Override

    public String toString() {

     return  "名称: " + name + ", 好感度: " + lovepoint;

    }


}



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Animanation> list = new ArrayList<Animanation>();
        System.out.println("你喜欢的动漫有什么？你分别为他们打多少分？");
        while (true) {
            String name = input.next();
            int point;
            if (input.hasNextInt()&&name != "null") {
                point = input.nextInt();
            }
            else
            {
                break;
            }
          list.add( new Animanation(name,point));
                System.out.println("已录入");




        }
   list.sort((s1,s2) -> s1.lovepoint - s2.lovepoint);
        System.out.println(list);


    }


}
