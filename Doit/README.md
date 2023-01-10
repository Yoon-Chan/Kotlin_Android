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
|![1](https://user-images.githubusercontent.com/56026214/209552397-3bccb79d-bb9d-4de3-8a54-67fbfb618b45.png)| ![2](https://user-images.githubusercontent.com/56026214/209552413-6fb79aab-fbb3-4f68-a1bf-01f33926280d.png) |![3](https://user-images.githubusercontent.com/56026214/209552414-af4988a9-fcc6-4091-9725-207f5ccd3ce3.png) |



툴바에 있는 메뉴화면(햄버거 모양)을 누르면 drawer 기능을 사용할 수 있다.

|                     햄버거 모양 누를 시                      |                     drawer 밖을 누를 시                      |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![4](https://user-images.githubusercontent.com/56026214/209552437-6d56d15b-84c2-4d8d-8921-a973c1a7cbb6.png)|![5](https://user-images.githubusercontent.com/56026214/209552453-b1b2e75e-9abe-4753-8293-f7bcca52a8e3.png)|

 햄버거 모양을 누르지 않고 스와이프를 누른채로 옆을 당기면 drawer를 꺼낼 수 있다.



툴바에 있는 검색기능을 사용하는 경우

|                    x검색 버튼을 누른 경우                    |
| :----------------------------------------------------------: |
|  ![6](https://user-images.githubusercontent.com/56026214/209552968-dc0f6987-e321-4d78-a23c-80dadf757ad8.png) |

검색 창이 열리며 검색이 가능하다. 



---



## Ch12 실습(머티리얼 사용하기)



다른 안드로이드 확장 기능을 사용하여 Ch11에 사용했던 기능에서 추가를 했다.

| 시작 화면 | 해당 탭을 눌렀을 때 | 아래쪽으로 내렸을 때 | drawer를 눌렀을 때 |
| :-------: | :-----------------: | :------------------: | :----------------: |
|     <img width="395" alt="1" src="https://user-images.githubusercontent.com/56026214/209562533-0bb83604-b93a-4150-882b-7cbd529861ff.png">    |          <img width="396" alt="2" src="https://user-images.githubusercontent.com/56026214/209562544-603f517d-65ef-4fa0-b8b5-c20c824cfb38.png">   |          <img width="765" alt="3" src="https://user-images.githubusercontent.com/56026214/209562553-dabe36e2-3910-4c58-b47a-99d82d412689.png">       |         <img width="398" alt="4" src="https://user-images.githubusercontent.com/56026214/209562560-5560d32b-d387-457a-995b-d14516294a4f.png">        |



Drawer에서는 네비게이션을 이용하여 많이 사용하는 형태인 디자인으로 만들었다.

또한 아래에는 ExtendedFloatingActionButton을 추가하여 버튼을 만들었다. 기능은 추가 x

앱바를 다른 형식으로 이미지와 함께 추가하였으며 아래로 스크롤 했을 경우 기본 앱바 형식으로 돌릴 수 있는 기능을 만들었다.

또한 탭을 추가하여 해당 탭을 눌렀을 때 해당 프래그먼트로 이동하는 기능을 만들었다.



---

## Ch13 실습



인텐트 기능을 사용하여 텍스트 등록



| 시작 화면 | 플로팅 확장 버튼 누른 경우 | 등록한 경우 |
| :-------: | :------------------------: | :---------: |
|   <img width="398" alt="1" src="https://user-images.githubusercontent.com/56026214/209635406-4176ffd0-52c6-47b9-8522-6fc5a941dc54.png"> |              <img width="398" alt="2" src="https://user-images.githubusercontent.com/56026214/209635416-e22cb1a0-9ecf-433e-be00-29685e69027c.png">  |     <img width="399" alt="3" src="https://user-images.githubusercontent.com/56026214/209635427-2ee8bf2d-c0ce-419c-ba1a-7cd17b65d0cb.png">|

플로팅 확장 버튼 기능으로 intent 기능을 이용하여 다른 액티비티에 간 후

해당 EditText에서 글을 등록하고 AppBar에 있는 저장 버튼을 누르면 다시 메인 액티비티에 와서

해당 등록된 글을 저장한다.



---



## ch14 실습



| 배터리 충전 화면 | 충전 x 화면 | RUN RECEIVER 버튼 눌렀을 때 |
| :--------------: | :---------: | :-------------------------: |
|     <img width="398" alt="1" src="https://user-images.githubusercontent.com/56026214/209640280-49559cc0-2f19-44f2-92cd-06cb432c5ac2.png"> |      <img width="401" alt="2" src="https://user-images.githubusercontent.com/56026214/209640289-5eecb12b-adf5-452e-9940-20aa06e3e3f5.png"> |<img width="390" alt="3" src="https://user-images.githubusercontent.com/56026214/209640299-c3d88793-3a2a-42d8-8e35-96092dfa415b.png">|



브로드캐스트 리시버를 통해 배터리 정보를 확인 할 수 있는 기능을 만들었다.

버튼을 누르면 예전 실습에서 사용한 알림 기능을 사용하여 기능이 작동하는지 확인했다.





---



## ch16 실습



카메라 앱, 사진 선택으로 이미지를 바꾸는 기능



| 시작 화면 | 갤러리 버튼 선택 | 갤러리 버튼 선택 후 화면 변경 | 카메라 촬영 | 카메라 촬영 결과 |
| :-------: | :--------------: | :---------------------------: | :---------: | :--------------: |
|   ![1](https://user-images.githubusercontent.com/56026214/210236937-31d635ed-35a8-4ad8-811d-d10b979b05a8.png)|          ![2](https://user-images.githubusercontent.com/56026214/210236942-a53b982e-4e99-41a2-bfcb-f2382e52ea52.png)|                ![3](https://user-images.githubusercontent.com/56026214/210236947-53391f80-7168-446a-98c1-eced83d484a7.png)|    ![4](https://user-images.githubusercontent.com/56026214/210236954-1b773896-4029-470a-9652-50200e6f755e.png)|          ![5](https://user-images.githubusercontent.com/56026214/210236963-f255b51c-4371-427b-b513-926b47d0e9b4.png)|



1. 시작 화면 - 갤러릭 선택과 카메라 선택 버튼이 주어지고 가운데에는 기본 이미지가 설정 되어 있다.
2. 갤러리 버튼 선택 - 사진 앨범으로 이동하며 사진을 선택할 수 있다.
3. 갤러리 버튼 선택 결과 - 앨범에 사진을 선택하면 기본 이미지에서 해당 이미지로 바뀐 것을 볼 수 있다.
4. 카메라 버튼 - 카메라 앱이 실행 되며 사진을 찍으면 해당 사진이 이미지로 설정된다.
5. 카메라 촬영 결과 - 바뀐 사진을 볼 수 있다.

---



## ch17 실습



내장된 sqlite 파일을 이용하여 데이터베이스를 꺼내어 쓰거나, 저장하는 방법을 사용한다.



| 시작 화면 | 앱바 설정 클릭 | 설정 변경 - ID |
| :-------: | :------------: | :------------: |
|     ![1](https://user-images.githubusercontent.com/56026214/210273381-271bb285-4176-4312-84f6-d0ebd50d35d3.png)|          ![2](https://user-images.githubusercontent.com/56026214/210273383-64d0c7f6-b3b0-4fca-b114-47dfb4b1ca98.png)|        ![3](https://user-images.githubusercontent.com/56026214/210273401-4c27f112-9ecf-4722-ab1c-9c7c29675f29.png)|

| 설정 변경 - 색상선택 | 확장 버튼 클릭 | 저장 버튼 클릭 |
| :------------------: | :------------: | :------------: |
|             ![4](https://user-images.githubusercontent.com/56026214/210273414-8151f78f-7ad9-4d42-b77e-5a6a450f7838.png)|        ![5](https://user-images.githubusercontent.com/56026214/210273417-cb5871ea-9012-40e3-b84f-1568fa0315f3.png)|       ![7](https://user-images.githubusercontent.com/56026214/210273478-96745e58-059d-4818-ab52-b700a5314fce.png)|





1. 시작 화면 - ch13에서 사용했던 실습과 비슷한 환경이다.
2. 앱바 설정 클릭 - 앱바에 있는 설정 버튼을 누르면 위와 같은 설정 화면이 나온다. 이 화면은 settings.xml 파일에서 만든 것이다. PreferenceScreen 태그와 PreferenceCategory, SwitchPreferenceCompat 등 여러 태그를 이용하여 만들었다.
3. 설정 변경 - ID  - 해당 화면을 클릭하면 id값을 변경할 수 있게 설정할 수 있다. 설정한 값을 지정하고 OK를 누르면 아래에 변경된 ID값을 볼 수 있다.
4. 설정 변경 - 색상선택 - 해당 화면을 클릭하면 3가지 색상을 선택할 수 있게 한다. 이또한 변경된 색상 값을 아래의 텍스트에서 볼 수 있다.
5. 확장 버튼 클릭 - 확장 버튼을 클릭하면 텍스트를 입력할 수 있는 화면이 나온다.
6. 저장 버튼 클릭 - 시작화면에 저장된 값을 볼 수 있다.



저장된 값은 SQLite에 저장되어 있어 해당 앱을 끄고 다시 실행해도 다시 데이터를 가져오므로 같은 화면이 나온다.



---



## ch18 실습 



기사 작성되어 있는 https://newsapi.org 사이트에서 뉴스 기사를 JSON 데이터로 가져와

앱에 보여지는 기능을 만들었다.

Volley와 Retrofit 두 라이브러리를 이용하여 만들었다.



| VOLLEY | RETROFIT |
| :----: | :------: |
|   1    |    2     |



두 화면을 프래그먼트로 이용하여 탭바를 누르면 화면이 전환되도록 구현했다.

프래그먼트가 바뀌어도 두 화면은 같은 뉴스 정보를 가져오기 때문에 차이가 없다. 하지만 뉴스를 가져오는 방법을 다른 방법으로 사용하여 구현했다.



Volley 라이브러리를 이용하여 사용한 방법은 url에 해당 url을 저장하고

Volley.newRequestQueue를 생성하여 해당 jsonRequest를 넣는 방법이다.

JSON 데이터는 JsonObjectRequest를 이용하여 해당 url에 JSON 데이터를 가져오는 방식으로 구현했다.



Retrofit 라이브러리는 Call 인터페이스를 구현하여 직접 구현한 NetworkService 인터페이스를 이용하여 url에 접근하고 데이터를 @Query @GET을 사용하여 해당 url에 있는 데이터를 가져오도록 하고 가져온 데이터를 이용하여 화면에 보여준다.



