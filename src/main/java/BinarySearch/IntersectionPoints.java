package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class IntersectionPoints {

    static class Line{
        int position;
        char direction;

        public Line(int position, char direction) {
            this.position = position;
            this.direction = direction;
        }
    }

    static class Rectangle{

        int x1, y1, x2, y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static class Direction {
        static final char HORIZONTAL = 'x';
        static final char VERTICAL = 'y';
    }


    public static void main(String[] args) {

        List<Line> xLines =  Arrays.asList(new Line(1,'y'),new Line(2,'y'),new Line(4,'y'),new Line(19,'y'));

        List<Line> yLines = Arrays.asList(new Line(2,'x'),new Line(5,'x'),new Line(9,'x'));

        List<Rectangle> rectangles = Arrays.asList(new Rectangle(1,3,3,6));

        int count =0;

        for(Rectangle rectangle:rectangles){
            count+= countInterseectionPoints(xLines,yLines,rectangle);
        }

        System.out.println(count*2);


    }

    private static int countInterseectionPoints(List<Line> xLines, List<Line> yLines, Rectangle rectangle) {
        int count = 0;
        for(Line xLine:xLines){
            if(xLine.position>=rectangle.y1 && xLine.position<=rectangle.y2){
                count++;
            }
        }
        for(Line yLine:yLines){
            if(yLine.position>=rectangle.x1 && yLine.position<=rectangle.x2){
                count++;
            }

        }
        return count;
    }

    static int countIntersectionPointsUsingBS(List<Line> xLines, List<Line> yLines, Rectangle rect) {
        int xLeftIndex = binarySearchX(xLines, rect.x1);
        int xRightIndex = binarySearchX(xLines, rect.x2);
        int yBottomIndex = binarySearchY(yLines, rect.y1);
        int yTopIndex = binarySearchY(yLines, rect.y2);

        int count = 0;
        for (int i = xLeftIndex; i <= xRightIndex; i++) {
            Line xLine = xLines.get(i);
            if (xLine.direction == Direction.HORIZONTAL) {
                for (int j = yBottomIndex; j <= yTopIndex; j++) {
                    Line yLine = yLines.get(j);
                    if (yLine.direction == Direction.VERTICAL) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static int binarySearchX(List<Line> xLines, int pos) {
        int left = 0;
        int right = xLines.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (xLines.get(mid).position == pos) {
                return mid;
            } else if (xLines.get(mid).position < pos) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -left - 1;
    }

    static int binarySearchY(List<Line> yLines, int pos) {
        int left = 0;
        int right = yLines.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (yLines.get(mid).position == pos) {
                return mid;
            } else if (yLines.get(mid).position < pos) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -left - 1;
    }
}
