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
