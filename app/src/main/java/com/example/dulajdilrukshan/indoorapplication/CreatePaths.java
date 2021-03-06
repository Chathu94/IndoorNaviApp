package com.example.dulajdilrukshan.indoorapplication;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
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
    ArrayList<Integer>pathsindex=new ArrayList<>();


    public void drawingpaths(Canvas canvas,float locationarray[][],float connectionarray[][])
    {

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        paint.setShader(new LinearGradient(0, 0, 5, 5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);


        //canvas.drawLine(209f,640f+20, st, yt, paint);
        //canvas.drawLine(x1, y1 - 50, x2, y2 - 50, paint);
        //canvas.drawLine(x2, y2 - 50, x3, y3 - 50, paint);


        locationindex=new ArrayList<>(Arrays.asList("Auditorium","MultimediaLab","MSCRoom","Library","LectureHallOne","DCCNLab",
                "Lift","CommonRoom","StaffRoom","WashRoom"));

        connectionindex=new ArrayList<>(Arrays.asList("con1","con2","con4","con5","con6","con7","con8","con9","con10","mainCon"));

        //if(!paths.get(0).startsWith("con")) //if location is the first element in the Paths array
        {
            for (int i = 0; i <paths.size(); i++)
            {
                for (int j = 0; j < locationindex.size(); j++)
                {
                    if (paths.get(i).equalsIgnoreCase(locationindex.get(j)))
                    {
                        for (int k = 0; k < connectionindex.size(); k++)
                        {
                            if (paths.get(i+1).equalsIgnoreCase(connectionindex.get(k)))
                            {
                                float startX = locationarray[j][0];
                                float startY = locationarray[j][1];
                                float stopX = connectionarray[j][0];
                                float stopY = connectionarray[j][1];
                                canvas.drawLine(startX, startY, stopX, stopY, paint);
                                break;
                            }
                        }
                        break;
                    }
                   break;

                }
            }
        }
        //else
        {
            for (int i = 1; i < paths.size(); i++)
            {
                for (int j=0;j<connectionindex.size();j++)
                {
                    if(paths.get(i).equalsIgnoreCase(connectionindex.get(j)))
                    {
                        for(int k=0;k<locationindex.size();k++)
                        {
                            if(paths.get(i).equalsIgnoreCase(locationindex.get(k)))
                            {
                                float startX = locationarray[j][0];
                                float startY = locationarray[j][1];
                                float stopX = connectionarray[j][0];
                                float stopY = connectionarray[j][1];
                                canvas.drawLine(startX, startY, stopX, stopY, paint);
                                break;
                            }
                            else
                                if(paths.get(i).equalsIgnoreCase(connectionindex.get(k)))
                                {
                                    float startX = connectionarray[j][0];
                                    float startY = connectionarray[j][1];
                                    float stopX = locationarray[j+1][0];
                                    float stopY = locationarray[j+1][1];
                                    canvas.drawLine(startX, startY, stopX, stopY, paint);

                                }
                            break;
                        }
                        break;
                    }
                    break;

                }
                break;
            }
        }


//            canvas.drawLine(connectionarray[0][0],connectionarray[0][1],connectionarray[1][0],connectionarray[1][1], paint);//Con1toCon2
//            canvas.drawLine(connectionarray[1][0],connectionarray[1][1],connectionarray[2][0],connectionarray[2][1], paint);//Con2toCon4
//            canvas.drawLine(connectionarray[2][0],connectionarray[2][1],connectionarray[3][0],connectionarray[3][1], paint);//Con4toCon5
//            canvas.drawLine(connectionarray[3][0],connectionarray[3][1],connectionarray[9][0],connectionarray[9][1], paint);//Con5toConMain
//            canvas.drawLine(connectionarray[3][0],connectionarray[3][1],connectionarray[4][0],connectionarray[4][1], paint);//Con5toCon6
//            canvas.drawLine(connectionarray[4][0],connectionarray[4][1],connectionarray[5][0],connectionarray[5][1], paint);//Con6toCon7
//            canvas.drawLine(connectionarray[5][0],connectionarray[5][1],connectionarray[7][0],connectionarray[7][1], paint);//Con7toCon9
//            canvas.drawLine(connectionarray[5][0],connectionarray[5][1],connectionarray[6][0],connectionarray[6][1], paint);//Con7toCon8
//            canvas.drawLine(connectionarray[7][0],connectionarray[7][1],connectionarray[8][0],connectionarray[8][1], paint);//Con9toCon10
//
//
//            canvas.drawLine(locationarray[0][0], locationarray[0][1],connectionarray[0][0],connectionarray[0][1], paint);//Auditorium
//            canvas.drawLine(connectionarray[0][0],connectionarray[0][1],locationarray[1][0], locationarray[1][1], paint);//Multimedia
//            canvas.drawLine(locationarray[2][0],locationarray[2][1],connectionarray[1][0],connectionarray[1][1], paint);//MSC
//            canvas.drawLine(locationarray[4][0],locationarray[4][1],connectionarray[1][0],connectionarray[1][1], paint);//Hallone
//            canvas.drawLine(connectionarray[2][0],connectionarray[2][1],locationarray[3][0],locationarray[3][1], paint);//Library
//            canvas.drawLine(connectionarray[9][0],connectionarray[9][1],locationarray[5][0],locationarray[5][1], paint);//DCCN
//            canvas.drawLine(connectionarray[3][0],connectionarray[3][1],locationarray[6][0],locationarray[6][1], paint);//Lift
//            canvas.drawLine(connectionarray[7][0],connectionarray[7][1],locationarray[7][0],locationarray[7][1], paint);//CommonRoom
//            canvas.drawLine(connectionarray[8][0],connectionarray[8][1],locationarray[9][0],locationarray[9][1], paint);//WashRoom
//            canvas.drawLine(connectionarray[6][0],connectionarray[6][1],locationarray[8][0],locationarray[8][1], paint);//StaffRoom
    }
    public void createpath(String startlocation, String destination)
    {
        auditoriumtomain=new ArrayList<>(Arrays.asList("con1","Auditorium","con1","MultimediaLab","con1","con2","MSCRoom","con2","LectureHall1","con2"
                ,"con4","Library","con4"));

        maintostaff=new ArrayList<>(Arrays.asList("con5","conMain","DCCNLab","conMain","con5","Lift","con5","con6","con7","con9",
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
