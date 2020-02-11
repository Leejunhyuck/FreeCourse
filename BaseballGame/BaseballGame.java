package BaseballGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Game의 모든 기능을 구현한 클래스
 * 
 * @author Junhyuck
 * @version 1.0, 에외처리를 제외한 기본 기능 구현 2020년 2월 11일
 * @see None
 */
class BaseballGame {

    /** 각 함수에서 입력을 받기 위한 클래스 변수 */
    Scanner scann = new Scanner(System.in);
    
    /** 게임 중지를 판단하기 위한 변수 */
    static boolean STOP_FLAG = true;


    public void run() {

        while (flagStop()) {

        }

        scann.close();

    }

    /**
     * 숫자를 입력 받고, 숫자가 맞았는지 판단하는 메소드
     * 
     * @return 다시 시작 한다면 true, 반대면 false 
     */
    public boolean flagStop() {
        String randNum = makeNum();
        System.out.println("------------- " + randNum);
        while (STOP_FLAG) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scann.nextLine();
            checkNum(randNum, input);
        }

        boolean check = restartCheck();

        return check;
    }

    /**
     * 입력한 수와, 생성한 난수를 비교하여 갯수를 출력하는 메소드
     * 
     * @param ranNum 생선된 난수
     * @param inputNum 사용자가 입력한 수
     */
    public void checkNum(String ranNum, String inputNum) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < ranNum.length(); i++) {
            strikeCnt = checkStrike(ranNum, inputNum, i) ? strikeCnt + 1 : strikeCnt;
            ballCnt = checkBall(ranNum, inputNum, i) ? ballCnt + 1 : ballCnt;
        }

        printResult(strikeCnt, ballCnt);

    }

    /**
     * 입력한 수와, 생성한 난수를 비교하여 볼의 값 체크
     * 
     * @param randNum 생선된 난수
     * @param inputNum 사용자가 입력한 수
     * @param index 각 자리를 비교하기 위한 인덱스
     * @return 같은 값이 있다면 true, 없다면 false 
     */
    public boolean checkBall(String randNum, String inputNum, int index) {
        return (randNum.contains(String.valueOf(inputNum.charAt(index))));
    }
    
    /**
     * 입력한 수와, 생성한 난수를 비교하여 strike의 값 체크
     * 
     * @param randNum 생선된 난수
     * @param inputNum 사용자가 입력한 수
     * @param index 각 자리를 비교하기 위한 인덱스
     * @return 같은 값이 있다면 true, 없다면 false
     */
    public boolean checkStrike(String randNum, String inputNum, int index) {
        return (randNum.charAt(index) == inputNum.charAt(index));
    }

   /**
    * 난수를 생성하는 메소드 
    *
    * @return 생성된 난수
    */
    public String makeNum() {
        Random random = new Random();
        String randNum = Integer.toString((random.nextInt(10) * 100 + random.nextInt(10) * 10 + random.nextInt(9) + 1));
        return randNum;
    }

    /**
     * 스트라이크 갯수와, 볼의 갯수를 비교하여 결과 출력
     * 
     * @param strikeCnt 카운트된 스트라이크 갯수
     * @param ballCnt 카운트된 볼 갯수 
     */
    public void printResult(int strikeCnt, int ballCnt) {

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("Nothing!");
        } else {
            System.out.println("STRIKE : " + strikeCnt + ", BALL : " + ballCnt);
        }

        if (strikeCnt == 3) {
            System.out.println("정답 입니다!");
            STOP_FLAG = false;
        }
    }

    /**
     * 사용자에게 입력값을 받아서 게임의 restart 결정하는 메소드
     * 
     * @return 사용자가 1을 입력하면 true, 2를 입력하면 false return
     */
    public boolean restartCheck() {
        System.out.println("게임을 새로 시작하시려면 1, 그만 하시려면 2 를 눌러주세요.");
        int input = scann.nextInt();
        boolean check = input == 1 ? true : false;
        return check;
    }

}