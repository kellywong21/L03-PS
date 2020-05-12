package sg.edu.rp.c346.problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddGrade extends AppCompatActivity {
    TextView tvWeeks;
    RadioGroup rgGrade;
    RadioButton rb1;
    Button btnSubmit;
    Integer selectedRG;
    Integer weeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        tvWeeks = findViewById(R.id.tvWeeks);
        rgGrade = findViewById(R.id.rgGrade);
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent intent1 = getIntent();
        weeks = intent1.getIntExtra("weeks",0);
        tvWeeks.setText("Week " + weeks );

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedRG = rgGrade.getCheckedRadioButtonId();
                rb1 = findViewById(selectedRG);


                DailyCA newCa = new DailyCA(rb1.getText().toString(),weeks);
                Intent i = new Intent();
                i.putExtra("newCa",newCa);
                setResult(RESULT_OK,i);
                finish();



            }
        });

    }
}
