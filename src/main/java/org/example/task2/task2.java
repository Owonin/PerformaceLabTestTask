package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) {

        String file1 = args[0];
        String file2 = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            Circle circle = getCircle(br);
            handlePoints(br2, circle);

        } catch (Exception e) {
            System.out.printf("File read error %s", e.getMessage());
        }
    }

    private static void handlePoints(BufferedReader br2, Circle circle) throws IOException {
        List<Point> points = new ArrayList<>();

        for (String line = br2.readLine(); line != null; line = br2.readLine()) {
            Point point = new Point(Integer.parseInt(line.split(" ")[0]),
                    Integer.parseInt(line.split(" ")[1]));
            points.add(point);
        }
        points.forEach(point -> System.out.println(circle.isPointInside(point)));
    }

    private static Circle getCircle(BufferedReader br) throws IOException {
        String circleCoordinatesLine = br.readLine();

        int circleX = Integer.parseInt(circleCoordinatesLine.split(" ")[0]);
        int circleY = Integer.parseInt(circleCoordinatesLine.split(" ")[1]);
        int radius = Integer.parseInt(br.readLine());

        return new Circle(circleX, circleY, radius);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Circle {
        int x;
        int y;
        int radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public int isPointInside(Point point) {
            double data = Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2);
            double radiusPow = Math.pow(radius, 2.0);

            if (data == radiusPow) {
                return 0;
            }
            if (data > radiusPow) {
                return 2;
            }
            return 1;
        }
    }
}
