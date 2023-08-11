package practice.HashMap;

import java.util.*;

/*
    해시맵
 */
class ParkingPrice {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, String> in = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for(String rec : records){
            String[] info = rec.split(" ");
            if(info[2].equals("IN")){
                in.put(info[1], info[0]);
            } else {
                for(Map.Entry<String, String> entry: in.entrySet()){
                    int time = 0;
                    String[] time1 = entry.getValue().split(":");
                    String[] time2 = info[0].split(":");
                    if(entry.getKey().equals(info[1]) && !entry.getValue().equals("25:0")){
                        time += (Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]))*60;
                        time += Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
                        if(result.containsKey(info[1])){
                            result.put(info[1], result.get(info[1])+time);
                        } else {
                            result.put(info[1], time);
                        }
                        in.put(entry.getKey(), "25:0");
                        break;
                    }
                }
            }

        }

        for(String key: in.keySet()){
            if(!in.get(key).equals("25:0")){
                String[] time1 = in.get(key).split(":");
                int time = (23 - Integer.parseInt(time1[0]))*60;
                time += 59 - Integer.parseInt(time1[1]);

                if(result.containsKey(key)){
                    result.put(key, result.get(key)+time);
                } else {
                    result.put(key, time);
                }
            }
        }


        List<String> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            int time = result.get(key);
            System.out.println(time);
            int tmp = fees[1];
            if(time > fees[0]){
                tmp += (int) Math.ceil((time - fees[0])/(double)fees[2]) * fees[3];
            }
            answer.add(tmp);
        }

        return answer;
    }
}