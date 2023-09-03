package practice.SQL.JOIN;

/*
    [조인] 주문량이 많은 아이스크림들 조회하기 (나의 풀이)
 */
SELECT J.FLAVOR
FROM FIRST_HALF F
RIGHT JOIN JULY J
ON F.SHIPMENT_ID = J.SHIPMENT_ID
GROUP BY J.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER)+SUM(J.TOTAL_ORDER) DESC
LIMIT 3;