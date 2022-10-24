package com.cleancode.racingcar.level4.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if(position < 0)
            throw new IllegalArgumentException("음수는 불가능");
        this.position = position;
    }



    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public Position fartherPosition(Position maxPosition) {
        if(position < maxPosition.position)
            return maxPosition;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }



}
