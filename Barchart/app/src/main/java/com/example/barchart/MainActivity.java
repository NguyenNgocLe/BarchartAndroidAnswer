package com.example.barchart;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart mchart = (BarChart) findViewById(R.id.barChart);
        toTuVan(mchart);
    }

    @SuppressLint("ResourceType")
    public void toTuVan(View view) {
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_main);
        dialog.setCanceledOnTouchOutside(false);//->Click vào bên ngoài thì đóng dialog
        Objects.requireNonNull(dialog.getWindow()).setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        toTuVan(dialog);
        dialog.show();
    }
    public void toTuVan(Dialog dialog){

        BarChart barChart =dialog.findViewById(R.id.barChart);

        ArrayList<BarEntry> datas = new ArrayList<>();
        datas.add(new BarEntry(0,9));
        datas.add(new BarEntry(1, 2));
        datas.add(new BarEntry(2, 3));
        datas.add(new BarEntry(3, 1));

        BarDataSet barDataSet = new BarDataSet(datas, "");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextSize(20f);


        BarData barData = new BarData( barDataSet);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        final String[] labels=new String[]{"A","B","C","D"};
        IndexAxisValueFormatter formatter=new IndexAxisValueFormatter(labels);
        xAxis.setTextSize(18f);
        xAxis.setGranularity(1f);

        xAxis.setValueFormatter(formatter);
        //gán dữ liệu vào barChart
        barChart.setData(barData);

        //Khong ve luoi tren bieu do
        xAxis.setDrawGridLines(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);
        //Zoom bieu do
        barChart.setDoubleTapToZoomEnabled(false);
        //Touch biêu đồ
        barChart.setTouchEnabled(false);

        barChart.animateY(3000);
        barChart.invalidate();
    }
}
