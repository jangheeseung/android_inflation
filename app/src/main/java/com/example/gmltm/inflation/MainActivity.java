package com.example.gmltm.inflation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button btOk=findViewById(R.id.button); xml을 인자로 받는 경우
//        btOk.setText("Yes");

        TextView tvHello =new TextView(this); //width 속성을 주어야 한다.
        tvHello.setText("Hello android in code");

     //   Button btOk=new Button(this);//직접 매다는 경우
       //   btOk.setText("Ok in code");

  //      LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);//width랑 height가 필요 x  나의 속성이 아니라 무시핟
   //     Button btMyButton=(Button) inflater.inflate(R.layout.my_buuton4,null);//xml에 먹지 않더라고 wrap_parent를 지우면 안된다.

        Button btMyButton=(Button)View.inflate(this,R.layout.my_buuton4,null);//위에 두줄 대신 이 한줄로도 쓸수있다.

        LinearLayout llManager =new LinearLayout(this);

        llManager.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams llParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        llManager.addView(tvHello ,llParams);
    //    llManager.addView(btOk, llParams);
         llManager.addView(btMyButton);
        setContentView(llManager,llParams);//매달자(llPrams를 쓰면height랑 width 속성이 적용된다.)
    }
}

//ex) void setContenrView(int resourse2D){
//    [view v=]xml파일을 읽어 최상위에 있는 ..매달자...?
//        각각의 뷰를 생성해서 하이어라키를 만들어 최상위에 만들자->inflate->할수 있는 여러가지 매소드가 있다,
//    set ContentView(v);//여기에 매달면된다.
//        }