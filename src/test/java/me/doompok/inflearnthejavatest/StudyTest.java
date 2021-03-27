package me.doompok.inflearnthejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    @DisplayName("스터디 만들기 111")
    void create() {
        Study study = new Study(-10);

        //assertAll을 안쓰면 한메소드에 해당 테스트라인이 실패하면 그밑으로는 진행이 되지 않는다
        //그래서 assertAll로 묶어주면 이 안에 테스트라인들이 실패/성공 모두 실행된다.
        assertAll(
                () -> assertNotNull(study),
                () -> assertTrue(study.getLimit() > 0, "스터디 참석인원 0보다 커야한다.")
        );

    }

//    @Disabled  //해당 메서드 테스트 실행시키지 않기
    @Test
    @DisplayName("스터디 만들기\uD83C\uDF54 ")
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll

    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }
}




