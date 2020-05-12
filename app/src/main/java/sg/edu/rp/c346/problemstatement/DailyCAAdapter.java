package sg.edu.rp.c346.problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DailyCAAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> dailyCAS;
    private Context context;
    private TextView tvWeek,tvDailyGrade;

    public DailyCAAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        dailyCAS = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row,parent,false);
        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvDailyGrade = rowView.findViewById(R.id.tvDailyGrade);
        DailyCA currentDailyGrade = dailyCAS.get(position);
        tvWeek.setText("Week " + currentDailyGrade.getWeek().toString());
        tvDailyGrade.setText(currentDailyGrade.getDgGrade());
        return rowView;

    }


}
