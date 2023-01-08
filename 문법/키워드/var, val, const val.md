## var

var은 **`variable = 변수`**를 의미, Kotlin에서 **변수를 선언할 때 사용**

var 키워드로 선언된 변수는 값을 변경 가능

또한 **선언하면서 초깃값을 지정해준다면 변수 타입을 생략 가능하도록 타입 추론 기능**이 있음

```java
var count = 0 // Int 타입이 된다
count = 1
println(count)

1 // 출력
```

---

## val

val은 **`value = 값`**을 의미, 또한 **Kotlin에서 변수를 선언할 때 사용**

val 키워드로 선언된 변수는 **`단 한 번만 초기화 가능`**

```java
val count = 0 // Int 타입이 된다
count = 1 // 오류가 남!! -> val 값을 바꾸려고 했기 때문에
println(count)
```

### 중요한 점

val 키워드로 **`값을 저장했을 경우에는 해당 변수는 변경이 불가능`**

만약 변수가 **객체에 대한 참조 값을 저장하고 있다면 객체의 내부 값은 변경 가능**

---

## const val

**`const는 상수를 정의하기 위한 키워드`**, val은 변경이 불가능한 상수를 저장

const는 **컴파일 시점에 값이 할당**되어 있어야 함

컴파일 시점에 값이 할당 필수 = **`함수나 클래스 생성자로 할당 X, 기본 자료형으로 할당, 지역변수 X`**

const로 변수를 선언할 경우 int, boolean, float, **`String만 예외`**

등으로 초기화를 해야한다

---

## 정리

**`var = mutable(변경 가능)`**

**`val = immutable(변경 불가능)`**

---

## 참고
https://kumgo1d.tistory.com/60
