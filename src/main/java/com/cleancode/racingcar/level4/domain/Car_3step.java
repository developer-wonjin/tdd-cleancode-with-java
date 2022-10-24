package com.cleancode.racingcar.level4.domain;


import com.cleancode.racingcar.level4.utils.StringUtils;

import java.util.Objects;
import java.util.Random;

// 깨달음 : getRandomNo메소드 분리를 시켜야 RacingGame쪽으로 옮기기 편함
public class Car_3step {
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;
    private final String name;
    private int position = 0;

//    public Car(String name, int position) {
//        this.name = name;
//        this.position = position;
//    }

//    public Car(String name) {
//        if(StringUtils.isBlank(name)){
//            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 한다");
//        }
//        this.name = name.trim();
//    }

    //인자수가 많은 생성자에서 초기화및 유효성체크를 해야함.
    public Car_3step(String name, int position) {
        StringUtils.checkBlank(name, "자동차 이름은 값이 존재해야 한다");
        this.name = name;
        this.position = position;
    }

    //인자수가 적은 생성자에서는 this( )호출만 한다.
    public Car_3step(String name) {
        this(name, 0);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.movable())
            this.position++;
    }
    public void move(int randomNo){
        if(randomNo >= FORWARD_NUM)
            this.position++;
    }
    public void move(){
        int randomNo = getRandomNo();
        if(randomNo >= FORWARD_NUM)
            this.position++;
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }
    int fartherPosition(int maxPosition) {
        if(maxPosition < this.position){
            return this.position;
        }
        return maxPosition;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car_3step car = (Car_3step) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }



}
