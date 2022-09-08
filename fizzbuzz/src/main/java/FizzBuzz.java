public class FizzBuzz {

    private static void FizzBuzzValue(int value) {

        Boolean fizz = value % 3 ==0;
        Boolean buzz = value % 5 ==0;
        if(fizz && buzz) {
            System.out.println("fizzbuzz");
        } else if (fizz) {
            System.out.println("fizz");
        } else if (buzz) {
            System.out.println("buzz");
        }
    }

    public static void FizzBuzzValues(int begin, int end){
        for(int i = begin;i <= end;i++) {
            FizzBuzzValue(i);
        }
    }

    public static void main(String[] args) {
        FizzBuzz.FizzBuzzValues(1,15);
    }

}
