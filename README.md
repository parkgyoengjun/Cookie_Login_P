redirect(요청 종료) 쓰는 이유
1. 새로고침 문제 방지( Post-Redirect-Get PRG 패턴)
    - 로그인 같은 경우 중복로그인 문제가 발생할 수 있음
2. URL 정합성
    - 주소창이 이상해짐
3. 쿠키/세션 반영

redirect 쓰는 방법
질문	                         방법
화면에 잠깐 보여줄 메시지?	     RedirectAttributes
로그인 상태?	                 Cookie / Session
화면 렌더링용 데이터?	         Model
새로고침 시 유지되면 안 됨?	     Redirect + Flash


GET/POST

GET
   - 조회

POST
   - 처리

여기서 POST 는 정보를 처리하는건데 예를 들어서 새로고침( 마지막 행동 다시하는것)을 하면 이중으로 사용되서 
결제나 회원가입 같은 경우 이중으로 되서 실무에서 큰 문제를 일으킬수 있음

그래서 POST 같은 경우 redirect 로 중간 방지턱을 만드는 행위 인거 같다.
redirect 는 GET 의 역할을 하는것 

POST 로 정보 처리 후 redirect 로 페이지이동?(get과 같이 조회)를 하면 새로고침을 해도 정보 처리가 두번 일어나지 않는다.
즉, redirect 는 POST 의 정보 처리가 끝났음을 알리는것.
