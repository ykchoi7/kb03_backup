package algorithm;

public class baekjoon_1874 {

	//스택수열 만드는 프로그램 (bufferedreader)
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        //declare 
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int x;
        
        while((n--)!=0) {
            x = Integer.parseInt(br.readLine());
            if(x>max) {
                for(int i=max+1;i<=x;i++) {
                    s.push(i);//4들어온 경우 1,2,3,4 push
                    sb.append("+").append("\n"); //4번 + 출력
                }
                s.pop();//4 내보냄
                sb.append("-").append("\n"); //4 뺐으니까 - 출력
                //스택에 1,2,3 남음 
                max = x; //젤큰게 x로 갱신
            }
            else { //x<=max인 경우
                if(s.peek()!=x) { //이런 경우는 해결할 수 없음
                    sb = new StringBuilder("NO");
                    break;
                }
                s.pop();//바로 내보내고                
                sb.append("-").append("\n"); 

            }
        }
        System.out.println(sb);
        
    }

}


//일반 스택으로 푸는 경우
//public static void main(String[] args) {
//    // TODO Auto-generated method stub
//
//    Scanner sc = new Scanner(System.in);
//    StringBuilder sb = new StringBuilder();
//
//    int n = sc.nextInt();
//    Stack<Integer> st = new Stack<>();
//
//    int cnt = 1;
//    int size = 0;
//
//    out: for (int i = 0; i < n; i++) {
//
//        int v = sc.nextInt();
//
//        for (int j = cnt; j <= v; j++) {
//            st.push(j);
//            sb.append("+" + "\n");
//            cnt = v + 1;
//
//        }
//        
//        if (st.isEmpty()) {
//            continue;
//        }
//
//        while (st.peek() != v) {
//            if (st.size() == 1)
//                break out;
//            st.pop();
//            sb.append("-" + "\n");
//
//        }
//
//        if (st.peek() == v) {
//
//            st.pop();
//            sb.append("-" + "\n");
//            size++;
//
//        }
//
//    }
//
//    if (size != n)
//        System.out.print("NO");
//
//    else
//        System.out.print(sb.toString());
//
//}
