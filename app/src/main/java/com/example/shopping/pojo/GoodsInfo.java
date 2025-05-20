package com.example.shopping.pojo;

import com.example.shopping.R;

import java.util.ArrayList;

public class GoodsInfo {
    public int id;
    public String name;
    public String description;
    public float price;
    public String picPath;
    public int pic;

    public GoodsInfo(int id, String name, String description, float price, String picPath, int pic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picPath = picPath;
        this.pic = pic;
    }

    private static String[] mNameArray = {"iPhone16", "Mate60", "小米14", "OPPO Reno12", "VIVO X100", "荣耀60"};

    private static String[] mDescArray = {"Apple iPhone16 256GB 绿色 5G全网通手机",
            "华为 HUAWEI Mate60 8GB+256GB 丹霞橙 5G全网通 全面屏手机",
            "小米14 8GB+128GB 黑色 5G手机 游戏拍照手机",
            "OPPO Reno12 8GB+128GB 蓝色星夜 双模5G 拍照游戏智能手机",
            "vivo X100 8GB+128GB 绯云 5G全网通 美颜拍照手机",
            "荣耀60 8GB+128GB 黑色 5G芯片 自拍全面屏手机"
    };

    private static float[] mPriceArray = {6299, 4999, 3999, 2999, 2998, 2399};

    public static int[] mPicArray = {
            R.drawable.iphone_16,
            R.drawable.huawei_mate60,
            R.drawable.xiaomi_14,
            R.drawable.oppo_reno_12,
            R.drawable.vivo_x100,
            R.drawable.honor_60
    };

    public GoodsInfo() {

    }

    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.id = i;
            info.name = mNameArray[i];
            info.description = mDescArray[i];
            info.price = mPriceArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }

}

