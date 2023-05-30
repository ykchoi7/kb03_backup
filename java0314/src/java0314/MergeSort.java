package java0314;

// 병합 정렬
import java.util.Scanner;

class MergeSort {
    static int[] buff;    // 작업용 배열

    //--- a[left] ~ a[right]를 재귀적으로 병합정렬 ---//
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0; //저장위치 0부터 시작
            int j = 0; //저장하는 숫자를 비교하는 순서
            int k = left;

            __mergeSort(a, left, center);         // 전반부를 병합정렬
            __mergeSort(a, center + 1, right);    // 후반부를 병합정렬
            									  // 전반부, 후반부 모두 한 인덱스만 남을 때까지 쪼개기 반복
            for (i = left; i <= center; i++)
                buff[p++] = a[i];

            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            	//buff[j] 값이 a[i]값보다 작으면 buff[j]를 넣고, 크면 a[i]를 넣는다
            	//*삼항연산자(~?~:)* - (조건) ? (true일 때 실행) : (false일 때 실행)

            while (j < p)
                a[k++] = buff[j++];
        }
    }

    //--- 병합 정렬 ---//
    static void mergeSort(int[] a, int n) {
        buff = new int[n];                    // 작업용 배열을 생성

        __mergeSort(a, 0, n - 1);            // 배열 전체를 병합 정렬

        buff = null;                         // 작업용 배열을 해제
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);        // 배열 x를 병합정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
