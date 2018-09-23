package com.chapter.controllingexecution;

public class Exercise {
    public static void generateAndClassifyIntValue(int num){
        int pre = -1;
        for(int index = 0 ; index < num ; index ++){
            int indexNum = (int)(Math.random()*10);
       /*     int indeNum = (int)Math.random()*10; // error (int)Math.random()*10 = 0*10 */
            if(pre != -1){

                if(pre > indexNum){
                    System.out.println("generate value of this time if lees than previous time.this time value is"+indexNum+",previous time value is"+pre);
                }else if(pre < indexNum){
                    System.out.println("generate value of this time if more than previous time.this time value is"+indexNum+",previous time value is"+pre);
                }else{
                    System.out.println("generate value of this time if equal with n previous time.this time value is"+indexNum+",previous time value is"+pre);
                }
            }
            pre = indexNum;
        }
    }

    public static void main(String[] args) {
        generateAndClassifyIntValue(2);
    }
}
