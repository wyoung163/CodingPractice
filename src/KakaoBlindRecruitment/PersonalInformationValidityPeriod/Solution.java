package KakaoBlindRecruitment.PersonalInformationValidityPeriod;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] temp = {}, temp2 = {};
        int c = 0, year = -1, month2 = -1, day = -1;
        String month = "";


        for (int i = 0; i < privacies.length; i++) {
            temp2 = privacies[i].split(" ");
            for (int j = 0; j < terms.length; j++) {
                temp = terms[j].split(" ");

                if (temp[0].equals(temp2[1])) {
                    month = temp2[0].substring(5, 7);
                    month2 = Integer.parseInt(month) + Integer.parseInt(temp[1]);
                    year = Integer.parseInt(temp2[0].substring(0, 4));

                    if (month2 > 12) {
                        year = year + 1;
                        month2 = month2 - 12;
                    }
                    day = Integer.parseInt(temp2[0].substring(8, 10)) - 1;
                    if (day == 0) {
                        month2 -= 1;
                        day = 28;
                    }


                    if (year < Integer.parseInt(today.substring(0, 4))) {
                        answer.add(i + 1);
                        break;
                    } else if (month2 < Integer.parseInt(today.substring(5, 7))) {
                        answer.add(i + 1);
                        break;
                    } else if (day < Integer.parseInt(today.substring(8, 10))) {
                        answer.add(i + 1);
                        break;
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
