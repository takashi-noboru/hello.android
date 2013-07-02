package com.example.helloandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
	ProgressDialog progressDialog;
	int DIALOG_DISPLAY_LENGTH = 3000;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ProgressDialogインスタンスを生成
        progressDialog = new ProgressDialog(this);
        
        // フ?ロク?レススタイルを設定
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        
        // キャンセル可能に設定
        progressDialog.setCancelable(true);
        
        // タイトルを設定
        progressDialog.setTitle( "タイトル" );
        
        // メッセーシ?を設定
        progressDialog.setMessage( "メッセージ" );
        
        // タ?イアロク?を表示
        progressDialog.show();
        
        // 3秒後にタ?イアロク?を消す
        new Thread(new Runnable() {
        	@Override
        	public void run() {
		        try{
		     		progressDialog.setMax(DIALOG_DISPLAY_LENGTH/100);
		     		for(int i=0; i<progressDialog.getMax(); i++) {
		     			// 進捗率を更新
		     			progressDialog.setProgress(i);
		     			Thread.sleep(100);
		     		}
		        }
		        catch (InterruptedException e){
		        	
		        }
		        progressDialog.dismiss();
  			}
        }).start();

    }
}