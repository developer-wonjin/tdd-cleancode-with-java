package com.cleancode.racingcar.level4.domain;


import com.cleancode.racingcar.level4.utils.StringUtils;

import java.util.Objects;
import java.util.Random;

// 깨달음 : 접근제어자의 접근 레벨을 간단할 때 default => 공개할 때 public 으로
public class Car_2step {
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
    public Car_2step(String name, int position) {
        StringUtils.checkBlank(name, "자동차 이름은 값이 존재해야 한다");
        this.name = name;
        this.position = position;
    }

    //인자수가 적은 생성자에서는 this( )호출만 한다.
    public Car_2step(String name) {
        this(name, 0);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(){
        Random random = new Random();
        int randomNo = random.nextInt(MAX_BOUND);
        if(randomNo >= FORWARD_NUM)
            this.position++;
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
        Car_2step car = (Car_2step) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }



}
