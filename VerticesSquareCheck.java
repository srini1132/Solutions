package com.interview.solv;

/**
 * Problem is given vertices form square or not
 */
public class VerticesSquareCheck {

    /**
     * Method to find distance between two point
     *
     * @param a array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @param b array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @return distance between a,b
     */
    private static double getDistanceVertices(int[] a, int[] b) {
        if (!(a.length == 2 && b.length == 2)) {
            return 0;
        }
        return Math.sqrt((b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]));
    }

    /**
     * Method to find give 4 indexes(vertices) can form the square or not
     *
     * @param a array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @param b array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @param c array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @param d array length should here is 2, and array holds the [x-axis-value, y-axis-value]
     * @return boolean for can these indexes form square or not
     */
    private static boolean isVerticesFormASquare(int[] a, int[] b, int[] c, int[] d) {
        // taken a ase base index
        double lenAB = getDistanceVertices(a, b); // a to b distance
        double lenAC = getDistanceVertices(a, c); // a to c distance
        double lenAD = getDistanceVertices(a, d); // a to d distance

        // if any distance is 0 both indexes pointing same vertex so can not square
        if (lenAB == 0 || lenAC == 0 || lenAD == 0) {
            return false;
        }

        // if "ab", "ac" are sides then "ad" should be diagonal
        // so "ab" == "ac" and "ad" == "bc"(other diagonal)
        // and "db" == "dc" (other 2 sides)
        if (lenAB == lenAC && lenAD == getDistanceVertices(b, c)
                && getDistanceVertices(d, b) == getDistanceVertices(d, c)) {
            return true;
        }

        // if "ab", "ad" are sides, then "ac" should be diagonal
        // so "ab" == "ad" and "ac" == "bd"(other diagonal)
        // and "cb" == "cd" (other 2 sides)
        if (lenAB == lenAD && lenAC == getDistanceVertices(b, d)
                && getDistanceVertices(c, b) == getDistanceVertices(c, d)) {
            return true;
        }

        // if "ac", "ad" are sides then "ab" should be diagonal
        // so "ac" == "ad" and "ab" == "cd"(other diagonal)
        // and "bc" == "bd" (other 2 sides)
        if (lenAC == lenAD && lenAB == getDistanceVertices(c, d)
                && getDistanceVertices(b, c) == getDistanceVertices(b, d)) {
            return true;
        }

        //If condition satisfies then square can not form
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                isVerticesFormASquare(new int[]{-10, -10}, new int[]{-10, 10},
                        new int[]{10, 10}, new int[]{10, -10}));
    }
}
