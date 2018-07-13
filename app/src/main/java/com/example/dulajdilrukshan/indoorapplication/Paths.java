package com.example.dulajdilrukshan.indoorapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;

public class Paths
{
    public void lifttoaudit(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();
        p.moveTo(220,270);
        p.lineTo(220,730);
        p.moveTo(220,730);
        p.lineTo(300,730);
        p.moveTo(300,730);
        p.lineTo(300,820);
        canvas.drawPath(p, paint);


    }
    public void lifttolibrary(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();

        p.moveTo(300,730);
        p.lineTo(300,820);
        p.moveTo(300,730);
        p.lineTo(190,730);
        canvas.drawPath(p, paint);
    }

    public void lifttomscroom(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();
        p.moveTo(220,500);
        p.lineTo(220,730);
        p.moveTo(220,500);
        p.lineTo(190,500);
        p.moveTo(220,730);
        p.lineTo(300,730);
        p.moveTo(300,730);
        p.lineTo(300,820);

        canvas.drawPath(p, paint);
    }

    public void lifttomultimedia(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();
        p.moveTo(220,330);
        p.lineTo(220,730);
        p.moveTo(220,730);
        p.lineTo(300,730);
        p.moveTo(300,730);
        p.lineTo(300,820);
        p.moveTo(220,330);
        p.lineTo(190,330);
        canvas.drawPath(p, paint);
    }
    public void lifttohallone(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();
        p.moveTo(220,520);
        p.lineTo(220,730);
        p.moveTo(220,730);
        p.lineTo(300,730);
        p.moveTo(300,730);
        p.lineTo(300,820);
        p.moveTo(220,520);
        p.lineTo(240,520);

        canvas.drawPath(p, paint);
    }
    public void lifttodccnlab(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();

        p.moveTo(300,700);
        p.lineTo(380,700);
        p.moveTo(300,700);
        p.lineTo(300,820);


        canvas.drawPath(p, paint);
    }

    public void lifttoStaffroom(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();


        p.moveTo(330,770);
        p.lineTo(330,820);

        p.moveTo(330,770);
        p.lineTo(490,770);

        p.moveTo(490,770);
        p.lineTo(490,1150);

        p.moveTo(490,1150);
        p.lineTo(510,1150);


        canvas.drawPath(p, paint);
    }

    public void lifttoWashroom(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();


        p.moveTo(330,770);
        p.lineTo(330,820);

        p.moveTo(330,770);
        p.lineTo(490,770);

        p.moveTo(490,770);
        p.lineTo(490,940);

        p.moveTo(490,940);
        p.lineTo(620,940);



        canvas.drawPath(p, paint);
    }

    public void lifttocommomroom(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
        Path p = new Path();


        p.moveTo(330,770);
        p.lineTo(330,820);

        p.moveTo(330,770);
        p.lineTo(480,770);

        p.moveTo(480,770);
        p.lineTo(480,910);

        p.moveTo(480,910);
        p.lineTo(650,910);




        canvas.drawPath(p, paint);
    }

    public void showLocation(Canvas canvas,float x,float y)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setShadowLayer(15, 0, 0, Color.BLUE);

        canvas.drawCircle(x, y, 10, paint);
    }



}

