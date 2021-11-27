# Animalunteer
## Abandoned animal shelter App

### 목적
유기동물을 위한 후원이나 봉사를 하고 싶지만, 어디서 어떻게 해야할지 막막한 사람들을 위해 신뢰성 있는 정보를 제공하는 것

### 앱 사용자 범위
- 전라도 거주자
- 평소 유기동물 봉사나 후원에 관심 있는 사람
- 거주지 근처의 유기동물 보호센터를 찾고자 하는 사람
- 봉사와 후원이 필요해 유기동물 보호센터의 홍보가 필요한 사람


### 1. BottomNavigationView
FrameLayout을 이용해 세 가지 xml 파일이 BottomNavigationView에 따라 전환될 수 있도록 구현


### 2. Map Fragment
GoogleMap API를 사용해 구현
<div>
<img width="200" src="https://user-images.githubusercontent.com/45174177/103396917-32c79a00-4b79-11eb-8266-6a5499da18f6.jpg">
</div>

> 처음 앱 실행 후 Map Fragment가 기본으로 보이고, 마커 클릭 시 말풍선을 보여주고, 
말풍선 클릭시 관련 정보를 Dialog 통해 띄워준다.

<div>
<img width="400" src="https://user-images.githubusercontent.com/45174177/143670537-358682ea-7b20-4034-98f9-a419fe437ed5.png">
</div>
<div>
<img width="400" src="https://user-images.githubusercontent.com/45174177/143670577-f6402b4b-c840-46d3-a711-85d097434584.png">
</div>

### 3. Recruit Fragment
#### 초기화면 / 리스트 작성 화면 / 저장된 리스트 화면 / 리스트 수정화면
> BottomNavigationView에서 '봉사 기록' 버튼 클릭시 나오는 화면으로, 봉사에 대한 간단한 기록을 할 수 있게 구현
> 글을 작성하고 완료시 CardView를 통해 작성한 내용을 보여주고, 수정할 수 있다. 
> 메모 내용은 SQLite를 사용해 저장
<div>
  <img width="200" src="https://user-images.githubusercontent.com/45174177/103396949-4d9a0e80-4b79-11eb-9cf4-cbe80fc115ea.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/45174177/103396962-5c80c100-4b79-11eb-8a9e-2d53a7071e31.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/45174177/103396970-660a2900-4b79-11eb-9999-4b30593dfd8f.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/45174177/103396981-76ba9f00-4b79-11eb-855b-f09bf85844ee.jpg">
</div>

### 4. Information Fragment
> '보호소 정보' 버튼을 클릭시 앱의 목적에 관한 주요 내용들이 나온다.
<div>
<img width="200" src="https://user-images.githubusercontent.com/45174177/103396989-833ef780-4b79-11eb-811b-9bf207178fcd.jpg">
</div>


### 향후 발전 계획
- 서비스 제공하는 지역을 더 확장할 수 있다.
- 보호소에서 인증절차를 거쳐 직접 지도에 등록할 수 있는 기능을 추가할 수 있다.
- 봉사활동에 대해 기록한 내용들을 커뮤니티로 확장시켜 다른사람들과 공유할 수 있다.
- 커뮤니티가 만들어지면 사용자들 사이에 정보 공유가 활성화 되어, 더욱 효율적인 봉사활동이 가능할 수 있다.


### 참고 자료
- https://mailmail.tistory.com/19
- https://wonpaper.tistory.com/250
