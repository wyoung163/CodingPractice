package SummerWinterCoding.EndToEndInEnglish;

class Solution {
    public static void main(String[] args) {
        String[] test = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        solution(3, test);
    }
    static int wrong1 = -1;
    static int wrong2 = -1;
    static int[] count = new int[10];

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        findNotEndToEnd(words, n);
        findDuplicate(words, n);

        if(wrong1 != -1){
            if(wrong2 != -1){
                if(wrong1 < wrong2){
                    answer[0] = wrong1 % n + 1;
                    answer[1] = count[wrong1 % n];
                } else if(wrong1 > wrong2){
                    answer[0] = wrong2 % n + 1;
                    answer[1] = wrong2 / n + 1;
                }
            }
            else{
                answer[0] = wrong1 % n + 1;
                answer[1] = count[wrong1 % n];
            }
        } else if(wrong2 != -1){
            answer[0] = wrong2 % n + 1;
            answer[1] = wrong2 / n + 1;
        }
        return answer;
    }

    public static void findNotEndToEnd(String[] words, int n){
        for(int i = 0; i < words.length-1; i++){
            count[i%n]++;
            if(words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)){
                wrong1 = i+1;
                count[(i+1)%n]++;
                break;
            }
        }
    }

    public static void findDuplicate(String[] words, int n){
        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){
                    System.out.println("test");
                    wrong2 = j;
                    break;
                }
            }
        }
    }
}

