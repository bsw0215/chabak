# 차박어때 (ChaBakEoDdae) 웹 애플리케이션

## 프로젝트 개요
**차박어때**는 스프링 프레임워크를 활용하여 구현한 MVC 패턴의 웹 애플리케이션입니다. 이 프로젝트는 차박 장소 정보를 카카오맵 API를 활용하여 시도별로 구분하고, 유저들이 리뷰를 작성할 수 있는 기능을 제공합니다.

## 주요 기능

### 1. 지도 기능
- 카카오맵 API를 이용하여 차박 장소들을 마커로 표시하고, 대한민국 캠핑 지도로 시도별로 구분합니다.
- 각 장소의 마커를 클릭하면 해당 장소의 게시판으로 이동하고, 유저들은 별점 리뷰를 작성할 수 있습니다.
- 장소 정보는 Mysql에 저장되며, 도로명주소 API를 이용하여 주소를 받아 위도 경도로 변환하여 저장합니다.

### 2. 다양한 게시판
- 공지사항, 캠핑장소, 캠핑 팁, 자유게시판 등 다양한 게시판을 카테고리 별로 구분하여 작성할 수 있습니다.
- 각 게시판은 페이징 처리를 하여 한 페이지당 8개의 게시글이 카테고리에 따라 출력됩니다.
- 아래에는 화살표와 최대 10개의 페이지 숫자를 표시하여 페이지를 넘길 수 있도록 구현되었습니다.
- 캠핑장소 게시판에서는 각 장소의 이미지를 저장하여 썸네일로 출력되도록 하였습니다.

### 3. 회원가입 및 로그인
- Spring Security와 thymeleaf를 사용하여 다양한 권한 로직과 회원가입 기능을 구현하였습니다.
- 소셜 로그인 기능으로 네이버, 구글, 카카오 로그인이 가능하며, 자체 사이트 회원가입도 구현되었습니다.
- 회원가입 시 유효성 검사를 통해 필수 조건들을 확인합니다.

### 4. 글쓰기 및 댓글
- 로그인된 사용자에게만 글쓰기 버튼이 표시되며, 글쓴이 칸에는 사용자의 닉네임이 자동으로 적용됩니다.
- Summernote 웹 에디터를 이용하여 글 작성 및 이미지 등록이 가능합니다.
- 댓글은 로그인한 사용자에게만 작성할 수 있으며, 자신이 쓴 글과 댓글은 수정과 삭제가 가능합니다.

### 5. 데이터 처리 및 보안
- Spring Data JPA를 사용하여 데이터 수정, 삭제, 조회, 저장 등의 API 요청을 수행합니다.
- JavaScript에서는 Ajax를 활용하여 서버와 클라이언트 간 데이터 교환 및 조작이 이루어집니다.
- 보안을 위해 Spring Security를 통해 다양한 권한을 부여하고, 관리자 권한이 있는 사용자만 좌표를 입력할 수 있는 페이지에 접근할 수 있도록 제한합니다.

## 환경 및 기술 스택
- **Frontend:** HTML, CSS, JavaScript
- **Backend:** Spring Boot, MySQL, Spring Security, Thymeleaf, Java (version 11), Spring Data JPA, Gradle, Amazon Web Service (AWS)

# Board API

1. **게시글 작성**
   - **Method:** `POST`
   - **Endpoint:** `/api/board`
   - **Data:**
     - title
     - content
     - categoryName 

2. **게시글 삭제**
   - **Method:** `DELETE`
   - **Endpoint:** `/api/board/{id}`

3. **게시글 수정**
   - **Method:** `PUT`
   - **Endpoint:** `/api/board/{id}`
   - **Data:**
     - title
     - content

4. **댓글 저장**
   - **Method:** `POST`
   - **Endpoint:** `/api/board/{boardId}/reply`
   - **Data:**
     - rating
     - userId
     - boardId
     - content

5. **댓글 삭제**
   - **Method:** `DELETE`
   - **Endpoint:** `/api/board/{boardId}/reply/{replyId}`

6. **카테고리 게시글 작성 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/saveForm/{categoryName}`

7. **카테고리 게시글 목록 조회 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/mainMenu/{categoryName}`

8. **게시글 조회 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/board/{id}`

9. **게시글 수정 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/board/{id}/edit`

# Point API

1. **장소 저장**
   - **Method:** `POST`
   - **Endpoint:** `/api/map`
   - **Data:**
     - lat
     - lng
     - address
     - sido

2. **DB에 저장된 장소 보내기**
   - **Method:** `GET`
   - **Endpoint:** `/api/marker`
   - **Data:** `List<PointResponse>`

3. **장소 넣는 페이지 이동**
   - **Method:** `GET`
   - **Endpoint:** `/map`

# User API

1. **아이디 중복 검사**
   - **Method:** `POST`
   - **Endpoint:** `/api/user/usernameRegister`
   - **Data:**
     - username

2. **로그인 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/login`

3. **회원가입 페이지**
   - **Method:** `GET`
   - **Endpoint:** `/join`

4. **회원가입**
   - **Method:** `POST`
   - **Endpoint:** `/joinProc`
   - **Data:**
     - User

# 데이터베이스

![image01](https://github.com/bsw0215/chabak/assets/144658036/26e7533a-7331-4670-a1f0-cedec3728c79)

# 실행화면

- 메인화면: 카카오맵에서 차박 장소들을 마커로 표시하고, 대한민국 캠핑 지도로 시도별로 구분하여 탐색 가능합니다. '자세히'를 클릭하면 해당 장소 페이지로 이동합니다.

![0](https://github.com/bsw0215/chabak/assets/144658036/2c932342-98c3-4917-b83e-fedd3b86ad23)
![1](https://github.com/bsw0215/chabak/assets/144658036/e6b7f64d-038b-461a-9c3f-782f1a038fca)

- 게시판 목록: 상단 메뉴를 클릭하면 카테고리별 게시판 목록이 출력됩니다. 로그인 한 사람만 글쓰기를 할 수 있습니다. 페이징 처리를 하였습니다.

![2](https://github.com/bsw0215/chabak/assets/144658036/e9b5ea11-73fc-434f-8212-edb4288cc183)
![4](https://github.com/bsw0215/chabak/assets/144658036/e5516a95-8b18-4964-950a-f9498583e39c)

- 게시글 출력: 제목, 번호, 작성일, 조회수, 내용, 댓글이 출력됩니다.
![3](https://github.com/bsw0215/chabak/assets/144658036/3a464294-b636-45dc-b0e5-e29d3accded5)

- 게시글 수정
![5](https://github.com/bsw0215/chabak/assets/144658036/163eb91b-a3a8-4871-890c-c00e226fc6cc)

- 장소 게시판: 평점과 후기를 입력할 수 있습니다. 그리고 좌측 상단에 평균 평점이 출력됩니다.
![7](https://github.com/bsw0215/chabak/assets/144658036/70de930f-bcb6-4256-95fb-479d01ba7778)

- 로그인 페이지: 로그인 및 회원가입을 할 수 있습니다.
![8](https://github.com/bsw0215/chabak/assets/144658036/b98b857d-b9a3-4875-9f92-ccb8c65a18c3)




