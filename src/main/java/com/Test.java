package com;

import java.util.*;

/**
 * Author:   wangchao
 * Version：
 * Date:     2017/11/23
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * --------------------------------------------------------------
 * Why & What is modified:
 */
public class Test {

    public static void count(String str){
        //将字符串转化为字符数组
        char[] chars = str.toCharArray();
        //创建一个HashMap名为hm
        List<HashMap<Character,Integer>> list=new ArrayList<HashMap<Character,Integer>>();
        HashMap<Character,Integer> hm = new LinkedHashMap();
        for(int i=0;i<chars.length;i++){

            if(i>0)
            {
                if(!hm.containsKey(chars[i])){
                    hm.put(chars[i],1);
                }
                else
                {
                    if(chars[i]==chars[i-1])
                    {
                        //否则获得c的值并且加1
                        hm.put(chars[i], hm.get(chars[i])+1);
                    }
                    else
                    {
                        list.add(hm);
                        hm = new LinkedHashMap();
                        hm.put(chars[i],1);
                    }
                }
            }
            else
            {
                if(!hm.containsKey(chars[i])){
                    hm.put(chars[i],1);
                }else{
                    hm.put(chars[i], hm.get(chars[i])+1);
                }

            }
        }
        list.add(hm);
        String strPrint="";

        for(HashMap<Character,Integer> map: list){
            for(Character key: map.keySet()){
                //hm.keySet()代表所有键的集合,进行格式化输出
                strPrint+=String.valueOf(key)+ String.valueOf(map.get(key));
            }
        }
        System.out.println(strPrint);
    }
    public static void count1(String str){
        //将字符串转化为字符数组
        char[] chars = str.toCharArray();
        //创建一个HashMap名为hm
        HashMap<Character,Integer> hm = new LinkedHashMap();

        //HashMap<Character,Integer> hm = new LinkedHashMap();
        //ArrayList<Count> hm=new ArrayList();
        //定义一个字符串c，循环遍历遍历chars数组
        for(char c : chars){
            //containsKey(c),当c不存在于hm中
            if(!hm.containsKey(c)){
                hm.put(c,1);
            }else{
                //否则获得c的值并且加1
                hm.put(c, hm.get(c)+1);
            }
        }

        String strPrint="";
        for(Character key: hm.keySet()){
            //hm.keySet()代表所有键的集合,进行格式化输出
            strPrint+=String.valueOf(key)+ String.valueOf(hm.get(key));
        }

        System.out.println(strPrint);
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String str = "bbbaaccba";
        count(str);
        count1(str);

    }



}