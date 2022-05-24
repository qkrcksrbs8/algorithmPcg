package cg.park.algorithmpcg.mytest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class test4 {

    public static void main(String[] args) {
        BufferedReader br = null;
        Workbook workbook = null;

        try {
            br = new BufferedReader(new java.io.InputStreamReader(System.in));

            Path currentPath = Paths.get("");
            String path = currentPath.toAbsolutePath().toString();
            System.out.println("현재 작업 경로: " + path);

            workbook = Workbook.getWorkbook(new File("./zipcode_seoul_euckr_type2.xls"));
            Sheet sheet = workbook.getSheet(0);

                //입력값 검사
                System.out.print("데이터 입력: ");
                String data = br.readLine();

                //데이터 출력
                for(int i=0; i<sheet.getRows(); i++) {
                    Cell dong = sheet.getCell(3,i);
                    if( dong.getContents().contains(data) ) {
                        for (int j = 0 ; j < 6; j++) {
                            System.out.print(sheet.getCell(j,i).getContents() + " ");
                        }
                        System.out.println();
                    }
                }
            System.out.println("프로그램 종료");
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(br != null) try {br.close();} catch(IOException e) {}
            if(workbook != null) workbook.close();
        }
    }
}