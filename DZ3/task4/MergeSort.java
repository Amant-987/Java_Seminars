// ; Урок 3. Коллекции JAVA: Введение
// ; *Реализовать алгоритм сортировки слиянием

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9};

        mergeSort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left &lt; right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i &lt; n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j &lt; n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i &lt; n1 &amp;&amp; j &lt; n2) {
            if (leftArray[i] &lt;= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i &lt; n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j &lt; n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}