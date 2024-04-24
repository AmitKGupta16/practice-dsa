package mockPre.day3_Sorting;


import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    You are developing a feature for Zomato that helps users find the nearest restaurants to their current location. It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
    Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
    Here, the distance between two points on a plane is the Euclidean distance.
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
    NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).

Problem Constraints
    1 <= B <= length of the list A <= 10^5
    -10^5 <= A[i][0] <= 10^5
    -10^5 <= A[i][1] <= 10^5

Input Format
    The argument given is list A and an integer B.

Output Format
    Return the B closest points to the origin (0, 0) in any order.

Example Input
    Input 1:
         A = [
               [1, 3],
               [-2, 2]
             ]
         B = 1
    Input 2:
         A = [
               [1, -1],
               [2, -1]
             ]
         B = 1

Example Output
    Output 1:
         [ [-2, 2] ]
    Output 2:
         [ [1, -1] ]

    Example Explanation
    Explanation 1:
         The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
        So one closest point will be [-2,2].
    Explanation 2:
         The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
        So one closest point will be [1,-1].
* */
public class BClosestPointsToOrigin {

    // https://www.scaler.com/academy/mentee-dashboard/class/146056/assignment/problems/4194?navref=cl_tt_lst_nm
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        List<ArrayList<Integer>> list = A.stream().sorted((o1, o2) -> {
            int dist1 = o1.get(0) * o1.get(0) + o1.get(1) *o1.get(1);
            int dist2 = o2.get(0) * o2.get(0) + o2.get(1) *o2.get(1);
            return dist1 - dist2;
        }).limit(B).collect(java.util.stream.Collectors.toList());
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(ArrayList<Integer> aList : list) {
            result.add(aList);
        }
        return result;

/*        int rowLength = A.length;
        ArrayList<Point> points = new ArrayList<>();
        for (int i =0;i < rowLength;i++) {
            points.add(new Point(A[i][i],A[i][i+1]));
        }
        List<Point> result = points.stream().sorted(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int dist1 = o1.x * o1.x + o1.y *o1.y;
                int dist2 = o2.x * o2.x + o2.y * o2.y ;
                return dist1-dist2;

            }
        }).limit(B).collect(Collectors.toList());

        ArrayList<ArrayList<Point>> arrayLists = new ArrayList<>();
        for (Point point : result) {
            //new ArrayList<>().add(point);
            arrayLists.add();
        }

        return null;*/
    }

}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y= y;
    }
}

