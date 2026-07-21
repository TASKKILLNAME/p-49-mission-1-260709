package ll;

import java.util.ArrayList;
import java.util.Arrays;

public class Calc {
    public static int run(String cmd) {
        String[] strArr = cmd.split(" ");
        ArrayList<String> arrl = new ArrayList<>(Arrays.asList(strArr));;
        // 문제 접근방식
        // 첫번째 숫자, 연산자 구분
        // 두번째 숫자, 연산자 모두 각각 인덱스를 저장해서 연산 순서 올바르게 맞춰주기
        // 세번째 곱하기 나누기 연산은 우선순위

        // 입력은 어떻게 받을건가 -> 문자열 형식
        // split()으로 배열로 받기
        // 숫자인지 연산자인지 구분 (숫자로 변환이 되나/안되나 기준)
        // 우선순위 구현을 어떻게 할것인가

        // 괄호 연산은 맨 마지막에 구현
        int i = 0;
        while(i < arrl.size()) {
           if(!isNumeric(arrl.get(i))) {
                if(arrl.get(i).equals("*") || arrl.get(i).equals("/")) {
                    int leftNum = Integer.parseInt(arrl.get(i-1));
                    int rightNum = Integer.parseInt(arrl.get(i+1));

                    int total = arrl.get(i).equals("*") ? leftNum * rightNum : leftNum / rightNum;
                    arrl.set(i-1, String.valueOf(total));
                    arrl.remove(i+1);
                    arrl.remove(i);

                    continue;
                }
                i++;
           }
           else {
               i++;
           }
       }

        i = 0;

        while(i < arrl.size()) {
            if(!isNumeric(arrl.get(i))) {
                if(arrl.get(i).equals("+") || arrl.get(i).equals("-")) {
                    int leftNum = Integer.parseInt(arrl.get(i-1));
                    int rightNum = Integer.parseInt(arrl.get(i+1));

                    int total = arrl.get(i).equals("+") ? leftNum + rightNum : leftNum - rightNum;
                    arrl.set(i-1, String.valueOf(total));
                    arrl.remove(i+1);
                    arrl.remove(i);

                    continue;
                }
                i++;
            }
            else {
                i++;
            }
        }

        int result = Integer.parseInt(arrl.get(0));
        return result;
    }

    // 연산자인지 숫자인지 구분
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; 
            }
        }
        return true; 
    }
}
