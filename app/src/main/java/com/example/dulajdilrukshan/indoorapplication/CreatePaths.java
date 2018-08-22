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

    int startlocationindex=0,destinationindex=0;

    PathActivity location=new PathActivity();


    ArrayList<String>paths=new ArrayList<>();
    ArrayList<String>path1=new ArrayList<>();
    ArrayList<String>path2=new ArrayList<>();
    ArrayList<String>auditoriumtomain=new ArrayList<>();
    ArrayList<String>maintostaff=new ArrayList<>();
    ArrayList<String>locationindex=new ArrayList<>();
    ArrayList<String>connectionindex=new ArrayList<>();


    public void drawingpaths(Canvas canvas)
    {

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        paint.setShader(new LinearGradient(0, 0, 5, 5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);


        //canvas.drawLine(209f,640f+20, st, yt, paint);
        //canvas.drawLine(x1, y1 - 50, x2, y2 - 50, paint);
        //canvas.drawLine(x2, y2 - 50, x3, y3 - 50, paint);

    }

    public void createpath(String startlocation, String destination,float locationarray[][],float connectionarray[][])
    {
        auditoriumtomain=new ArrayList<>(Arrays.asList("Auditorium","con1","Multimedia","con2","MSCRoom","con2","LectureHall1","con4"
                ,"Library","conMain"));

        maintostaff=new ArrayList<>(Arrays.asList("conMain","DCCNLab","con5","Lift","con5","con6","con7","con9",
                "CommonRoom","con7","con9","con10","WashRoom","con7","con8","StaffRoom"));

        locationindex=new ArrayList<>(Arrays.asList("Auditorium","Multimedia","MSCRoom","Library","LectureHallOne","DCCNLab",
                "Lift","CommonRoom","StaffRoom","WashRoom"));

        connectionindex=new ArrayList<>(Arrays.asList("con1","con2","con4","con5","con6","con7","con8","con9","con10","mainCon"));


            for (int j = 0; j < auditoriumtomain.size(); j++)
            {
                if (auditoriumtomain.get(j).equalsIgnoreCase(startlocation))
                {
                    {
                        for (int i = 0; i < auditoriumtomain.size(); i++) {
                            if (auditoriumtomain.get(i).equalsIgnoreCase(startlocation))
                            {
                                startlocationindex = i;
                            }
                            if (auditoriumtomain.get(i).equalsIgnoreCase(destination))
                            {
                                destinationindex = i;
                            }
                        }
                    }
                    if (startlocation.equalsIgnoreCase("Auditorium"))
                    {
                        for (int i = startlocationindex; i <= destinationindex; i++)
                        {
                            path1.add(auditoriumtomain.get(i));
                        }
                    } else if (!startlocation.equalsIgnoreCase("Auditorium"))
                    {
                        for (int i = startlocationindex; i >= destinationindex; i--)
                        {
                            path1.add(auditoriumtomain.get(i));
                        }
                    }
                }
                else
                {

                    for (int k=0;k<maintostaff.size();k++)
                    {
                        if(maintostaff.get(k).equalsIgnoreCase(startlocation))
                        {
                            {
                                for(int l=0;l<maintostaff.size();l++)
                                {
                                    if(maintostaff.get(l).equalsIgnoreCase(startlocation))
                                    {
                                        startlocationindex=l;
                                    }
                                    if(maintostaff.get(l).equalsIgnoreCase(destination))
                                    {
                                        destinationindex=l;
                                    }

                                }
                            }
                            if(startlocation.equalsIgnoreCase("DCCNLab"))
                            {
                                path2.add("conMain");
                                for(int a=startlocationindex+1;a<=destinationindex;a++)
                                {

                                    path2.add(maintostaff.get(a));
                                }
                            }
                            else if(!startlocation.equalsIgnoreCase("DCCNLab"))
                            {
                                for (int b=startlocationindex+1;b>=destinationindex;b--)
                                {
                                    path2.add(maintostaff.get(b));
                                }
                            }
                        }

                    }
                }
            }

        for(int i=0;i<=path1.size();i++)
        {
            if(path1.size()>0)
            {
                paths.add(path1.get(i));
                if(path2.size()>0)
                {
                    for(i=i+path2.size();i<path2.size();i++)
                    {
                        paths.add(path2.get(i));
                    }
                }
            }
            else
            {
                paths.add(path2.get(i));
                if(path1.size()>0)
                {
                    for(i=i+path1.size();i<path1.size();i++)
                    {
                        paths.add(path1.get(i));
                    }
                }
            }
        }

    }

    public void  text(TextView textView)
    {
        float locationarray[][]=new float[0][1];
        float connectionarray[][]=new float[0][1];
        createpath("Library","CommonRoom",locationarray,connectionarray);
       textView.setText(" "+paths.get(0));
    }

}
