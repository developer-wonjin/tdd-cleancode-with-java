package com.cleancode.racingcar.level4.domain;


import com.cleancode.racingcar.level4.utils.StringUtils;

import java.util.Objects;
import java.util.Random;

// 깨달음 : getRandomNo메소드 분리를 시켜야 RacingGame쪽으로 옮기기 편함
public class Car {
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;

    private final Name name;
    private Position position;

    //인자수가 적은 생성자에서는 this( )호출만 한다.
    public Car(String name) {
        this(name, 0);
    }

    //인자수가 많은 생성자에서 초기화및 유효성체크를 해야함.
    public Car(String name, int position) {
        StringUtils.checkBlank(name, "자동차 이름은 값이 존재해야 한다");
        this.name = new Name(name);
        this.position = new Position(position);
    }



    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.movable())
            position = position.move();
    }
    public void move(int randomNo){
        if(randomNo >= FORWARD_NUM)
            position = position.move();
    }
    public void move(){
        int randomNo = getRandomNo();
        if(randomNo >= FORWARD_NUM)
            position = position.move();
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }
    Position fartherPosition(Position maxPosition) {
        return position.fartherPosition(maxPosition);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
