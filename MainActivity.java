package com.example.bmpshow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ContentHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.Test;

import com.example.bmpshow.factory.BMPMassege;
import com.example.bmpshow.factory.FileMassege;
import com.example.bmpshow.v9.PrintMethod;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView text;
	Button button0,button1,button2,button3,button4,button5;
	ImageView image,image2;
//	Context c;
	
	int image_width;
	int image_heigh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.text);
		button0 = (Button) findViewById(R.id.button0);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		
		image = (ImageView) findViewById(R.id.image);
		image2 = (ImageView) findViewById(R.id.image2);
//		c = this;
		
		
		
		button0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/rgbtest.bmp",text);
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/011260.bmp",text);
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/011261.bmp",text);
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/030250.bmp",text);
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/030281.bmp",text);
//					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/030298.bmp",text);
					BMPMassege.OpenFile(FileMassege.getSDPath()+"/360/030291.bmp",text);
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bitmap bitmap = BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291.bmp"); //从本地取图片
				image2.setImageBitmap(bitmap);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				saveBmp(image_width, image_heigh, FileMassege.getSDPath()+"/360/brbg2.bmp", imageR, imageG, imageB,true);
				Bitmap bitmap = BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291color.bmp"); //从本地取图片
				image.setImageBitmap(bitmap);
			}
		});
		button3.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				saveBmp(image_width, image_heigh, FileMassege.getSDPath()+"/360/brbg3.bmp", imageR, imageG, imageB,false);
				Bitmap bitmap = BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291black.bmp"); //从本地取图片
				image.setImageBitmap(bitmap);
			}
		});
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**
				 * 效果未明还有待研究
				 * 该功能不可用
				 * */
				Bitmap bitmap = BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291luminance.bmp"); //从本地取图片
				image.setImageBitmap(bitmap);
				
//				PrintMethod.print_single_nail(image.getDrawingCache(),116 , 116, 41, 117,1);
			}
		});
		
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**
				 * 效果未明还有待研究
				 * 该功能不可用
				 * */
				int i = 0;
				Bitmap bmp = BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291.bmp"); //从本地取图片
				Bitmap bitmap=null;
				for (int j = 0; j < 20; j++) {
					
					bitmap = BMPMassege.convertToBlackWhite(bmp, text);//BMPMassege.getLoacalBitmap(FileMassege.getSDPath()+"/360/030291luminance.bmp"); //从本地取图片
				
				}
				
				image.setImageBitmap(bitmap);
				
//				i = BMPMassege.convertToBlackWhite(bmp,text);
				
				switch (i) {
				case 0:
					text.append("\n黑色墨盒打印");
					break;
				case 1:
					text.append("\n混合墨盒打印");
					break;
				case 2:
					text.append("\n彩色墨盒打印");
					break;

				default:
					break;
				}
				
//				PrintMethod.print_single_nail(image.getDrawingCache(),116 , 116, 41, 117,1);
			}
		});
		
	}
	
	
	

	
}
