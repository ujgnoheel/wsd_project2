# WSD Project 2 - RESTful API 구현

## 프로젝트 개요
Spring Boot를 이용하여 사용자(User)와 상품(Item)을 관리하는 RESTful API 서버를 구현한 프로젝트입니다.  
과제 요구사항에 따라 미들웨어(필터), HTTP 상태 코드 처리, JSON 기반 테스트를 포함합니다.


## 기술 스택
- Java 21
- Spring Boot 4.0.0
- Spring Web MVC
- Spring Data JPA
- H2 Database (In-memory)
- Gradle
- IntelliJ HTTP Client (api.http)

--- 

## 미들웨어 (LoggingFilter)
요청(Request)과 응답(Response)의 정보를 출력하는 필터를 구현하였습니다.

### 기능
- HTTP Method 출력
- 요청 URI 출력
- 응답 Status Code 출력


### 예시 로그
===== [Middleware] Request =====
Method : POST
URI : /api/v1/items
===== [Middleware] Response =====
Status : 201

---

## API 목록

### POST
#### 1. 상품 생성
POST /api/v1/items

#### 2. 사용자 등록 
POST /api/v1/users


### GET
#### 3. 전체 상품 조회
GET /api/v1/items

#### 4. 특정 사용자 조회
GET /api/v1/users/{id}


### PUT
#### 5. 상품 수정
PUT /api/v1/items/{id}

#### 6. 사용자 이름 변경
PUT /api/v1/users/{id}/name


### DELETE
#### 7. 상품 삭제
DELETE /api/v1/items/{id}

#### 8. 사용자 탈퇴
DELETE /api/v1/users/{id}
→ 실제 삭제가 아닌 `deleted = true` 처리

----

## 테스트 방법

IntelliJ의 `api.http` 파일에서 각 API를 실행하여 테스트합니다.

예시:

### 상품 생성 (201)
POST http://localhost:8080/api/v1/items
Content-Type: application/json

{
  "name": "웹서비스 설계",
  "price": 15000
}

### 잘못된 요청 (400)
POST http://localhost:8080/api/v1/items
Content-Type: application/json

{
  "price": 1000
}

### 없는 데이터 조회 (404)
GET http://localhost:8080/api/v1/items/999

---

## 서버 확인
http://localhost:8080

