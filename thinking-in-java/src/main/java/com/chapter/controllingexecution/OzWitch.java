package com.chapter.controllingexecution;

public enum OzWitch {
    WEST("sadad"),
    NORTH("Oh ye"); // 申明枚举类型的成员，这些成员都是 OzWitch

    private String de;
    OzWitch(String desciption) {
        this.de = desciption;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public static void main(String[] args) {
        System.out.println(OzWitch.values()[0].getDe());
    }


}
