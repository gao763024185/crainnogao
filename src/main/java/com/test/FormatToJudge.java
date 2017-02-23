package com.test;

import java.util.Scanner;

public class FormatToJudge {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("**********欢迎进入作业提交系统**********");
        System.out.println("请输入java文件名:");
        String ss = input.next();
        boolean flag1 = false;
        int place = ss.lastIndexOf(".");
        String a = ss.substring(place);
        if(a.equals(".java")){
            flag1 = true;
        }
        System.out.println("请输入你的邮箱:");
        ss = input.next();
        boolean flag2 = false;
        int place2 = ss.indexOf("@");
        int place1 = ss.lastIndexOf("@");
        int place3 = ss.lastIndexOf(".");
        String b = ss.substring(place3);
        if(place1!=place2){
            flag2 = true;
        }else if(place1>place3){
            flag2 = true;
        }
        boolean flag3 = false;
        if(b.equals(".com"));{
            flag3 = true;
        }
        if(flag1==true&&flag2==false&&flag3==true){
            System.out.println("作业提交成功!");
        }else if(flag1==false||flag2==true||flag3==false){
            if(flag1==false){
                System.out.println("作业文件格式无效!");
            }else if(flag2==true||flag3==false){
                System.out.println("E-mail无效!");
            }
            System.out.println("作业提交失败!");
        }
    }

}
