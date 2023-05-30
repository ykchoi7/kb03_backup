package java0322;

public class 코테_기본사항 {

/*
Input
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
br.readLine();  < 한줄씩 읽기
StringTokenizer st = new StringTokenizer(br.readLine(), "기준"); < 기준 정해서 나누기
st.nextToken(); < 자른 문자열 하나씩 읽기


**string 입력 방법 알아내기!!**


Math
Math.max() : 최대값
Math.min() : 최소값
Math.abs() : 절대값
Math.pow(x, y) : x의 y제곱승

Arrays
Arrays
1차배열 : Arrays.toStrign(배열)
2차배열 : Arrays.deepToString(배열)

배열 정렬
Arrays.sort(array)

배열 기준 정렬
Arrays.sort(array, (o1, o2) -> { return o1.기준 > o2.기준 ? 1: o1.기준 < o2.기준 ? -1 : 0 });
ex) 2차원배열 0열 기준 : Arrays.sort(array, (o1, o2) -> { return o1[0] > o2[0] ? 1: o1[0] < o2[0] ? -1 : 0});


배열복사
System.arraycopy(원본 배열, 몇번째 index 부터, dest, 몇번째 index 부터, 몇개 복사);
새로운 배열 = Arrays.copyOf(원본 배열, 몇개 복사); 원본 배열 처음부터 몇개 복사할것인지
새로운 배열 = Arrays.copyOfRange(원본 배열, 어디부터, 어디까지); 원본 배열의 몇번째 index부터 몇번째 index앞 까지 복할 것인지


배열비교
Arrays.equals( a, b ) //1차 배열
Arrays.deepEqulas( a, b ) //2차 배열


Collections
List, Map, Set 등
Collections.함수()
collection : 이터러블 한것들(?)
값 가져오기 collection.get(인덱스)
인덱스 가져오기 collection.indexOf(값)
값 수정 collection.set(인덱스, 값)


List 깊은복사
List<> a = new ArrayList<>();
List<> b = new ArrayList<>();
b.addAll(a);

List정렬
Collections.sort(list);

List 기준 정렬
Collections.sort(list, (o1, o2) -> { return o1.기준 > o2.기준 ? 1: o1.기준 < o2.기준 ? -1 : 0 });


Set
Set<> set = new HashSet<>();
- 중복허용x, 순서유지x
Set<> set = new TreeMap<>();
- 중복허용x, 정렬


Map
자주쓰이는게 HashMap, TreeMap 이있는듯
TreeMap은 넣자마자 키기준으로 정렬됨

Map.put() : 값 넣기
Map.get() : 값 가져오기
Map.replace() :  값 수정

Map.entrySet() : 키와 값의 집합
Map.keySet() : 키 집합
Map.values() : 값 집합

키 포함 확인
Map.containsKey("키");
Map.containsValue("값");

값 기준 정렬 Map -> list화
List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
Collections.sort(list, (o1, o2) -> { return o1.getValue() > o2.getValue()?1 : o1.getValue() < o2.getValue()?-1 : 0 });


Array, Collection
for ( : ) { } 로 반복 가능


문자열
문자열 비교
s1.compareTo(s2)
0 : 두개의 문자열이 동일
양수 : compareTo()를 호출하는 객체가 인자보다 사전적으로 순서가 앞설 때
음수 : 인자가 객체보다 사전적으로 순서가 앞설 때

숫자로 이루어진 문자열 2개를 합쳐서 큰 경우를 알고싶을때
-> 맨 앞자리로 정렬 후 앞자리가 같으면 (o1 + o2).compareTo(o2 + o1) 이용


문자열 대/소문자 변경
string.toLowerCase();
string.toUpperCase();

문자 대/소문자, 숫자 인지 확인
Character.isLowerCase(문자)
Character.isUpperCase(문자)
Character.isDigit(문자)
Character.toLowerCase(문자)
Character.toUpperCase(문자)

문자열 추가, 수정, 삭제할때는 StringBuilder를 사용하자
stringBuilder.charAt(인덱스); : 인덱스 값 가져오기
stringBuilder.append(값); : 마지막에 추가
stringBuilder.insert(인덱스, 값); : 인덱스부터 추가
stringBuilder.replace(인덱스, 인덱스, 값); : 인덱스 ~ 인덱스범위 값 수정
stringBuilder.deleteCharAt(인덱스); : 인덱스 값 삭제 
stringBuilder.delete(인덱스, 인덱스); : 인덱스 ~ 인덱스-1 범위 값 삭제
stringBuilder.subString(인덱스, 인덱스); : 인덱스 ~ 인덱스-1 범위의 문자열

정규식에 맞는 표현을 삭제할때는 String을 사용하자
string.replaceAll("정규식", "바꿀문자"); : 정규식에 맞는 모든값 바꿈
string.replaceFirst("정구식", "바꿀문자"); : 정규식과 처음 맞는 값바꿈


정규식
[] : []안에 문자중 하나 
a-z : 소문자
A-Z : 대문자
0-9 : 숫자
[^] : []안에 문자를 제외한 나머지
+ : 1개이상 문자 반복
{ x, } : x번이상 문자 반복
x? : x가 한번나오거나 안나옴
string.replaceAll("[^a-z0-9]", "") : 소문자, 숫자를 제외한 나머지 문자 제거
string.replaceAll("[.]+", "") = string.replaceAll("[.]{1,}", "") : .이 한번이상 연속으로 나오는 문자 제거 


같은 문자 연속 :  baabaaaa
\를 쓸려면 \를 하나더 써줘야함
([a-z])\\1{1,1} : 한문자 연속       ([a-z]+)\\1{1,1} : 문자패턴 연속
([a-z]) : a-z중 하나의 문자          ([a-z]+) : a-z 하나이상 문자
\1 : 앞에서 나온문자 하나              \1 : 앞에서 나온패턴(문자( 하나
{1, 1} : 1번 반복                  {1, 1} : 1번 반복
 baabaaaa-> aa, aa, aa           baabaaaa   ->baabaa, aa


int -> String : String.valueOf(int) or Integer.toString(int)
x -> String : String.valueOf(x)
x 는 숫자형, boolean, char, char[]
String -> int : Integer.parseInt(string) , Integer.parseInt(string, x) x진수값을 10진수로 바꿈


문자열str을 정규식에 맞는 문자별로 추출하기
import java.util.regex.*;
Pattern p = Pattern.complie(정규식);
Matcher m = p.matcher(str);
while (m.find()) m.group();


Stack
Stack<자료형> stack = new Stack<>();
stack.push(값);
stack.pop();
stack.peek(); : 맨위 값 리턴
stack.clear(); : stack 비우기
stack.isEmpty(); : boolean
stack.contains(값); : boolean


Queue
Queue<자료형> queue = new LinkedList<>();
queue.add(값);
queue.remove();
queue.peek(); : 첫번째 값 ( 삭제될 처음값, 삭제x )
queue.clear(); : queue 비우기
queue.isEmpty(); :boolean
queue.contains(값); : boolean


Queue
Heap으로 구현
PriorityQueue<Integer> pQueue = new PriorityQueue<>();  -  min heap
PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());  -  max heap

기준 정하기
PriorityQueue pQueue = new PriorityQueue<>(
      (o1, o2) -> { return o1.기준 > o2.기준? 1: o1.기준 < o2.기준? -1: 0; }
);


DFS
완탐
재귀로 푼다.
순열 - stack으로 인덱스 넣기
조합


BFS
완탐
큐로 푼다. 큐가 비어있을때까지 반복
- 시작 위치를 큐에 넣고 방문표시
- 큐가 비어있을때 까지 반복문
- 큐 remove -> 주변 노드 방문한 것인지 확인 -> 방문하지 않았으면 방문처리후  큐에 넣음
 

최대공약수
a > b
while( b != 0 ){
      int temp = a % b;
      a = b;
      b = temp;
}

a -> 최대공약수

 */
	
}
