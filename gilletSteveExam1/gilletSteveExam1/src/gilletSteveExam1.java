// Steve Gillet Exam 1

import java.util.Scanner;

public class gilletSteveExam1 {
    public static void main(String[] args) throws Exception {
        new ScoreGradeTest();
    }
}

class ScoreGrade{
    private double testScore1, testScore2, testScore3;
    ScoreGrade(double t1, double t2, double t3){
        testScore1 = t1;
        testScore2 = t2;
        testScore3 = t3;
    }
    double calculateAverage(){
        return (testScore1 + testScore2 + testScore3) / 3;
    }
    void maxScore(){
        double max;
        max = testScore1;
        if(testScore2 > max) max = testScore2;
        if(testScore3 > max) max = testScore3;
        System.out.println("The max score is " + max);
    }
}

class ScoreGradeTest{
    double t1, t2, t3;
    Scanner sc = new Scanner(System.in);
    ScoreGradeTest(){
        System.out.println("Enter the first test score: ");
        t1 = sc.nextDouble();
        System.out.println("Enter the second test score: ");
        t2 = sc.nextDouble();
        System.out.println("Enter the third test score: ");
        t3 = sc.nextDouble();
        ScoreGrade scoreGradeObj = new ScoreGrade(t1, t2, t3);
        double avg = scoreGradeObj.calculateAverage();
        System.out.println("The average is " + avg);
        scoreGradeObj.maxScore();
    }
}