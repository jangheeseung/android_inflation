참고:안드로이드 프로그래밍(생능출판), https://www.android.com

Inflater (xml->setcontentview()->findviewbyid())
Void setcontentview();
1. 리소스 아이디를 받거나
2. inflat 한다->LinearLayout을 리턴->V=Xml객체 생성 

setContentView(v)하나는 v를 받거나->xml에 파일에 있는 내용을 읽어서 그걸 new로 생성해서 매단다 (hierarchy 만들어서 최상위에 매단다.) 
레이아웃 XML파일을 View객체로 만들기 위해서는 LayoutInflater를 이용한다.
간략하게 코드로 작성하면 이렇게 쓸 수 있다.

LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View view = inflater.inflate(R.layout.my_layout, parent, false);
LayoutInflate.

객체를 생성->new를 이용해서 객체를 생성하는게 더 쉽다. 
하지만 protected로 막혀 있기 때문에 할 수 없다. ->그래서 다른 방법을 제공해 준다.

그 방법은 Activity.getLayoutInflater() 또는 Context.getSystemService(Class)  를 사용해서 inflate()해주는 방법이다.
LayoutInflater inflater =getLayoutInflater();
LayoutInflater inflater = getSystemService(class);
->인자를 class나 서비스를 명시해 줘야한다.
LayoutInflater inflater = getSystemService (Context.LAYOUT_INFLATER_SERVICE);
->서비스명시
LayoutInflater inflater =LayoutUnflater.from(this);
 
이렇게 3가지 방법이 있다.

그 방법도 아니라면 객체를 만들고 직접 함수를 호출하는 방법도 있는대
Inflater.inflate (int resourceID, ViewGroup root);
 
이렇게 쓸 수 있다. 
ResourceID와 View 그룹의 root를 받아와서 
xml이 LinearLayout에 textView와 button을 매단 상태이다. 

View v는 v=inflate(int resID,ViewGroup root)이다.
여기서 만약 v를 최상위로 쓰고 싶으면 root에 null을 넣어 주면 되고,
만약 나만의 hierarchy가 있거나 중간에 넣고 싶다면, root에 넣으면 된다. 

LinearLayout
    ㅣ      \    
TextView    button
    ㅣ 
Hierarchy

View.inflate(this. int resID,ViewGroup root)->간단한 코딩을 할 때는 이것만 쓴다. 
View에 기본적인 inflate 함수가 들어가 있어서 가능하다. 

그렇다면 과연 Inflation을 쓰는 경우는 과연 언제 일까?

Inflation을 쓰는경우
전체 ui가 아니라 컴포넌트 단위로 전개하고 싶을 때
만약 내가 버튼을 예쁘게 한 개를 만들었을 때 이 버튼을 프로젝트마다 넣고 싶다 그러면?
1.	xml에 복사해서 넣기 ,
2.	button따로 수동으로 전개 하기(inflation 버튼xml에)
 여기서 내가 넣고 싶은 버튼은 my_button xml이다
LayoutInflater inflater
 = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
Button btButton=(Button) inflater.inflate(R.layout.my_button,null);
llManager.addView(btMyButton);
	
	Button btButton=(Button)View.inflate(this,R.layout.my_button,null);
위에 코드들 대신에 이렇게 한 줄로 줄여서 쓸 수 있다.
그렇다면 지금부터 전체적인 코드를 보면서 정리를 해보겠다.

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

  //      LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);//width랑 height가 필요 x  나의 속성이 아니라 무시한다
   //     Button btMyButton=(Button) inflater.inflate(R.layout.my_buuton4,null);//xml에 먹지 않더라고 wrap_parent를 지우면 안된다.

Button btMyButton= (Button)View.inflate(this,R.layout.my_button,null);//위에 두줄 대신 이 한줄로도 쓸수있다.

        LinearLayout llManager =new LinearLayout(this);

        llManager.setOrientation(LinearLayout.VERTICAL);		

 	LinearLayout.LayoutParams llParams=new LinearLayout.LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        llManager.addView(tvHello ,llParams);
    //    llManager.addView(btOk, llParams);
         llManager.addView(btMyButton);
        setContentView(llManager,llParams);//매달자(llPrams를 쓰면height랑 width 속성이 적용된다.)
    }
}


