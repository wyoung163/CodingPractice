package KakaoBlindRecruitment.PersonalInformationValidityPeriod;

import java.util.*;

/*
    문제 해결:
                 if(year < tYear){
                        answer.add(i+1);
                        break;
                    } if (year == tYear && month < tMonth){
                        answer.add(i+1);
                        break;
                    } if(year == tYear && month == tMonth && day < tDay){
                        answer.add(i+1);
                    }
                 에서 처음에는 조건문을 else if를 사용하고 month, day에 대해 가장 후자의 조건만 제시함으로서 달을 고려함과 동시에 년도를 함께 고려하는 등의 조건을 고려하지 못하는 문제를 해결

*/

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] temp = {}, temp2 = {};
        int c = 0, year = -1, month = -1, day = -1;

        for(int i = 0; i < privacies.length; i++) {
            temp2 = privacies[i].split(" ");
            for(int j = 0; j < terms.length; j++){
                temp = terms[j].split(" ");

                if(temp[0].equals(temp2[1])) {
                    month = Integer.parseInt(temp2[0].substring(5,7)) + Integer.parseInt(temp[1]);
                    year = Integer.parseInt(temp2[0].substring(0,4));
                    day = Integer.parseInt(temp2[0].substring(8,10)) - 1;

                    c = month / 12;
                    if(month > 12){
                        year = year + 1*c;
                        month = month - 12*c;
                    }

                    if(day == 0){
                        month -= 1;
                        day = 28;
                    }

                    System.out.println(month);
                    System.out.println(year);
                    System.out.println(day);

                    int tYear = Integer.parseInt(today.substring(0,4));
                    int tMonth = Integer.parseInt(today.substring(5,7));
                    int tDay = Integer.parseInt(today.substring(8,10));

                    if(year < tYear){
                        answer.add(i+1);
                        break;
                    } if (year == tYear && month < tMonth){
                        answer.add(i+1);
                        break;
                    } if(year == tYear && month == tMonth && day < tDay){
                        answer.add(i+1);
                    }
                }
            }

        }

        int[] result = answer.stream()
                .mapToInt(i -> i)
                .toArray();

        return result;
    }
}