package com.example.dulajdilrukshan.indoorapplication;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class CreatePaths{

//    public LinearLayout Auditorium,Multimedia,MSCRoom,LectureHall1,Library,DCCNLab,LiftLobby,CommonRoom,WashRooms,StaffRoom;
//    public LinearLayout con1,con2,con4,main,con5,con6,con7,con8,con9,con10;

    int startlocation1index=0,destination1index=0,startlocation2index=0,destination2index=0;
    boolean isDestination1=false,isDestination2=false;
    int index=0;
    PathActivity location=new PathActivity();


    ArrayList<String>paths=new ArrayList<>();
    ArrayList<String>path1=new ArrayList<>();
    ArrayList<String>path2=new ArrayList<>();
    ArrayList<String>auditoriumtomain=new ArrayList<>();
    ArrayList<String>maintostaff=new ArrayList<>();
    ArrayList<String>locationindex=new ArrayList<>();
    ArrayList<String>connectionindex=new ArrayList<>();


    public void drawingpaths(Canvas canvas,float locationarray[][],float connectionarray[][])
    {

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        paint.setShader(new LinearGradient(0, 0, 5, 5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);


        //canvas.drawLine(209f,640f+20, st, yt, paint);
        //canvas.drawLine(x1, y1 - 50, x2, y2 - 50, paint);
        //canvas.drawLine(x2, y2 - 50, x3, y3 - 50, paint);


        for(int i=0;i<paths.size();i++)
        {
            for (int j=0;j<=i;j++)
            {
                canvas.drawLine(locationarray[i][j],);
            }
        }

    }

    public void createpath(String startlocation, String destination)
    {
        auditoriumtomain=new ArrayList<>(Arrays.asList("con1","Auditorium","con1","Multimedia","con1","con2","MSCRoom","con2","LectureHall1","con2"
                ,"con4","Library","con4"));

        maintostaff=new ArrayList<>(Arrays.asList("conMain","DCCNLab","conMain","con5","Lift","con5","con6","con7","con9",
                "CommonRoom","con7","con9","con10","WashRoom","con7","con8","StaffRoom"));



        //From Auditorium to Library
            for (int j = 0; j < auditoriumtomain.size(); j++)
            {
                if (auditoriumtomain.get(j).equalsIgnoreCase(startlocation))
                    {
                        for (int i = 0; i < auditoriumtomain.size(); i++)
                        {
                            if (auditoriumtomain.get(i).equalsIgnoreCase(startlocation))
                            {
                                startlocation1index = i;
                                break;
                            }

                        }
                    }
            }
        for(int y=0;y<auditoriumtomain.size();y++)
        {
            if (auditoriumtomain.get(y).equalsIgnoreCase(destination))
            {

                destination1index = y;
                isDestination1=true;
                break;
            }


        }
        if (startlocation1index < destination1index) {
            for (int i = startlocation1index; i <= destination1index; i++) {

                {
                    path1.add(auditoriumtomain.get(i));
                }
            }
        } else
            if (startlocation1index > destination1index)
            {
                if(!isDestination1)
                {
                    for (int i = startlocation1index; i < auditoriumtomain.size(); i++) {

                        {
                            path1.add(auditoriumtomain.get(i));
                        }
                    }
                }
                else
                {
            for (int i = startlocation1index; i >= destination1index; i--)
            {
                path1.add(auditoriumtomain.get(i));
            }
            }
        }
//Only if the Destination and Start location are in a same array
        if(isDestination1) {
            for (int i = 0; i < path1.size() - 1; i++) {
                if (!path1.get(i).startsWith("con")) {
                    if (!path1.get(i).equalsIgnoreCase(startlocation) || !path1.get(path1.size() - 1).equalsIgnoreCase(destination)) {
                        path1.remove(i);
                    }
                }

            }
        }



        //From conMain to StaffRoom
        for (int j = 0; j < maintostaff.size(); j++)
        {
            if (maintostaff.get(j).equalsIgnoreCase(startlocation))
            {
                for (int i = 0; i < maintostaff.size(); i++)
                {
                    if (maintostaff.get(i).equalsIgnoreCase(startlocation))
                    {
                        startlocation2index = i;
                        break;
                    }

                }
            }
        }
        for(int y=0;y<maintostaff.size();y++)
        {
            if (maintostaff.get(y).equalsIgnoreCase(destination))
            {

                destination2index = y;
                isDestination2=true;
                break;
            }


        }

        if (startlocation2index < destination2index) {
            for (int i = startlocation2index; i <= destination2index; i++) {

                {
                    path2.add(maintostaff.get(i));
                }
            }
        } else
        if (startlocation2index > destination2index)
        {
            if(!isDestination2)
            {
                for (int i = startlocation2index; i < maintostaff.size(); i++) {

                    {
                        path2.add(maintostaff.get(i));
                    }
                }
            }
            else
            {
                for (int i = startlocation2index; i >= destination2index; i--)
                {
                    path2.add(maintostaff.get(i));
                }
            }
        }
//Only if the Destination and Start location are in a same array
        if(isDestination2) {
            for (int i = 0; i < path2.size() - 1; i++) {
                if (!path2.get(i).startsWith("con")) {
                    if (!path2.get(i).equalsIgnoreCase(startlocation) || !path2.get(path2.size() - 1).equalsIgnoreCase(destination)) {
                        path2.remove(i);
                    }
                }

            }
        }


            paths.addAll(path1);
            paths.addAll(path2);




    }

    public void findindex()
    {
        locationindex=new ArrayList<>(Arrays.asList("Auditorium","Multimedia","MSCRoom","Library","LectureHallOne","DCCNLab",
                "Lift","CommonRoom","StaffRoom","WashRoom"));

        connectionindex=new ArrayList<>(Arrays.asList("con1","con2","con4","con5","con6","con7","con8","con9","con10","mainCon"));
    }
    public void  text(TextView textView,int index)
    {
        float locationarray[][]=new float[0][1];
        float connectionarray[][]=new float[0][1];
        createpath("Library","CommonRoom");

        {
            textView.setText(" "+paths.get(index));
            //index++;
        }


    }

}
