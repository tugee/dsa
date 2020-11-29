import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Shape{
    int GetArea();
}

class Rectangle implements Shape{
    int height;
    int width;
    
    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }
    public int GetArea() {
        return Math.round(height * width);
    }
}

class Triangle implements Shape {

    int height;
    int width;

    public Triangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int GetArea() {
        return (int) Math.round((height * width)/2);
    }
}

class Circle implements Shape {

    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int GetArea() {
        return (int) Math.round(3.14*(radius * radius));
    }
}


public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String rawInput;
        try {
            rawInput = in.nextLine();

            String[] parameters = rawInput.split(" ");

            int rectHeight = Integer.parseInt(parameters[0]);
            int rectWidth = Integer.parseInt(parameters[1]);

            int triHeight = Integer.parseInt(parameters[2]);
            int triWidth = Integer.parseInt(parameters[3]);

            int cirRadius = Integer.parseInt(parameters[4]);

            int totalArea = 0;

            List<Shape> shapes = new ArrayList<>();
            shapes.add(new Rectangle(rectHeight, rectWidth));
            shapes.add(new Triangle(triHeight, triWidth));
            shapes.add(new Circle(cirRadius));

            for(Shape shape : shapes)
            {
                totalArea += shape.GetArea();
            }

            System.out.println(String.valueOf(totalArea));

        } catch (Exception e) {
        }
    }
}
