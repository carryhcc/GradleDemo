package com.example.demo;

import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.*;

public class LogTestAnalyze {
    static Vector<String> vector = new Vector<>();
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\synchronization-api.jk.com-2021-08-20\\out_2021-08-20-";
        for (int i = 0; i < 24; i++) {
            String nn;
            if (i < 10) {
                nn = "0" + i;
            } else {
                nn = i + "";
            }
            //日志名称拼接
            String file = filePath + nn + ".log";
            new Thread(()->{
                try {
                    a(new File(file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        while (vector.size()<24){
            Thread.sleep(1000);
        }
        System.out.println();

    }

    public static void a(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\"+file.getName()+".txt"));
        boolean flag = true;
        boolean flag1 = true;
//            String reg = "获取万店联盟会员信息请求地址";
//            String reg = "获取好药师连锁商品信息请求地址";
        String reg = "LsGoodsPriceAllSyncJob";
        String reg1 = "\"PageIndex\":1,\"LastModifyTime\":\"2017-01-01 00:00:00\"";
//            String reg1 = "\"PageSize\":\"100\",\"GoodsCode\":\"\",\"PageIndex\":1,\"LastModifyTime\":\"1970-01-01 00:00:00\"";
        String reg2 = "同步hys会员，一共";
        String reg3 = "O21SRAW5MXS";
        String reg4 = "获取好药师连锁商品价格接口";
        String reg5 = "会员json字符串转实体失败";
        String reg6="1339850442584129538";
        while (flag || flag1) {
            String lineStr = br.readLine();
            if (StringUtils.isBlank(lineStr)) {
                if (!flag) {
                    flag1 = false;
                } else {
                    flag = false;
                }
//                    System.out.println(file+"===="+j);
            } else {
                flag = true;
                flag1 = true;
//                    if(lineStr.indexOf(reg)>-1&&lineStr.indexOf(reg4)>-1){
//                        String json = lineStr.substring(lineStr.indexOf("{"),lineStr.lastIndexOf("}")+1);
//                        LsErpGoodsPriceReturn lsErpGoodsPriceReturn = JSONObject.parseObject(json,LsErpGoodsPriceReturn.class);
//                        if(lsErpGoodsPriceReturn.getRetailp().size()>0){
//                            String Orgid = lsErpGoodsPriceReturn.getRetailp().get(0).getOrgId();
//                            resultMap.put(Orgid,lsErpGoodsPriceReturn.getTotalCount());
//                        }
//                    }
                if (lineStr.contains(reg6)) {
//                        System.out.println(lineStr);
                    bw.write(lineStr);
                    bw.newLine();
                }
            }
        }
        bw.flush();
        vector.add(file.getName());
    }
}
