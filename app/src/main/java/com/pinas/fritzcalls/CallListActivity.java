package com.pinas.fritzcalls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CallListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_list);

        //CallController.getInstance().getCallList("fx8320xtred");

        TableLayout layout = (TableLayout) findViewById(R.id.call_layout);
        List<String> calls = Globals.getInstance().getCalls();

        TableRow headline = new TableRow(this);
        headline.setGravity(Gravity.CENTER);
        TextView typeView = new TextView(this);
        typeView.setText("Anrufart");
        typeView.setPadding(15, 10, 15, 20);
        headline.addView(typeView);

        TextView numberView = new TextView(this);
        numberView.setText("Nummer");
        numberView.setPadding(15, 10, 15, 20);
        headline.addView(numberView);

        TextView timeView = new TextView(this);
        timeView.setText("Anrufzeit");
        timeView.setPadding(15, 10, 15, 20);
        headline.addView(timeView);

        TextView durationView = new TextView(this);
        durationView.setText("Dauer");
        durationView.setPadding(15, 10, 15, 20);
        headline.addView(durationView);

        layout.addView(headline);

        for (String call : calls) {
            String[] allSplit = call.split(" ");
            List<String> content = new ArrayList<>();
            for (String split : allSplit) {
                if (split.length() >= 1) {
                    content.add(split);
                }
            }

            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER);
            row.addView(getCallType(content.get(0)));
            row.addView(getNumber(content.get(1)));
            row.addView(getTime(content.get(2), content.get(3)));
            row.addView(getDuration(content.get(4)));
            layout.addView(row);
        }
    }

    private TextView getCallType(String typeNumber) {
        TextView callTypeView = new TextView(this);
        String typeText;
        switch (typeNumber) {
            case "1":
                typeText = "Eingehend";
                break;
            case "2":
                typeText = "Verpasst";
                break;
            case "3":
                typeText = "Ausgehend";
                break;
            default:
                typeText = typeNumber;
                break;
        }
        callTypeView.setText(typeText);
        callTypeView.setPadding(15, 10, 15, 10);
        return callTypeView;
    }

    private TextView getNumber(String callNumber) {
        TextView callNumberView = new TextView(this);
        callNumberView.setText(callNumber);
        callNumberView.setPadding(15, 10, 15, 10);
        return callNumberView;
    }

    private TextView getTime(String date, String time) {
        TextView callTimeView = new TextView(this);
        callTimeView.setText(date + " " + time);
        callTimeView.setPadding(15, 10, 15, 10);
        return callTimeView;
    }

    private TextView getDuration(String duration) {
        TextView callDurationView = new TextView(this);
        callDurationView.setText(duration);
        callDurationView.setPadding(15, 10, 15, 10);
        return callDurationView;
    }
}