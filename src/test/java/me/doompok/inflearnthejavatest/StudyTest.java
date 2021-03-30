package me.doompok.inflearnthejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

//기본 테스트의 인스턴스 작동 원리는 하나의 메소드마나 각기다른 하나의 인스턴스를 생성
//각 메소드의 사용돼는 인스턴스를 하나의 인스턴스로 쓰게 해주는 기능
//BeforeAll과 AfterAll의 static은 생략 가능
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    int value = 1;

    @Order(2)
    @Test
    @DisplayName("스터디 만들기 111")
    void create() {
        System.out.println(this);
        System.out.println(value++);

        Study study = new Study(10);

        //assertAll을 안쓰면 한메소드에 해당 테스트라인이 실패하면 그밑으로는 진행이 되지 않는다
        //그래서 assertAll로 묶어주면 이 안에 테스트라인들이 실패/성공 모두 실행된다.
        assertAll(
                () -> assertNotNull(study),
                () -> assertTrue(study.getLimit() > 0, "스터디 참석인원 0보다 커야한다.")
        );

    }

//    @Disabled  //해당 메서드 테스트 실행시키지 않기
    @Order(1)
    @Test
    @DisplayName("스터디 만들기222")
    void create1() {
        System.out.println(this);
        System.out.println(value);
        System.out.println("create1");
    }

    @Order(3)
    @DisplayName("스터디 반복하기111")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test "+repetitionInfo.getCurrentRepetition() +"/"+
                repetitionInfo.getTotalRepetitions());
    }

    @Order(4)
    @DisplayName("스터디 반복하기222")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "더워지고", "있넫"})
    void parameterrizedTest(String message) {
        System.out.println(message);
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




