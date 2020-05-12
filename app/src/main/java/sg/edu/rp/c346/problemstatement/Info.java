package sg.edu.rp.c346.problemstatement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Info extends AppCompatActivity {
    ListView lvInfo;
    Button btnAdd,btnInfo,btnEmail;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCAList;
    int RequestCode1 = 1;
    String moduleCode,emailTo,email;
    Integer weeks = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lvInfo = findViewById(R.id.lvInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);
        dailyCAList = new ArrayList<>();
        dailyCAList.add(new DailyCA("A",1));
        dailyCAList.add(new DailyCA("B",2));
        dailyCAList.add(new DailyCA("A",3));



        Intent intent = getIntent();
        emailTo = intent.getStringExtra("email");
        moduleCode = intent.getStringExtra("moduleCode");
        setTitle("Info for " + moduleCode);
        aa = new DailyCAAdapter(this,R.layout.row,dailyCAList);
        lvInfo.setAdapter(aa);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Info.this,AddGrade.class);
                intent1.putExtra("weeks",dailyCAList.size()+1);
                startActivityForResult(intent1,RequestCode1);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int  num = dailyCAList.size();
                for (int  b = 0;b<num;b++){
                    DailyCA ca = dailyCAList.get(b);
                    email = email + "Week " + ca.getWeek() + " DG " + ca.getDgGrade() + "\n";
                    Intent sendEmail = new Intent(Intent.ACTION_SEND);
                    sendEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{emailTo});
                    sendEmail.putExtra(Intent.EXTRA_TEXT,"Hi faci, \n\nI am...\nPlease see my remarks so far, thank you! \n" +email);
                    sendEmail.setType("message/rfc822");
                    startActivity(Intent.createChooser(sendEmail,"Choose an email client:"));
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == RequestCode1){
                DailyCA newCa = (DailyCA) data.getSerializableExtra("newCa");
                dailyCAList.add(newCa);
                aa.notifyDataSetChanged();

            }
        }
    }


}
