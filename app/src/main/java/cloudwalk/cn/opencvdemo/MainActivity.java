package cloudwalk.cn.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static cloudwalk.cn.opencvdemo.R.id.img;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    Button button;
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        bitmap  = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        imageView= (ImageView)findViewById(img);
        imageView.setImageBitmap(bitmap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    w      = bitmap.getWidth(), h = bitmap.getHeight();
                int[] pix = new int[w * h];
                bitmap.getPixels(pix, 0, w, 0, 0, w, h);
                int [] resultPixes=OpenCVHelper.gray(pix,w,h);//调用native方法
                Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
                result.setPixels(resultPixes, 0, w, 0, 0,w, h);
                imageView.setImageBitmap(result);
            }
        });

    }


}
