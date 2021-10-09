package space.kuz.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;

import static space.kuz.myapplication.MyComputer.arrPro;
import static space.kuz.myapplication.MyComputer.arrPro_1;

public class MainActivity extends AppCompatActivity {
    TextView t ;
    TextView t2;
    MyComputer[] myArrayComputer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         t = findViewById(R.id.d);
        t2 = findViewById(R.id.d2);
        final int SIZE=10000;
        setHashMap();
        myArrayComputer = new MyComputer[SIZE];
                for (int i = 0; i <myArrayComputer.length ; i++) {
           myArrayComputer[i]= new MyComputer();
        }
        String s ="";
        for (int i = 0; i <myArrayComputer.length ; i++) {
            s=s+myArrayComputer[i].getCent() +" "+myArrayComputer[i].getMind()+" " +myArrayComputer[i].getPro() +"\n";
        }
        t.setText(s);
        s="";
        BubbleSort.sort(myArrayComputer);
     //   InsertionSort.sort(myArrayComputer);
       // SelectSort.sort(myArrayComputer);

        for (int i = 0; i <myArrayComputer.length ; i++) {
            s=s+myArrayComputer[i].getCent() +" "+myArrayComputer[i].getMind()+" " +myArrayComputer[i].getPro() + "\n";
        }
        t2.setText(s);

    }

    private void setHashMap() {
        for (int i = 0; i <arrPro.length ; i++) {
            arrPro_1.put(arrPro[i],i);
        }
    }


}