package sg.edu.rp.c346.problemstatement;

import androidx.annotation.Nullable;
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvModules = findViewById(R.id.lvModule);
        aa = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dailyCA);
        dailyCA.add("C347");
        lvModules.setAdapter(aa);
        setTitle("P03-Class Journal");

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Info.class);
                intent.putExtra("email","jason_lim@rp.edu.sg");
                intent.putExtra("moduleCode","C347");
                startActivity(intent);
            }
        });

    }

}
