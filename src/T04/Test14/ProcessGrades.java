package src.T04.Test14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessGrades {
    public static void main(String[] args) {
        File file1 = new File("./src/T04/Test14/in.txt");
        File file2 = new File("./src/T04/Test14/result.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        List<GradeStruct> list = null;

        try {
            fis = new FileInputStream(file1);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            fos = new FileOutputStream(file2);

            list = new ArrayList<>();

            String str = null;
            double chineseAvg = 0, mathAvg = 0;

            while ((str = br.readLine()) != null) {
                String[] data = str.split("\\s+");
                list.add(new GradeStruct(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }

            chineseAvg = getAverageOfChineseGradeStructList(list);
            mathAvg = getAverageOfMathGradeStructList(list);

            fos.write(String.format("语文平均分：%.1f\n", chineseAvg).getBytes());
            fos.write(String.format("数学平均分：%.1f\n", mathAvg).getBytes());

            for (GradeStruct gradeStruct : list) {
                fos.write(
                    String.format(
                        "%s\t%s\t总分：%d\n", 
                        gradeStruct.Id, gradeStruct.Name, getSum(gradeStruct.GradeChinese, gradeStruct.GradeMath)
                    ).getBytes()
                );
            }
            fos.close();
            br.close();
            isr.close();
            fis.close(); 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getSum(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static double getAverageOfChineseGradeStructList(List<GradeStruct> list) {
        int sum = 0;
        for (GradeStruct gradeStruct : list) {
            sum += gradeStruct.GradeChinese;
        }
        return (double) sum / list.size();
    }

    public static double getAverageOfMathGradeStructList(List<GradeStruct> list) {
        int sum = 0;
        for (GradeStruct gradeStruct : list) {
            sum += gradeStruct.GradeMath;
        }
        return (double) sum / list.size();
    }
}