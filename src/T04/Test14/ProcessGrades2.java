package src.T04.Test14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcessGrades2 {
    public static void main(String[] args) {
        
        InputStreamReader isr = null;
        BufferedReader br = null;

        PrintWriter pw = null;
        List<GradeStruct> list = null;

        try {
            isr = new InputStreamReader(
                new FileInputStream("./src/T04/Test14/in.txt")
            );
            br = new BufferedReader(isr);
            pw = new PrintWriter("./src/T04/Test14/result.txt");

            list = new ArrayList<GradeStruct>();
            String str = null;
            double chineseAvg = 0, mathAvg = 0;

            while ((str = br.readLine()) != null) {
                String[] data = str.split("\\s+");
                list.add(new GradeStruct(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }

            chineseAvg = ProcessGrades.getAverageOfChineseGradeStructList(list);
            mathAvg = ProcessGrades.getAverageOfMathGradeStructList(list);

            pw.printf("语文平均分：%.1f\n", chineseAvg);
            pw.printf("数学平均分：%.1f\n", mathAvg);

            for (GradeStruct gradeStruct : list) {
                pw.println(gradeStruct.Id + "\t" + gradeStruct.Name + "\t" 
                           + ProcessGrades.getSum(gradeStruct.GradeChinese, gradeStruct.GradeMath));
            }
            pw.close();
            br.close();
            isr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}