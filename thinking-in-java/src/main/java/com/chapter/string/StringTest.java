package com.chapter.string;

public class StringTest {
    private String name;
    private String age;

    public StringTest(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
     /*   String s= "123123";
        String s1 = "123";
        String s2 = "123";
        System.out.println((s1+s2)==s);
        StringBuilder builder = new StringBuilder();
        String s3 = builder.append("123").append("123").append("123").toString();
        System.out.println(s3);*/
        StringTest test = new StringTest("zs", "12");
        System.out.println(test.toString());

        char a = 'a';
        Byte b = 'a';
        Byte c = (byte)a;
        byte[] bytes = new byte[]{40,'b','c'};
        String s = new String(bytes);
        System.out.println(s);
        byte[] bytes1 = s.getBytes();
        char[] chars = s.toCharArray();
        char c1 = '在';
        System.out.println(new Byte((byte)c1).intValue());

    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("name:")
                .append(name)
                .append("\n")
                .append("age:")
                .append(age)
                .toString();
    }
}
