package Syntax.Super;

public class Shape{
    int x,y;

    Shape(){
        x = y = 0;
    }
    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Rectangle extends Shape{
    int width,height;

    public Rectangle(){
        this(0,0,0,0);
    }

    public Rectangle(int x,int y,int w,int h){
        super(x,y);
        width =w;
        height = h;
    }
}