package com.miet.walkman295.unirating;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Section1_1_1_Statistics extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        GraphView graph = (GraphView) findViewById(R.id.graphics);

        //график start
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
            new DataPoint(0,2),
            new DataPoint(1,6),
            new DataPoint(5,3)
        });
        //график end

        //гистограмма start
        /*BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0,2),
                new DataPoint(1,6),
                new DataPoint(5,3)
        });*/
        //гистограмма end

        /*
        установка цвета
        толщина линии графика
        отмечать точки на графике
        радиус точек-отметок
         */
        series.setColor(Color.BLUE);
        series.setThickness(10);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);

        graph.addSeries(series);
    }
}