## 상속 ?

자식 클래스가 부모 클래스의 필드와 메소드를 받아서 사용하는 것

자바에서는

```java
public class Test extends ParentTest {
}
```

우리가 공부하고 있는 코틀린에서는

```kotlin
class Test: ParentTest {
}
```

부모 클래스인 **ParentTest 클래스에 open 키워드를 달아줘야한다**

### 달아주지 않으면 ?

**This Type is final, so it cannot be inherited from** 이라는 에러가 나온다

왜냐하면 코틀린은 open 키워드가 없을 경우 다른 곳에서 상속 받지 못하는 final class로 정의된다

final class (java) == class (kotlin) 같고

class (java) == open class (kotlin) 같다

### 참고
https://androidtest.tistory.com/102
