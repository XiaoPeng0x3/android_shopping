package com.example.shopping;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shopping.dao.ShoppingDBHelper;
import com.example.shopping.pojo.GoodsInfo;
import com.example.shopping.utils.FileUtil;
import com.example.shopping.utils.SharedUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class MyApplication extends Application {
    public static MyApplication mApp;
    public HashMap<String, String> infoMap = new HashMap<>();

    public static MyApplication getInstance() {
        return mApp;
    }
    public int goodsCount;

    private void initGoodsInfo(){
        boolean isFirst = SharedUtil.getInstance(this).readBoolean("first", true);
        String directory = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator;
        if (isFirst) {
            List<GoodsInfo> list = GoodsInfo.getDefaultList();
            for (GoodsInfo info : list) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), info.pic);
                String path = directory + info.id + ".png";
                FileUtil.SaveImage(path, bitmap);

                bitmap.recycle();
                info.picPath = path;
            }

            ShoppingDBHelper dbHelper = ShoppingDBHelper.getInstance(this);
            dbHelper.openWriteLink();
            dbHelper.insertGoodsInfos(list);
            dbHelper.closeLink();
            SharedUtil.getInstance(this).writeBoolean("first", false);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initGoodsInfo();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d("HKHL", "MyApplication onTerminate");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("HKHL", "MyApplication onConfigurationChanged");
    }
}

