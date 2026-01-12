package com.sisa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PersonMenuTest {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PersonMenu menu = new PersonMenu();

        while (true) {
            System.out.println("\n1. 등록  2. 조회  3. 삭제  0. 종료");
            System.out.print("선택 > ");
            int num = Integer.parseInt(in.readLine());

            if (num == 0) break;

            switch (num) {
                case 1:
                    System.out.print("이름: ");
                    String name = in.readLine();

                    System.out.print("나이: ");
                    int age = Integer.parseInt(in.readLine());

                    System.out.print("직업: ");
                    String job = in.readLine();

                    Person p = new Person(name, age, job);
                    menu.insert(p);
                    System.out.println("등록 완료");
                    break;

                case 2:
                    Person[] persons = menu.select();

                    if (persons.length == 0) {
                        System.out.println("조회할 내용이 없습니다.");
                    } else {
                        System.out.println("번호\t이름\t나이\t직업");
                        for (Person person : persons) {
                            System.out.println(person);
                        }
                    }
                    break;

                case 3:
                    System.out.print("삭제할 번호: ");
                    int delNo = Integer.parseInt(in.readLine());

                    boolean deleted = menu.delete(delNo);

                    if (deleted) {
                        System.out.println("삭제 완료");
                    } else {
                        System.out.println("삭제할 내용이 없습니다.");
                    }
                    break;

                default:
                    System.out.println("잘못된 선택");
            }
        }

        System.out.println("프로그램 종료");
    }
}
