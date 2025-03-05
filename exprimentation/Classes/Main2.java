public class Main2 {
    public static void main(String[] args) {
        Person2 person1 = new Person2(18, "Samuel");
        System.out.println(person1);
        Person2 person2 = new Person2(18, "Samuel");
        System.out.println(person2);
        System.out.println(person1.equals(person2));

        String str = "Hello";
        String str1 = new String ("Hello");
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println(str == str2);
        System.out.println(str1 == str3);
        System.out.println(str == str1);
        System.out.println(str2.substring(1,3));
        System.out.println(str2.substring(1));
        System.out.println(str.indexOf("e"));
        System.out.println(str.indexOf("el"));
        System.out.println(str.indexOf("g"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.parseInt("123"));
        System.out.println("123"+1);
        Integer y = 10;
        Integer z = Integer.valueOf(123);
        System.out.println(y.compareTo (z));
        System.out.println(y.compareTo (y));
        //Double b = 0.3;
        //double c = b;
       // double d = Double.parseDouble("0.4");
       // Double e = Double.valueOf("0.5");
        
        System.out.println(Math.abs(-5));
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5.5));
        System.out.println(Math.sqrt(9));
        System.out.println(Math.pow(5,2));
        System.out.println(Math.round(100.5));
        System.out.println(Fibonnaci.f(5));
        
        System.out.println(Fibonnaci.sumArray( , 0));
    }
}
        
        
        
                
        
        
        
       
        