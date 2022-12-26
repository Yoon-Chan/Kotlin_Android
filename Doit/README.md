# Doit Kotlin

## ch6 실습
---
간단한 화면 예제이다. xml으로만 꾸몄기 때문에 기능은 아무것도 없다.

__실행 화면 결과__

<img width="200" alt="1" src="https://user-images.githubusercontent.com/56026214/209336221-7610cffd-9e1a-4077-accd-aa649af728ab.png">

---

## ch7 실습(레이아웃)

간단한 화면 예제이다. 전화번호를 레이아웃을 이용하여 만들었다

__실행 화면 결과__

<img width="200" alt="1" src="https://user-images.githubusercontent.com/56026214/209382968-1412658c-9a39-4d92-8c4a-871118d902df.png">


---

## ch8 실습(이벤트 터치)

버튼 터치 이벤트로 시계 앱의 스톱워치 기능 만들기

__실행 결과__

| 시작 화면 | start | stop| reset | back |
| :--: | :--:| :--: | :--: | :--: |
|<img width="200" height="300" alt="1" src="https://user-images.githubusercontent.com/56026214/209398507-3fa88e41-7be7-4dfd-aeaa-cbfe105778e4.png"> | <img width="200" height="300" alt="2" src="https://user-images.githubusercontent.com/56026214/209398510-2efb6eca-5b2c-442f-a28a-dfb2406b568c.png"> | <img width="200" height="300" alt="3" src="https://user-images.githubusercontent.com/56026214/209398514-348e4e8c-4b1a-4ffd-b8dc-54d0f71f78d3.png"> | <img width="200" height="300" alt="4" src="https://user-images.githubusercontent.com/56026214/209398519-18c83409-846a-4f80-a3b4-c785393c6682.png"> | <img width="200" height="300" alt="5" src="https://user-images.githubusercontent.com/56026214/209398522-0321160f-a980-464f-8d99-3654f0823b5c.png"> |


---

## ch9 실습(리소스 활용)

메신저 앱의 인트로 화면 만들기
언어가 한국어 일때, 영어권일 때 화면이 다르게 나오는 것과
가로와 세로 일 때의 화면이 보여지는 것을 다르게 설정하여 나오도록 한다.

|시작화면 - 세로| 시작화면 - 가로| 영어권 - 세로| 영어권 - 가로|
|:--:| :--: | :--: | :--: |
|<img width="394" alt="1" src="https://user-images.githubusercontent.com/56026214/209402817-83e83684-3eaa-4d44-b5cb-a3c8a0dba8f4.png"> | <img width="600" height ="300" alt="2" src="https://user-images.githubusercontent.com/56026214/209402825-209708e7-e940-461a-833a-c796711ac6b1.png">| <img width="392" alt="3" src="https://user-images.githubusercontent.com/56026214/209402837-c0fe6053-ed22-4071-a6f6-d56a066924a9.png">|<img width="600" height ="300" alt="4" src="https://user-images.githubusercontent.com/56026214/209402847-3d9641e5-1506-41df-9428-4fc8cdce504b.png">|


---

## ch10 실습(알림사용)

카카오톡 알림 실습 예제

|시작 화면| 버튼 누른 후 알림 | 답장 누름 | 답장 보내기|
| :--: | :--: | :--: | :--: |
|<img width="400" alt="1" src="https://user-images.githubusercontent.com/56026214/209445834-f9ffb652-b592-42e7-8d56-375421cbafa3.png">|<img width="400" alt="2" src="https://user-images.githubusercontent.com/56026214/209445836-fe777df9-0147-46de-aeb6-bf446021d406.png">|<img width="400" alt="3" src="https://user-images.githubusercontent.com/56026214/209445840-0edbf731-b58b-49e7-bff3-a26de41d66bb.png">|<img width="400" alt="4" src="https://user-images.githubusercontent.com/56026214/209445848-7cb5f36e-9b74-4c2f-b79f-f6fa40dc2471.png">|



---

## Ch11 실습(jetpack 사용해보기)



제트팩의 여러 기능들을 사용하여 앱을 만든다.



메인화면에서 스와이프 기능으로 프래그먼트를 이동할 수 있게 한다.

|                          메인 화면                           |                         플레그먼트2                          |                         플레그먼트 3                         |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226215726935.png" alt="image-20221226215726935" style="zoom: 25%;" /> | <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226215757727.png" alt="image-20221226215757727" style="zoom:25%;" /> | <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226215812171.png" alt="image-20221226215812171" style="zoom:25%;" /> |



툴바에 있는 메뉴화면(햄버거 모양)을 누르면 drawer 기능을 사용할 수 있다.

|                     햄버거 모양 누를 시                      |                     drawer 밖을 누를 시                      |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226220041343.png" alt="image-20221226220041343" style="zoom:25%;" /> | <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226220053956.png" alt="image-20221226220053956" style="zoom:25%;" /> |

 햄버거 모양을 누르지 않고 스와이프를 누른채로 옆을 당기면 drawer를 꺼낼 수 있다.



툴바에 있는 검색기능을 사용하는 경우

|                    x검색 버튼을 누른 경우                    |
| :----------------------------------------------------------: |
| <img src="C:\Users\vsvx1\AppData\Roaming\Typora\typora-user-images\image-20221226220226318.png" alt="image-20221226220226318" style="zoom:25%;" /> |

검색 창이 열리며 검색이 가능하다. 



