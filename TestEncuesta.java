
public class TestEncuesta
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public static void main(String args[])
    {
        int[] vector1 = new int[]{1, 3, 5, 6, 9, 10, 12, 13, 15, 16};
        int[] vector2 = new int[]{2, 4, 7, 8, 11, 14, 17, 18, 19, 20};
        
        Encuesta e = new Encuesta(vector1, vector2);
        
        System.out.println(e.compararVectores(vector1, vector2, 0, vector1.length-1, 0, vector2.length-1));
    }

}
