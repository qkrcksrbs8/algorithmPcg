package cg.park.algorithmpcg.baekjoon;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Builder
@Data
public class MyDate {
    private int day = 0;
    private int month = 0;
    private int year = 0;
    public MyDate(int day) {this.day = day;};
}


class test2 extends MyDate{
    public test2(int day) {
        super(day);
    }

    public void ttt() {

    }

}