package practice.Hash;

import java.util.*;
import java.util.stream.Collectors;

/*
    <1차 시도> lv2 [해시] 베스트앨범

    [해시 저장 데이터]
    1. 장르 별 누적 횟수
    2. 음악의 고유 번호별 장르
    3. 음악의 고유 변호별 횟수

    [구상 알고리즘]
    1. 장르 별 누적 횟수 내림차순 정렬
    2. 누적 횟수가 높은 장르 내 음악 고유 번호 선별
    3. 선별된 고유 번호에 대한 횟수 선별
    4. 선별된 횟수 중 상위 2개의 음악 고유 번호를 정답 리스트에 저장
     4-1. 상위 2개의 횟수가 같다면 오름차순으로 고유 번호 정렬

 */
class Solution3 {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();;
        Map<String, Integer> genre = new HashMap<>();
        Map<Integer, String> num = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(genre.get(genres[i])!= null){
                genre.put(genres[i], genre.get(genres[i]) + plays[i]);
            } else {
                genre.put(genres[i], plays[i]);
            }
            // 고유식별 번호, 장르
            num.put(i, genres[i]);
            // 고유식별 번호, 횟수
            cnt.put(i, plays[i]);
        }

        //장르+횟수
        List<Map.Entry<String, Integer>> entries = genre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // 고유번호+횟수
        List<Map.Entry<Integer, Integer>> entries2 = cnt.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        for(int i = 0; i < entries.size(-2; i++){
            entries.remove(entries.getKey());
        }

        for (Map.Entry<String, Integer> entry : entries) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry2 : entries2){
                if(entry2.getValue().equals(entry.getKey())){
                    arr.add(entry2.getKey());
                    //entry2.remove(entry2.getKey()); 제거
                }
            }

            for(int n: arr){
//                if(cnt.contains(n)){
//
//                }
            }
            Collections.sort(arr);
            for(int i = arr.size()-1; i == arr.size()-1; i--){
                answer.add(arr.get(i));
            }
        }

        return answer;
    }
}