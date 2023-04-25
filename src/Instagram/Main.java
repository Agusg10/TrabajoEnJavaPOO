package Instagram;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Input number: ");
            numbers.add(read.nextInt());
        }
        Collections.sort(numbers); //ordena de menor a mayor
        System.out.println(numbers);
        Collections.sort(numbers, Collections.reverseOrder()); //ordena de mayor a menor
        System.out.println(numbers);
        System.out.println("Input number to search in the Array: ");
        Integer x = read.nextInt();
        if(numbers.contains(x)){
            System.out.println("ArrayList contains "+x);
        }else{
            System.out.println("ArrayList doesn't contains "+x);
        }
        TreeSet<Integer> integerTree = new TreeSet<>();
        integerTree.addAll(numbers);
        System.out.println(integerTree);
    }
}