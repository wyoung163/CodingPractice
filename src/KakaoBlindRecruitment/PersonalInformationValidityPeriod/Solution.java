package KakaoBlindRecruitment.PersonalInformationValidityPeriod;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] temp = {};
        String[] temp2 = {};
        int c = 0;
        int year = -1;
        int month2 = -1;
        int day = -1;
        String month = "";


        for(int i = 0; i < privacies.length; i++) {
            temp2 = privacies[i].split(" ");
            for(int j = 0; j < terms.length; j++){
                temp = terms[j].split(" ");
                System.out.println(temp[0]);
                System.out.println(temp2[1]);

                if(temp[0].equals(temp2[1])) {
                    month = temp2[0].substring(5,6);
                    month2 = Integer.parseInt(month) + Integer.parseInt(temp[1]);
                    year = Integer.parseInt(temp2[0].substring(0,3));
                    System.out.println(Integer.parseInt(temp2[0].substring(0,3)));

                    if(month2 > 12){
                        year = year + 1;
                        month2 = month2 - 12;
                    }
                    day = Integer.parseInt(temp2[0].substring(8,9)) - 1;

                    //System.out.println(year);
                    //System.out.println(month2);
                    //System.out.println(day);

                    if(year > Integer.parseInt(today.substring(0,3))){
                        answer[c++] = i;
                        break;
                    } else if (month2 > Integer.parseInt(today.substring(5,6))){
                        answer[c++] = i;
                        break;
                    } else if(day > Integer.parseInt(today.substring(8,9))){
                        answer[c++] = i;
                        break;
                    }
                }
            }

        }

        return answer;
    }
}
