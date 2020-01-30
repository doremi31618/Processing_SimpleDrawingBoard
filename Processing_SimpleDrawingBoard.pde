ArrayList<DrawPoint> mousePoint;
void setup()
{
  size(640,480);
  mousePoint = new ArrayList<DrawPoint>();
}

void draw(){
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


void mouseDragged()
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
  color pointColor=color(0);
  float pointWeight=1;
  PVector pointPosition=new PVector(0,0);
  public int index;
  
  public DrawPoint(int _index,PVector _pointPosition,color _pointColor,color _pointWeight){
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