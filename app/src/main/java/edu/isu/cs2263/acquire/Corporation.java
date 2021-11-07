package edu.isu.cs2263.acquire;

public class Corporation {
    String name;
    Integer Size;
    String color;

    public Corporation(String name, Integer size, String Color) {
        this.name = name;
        Size = size;
        color = Color;
    }
    public Corporation(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void increaseSize(Integer increase){
        Size = Size + increase;
    }
    public void merge(Corporation one, Corporation two){
        Integer onesize = one.getSize();
        Integer twosize = two.getSize();
        if (onesize > twosize){
            two.resetSize();
            one.increaseSize(twosize);
        }
        else if (twosize > onesize){
            one.resetSize();
            two.increaseSize(onesize);
        }


    }
    public void resetSize(){
        Size = 0;
    }

    @Override
    public String toString() {
        return "Corporation{" +
                "name='" + name + '\'' +
                ", Size=" + Size +
                ", color='" + color + '\'' +
                '}';
    }
}
