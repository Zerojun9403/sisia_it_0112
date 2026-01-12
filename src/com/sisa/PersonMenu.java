package com.sisa;

public class PersonMenu {

    private Person[] persons = new Person[100];
    private int no = 0;

    // 등록
    public void insert(Person p) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                p.no = ++no;
                persons[i] = p;
                break;
            }
        }
    }

    // 전체 조회
    public Person[] select() {
        int count = 0;

        for (Person p : persons) {
            if (p != null) count++;
        }

        Person[] result = new Person[count];
        int idx = 0;

        for (Person p : persons) {
            if (p != null) {
                result[idx++] = p;
            }
        }

        return result;
    }

    // 삭제
    public boolean delete(int no) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].no == no) {
                persons[i] = null;
                return true;   // 삭제 성공
            }
        }
        return false;          // 삭제할 내용 없음
    }
}
