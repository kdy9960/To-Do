# To Do 앱 </span>

### 1. 앱 설명
이 프로젝트는 사용자가 할 일을 생성, 조회, 수정 및 삭제할 수 있는 Todo 관리 애플리케이션입니다. Spring Boot 프레임워크를 기반으로 개발되었으며, RESTful API를 통해 클라이언트와 상호 작용합니다.


##### 애플리케이션 기능
- 할 일 생성     : 새로운 할 일을 추가
- 할 일 전체 조회: 할 일 목록 전체를 조회
- 할 일 단일 조회: 할 일 목록중 특정 할 일의 상세 정보를 조회
- 할 일 내용 수정: 작성된 할 일의 내용을 수정
- 할 일 상태 변경: 작성된 할 일의 상태롤 '완료' 혹은 '미완료'로 변경
- 할 일 삭제    : 작성된 할 일을 삭제

### 2.소스 빌드 및 실행 방법

##### 2-1. 필수 소프트웨어 설치:
- Java Development Kit (JDK) 17: 프로젝트는 Java 17을 기반으로 개발되었습니다. JDK 17이 설치되어 있는지 확인하세요.
- Gradle: 프로젝트 빌드 도구로 Gradle을 사용합니다. Gradle이 설치되어 있는지 확인하세요.
- MySQL 데이터베이스: 프로젝트는 MySQL을 데이터베이스로 사용합니다. MySQL 서버가 설치되어 있고 실행 중인지 확인하세요.

##### 2-2. 프로젝트 클론 및 디렉토리 이동:

- GitHub 저장소에서 프로젝트를 클론합니다:
  - ```bash
    git clone https://github.com/kdy9960/To-Do.git
    ``

- 프로젝트 디렉토리로 이동합니다:
  - ```bash
    cd To-Do
    ``
##### 2-3.환경 변수 설정:
- ```application-local.yml``` 파일에서 데이터베이스 연결 정보를 환경 변수로 설정하였습니다:

  ```yaml
  spring:
    datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: ${LOCAL_DB_URL}
      username: ${LOCAL_DB_USER}
      password: ${LOCAL_DB_PASSWORD}

- 시스템 환경 변수에 아래와 같이 설정합니다:
  - ```LOCAL_DB_URL```: 예시) jdbc:mysql://localhost:3306/your_database_name
  - ```LOCAL_DB_USER```: 예시) your_username
  - ```LOCAL_DB_PASSWORD```: 예시) your_password
- 환경 변수를 설정하는 방법은 운영체제에 따라 다르며, 아래 링크를 참고하여 설정하시기 바랍니다:
  - Windows: 환경 변수 설정 방법
  - macOS/Linux: 터미널에서 export 명령어를 사용하여 설정
 

##### 2-4. 의존성 설치 및 빌드:
- 프로젝트의 의존성을 설치하고 빌드합니다:
bash```./gradlew build```
- 빌드가 성공하면 ```build/libs/``` 디렉토리에 ```.jar``` 파일이 생성됩니다.

##### 2-5. 애플리케이션 실행:
- 생성된 .jar 파일을 실행합니다:
  - bash```java -jar build/libs/your_project_name-0.0.1-SNAPSHOT.jar```
- 애플리케이션이 성공적으로 시작되면, 기본적으로 http://localhost:8080에서 접근할 수 있습니다.


### 3. 사용한 주요 라이브러리 및 사용 이유
- Spring Boot: 애플리케이션의 빠른 개발과 배포를 위해 사용하였습니다. 내장된 서버와 다양한 스타터를 통해 생산성을 높였습니다.
- Spring Data JPA: 데이터베이스와의 상호 작용을 간편하게 처리하기 위해 사용하였습니다. 객체 지향적인 방식으로 데이터베이스 작업을 수행할 수 있습니다.
- Thymeleaf: 서버 사이드 템플릿 엔진으로, 동적인 HTML 페이지를 생성하기 위해 사용하였습니다. Spring MVC와의 자연스러운 통합이 장점입니다.
- Lombok: 반복적인 코드 작성을 줄이기 위해 사용하였습니다. 어노테이션을 통해 getter, setter, 생성자 등을 자동으로 생성합니다.
- MySQL Connector/J: MySQL 데이터베이스와의 연결을 위해 사용하였습니다.
- Spring Security Test: 보안 관련 테스트를 지원하기 위해 사용하였습니다.

### 4. API 명세
- 애플리케이션이 실행 중일 때, 웹 브라우저에서 http://localhost:8080/swagger-ui.html에 접속하여 API 문서를 확인하세요.






