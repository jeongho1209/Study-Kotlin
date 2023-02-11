## invoke

invoke 연산자는 **`이름 없이 호출`**될 수 있다.

---

## 예시

```kotlin
object Test {

	operator fun invoke() {
		println("Hello")
	}
}

class CallTestObject {

	Test() // 이렇게 이름 없이 호출 가능하다
}
```

---

## operator

코틀린은 `실행을 간편`하게 할 수 있는 **`연산자를 제공`**

연산자 예시로는 (+, -, invoke)등이 있는데 이러한 **연산자를 오버로딩을 할 수 있게 하는 것이 operator**

---
