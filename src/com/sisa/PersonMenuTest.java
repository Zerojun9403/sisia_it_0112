package com.sisa;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class PersonMenuTest {

    // 프로그램 시작 메서드
    public static void main(String[] args) throws Exception {

        // 콘솔 입력을 받기 위한 BufferedReader 생성
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // PersonMenu 객체 생성 (데이터 등록/조회/삭제 담당)
        PersonMenu menu = new PersonMenu();

        // 프로그램이 종료될 때까지 반복 실행
        while (true) {

            // 메뉴 출력
            System.out.println("\n1. 등록  2. 조회  3. 삭제  0. 종료");
            System.out.print("선택 > ");

            // 사용자 입력을 문자열로 받아 정수로 변환
            int num = Integer.parseInt(in.readLine());

            // 0번 선택 시 반복문 종료
            if (num == 0) break;

            // 선택한 메뉴에 따라 분기 처리
            switch (num) {

                // 1번: 등록
                case 1:
                    // 이름 입력
                    System.out.print("이름: ");
                    String name = in.readLine();

                    // 나이 입력
                    System.out.print("나이: ");
                    int age = Integer.parseInt(in.readLine());

                    // 직업 입력
                    System.out.print("직업: ");
                    String job = in.readLine();

                    // 입력받은 값으로 Person 객체 생성
                    Person p = new Person(name, age, job);

                    // PersonMenu에 데이터 저장
                    menu.insert(p);

                    System.out.println("등록 완료");
                    break;

                // 2번: 조회
                case 2:
                    // 저장된 Person 목록을 배열로 반환
                    Person[] persons = menu.select();

                    // 저장된 데이터가 없는 경우
                    if (persons.length == 0) {
                        System.out.println("조회할 내용이 없습니다.");
                    } 
                    // 데이터가 있는 경우
                    else {
                        System.out.println("번호\t이름\t나이\t직업");

                        // 향상된 for문으로 전체 출력
                        for (Person person : persons) {
                            // person.toString() 자동 호출
                            System.out.println(person);
                        }
                    }
                    break;

                // 3번: 삭제
                case 3:
                    // 삭제할 번호 입력
                    System.out.print("삭제할 번호: ");
                    int delNo = Integer.parseInt(in.readLine());

                    // 삭제 성공 여부 반환
                    boolean deleted = menu.delete(delNo);

                    // 삭제 결과 출력
                    if (deleted) {
                        System.out.println("삭제 완료");
                    } else {
                        System.out.println("삭제할 내용이 없습니다.");
                    }
                    break;

                // 그 외 잘못된 입력
                default:
                    System.out.println("잘못된 선택");
            }
        }

        // 프로그램 종료 메시지
        System.out.println("프로그램 종료");
    }
}
