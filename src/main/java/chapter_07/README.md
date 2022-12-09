# 객체 분해
- 추상화 : 한번에 다룰 문제의 크기를 줄일 수 있다 
- 큰 문제를 해결 가능한 작은 문제로 나누는 것 -> 분해(decomposition)


- 프로시저 추상화 : 소프트웨어가 무엇을 해야하는지
  - 기능 분해 (알고리즘 분해)
- 데이터 추상화 : 소프트웨어가 무엇을 알아야하는지
  - 데이터를 중심으로 타입을 추상화 (추상 데이터 타입)
  - **데이터를 중심으로 프로시저를 추상화 (객체지향)**


- 객체지향 패러다임
  - 역할과 책임을 수행하는 객체 -> 객체지향 패러다임이 이용하는 추상화
  - 협력하는 공동체를 구성하도록 객체들로 나누는 과정 -> 객체지향 패러다임에서의 분해 


## 하향식(Top-down) 기능 분해 방식 문제점 
- 시스템은 메인함수가 한개가 아님 
- 기능 추가, 요구사항 변경으로 인해 메인 함수를 빈번하게 수정해야 함 
- 비즈니스 로직이 사용자 인터페이스와 강하게 결합 됨 
  - 콘솔 기반의 UI를 유지하면서도, GUI 기반의 UI를 추가할 수 있는가?
  - top-down 방식은 기능을 분해하는 과정에서 UI의 관심사와 비즈니스 로직의 관심사를 동시에 고려하도록 강요한다.
  - 그렇기 때문에, 관심사 분리가 어렵다
- 하향식 분해는 너무 이른 시기에 함수들의 실행 순서를 고정시킨다 -> 유연성, 재사용성 저하
- 데이터 형식이 변경되면 파급효과를 예측할 수 없음 
- 무엇이 아닌 어떻게를 고려하게 된다 
- 중앙 집중 제어 스타일 -> 하지만, 제어 구조는 빈번한 변경의 대상이다.
  - 시간적 제약이 아닌, 논리적 제약 방식을 선택하라 


> 설계는 코드 배치 방법이며, 설계가 필요한 이유는 **변경에 대비하기 위한 것**이다.


## 모듈 
### 정보 은닉과 모듈 
- 함께 변경되는 부분을 하나의 구현 단위로 묶고, 퍼블릭 인터페이스를 통해서만 접근하게 하라 
- 변경에 방향에 맞춰 시스템을 분해하자!

### 모듈이 감춰야 하는 것 
- 복잡성 : 모듈이 너무 복잡하면 이해하고 사용하기가 어렵다. 외부에 모듈을 추상화 할 수 있는 간단한 인터페이스를 제공해서 모듈의 복잡도를 낮추자 
- 변경 가능성 : 변경 가능한 설계 결정이 외부에 노출될 경우, 실제로 변경이 발생했을 때 파급효과가 커진다. 변경 발생 시, 하나의 모듈만 수정하면 되도록 하자
  - 변경 가능한 설계 결정을 모듈 내부로 감춰라
  - 외부에는 쉽게 변경되지 않을 인터페이스를 제공하라 
- 비밀이 반드시 데이터일 필요는 없다
  - 복잡한 로직, 변경 가능성이 큰 자료구조 등일 수도 있다.
- 모듈은 기능이 아니라 변경의 정도에 따라 시스템을 분해하게 함
  - 모듈 내부 : 높은 응집도
  - 모듈 간 : 낮은 결합도


## 추상 데이터 타입 
- 타입 이란,
  - 변수에 저장할 수 있는 내용물의 종류와 변수에 적용될 수 있는 연산의 가짓 수를 의미 