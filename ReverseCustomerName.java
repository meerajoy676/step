import java.util.Scanner;

class ReverseCustomerName {
    static String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " +
                reverseCustomerName(customerName));
    }
}