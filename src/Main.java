import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Dizinin uzunluğunu giriniz: ");
        int length = s.nextInt();

        int[] array = new int[length];

        for (int i = 0; i < length;i++)
        {
            System.out.print(i + 1 + ". sayıyı giriniz: ");
            array[i] = s.nextInt();
        }
        System.out.print("Sıralama: ");
        System.out.println(Arrays.toString(mergeSort(array, length)));

    }

    public static int[] mergeSort(int[] arr, int n)
    {
        if (n < 2)
        {
            return arr;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++)
        {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++)
        {
            right[i - mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        return merge(arr, left, right, mid, n - mid);
    }

    public static int[] merge(int[] array, int[] lArray, int[] rArray, int left, int right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
        {
            if (lArray[i] <= rArray[j])
            {
                array[k++] = lArray[i++];
            }
            else
            {
                array[k++] = rArray[j++];
            }
        }
        while (i < left)
        {
            array[k++] = lArray[i++];
        }
        while (j < right)
        {
            array[k++] = rArray[j++];
        }

        return array;
    }
}
