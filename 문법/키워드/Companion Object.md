## Companion Object ?

우리가 공부하고 있는 **`코틀린에는 static이 존재하지 않는다`** 

만약 static과 비슷한 기능을 사용하고 싶다면 **객체를 선언할 때 Companion 키워드를 붙이면 된다**

```kotlin
class MyClass {
		companion object Factory {
				fun create() : MyClass = MyClass()
}
```

선언해주면 Java에서 static을 호출했던 것처럼 해당 객체를 사용 가능하다.

이 키워드는 어떤 클래스의 **`모든 인스턴스가 공유하는 객체`**를 만들고 싶을 때 

사용하며 **클래스당 한 개**만 사용 가능하다.

하나만 안 쓰면 에러 난다

> `Only one companion object is allowed per class`

### 참고
https://medium.com/@lunay0ung/kotlin-object-declaration-%EA%B7%B8%EB%A6%AC%EA%B3%A0-companion-object-feat-static-d5c97c21168
