package sg.edu.rp.c346.problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvModules;
    ArrayAdapter<String> aa;
    ArrayList<String> dailyCA = new ArrayList<>();
    int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvModules = findViewById(R.id.lvModule);
        aa = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dailyCA);
        dailyCA.add("C347");
        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Info.class);

            }
        });


    }
}
