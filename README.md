# Kotlin 안드로이드 실습

1. Do it 깡샘의 안드로이드 앱 프로그래밍 with 코틀린 개정 Android12 적용 
2. Project : 안드로이드여러 기능을 활용한 프로젝트들 (with Kotlin)

---

# CafeApp

### 사용 기능
+ 바텀 내비게이션(+ Jetpack Navigation)
  + 바텀 내비게이션을 이용해 2개의 버튼을 구현(홈, 오더 화면)
  + 홈 화면에는 사용자 이름, 추천 메뉴, 별점 등이 있으며 별점 점수의 프로그래스 바를 ValueAnimator를 이용하여 애니메이션 기능을 구현했다.
  + 오더 화면에서는 앱바 레이아웃이 줄어들 때 타이틀 이름과 search 아이콘을 이동하는 MotionLayout을 이용하여 애니메이션 기능을 구현했다.
  + 오더 화면 레이아웃에는 리스트 어댑터를 이용하여 메뉴 화면을 구성했다.
+ 모션 레이아웃 사용
+ 리스트 어댑터 이용

### 기능 정리
노션  : https://www.notion.so/69df340e9d494bf1ab028c9ec719b0e4?pvs=4


__실형 결과__

https://github.com/Yoon-Chan/Kotlin_Android/assets/56026214/38bdf4a5-0a45-4a49-9720-05e8c2eb73ec

---

# Todo 앱
+ Room을 이용하여 할 일을 생성, 수정, 삭제, 업데이트 기능을 하도록 구현했습니다.
+ 체크 클릭시 완료 표시, 플로팅 버튼 클릭 시 할 일 생서 화현으로 이동
+ 일정 클릭시 일정 수정 화면으로 이동
+ 일정을 길게 누르면 삭제하도록 구현

### 사용 기능
+ Room
+ Flow
+ Hilt
+ MVVM 패턴

### 기능 정리
노션  : https://www.notion.so/Room-Todo-7183f5d7656847e7b2b52930b2614d6d


__실행 결과__

https://github.com/Yoon-Chan/Kotlin_Android/assets/56026214/a83db498-47fe-427d-bb10-93e4063fba9a

---

# 얼굴 인식 기능 구현
+ ml-kit을 이용하여 얼굴 인식하기
+ camerax 라이브러리를 이용하여 카메라 기능 사용
+ 각 상황에 맞는 얼굴 인식 성공하기

### 사용 기술
+ Modlue
+ ml-kit 얼굴 인식 라이브러리
+ cameraX 라이브러리
+ CustomView

### 기능 정리
+ 노션 : https://www.notion.so/265c0d728f564113983fae6f9663ac18

__실행 결과__

https://github.com/Yoon-Chan/Kotlin_Android/assets/56026214/715b67b1-6079-48b1-86fa-404324c7c342

