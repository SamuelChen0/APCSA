package exprimentation;
public class NestedLoop {
    public static void main(String[] args) {
        for( int i=1; i<6; i++){
            for( int j=1; j<6; j++){
                System.out.print(i + "*" +j +"="+i*j+" ");
            }
            System.out.println("");
        }

     int a = 5;
     int b = 2;
     double c = 3.0;
     System.out.println(5 + a / b * c -1);

     int count = 0;
     for (int k = 0; k <4; k++)
     {
        for(int y =k; y<4 ; y++)
        {count++;
        }
     }
     System.out.println(count);

     

     
     System.out.print("*");
     System.out.println();
     System.out.println("*");
    }
}