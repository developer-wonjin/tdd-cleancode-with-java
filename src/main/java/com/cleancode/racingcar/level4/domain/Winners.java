package com.cleancode.racingcar.level4.domain;

import java.util.ArrayList;
import java.util.List;

// 깨달음1. 메세지를 주는 방식은 도메인 로직이 객체안으로 숨어지는 효과~~!!
// 깨달음2. Winners클래스를 설계하던 중 Car클래스에 메소드를 추가할 일이 생기면 CarTest에 @Test 테스트케이스를 추가해라
// 깨달음3. setter메소드는 엔티티에서 쓰지말아라! 생성자로 대체가능하다 (롬북쓰지마!)
// 깨달음4. getter/setter메소드는 dto에만 허용(롬북써도됨)

public class Winners {
    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, maxPostion(cars));
    }

    private static List<Car> findWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        //추후 리펙토링이 숙달되면 스트림을 이용해서 코드를 더 줄여보자
        for (Car car : cars) {  
            if(car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }

    private static Position maxPostion(List<Car> cars) {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.fartherPosition(maxPosition);//도메인 로직이 객체안으로 숨어지는 효과~~!!
        }
        return maxPosition;
    }
}
