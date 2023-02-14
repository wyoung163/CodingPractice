package BlindRecruitment.SecretMap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        String s = "";

        for(int i = 0; i < n; i++){
            map1[i] = String.format("%"+n+"s", Integer.toBinaryString(arr1[i]));
            map2[i] = String.format("%"+n+"s", Integer.toBinaryString(arr2[i]));
        }

        int j = 0;
        for(int i = 0; i < n; i++){
            s = "";
            j = 0;
            while(j < n){
                if(map1[i].substring(j, j+1).equals("1") || map2[i].substring(j,j+1).equals("1")){
                    s = s + "#";
                } else {
                    s = s + " ";
                }
                j++;
            }
            answer[i] = s;
        }

        return answer;
    }
}