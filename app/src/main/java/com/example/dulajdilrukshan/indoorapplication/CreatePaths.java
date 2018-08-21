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

    LinearLayout Auditorium,Multimedia,MSCRoom,LectureHall1,Library,DCCNLab,LiftLobby,CommonRoom,WashRooms,StaffRoom;
    LinearLayout con1,con2,con4,main,con5,con6,con7,con8,con9,con10;
    String to, from;
    float x=0,y=0,x1=0,y1=0,x2=0,y2=0,x3=0,y3=0,x4=0,y4=0,x5=0,y5=0,
            x6=0,y6=0,x7=0,y7=0,x8=0,y8=0,x9=0,y9,x10=0,
            y10=0,x11=0,y11=0,x12=0,y12=0;

    PathActivity location=new PathActivity();


    ArrayList<LinearLayout>paths=new ArrayList<>();

    ArrayList<LinearLayout>auditoriumpaths=new ArrayList<>();
    ArrayList<LinearLayout>multimediapaths=new ArrayList<>();
    ArrayList<LinearLayout>mscpaths=new ArrayList<>();
    ArrayList<LinearLayout>hallonepaths=new ArrayList<>();
    ArrayList<LinearLayout>librarypaths=new ArrayList<>();
    ArrayList<LinearLayout>dccnpaths=new ArrayList<>();
    ArrayList<LinearLayout>liftpaths=new ArrayList<>();
    ArrayList<LinearLayout>commonpaths=new ArrayList<>();
    ArrayList<LinearLayout>washroompaths=new ArrayList<>();
    ArrayList<LinearLayout>staffroompaths=new ArrayList<>();




    public void showpaths(Canvas canvas,String startlocation, String destination)
    {
        Auditorium=location.findViewById(R.id.auditorium);
        Multimedia=location.findViewById(R.id.multimedia);
        MSCRoom=location.findViewById(R.id.mscroom);
        LectureHall1=location.findViewById(R.id.hallone);
        Library=location.findViewById(R.id.library);
        DCCNLab=location.findViewById(R.id.dccn);
        LiftLobby=location.findViewById(R.id.lift);
        CommonRoom=location.findViewById(R.id.commonroom);
        WashRooms=location.findViewById(R.id.washroom);
        StaffRoom=location.findViewById(R.id.staffroom);
        con1=location.findViewById(R.id.con1);
        con2=location.findViewById(R.id.con2);

        con4=location.findViewById(R.id.con4);
        con5=location.findViewById(R.id.con5);
        main=location.findViewById(R.id.maincon);
        con6=location.findViewById(R.id.con6);
        con7=location.findViewById(R.id.con7);
        con8=location.findViewById(R.id.con8);
        con9=location.findViewById(R.id.con9);
        con10=location.findViewById(R.id.con10);

        auditoriumpaths=new ArrayList<>(Arrays.asList(Auditorium,con1,Multimedia,con2,MSCRoom,con2,LectureHall1,con4,Library,
                main,con5,LiftLobby,main,DCCNLab,con5,con6,con7,con9,CommonRoom,con10,WashRooms,con7,con8,StaffRoom));

        multimediapaths=new ArrayList<>(Arrays.asList(Multimedia,con1,Auditorium,con2,MSCRoom,LectureHall1,con4,Library,
                main,con5,LiftLobby,main,DCCNLab,con5,con6,con7,con9,CommonRoom,con10,WashRooms,con7,con8,StaffRoom));
        int startlocationarray[]=new int[2];
        int connarray[]=new int[2];
        int endlocationarray[]=new int[2];
        Auditorium.getLocationOnScreen(startlocationarray);
        con1.getLocationOnScreen(connarray);
        Multimedia.getLocationOnScreen(endlocationarray);

        x = startlocationarray[0];
        y = startlocationarray[1];
        x1 = connarray[0];
        y1 =connarray[1];
        x2=endlocationarray[0];
        y2=endlocationarray[1];

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        paint.setShader(new LinearGradient(0, 0, 5, 5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);


        canvas.drawLine(x, y - 50, x1, y1 - 50, paint);
        canvas.drawLine(x1, y1 - 50, x2, y2 - 50, paint);
        canvas.drawLine(x2, y2 - 50, x3, y3 - 50, paint);

    }

    public void  text(TextView textView)
    {

       textView.setText("56565");
    }

}
