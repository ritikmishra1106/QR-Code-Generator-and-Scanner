package com.ritik.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GenQRActivity extends AppCompatActivity {
    private TextView QRGenTV;
    private ImageView QrCodeIV;
    private TextInputEditText edtData;
    private Button btnQRGen;
    private QRGEncoder qrgEncoder;
    private Bitmap bitmap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_qractivity);

        QRGenTV=findViewById(R.id.QRGenTV);
        QrCodeIV =findViewById(R.id.QrCodeIV);
        edtData =findViewById(R.id.edtData);
        btnQRGen=findViewById(R.id.btnQRGen);

        btnQRGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edtData.getText().toString();
                if (data.isEmpty()){
                    Toast.makeText(GenQRActivity.this, "Please Enter Some data to Generate QR..", Toast.LENGTH_SHORT).show();
                }else{
                    WindowManager manager =(WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display  =manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int dimen = width<height?width:height;
                    dimen =dimen*3/4;

                    qrgEncoder = new QRGEncoder(edtData.getText().toString(),null, QRGContents.Type.TEXT,dimen);
                    try {
                        bitmap = qrgEncoder.getBitmap();
                        // Setting Bitmap to ImageView
                        QRGenTV.setVisibility(View.GONE);
                        QrCodeIV.setImageBitmap(bitmap);

                    }catch (Exception e){
                        e.printStackTrace();

                    }


                }

            }
        });

    }
}