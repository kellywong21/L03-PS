package sg.edu.rp.c346.problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Info extends AppCompatActivity {
    ListView lvInfo;
    Button btnAdd,btnInfo,btnEmail;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCAList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


    }
}
