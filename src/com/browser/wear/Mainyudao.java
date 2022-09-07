package com.browser.wear;
import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import java.io.*;
import java.util.*;
//这是一个自动记录崩溃日志的Application日志路径:/sdcard/崩溃日志.java
public class Mainyudao extends Application implements Thread.UncaughtExceptionHandler,Runnable{
				public static Context 上下文;
				@Override
    public void onCreate(){
				if(上下文==null){上下文=getApplicationContext();
				super.onCreate();
				异常处理=Thread.getDefaultUncaughtExceptionHandler();
				Thread.setDefaultUncaughtExceptionHandler(this);//设置该CrashHandler为程序的默认处理器
				}
				
				}
				@Override
    public void run(){
				Looper.prepare();
				Toast.makeText(上下文,"很抱歉,程序出现异常,即将退出\n异常日志:/sdcard/崩溃日志.java",1).show();
				Looper.loop();
    }
				private Thread.UncaughtExceptionHandler 异常处理;
				@Override  
    public void uncaughtException(Thread 线程, Throwable 异常){
				if(异常==null&&异常处理!=null){//如果用户没有处理则让系统默认的异常处理器来处理  
				异常处理.uncaughtException(线程,异常);}else{
				new Thread(this).start();
				try{
				FileWriter fw = new FileWriter("/sdcard/崩溃日志.java");
				fw.write(获取异常(异常));
				fw.flush();
				fw.close();
				Thread.sleep(2000L);
				}catch(Exception e){}
				异常处理.uncaughtException(线程,异常); 
				}
				System.exit(1);android.os.Process.killProcess(android.os.Process.myPid());
				}
				public static String 获取异常(Throwable 异常){
				Writer writer = new StringWriter();  
				PrintWriter printWriter = new PrintWriter(writer);  
				异常.printStackTrace(printWriter); 
				return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm ").format(new Date())+writer.toString();
				}  



}
