#include<stdio.h>
#include<graphics.h>
inline float mod(float i)
{
    return (i < 0) ? (-1 * i) : i;
}

void Ellipse1(float H,float K,float a,float b)
{
  float h = (float)getwindowheight();
  float w = (float)getwindowwidth();
  float x = 0;
  float y = b;
  float p;
  while(mod(b * b * x) < mod(a * a * y))
  {
    putpixel(H + x + w/2,(h/2) - (y + K),WHITE); //x,y
    putpixel(H + (-1 * x) + w/2,(h/2) - (y + K),WHITE); //-x,y
    putpixel(H + (-1 * x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //-x,-y
    putpixel(H + (x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //x,-y
    p = ((x + 1) * (x + 1) * b * b) + ((y - 0.5) * (y - 0.5) * a * a) - (a * a * b * b) ;

    if(p >= 0)
     y--;
    delay(10);
    x++;
   }

  while(y >= 0)
  {
    putpixel(H + x + w/2,(h/2) - (y + K),WHITE); //x,y
    putpixel(H + (-1 * x) + w/2,(h/2) - (y + K),WHITE); //-x,y
    putpixel(H + (-1 * x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //-x,-y
    putpixel(H + (x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //x,-y
    p = ((x + 0.5) * (x + 0.5) * b * b) + ((y - 1) * (y - 1) * a * a) - (a * a * b * b) ;

    if(p <= 0)
     x++;
    delay(10);
    y--;
   }
}
void circle1(float H,float K,float r)
{
  float h = (float)getwindowheight();
  float w = (float)getwindowwidth();
  float x = 0;
  float y = r;
  float p;

  while(x <= y)
  {

  //  putpixel(H + x,y + K,WHITE);
    putpixel(H + x + w/2,(h/2) - (y + K),WHITE); //x,y
    putpixel(H + y + w/2,(h/2) - (x + K),WHITE); //y,x

    putpixel(H + (-1 * x) + w/2,(h/2) - (y + K),WHITE); //-x,y
    putpixel(H + (-1 * y) + w/2,(h/2) - (x + K),WHITE); //-y,x

    putpixel(H + (-1 * x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //-x,-y
    putpixel(H + (-1 * y) + w/2,(h/2) - ((-1 * x) + K),WHITE); //-y,-x

    putpixel(H + (x) + w/2,(h/2) - ((-1 * y) + K),WHITE); //x,-y
    putpixel(H + (y) + w/2,(h/2) - ((-1 * x) + K),WHITE); //y,-x
    delay(50);

    p = (x + 1) * (x + 1) + (y - 0.5) * (y - 0.5) - r * r ;
    if(p >= 0)
     y--;

    x++;
   }

}
//Function for finding absiolute value
int absi (int n)
{
    return ( (n>0) ? n : ( n * (-1)));
}

//DDA Function for line generation
void DDA(float X0, float Y0, float X1, float Y1)
{
    float h = (float)getwindowheight();
    float w = (float)getwindowwidth();

    // calculate dx & dy
    float dx = X1 - X0;
    float dy = Y1 - Y0;

    // calculate steps required for generating pixels
    int steps = absi(dx) > absi(dy) ? absi(dx) : absi(dy);

    // calculate increment in x & y for each steps
    float Xinc = dx / (float) steps;
    float Yinc = dy / (float) steps;

    // Put pixel for each step
    float X = X0;
    float Y = Y0;
    for (int i = 0; i <= steps; i++)
    {
        putpixel (X+w/2,(h/2) - Y,WHITE);
        //putpixel(X,Y,WHITE);
        //delay(10);   // put pixel at (X,Y)
        X += Xinc;                          // increment in x at each step
        Y += Yinc;                          // increment in y at each step
    }
}
void triangle(float x1,float y1,float x2,float y2)
{
  float x3 = -1 * (x1 + x2);
  float y3 = -1 * (y1 + y2);
  DDA(x1,y1,x2,y2);
  DDA(x3,y3,x2,y2);
  DDA(x1,y1,x3,y3);

}
// Driver program
int main()
{
    int gd = DETECT, gm;

    // Initialize graphics function
    initgraph (&gd, &gm, "");

    float h = (float)getwindowheight();
    float w = (float)getwindowwidth();

    DDA(-w/2,0, w/2, 0);
    DDA(0,h/2,0,-h/2);

    //Input values
    //DDA(0,0,w,w);
    //circle1(0,0,100);
    //circle1(0,0,75);
    //circle1(0,0,50);
    //circle1(0,0,50);
    Ellipse1(0,0,100,50);
    Ellipse1(100,100,50,100);

    //triangle(-143.30f,-75,143.30f,-75);


    //circle1(0,0,100);
    getch();
    return 0;
}
