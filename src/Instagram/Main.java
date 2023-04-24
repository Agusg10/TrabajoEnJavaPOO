package Instagram;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Input number: ");
            numbers.add(read.nextInt());
        }
        System.out.println(numbers);
        System.out.println("Input number to search in the Array: ");
        Integer x = read.nextInt();
        if(numbers.contains(x)){
            System.out.println("ArrayList contains: "+x);
        }else{
            System.out.println("ArrayList doesn't contains: "+x);
        }
    }
}