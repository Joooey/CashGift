package cn.xiaojii.cashgift.util;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.xiaojii.cashgift.R;

/**
 * @author dmrfcoder
 * @date 2018/8/3
 */

public class WriteStringToFileUtil {
    public static void Write(Context context, String content, String filename) {
        //如果手机已插入sd卡,且app具有读写sd卡的权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {

                File dir = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "/" +  context.getPackageName());
                //文件夹是否已经存在
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                filename = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + context.getPackageName()+ "/" + filename + ".json";
                FileOutputStream output = new FileOutputStream(filename);
                output.write(content.getBytes());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else Toast.makeText(context, "SD卡不存在或者不可读写", Toast.LENGTH_SHORT).show();
    }
}