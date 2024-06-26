![header](https://capsule-render.vercel.app/api?type=waving&text=n.Pureun&height=200&color=73C2FB&animation=fadeIn&fontColor=003153)

# 🖥 야구게임 🖥
### 야구게임을 즐길 수 있는 프로그램입니다.

---

## 🔷 목차 🔷
### <p align="left"><a href="#-기능과-사용법">📒 기능과 사용법 </a></p>
### <p align="left"><a href="#-프로그램-구조">🌃 프로그램 구조 </a></p>
### <p align="left"><a href="#-기능-설명">🪐 기능 설명 </a></p>
### <p align="left"><a href="#-시도해본-것">🤖 시도해본 것 </a></p>

---
## 📒 기능과 사용법

프로그램의 사용법과, 기능을 소개합니다.


### 👾 사용법

메뉴를 선택하면 각 기능을 수행합니다.
```ruby
원하시는 번호를 입력해주세요
---------------
1. 게임 시작하기
2. 게임 기록 보기
3. 시간 기록 보기
4. 기록 초기화
5. 종료하기
---------------
입력: 
```

### 👾 부가기능

<code>**게임 :**</code> 게임 시작 후 <code>"lapf"</code>를 입력하면 현재의 정답을 알려줍니다.

```ruby
< 게임을 시작합니다 >

숫자를 입력하세요: lapf
--> (Loop:1) 치트 활성: 현재 정답= 296
```
<code>**로그 :**</code> 선택한 로그에 따라 각각 게임의 흐름에 대한 로그와, 클리어하는데 걸린 시간을 출력합니다.

```ruby
< 게임 로그를 봅니다. >

<Game:(1)>
(Loop): 1 || (Input): Cheat || {(Result): 치트 활성: 현재 정답= 296}
(Loop): 2 || (Input): 296 || {(Result): 3 스트라이크! 정답입니다!! 정답 = 296}
----------------------------------------
< 타임 로그를 봅니다. >

(1)Game= (2)loop / (20)sec
```

### 👾 예외처리

<code>**메뉴 :**</code> 메뉴에서 잘못된 입력을 넣으면 꾸짖습니다.
```ruby
입력: 6
마 똑디 선택해라 숫자 모르나?
입력: q
마 똑디 선택해라 숫자 모르나?
입력: 11
마 똑디 선택해라 숫자 모르나?
```

<code>**게임 :**</code> 숫자가 아니거나, 중복되었거나 가장 앞에 0이 입력된다면 예외를 발생합니다.
```ruby
숫자를 입력하세요: q
!!!올바르지 않은 값입니다.

숫자를 입력하세요: 111
!!!같은 숫자는 생성되지 않습니다.

숫자를 입력하세요: 011
!!!가장 앞에 0이 있습니다.
```

<code>**로그 :**</code> 진행한 게임이 없을 시 예외를 발생합니다.
```ruby
< 게임 로그를 봅니다. >

진행된 게임이 없습니다.
----------------------------------------
< 타임 로그를 봅니다. >

진행된 게임이 없습니다.
```


# <p align="right"><a href="#-목차-">🔝</a></p>

---
## 🌃 프로그램 구조

프로그램 구조 도식화 입니다.

<img width="604" alt="스크린샷 2024-05-02 오후 5 28 05" src="https://github.com/npureaun/image/assets/98468118/a3d3793f-598c-42d8-a69d-3c86426cc971">


# <p align="right"><a href="#-목차-">🔝</a></p>

---
## 🪐 기능 설명

주요클래스와 로직을 설명합니다.

### 👾 Manager  
<details>
<summary>전반적인 <code>흐름을</code> 관리합니다. Utile을 상속받습니다.</summary>

+ #### <code>private fun manual()</code>

    = <code>전체적인 흐름을</code> 알 수 있습니다.
    <details>
    <summary><code>row code</code></summary>
    
    ```kotlin
     when(choice)
            {
                1->{ println("< 게임을 시작합니다 >\n");startGame() }
                2->{ println("< 게임 로그를 봅니다. >\n");readLog(Logger.LogType.GAME_LOG) }
                3->{ println("< 타임 로그를 봅니다. >\n");readLog(Logger.LogType.TIME_LOG) }
                4->{ println("< 로그를 초기화 합니다. >\n");clearAll() }
                5->{ println("< 게임을 종료합니다 >\n");break }
            }
    ```
    
    </details>
    
</details>

### 👾 Utile  
<summary>전체적인 흐름의 <code>구현</code>을 담당합니다.</summary>



### 👾 InputException  
<details>
<summary><code>커스텀 </code>예외처리</summary>

+ #### <code>Exceptions</code>

    = <code>InputException</code>을 상속받는 커스텀 예외처리입니다.
    <details>
    <summary><code>row code</code></summary>
    
    ```kotlin
    class NumberException:InputException("!!!올바르지 않은 값입니다.\n")
    class LengthException:InputException("!!!올바르지 않은 길이입니다.\n")
    class ZeroException:InputException("!!!가장 앞에 0이 있습니다.\n")
    class EqualException:InputException("!!!같은 숫자는 생성되지 않습니다.\n")
    ```
    
    </details>
    
</details>


### 👾 StringProcessor  
<details>
<summary><code>난수생성과 사용자 입력</code>을 처리합니다.</summary>

+ #### <code>processor</code>

    = <code>interface</code> 구현된 생성, 입력 클래스를 작동시킵니다.
    <details>
    <summary><code>row code</code></summary>
    
    ```kotlin
    private var processor: StringInterface? = null
    private fun processInput() = processor?.setString()
    fun processGetting(): String?= processor?.getString()
    fun runProcess(processor: StringInterface)...
    }
    ```
    
    </details>
    
</details>


### 👾 Logger  
<details>
<summary><code>interface</code>구현된 여러 <code>LogType</code>를 핸들링 하는 <code>object</code>입니다.</summary>

+ #### <code>object Logger</code>

    = <code>Logger</code>는 여러<code>LogType</code>에 대한 연결을 지원합니다.
    <details>
    <summary><code>row code</code></summary>
    
    ```kotlin
    val gameLog = LogProcessor(TimeTable())
    val timeLog = LogProcessor(TimeChecker())
    ```
    
    </details>
    
</details>


# <p align="right"><a href="#-목차-">🔝</a></p>

---
## 🤖 시도해본 것

### 👾 동적메뉴를 구상하였습니다.  
<details>
<summary><code>private fun manual()</code></summary>
    
```kotlin
    //메뉴를 리스트에 담고
    val menu= listOf("게임 시작하기","게임 기록 보기","시간 기록 보기","기록 초기화","종료하기")

    // 카운팅을 자동으로 하여, 메뉴를 추가해주면 모든 변경사항이 적용되도록
    repeat(menu.size){println("${it+1}. ${menu[it]}")}
```

</details>


### 👾 숫자생성, 저장, 조회라는 유저와 컴퓨터의 동일한 동작에 대해 <code>interface</code>화 하였습니다.
<details>
<summary><code>interface StringInterface</code></summary>

```kotlin
    //문자열을 생성하고, 저장하고, 받아온다라는 기능이 같다. 
    var str:String
    fun setString()
    fun getString():String
```
    
</details>


### 👾 위와 마찬가지로, 각기다른 로그에 대응하는 <code>interface</code>를 통해, 서로다른 로그의 작동원리를 통일화 하였습니다. 
<details>
<summary><code>interface LogInterface<T></code></summary>

```kotlin
    //각 로그는 서로다른 데이터를 저장하지만, 로그를 쓰기위해 필요한 기능은 상통한다.
    //다만, 로그마다 저장하는 DataClass는 다르기에, Generic으로 구현되어야 한다.
    val log: MutableList<T>
    fun input(data: T)
    fun output(n: Int): T
    fun isEmpty(): Boolean
    fun indices(): IntRange
    fun readAll()
    fun clear()
```
    
</details>


### 👾 여러타입의 로그를 손쉽게 핸들링하고, 데이터 보존성을 높이기 위해, <code>Singleton</code>을 도입했습니다.
<details>
<summary><code>object Logger</code></summary>

```kotlin
    //여러타입의 로그를 Singleton을 통해 핸들링한다.
    val gameLog = LogProcessor(TimeTable())
    val timeLog = LogProcessor(TimeChecker())
    fun clearLog(type: LogType){...}
    fun readAll(type: LogType){...}
```
    
</details>


### 👾 예외에 대한 구분과, 그 예외들을 구체화하기 위해 <code>CustomException</code>을 도입했습니다.
<details>
<summary><code>open class InputException(message: String): Exception(message)</code></summary>

```kotlin
    //예외상황에 대한 대분류를 만들고, 소분류에서 구분한다. 
    class NumberException:InputException("!!!올바르지 않은 값입니다.\n")
    class LengthException:InputException("!!!올바르지 않은 길이입니다.\n")
    class ZeroException:InputException("!!!가장 앞에 0이 있습니다.\n")
    class EqualException:InputException("!!!같은 숫자는 생성되지 않습니다.\n")
```
    
</details>


# <p align="right"><a href="#-목차-">🔝</a></p>

---

