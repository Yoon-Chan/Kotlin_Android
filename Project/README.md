# Project 안드로이드 다양한 기능 구현 관련 앱 개발



## app 파일 - 숫자세기 앱



'+' 버튼을 누른 경우 숫자가 1씩 증가, reset 버튼을 누른 경우 숫자가 초기화(0)



| 시작화면 | + 버튼 눌렀을 때 | reset 버튼 눌렀을 때 | 화면을 회전했을 경우 |
| :------: | :--------------: | :------------------: | :------------------: |
|   ![1](https://user-images.githubusercontent.com/56026214/209665066-7ba2b931-6136-4214-a599-2b3dec4088ad.png)|![2](https://user-images.githubusercontent.com/56026214/209665069-3457f4c7-77bb-4951-b17f-b63ee4965996.png)|![3](https://user-images.githubusercontent.com/56026214/209665076-845a27c2-3ec3-46fd-bd33-f81b3f2e8477.png)|![5](https://user-images.githubusercontent.com/56026214/209665080-e6f4c0b2-2144-4abf-9cb3-6112817ed441.png)|



시작화면에는 숫자 0과 버튼 2개가 있다.

'+'버튼을 눌렀을 때는 1씩 증가하고 해당 사진에는 5번 클릭을 해서 5로 보인다.

reset 버튼을 누르면 다시 0으로 초기화 된다.

화면을 회전했을 경우 가로로 보였을 때의 화면을 만들어서 화면이 보이도록 하였으며

카운트 횟수는 onSaveInstanceState와 onRestoreInstanceState을 이용하여 값의 저장을 통해 회전을 통해서도 저장되도록 했다.

위의 사진은 5번 카운트하고 회전했을 경우이다. 회전을 했어도 5가 저장되어있는 것을 볼 수 있다.



----



## Project2 기능 - cm와 m 단위 변환기능



값을 넣었을 때 cm와 m의 값 변화 기능을 만들었다.



| 시작화면 | 값 입력 | 체인지 버튼 | 회전했을 경우 |
| :------: | :-----: | :---------: | :-----------: |
| ![1](https://user-images.githubusercontent.com/56026214/209856489-d014e9a8-bb59-422e-88c1-740edf70eadf.png)| ![2](https://user-images.githubusercontent.com/56026214/209856514-ffb9588c-36f5-413e-829e-8de9bb6ff532.png) |    ![3](https://user-images.githubusercontent.com/56026214/209856522-4025a943-951d-49ec-ac6d-eec26ca71976.png)|![4](https://user-images.githubusercontent.com/56026214/209856528-b1c360d4-5b91-46b3-9a72-692d136e1b9f.png)|



처음 시작 했을 경우는 아무 값도 입력이 되어 있지 않아 값이 표현되어 있지 않는다.

EditText에 값을 입력한 경우 해당 단위에 맞게 값이 변경이 된다. 해당 값은 소수점 둘째 자리까지 표현이 가능하게 했다.

또한 변환 옆에 있는 체인지 버튼을 누르면 cm와 m의 단위가 변한다.

화면을 돌려도 해당 값이 변하지 않고 잘 유지되도록 했다.

UI에 경우 app에는 Linearlayout을 사용했기 때문에 가로일 때의 경우 xml 파일을 만들었지만

지금 레이아웃은 ConstraintLayout이므로 상대적인 위치로 배치를 했기 때문에 화면 전환을 해도 UI가 비율에 맞게 배치가 된 것을 볼 수 있다.



---



## Project3 기능 - 개인 정보 저장 기능



개인 정보들을 작성하고 작성한 화면을 보여주며 수정 및 삭제 기능을 추가했다.



| 메인 화면 | 작성 버튼을 누른 후 생년월일 누른 경우 | 혈액형 Spinner 누른 경우 | 저장된 값들 |
| :-------: | :------------------------------------: | :----------------------: | :---------: |
|     ![1](https://user-images.githubusercontent.com/56026214/209856562-4fb4df86-e59b-4551-a356-47eba610bb3e.png)|                          ![2](https://user-images.githubusercontent.com/56026214/209856571-11641aad-6159-40b3-9173-09b3549ea898.png)|         ![3](https://user-images.githubusercontent.com/56026214/209856578-413dabb0-5631-412b-aca8-93718f0d9a25.png)|      ![5](https://user-images.githubusercontent.com/56026214/209856604-ffd4d2fc-ba39-4a28-a5d9-ff4e405c8049.png)|

| 저장 버튼을 누른 경우 | 저장된 핸드폰 번호를 누른 경우 | 초기화 버튼을 누른 경우 |
| :-------------------: | :----------------------------: | :---------------------: |
|         ![6](https://user-images.githubusercontent.com/56026214/209856637-6a54be5d-321a-4804-bbfe-60260164ab29.png)|                 ![7](https://user-images.githubusercontent.com/56026214/209856646-eb3f36e5-0c34-47f3-bc90-a76aa6bd10fc.png)|           ![8](https://user-images.githubusercontent.com/56026214/209856659-c594207d-f9e3-4b9d-b128-0f44b7579b70.png)|



1. 메인 화면 - 아직 작성을 안했기에 이름/생년월일/혈액형/비상 연락처가 미정으로 되어있다. 또한 주의사항도 있는데 초기에는 주의사항이 체크가 안되어 있기 때문에 보이지 않는다.
2.  작성 버튼을 누른 후 생년월일 클릭했을 경우 - DatePickerDialog를 이용하여 캘린더 형식의 다이얼로그를 보여준다.
3. 혈액형 선택 - RadioButton 형식과 Spinner 형식을 통해 혈액형 정보를 선택하도록 했다.
4.  모든 저장된 값 - 주의사항을 체크한 경우 저장된 정보에 주의사항을 표시하도록 하였다. 모든 정보를 입력하고 저장 버튼을 누르면 해당 액티비티가 종료되고 다시 메인 액티비티로 이동한다.
5. 이후 메인 액티비티에 가면 입력한 값들이 저장된 것을 볼 수 있다.
6. 비상 연락처의 이모티콘이나 번호를 클릭하면 해당 번호로 전화 할 수 있는 화면으로 넘어간다.
7. 메인 액티비티 아래에 휴지통 모양을 누르면 모든 정보가 초기화되며 다시 메인화면으로 넘어간다.





----



## Project4 - 계산기 기능 앱



계산기 UI를 보여주고 계산을 하는 기능을 만들었다.

계산기 기능은 +, - 기능만 추가했다.



| 시작 화면 | 덧셈 결과 | 뺄셈 결과 |
| :-------: | :-------: | :-------: |
|    ![1](https://user-images.githubusercontent.com/56026214/209992013-e7b10a6b-81bf-4710-a00b-607423f54811.png)|      ![2](https://user-images.githubusercontent.com/56026214/209992017-c49c07e5-65b9-4c47-bf4e-521e96017fa5.png)|     ![3](https://user-images.githubusercontent.com/56026214/209992023-3f967116-9837-45c5-8cbd-c4199dba643b.png)| 

| 추가 연산 결과 | 다크모드 |  초기화 버튼|
| :------: | :---------: | :------------: |
|  ![4](https://user-images.githubusercontent.com/56026214/209992029-accf5d54-bb6e-40f1-9ee3-95043730ddf6.png)|  ![5](https://user-images.githubusercontent.com/56026214/209992047-0a2f15e1-74cb-44cb-8f4f-6ab3089dd1e0.png)|![6](https://user-images.githubusercontent.com/56026214/209992054-9db43065-b668-41d8-a7cf-88be0f52d99f.png) |



1. 시작화면 - 숫자 버튼과, 연산 버튼, 초기화 버튼, = 버튼을 보여준다. 이 레이아웃은 ContraintLayout에서 Flow를 이용하여 버튼들을 배치하였다.
2. 덧셈 - 덧셈 결과를 했을 때 결과를 보여준다.  결과가 잘 나오는 것을 볼 수 있다.
3. 뺄셈 - 똑같이 뺄셈을 했을 경우에도 잘 보여준다.
4. 추가 연산 결과 - 여기서는 연산을 한번만 사용이 가능하기 때문에 결과값을 그대로 첫 번째 연산에 넣고 싶은 경우 위의 결과값에서 연산 버튼을 누르면 계산 했던 값에서 추가 연산이 가능하도록 하였다.
5. 다크 모드 - 안드로이드 설정에서 다크모드로 바꾸면 보여주는 뷰의 색이 흰색으로 바뀌도록 하였다.
6. 초기화 버튼(C) - 초기화 버튼을 누르면 계산하는 모든 숫자들을 없애고 시작화면과 같이 바뀐다.

---



## Project5 - 스톱워치 기능



타이머 설정하고 스톱워치 기능을 만들었다.

중간에 기록할 수 있게 아래에 측정 값을 적는 기능도 추가했다.



| 시작 화면 | 타이머 설정 | 시작 버튼 | 일시 정지 |
| :-------: | :---------: | :-------: | :-------: |
|      ![1](https://user-images.githubusercontent.com/56026214/210086764-7ff1e3bd-803e-48f1-94df-bbaca0a68149.png)|     ![2](https://user-images.githubusercontent.com/56026214/210086770-77cc82d1-8b40-468d-aa87-422f1d87d898.png)|      ![3](https://user-images.githubusercontent.com/56026214/210086773-ff623cf1-65ac-481c-b896-3b90f487d99c.png)|      ![4](https://user-images.githubusercontent.com/56026214/210086777-c3720a7d-8ae1-4d56-b529-f0b211a1b2d4.png)|



| 다시 시작 | 측정 버튼 | 중지 버튼 | 종료 - 네 |
| :-------: | :-------: | :-------: | :-------: |
|    ![5](https://user-images.githubusercontent.com/56026214/210086800-b919847b-0f98-4061-b6ce-36abc85cd516.png)|     ![6](https://user-images.githubusercontent.com/56026214/210086805-ac50ce3b-5926-4970-8e8a-0882575fe9f9.png)|    ![7](https://user-images.githubusercontent.com/56026214/210086810-ed3c9925-5e16-4991-9b50-80383c59b4b5.png)|      ![8](https://user-images.githubusercontent.com/56026214/210086819-7b046200-c3e7-4628-bfcd-9ea208073fc5.png)|



1. 시작화면 - 타이머 초와 종료버튼, 시작버튼이 보이며 타이머가 보인다.
2. 타이머 설정 - 카운트다운의 숫자를 클릭하면 다이얼로그가 나오면서 0~20초 사이의 값을 지정할 수 있다.
3. 시작 버튼 - 시작 버튼을 누르게 되면 시작화면의 두 버튼이 측정버튼과 일시 정지 버튼으로 바뀌게 된다. 타이머의 시작은 카운트다운이 끝날 때 시작되며 카운트 다운이 작아질 때 마다 프로그래스 바도 맞춰서 줄어든다. 프로그레스 바가 전부 줄어드면 시작한다.
4. 일시정지 - 일시 정지를 누르면 해당 타이머가 멈추며, 중지 버튼과 시작버튼으로 바뀐다.
5. 다시 시작 - 다시 시작버튼을 누르면 일지 정지한 타이머 부터 다시 시작된다.
6. 측정 버튼 - 측정 버튼을 누르게 되면 눌렀을 때의 타이머 시간이 아래에 표시된다. 여러 번 누를 경우 최근에 눌렀던 값이 제일 위에 오게 되며 스크롤뷰를 이용하여 화면이 넘어갈 때 화면을 위 아래로 볼 수 있게 했다.
7. 중지 버튼 - 중지 버튼을 누르면 타이머가 초기화 된다. 바로 초기화를 시키지 않고 다이얼로그를 불러 초기화 여부를 선택할 수 있도록 했다.
8. 종료(네) - 다시 시작화면과 동일한 형태로 바뀐다.

---



## project6 - 단어장 기능



 Room을 이용해 데이터를 CRUD 기능을 추가한 단어장 기능을 만들었다.

RecyclerView를 이용하여 데이터베이스가 가지고 있는 단어들을 보여주도록 만들었다.

ChipGroup을 이용하여 단어 8품사 선택하는 기능을 만들었다.



| 시작 화면 | 플로팅 버튼(+) 눌렀을 경우 | 단어를 1자리또는 비어있는 경우 경고 표시 | 작성 완료 |
| :-------: | :------------------------: | :--------------------------------------: | :-------: |
|   ![1](https://user-images.githubusercontent.com/56026214/210228496-fa3c45b8-7c05-413e-bb5f-10d76c12e1ea.png)|                   ![2](https://user-images.githubusercontent.com/56026214/210228501-bea92ec8-dd47-479d-ab8e-0b0ebbc27c79.png)|                          ![3](https://user-images.githubusercontent.com/56026214/210228507-1ca78c3a-3370-493f-be92-213417ad0404.png)|   ![4](https://user-images.githubusercontent.com/56026214/210228513-4f6ca359-e6da-4c36-9c93-506b093d65d1.png)|



| 추가 버튼 | 해당 단어 클릭 | 삭제 버튼  이미지 | 수정 버튼 이미지 | 수정 완료 버튼 |
| :-------: | :------------: | :---------------: | :--------------: | :------------: |
|     ![5](https://user-images.githubusercontent.com/56026214/210228519-548d95c3-2c92-4643-9314-80d2613e3ebe.png)|           ![6](https://user-images.githubusercontent.com/56026214/210228527-e8f77163-4014-4d37-ba07-fe4383f8e339.png)|        ![7](https://user-images.githubusercontent.com/56026214/210228539-1f362477-305e-479f-becd-019f262042b0.png)|         ![8](https://user-images.githubusercontent.com/56026214/210228545-6188241b-3654-4742-b903-feba3dd65da5.png)|        ![9](https://user-images.githubusercontent.com/56026214/210228552-b18bfa12-b148-4352-a529-3eb096920ce1.png)|



1. 시작 화면 - 데이터베이스에 있는 기존 데이터를 가져와 보여준다(처음 실행  당시 데이터베이스에 저장된 단어들이다.)
2. 플로팅버튼(+) 누른 경우 - 단어와 뜻을 추가하는 화면으로 넘어간다.
3. 단어 경고표시 - 단어를 안적었거나 1자리만 쓴 경우 경고 표시가 나타나도록 했다.
4.  작성 완료 - 작성한 예시를 보여주는 화면
5.  추가 버튼 - 다시 메인 화면으로 넘어가고 맨 위에 작성한 단어와 뜻, 품사를 보여준다.
6.  해당 단어 클릭 - 화면에 있는 단어를 선택하면 맨 위에 선택한 단어를 보여준다.
7. 삭제 버튼 이미지 - 맨 위 오른쪽에 있는 삭제 버튼 이미지를 누르면 단어가 삭제되고, 아래에 있는 단어도 같이 사라진다.
8. 수정 버튼 이미지 - 단어 추가하는 화면과 같은 화면으로 기존에 적혀 있던 단어를 보여주고 단어와 뜻, 품사를 변경 할 수 있게 한다.
9. 수정 완료 버튼 - 변경 전 단어가 사라지며 수정된 단어로 바뀐 것을 볼 수 있다.



---

## project7 - 사진 앨범 기능



GetMultipleContents를 이용하여 이미지파일을 가져와 앱에 저장하는 기능을 만들었다.

GridLayout형식으로 가로 2칸씩 화면에 보이게 했다.

버튼 또는 탭바에 있는 +를 이용하여 사진을 선택할 수 있는 화면으로 넘어갈 수 있도록 했다.

사진을 선택후 다시 선택했을 경우 사진이 추가되도록 하도록 했다.

맨 밑 앨범 버튼을 누르면 새로운 액티비티로 이동하게 되며 앱에 저장한 사진들을 큰 화면으로 하나씩

스와이프를 이용하여 보여주도록 했다.





| 권한 허용 다이얼로그 | 권한 허용 | 시작 화면 | 사진 선택 화면 |
| :------------------: | :-------: | :-------: | :------------: |
|            ![2](https://user-images.githubusercontent.com/56026214/211790551-7c498019-2195-44e5-a11b-e4d255e4185a.jpg)|      ![3](https://user-images.githubusercontent.com/56026214/211790568-359b5c4d-84dc-4e32-9916-6713c3967f51.jpg)|   ![1](https://user-images.githubusercontent.com/56026214/211790590-2cc1e876-d624-4ffb-a42a-c02f8729a3bf.jpg)|![4](https://user-images.githubusercontent.com/56026214/211790627-93ce5225-9001-44c7-b723-be89a728b3db.jpg)|

| 사진 선택(다중) | 화면  사진 선택(한 개) | 나만의 앨범 버튼 | 탭바 뒤로가기 버튼 |
| :-------------: | :--------------------: | :--------------: | :----------------: |
|![5](https://user-images.githubusercontent.com/56026214/211790659-77254056-47b4-4fed-904a-bc8a1a03f59e.jpg)|           ![6](https://user-images.githubusercontent.com/56026214/211790668-c87bff9a-5cf6-40e2-a0d7-b6b078bd4012.jpg)|          ![7](https://user-images.githubusercontent.com/56026214/211790694-57cc9f94-a58b-47af-bad1-c18d4e445a83.jpg)|     ![6](https://user-images.githubusercontent.com/56026214/211790717-3ee23856-6672-4c6f-a833-074aa197f125.jpg)|



1. 갤러리나 핸드폰 파일이 동시 권한 설정을 통해 이동을 해야하기 때문에 권한 설정 다이얼로그를 이용하여 설정 여부를 보여주고 이후 권한 허용 다이얼로그가 나오게 만들었다.
2. 시작화면에는 두 버튼과 탭바에 있는 + 버튼이 있다. 이미지 가져오기 버튼이나 + 버튼을 누르게 된다면 이미지가 있는 파일로 이동하게 된다.
3. 사진 선택 화면으로 이동한다면 사진을 여러 개 또는 한 개의 사진을 선택하여 시작 화면에 보이도록 하였다.
4. 다시 추가하는 경우 사진이 뒤에 추가가 되도록 만들었다.
5. 나만의 앨범 버튼을 누르면 시작 화면에 있는 사진들을 사진 한장 전체를 보여주며 스와이프를 이용하여 볼 수 있도록 하였다. 아래에는 탭바기능을 이용하여 사진의 개수와 현재 사진 위치를 보여주도록 했다.
6. 탭바에 있는 뒤로가기 버튼을 누르게 되면 다시 시작화면으로 돌아가게 된다. 







----

## Project8 - 음원 재생 기능



버튼을 누르면 음원 재생, 정지, 멈춤 3가지 기능을 사용하고

해당 음악을 백그라운드에서도 이용할 수 있게 Service를 이용하여 구현하였다.





| 시작 화면 | 화면을 나갔을 경우(백그라운드) | notification |
| :-------: | :----------------------------: | :----------: |
|   ![1](https://user-images.githubusercontent.com/56026214/212126393-63ff8c46-fea7-4a21-9126-a67e33e7061d.png)|               ![2](https://user-images.githubusercontent.com/56026214/212126405-1f4c81ba-51a1-44be-9d5d-2abc797506bf.png)|         ![3](https://user-images.githubusercontent.com/56026214/212126431-b71e2aa6-9606-4f55-ad27-9588c67dadc5.png)|



시작화면에는 가운데에 3개의 버튼이 있다. 일시정지, 플레이, 노래 종료 버튼이 있다. 이는 MediaPlayer를 이용해서 raw파일에 있는 음원을 실행하도록 했다. 일시정지는 노래를 멈추며 다시 시작 버튼을 누르면 멈춘 부분에서 다시 노래가 시작된다. 노래 종료버튼을 누르고 다시 시작 버튼을 누르게 되면 처음부터 시작된다.



노래 시작하면  알림창에 별표 모양이 생긴다. 이후 앱에 나가게 되더라도 노래가 멈추지 않고 실행된다.

알림창을 보면 음원이 재생 중입니다와 아래에는 시작 화면에 있는 3개의 버튼이 있다. notification에 있는 3개의 버튼을 누른 경우에도 시작화면에 있는 버튼과 같은 기능을 하게 된다.

