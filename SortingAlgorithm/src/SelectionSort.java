/**
 * Created by t-razhen on 7/24/2015.
 */
public class SelectionSort {
    public static int[] sort(int[] data){
        if (data.length == 0){
            return data;
        }
        else{
            rec_selectionSort(data, 0);
            return data;
        }
    }

    private static void rec_selectionSort(int[] data, int head){
        if(head == data.length-1){
            return;
        }
        else
        {
            int min = data[head];
            int minIndex = head;
            for (int i = head+1; i < data.length; i++) {
                if (data[i]<min) {
                    min = data[i];
                    minIndex = i;
                }
            }
            // swap min with head
            if (minIndex != head){
                int temp = data[head];
                data[head] = data[minIndex];
                data[minIndex] = temp;
            }
            // keep going on until hell freezes over
            rec_selectionSort(data, head+1);
            return;
        }
    }
}
