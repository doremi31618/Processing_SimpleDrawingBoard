import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Processing_SimpleDrawingBoard extends PApplet {

ArrayList<DrawPoint> mousePoint;
public void setup()
{
  
  mousePoint = new ArrayList<DrawPoint>();
  frameRate=120;
}

public void draw(){
  background(255);
  
  for(int i=0; i<mousePoint.size(); i++){
   DrawPoint _draw = mousePoint.get(i);
   _draw.display();
  }
  if (keyPressed) {
    if(key=='z' ||key=='Z'){
      if(mousePoint.size()>=1){
        mousePoint.remove(mousePoint.size()-1);
      }
    }
  }
 
}


public void mouseDragged()
{
  if(mouseButton == RIGHT){
    DrawPoint _erasePoint = new DrawPoint(mousePoint.size(),new PVector(mouseX,mouseY),color(255),50);
    mousePoint.add(_erasePoint);
  }else{
   DrawPoint _drawPoint = new DrawPoint(mousePoint.size(),new PVector(mouseX,mouseY),color(0),5);
   mousePoint.add(_drawPoint);
  }
 
}
class DrawPoint{
  int pointColor=color(0);
  float pointWeight=1;
  PVector pointPosition=new PVector(0,0);
  public int index;
  
  public DrawPoint(int _index,PVector _pointPosition,int _pointColor,int _pointWeight){
    pointPosition = _pointPosition;
    pointColor = _pointColor;
    pointWeight = _pointWeight;
    index = _index;
  }
  
  public void display(){
    stroke(pointColor);
    strokeWeight(pointWeight);
    point(pointPosition.x,pointPosition.y);
  }
  
}
public void keyPressed(){
  if(key == 's' || key =='S'){
    String filePath = "pic/ScreenShot/";
    String time = month() +"_" +day() +"_" +hour() +"_" + minute() +"_" + second() ;
    saveFrame(filePath +time+  ".jpg");
  }
  
}
  public void settings() {  size(640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Processing_SimpleDrawingBoard" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
