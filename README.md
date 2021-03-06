# 북마크SE
>[제작기간] 8주     
>[프로젝트 내용] 카테고리별 북마크 관리하는 안드로이드 앱   
>[프로젝트 인원] 1명    
>
* * *
### SKILL
  >  * Android : Java, MVVM Pattern, Retrofit2, Google/Facebook API, Firebase fcm, Room   
  >  * Server : Ubuntu 18.04(IWinV), Apache 2.4.29, PHP 7.2.25, MariaDB 10.1.44, JWT  
  >  * Retrofit2을 활용한 회원유저의 회원가입, 로그인, 북마크 CRUD
  >  * Firebase FCM을 활용한 push notification (업데이트 안내) 
  >  * Drag & Drop으로 북마크와 카테고리 순서 변경
  >  * JWT 인증을 통한 회원가입, 로그인 
  >  * MariaDB 를 활용한 회원 테이블 
  >  * JSON + PHP + HTTP를 활용한 북마크 관리 REST API 
* * *
### 클래스 및 기능 설명
  > #### 메인 페이지
  > <img src="./GithubImage/screenshot/Screenshot_home.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_darkTheme_1.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_darkTheme_2.jpg" width="30%" height="25%"></img>  
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_main.png"></img>
  >
  >  * home 프래그먼트 에서 bookmark 및 category 아이템 Recycler View 구현
  >  * Navigation View와 메뉴 
  >  * push 알림 및 다크테마 스위치
  >  * home 프래그먼트와 Navigation View 에 각각 viewModel 생성하고 분리하여 MVVM 패턴 적용   
* * *
  > #### 아이템 추가,편집 팝업
  > <img src="./GithubImage/screenshot/Screenshot_popup1.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_popup2.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_popup3.jpg" width="30%" height="25%"></img>  
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_popup.png"></img>
  >
  >  * category, bookmark 아이템 로컬데이터베이스(게스트), 원격데이터베이스(회원)에 각각 생성
  >  * 아이템 수정, 삭제
  >  * 북마크 공유기능 
  >  * 프래그먼트(view)와 viewModel클래스로 구분하여 MVVM 패턴 적용  
* * *
  > #### 아이템 포지션 편집 페이지 (Drag & Drop)
  > <img src="./GithubImage/screenshot/Screenshot_editPosition1.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_editPosition2.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_editPosition3.jpg" width="30%" height="25%"></img>  
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_itemtouch.png"></img>
  >
  >  * 프래그먼트에서 bookmark 및 category 아이템 Recycler View 구현
  >  * 각 아이템 Drag & Drop 으로 포지션 편집  
  >  * 프래그먼트(view)와 viewModel클래스로 구분하여 MVVM 패턴 적용  
* * *
  > #### 웹뷰 페이지 + 북마크 추가 팝업
  > <img src="./GithubImage/screenshot/Screenshot_webview.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_webview_shared.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_webview_editbookmark.jpg" width="30%" height="25%"></img>  
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_webview.png"></img>
  >
  >  * url 검색 기능 
  >  * web-view로 인터넷 페이지 확인 
  >  * bookmark 추가 팝업으로 북마크 저장 
  >  * url 공유 기능 
* * *
  > #### 푸쉬알림 페이지 
  > <img src="./GithubImage/screenshot/Screenshot_notice1.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_notice2.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_notice3.jpg" width="30%" height="25%"></img>  
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_notice.png"></img>
  >
  >  * 프래그먼트에서 Notice  Recycler View 구현 
  >  * Notice 객체 추가,수정,삭제
  >  * Firebase fcm 으로 푸쉬알림
  >  * 프래그먼트(view)와 viewModel클래스로 구분하여 MVVM 패턴 적용
* * *
  > #### 정보, 로그인 페이지 
  > <img src="./GithubImage/screenshot/Screenshot_information.jpg" width="30%" height="25%"></img>
  > <img src="./GithubImage/screenshot/Screenshot_login.jpg" width="30%" height="25%"></img>
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_information.png"></img>
  > <img src="./GithubImage/class/BookmarkSE_login.png"></img>
  >
  >  * 개인정보 처리방침, 오픈소스 라이센스 안내문
  >  * 구글, 페이스북 로그인 구현 
  >  * Retrofit 과 jwt 인증을 통한 회원가입, 로그인 구현   
* * *
  > #### util 패키지 
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_util.png"></img> 
* * *
  > #### data 패키지 
  > ##### 클래스
  > <img src="./GithubImage/class/BookmarkSE_data.png"></img>
* * *                    
