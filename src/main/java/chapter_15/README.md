# 디자인 패턴과 프레임워크 
### 디자인 패턴
- 설계에서 반복적으로 발생하는 문제에 대해 반복적으로 적용할 수 있는 해결 방법 
- 다양한 변경을 다루기 위해 반복적으로 재사용할 수 있는 설계의 묶음
  - 설계를 재사용하는 것이 목적임
- 특정한 변경을 일관성있게 다룰 수 있는 협력 템플릿 제공 
  - 협력을 일관성있게 만들기 위해 재사용할 수 있는 설계의 묶음 


### 프레임워크
- 설계와 코드를 함께 재사용하기 위한 목적임 
- 애플리케이션의 아키텍처를 구현 코드의 형태로 제공 
- 프레임워크는 각 애플리케이션 요구에 따라 적절하게 커스터마이징할 수 있는 확장 포인트를 제공 
- 특정한 변경을 일관성있게 다룰 수 있는 확장 가능한 코드 템플릿 제공 
  - 일관성있는 협력을 제공하는 확장 가능한 코드 


## 디자인 패턴과 설계 재사용 
### 소프트웨어 패턴 
- 패턴은 반복적으로 발생하는 문제와 해법의 쌍으로 저으이된다 
- 패턴을 사용함으로써 이미 알려진 문제와 이에 대한 해법을 문서로 정리할 수 있고, 이 지식을 다른 사람과 의사소통할 수 있다.
- 패턴은 추상적인 원칙과 실제 코드 작성 사이의 간극을 메워주며, 실질적인 코드 작성을 돕는다. 
- 패턴의 요점은 패턴이 실무에서 탄생했다는 점이다. 


### 패턴 분류 
- 아키텍처 패턴 
- 분석 패턴 
- 디자인 패턴 
- 이디엄 


### 패턴과 책임 주도 설계 
- 패턴 : 공통으로 사용할 수 있는 역할, 책임, 협력의 템플릿 
- 반복적으로 발생하는 문제를 해결하기 위해 사용할 수 있는 공통적인 역할과 책임, 협력의 훌륭한 예제를 제공
  - strategy : 다양한 알고리즘을 동적으로 교체할 수 있는 역할과 책임의 집합 제공 
  - bridge : 추상화의 조합으로 인한 클래스의 폭발적인 증가 문제를 해결하기 위해 역할과 책임을 추상화와 구현의 두 개의 커다란 집합으로 분해함으로써 설계를 확장 가능하게 만듬 
  - observer : 유연한 통지 메커니즘을 구축하기 위해 객체 간 결합도를 낮출 수 있는 역할과 책임의 집합 제공 


- 디자인 패턴은 단지 역할과 책임, 협력의 템플릿을 제안할 뿐이다. 구체적인 구현 방법에 대해서는 제한을 두지 않는다. 
- 디자인 패턴이 어떤 변경을 캡슐화 하는지를 이해하는 것이 더 중요하다. 
  - 각 디자인 패턴이 변경을 캡슐화 하기 위해 어떤 방법을 사용하는지를 이해하자 


### 패턴은 출발점이다 
- 패턴은 단지 목표로하는 설계에 이를 수 있는 방향을 제시하는 나침반에 불과하다. 
- 디자인 패턴이 현재의 요구사항이나 적용 기술, 프레임워크에 적합하지 않을 경우 패턴을 그대로 따르지 말고 목적에 맞게 수정하라. 
- 패턴을 적용할 때는 항상 설계를 좀 더 단순하고 명확하게 만들 수 있는 방법이 없는지를 고민하라 


## 프레임워크와 코드 재사용 
- 프레임워크 : 추상 클래스나 인터페이스를 정의하고 인스턴스 사이의 상호작용을 통해 시스템 전체 혹은 일부를 구현해 놓은 재사용 가능한 설계 
  - 또는 애플리케이션 개발자가 현재의 요구사항에 맞게 커스터마이징 할 수 있는 애플리케이션의 골격을 의미 
- 코드를 재사용함으로써 설계 아이디어를 재사용 

### 의존성 역전 원칙 
- 세부 사항 == 변경 

### 제어 역전 원리 
- 상위 정책 재사용 == 협력 관계 재사용 <br/><br/>
- 훌륭한 객체지향 설계 == 의존성이 역전된 설계 <br/><br/>
- 의존성을 역전시키면 제어 흐름의 주체 역시 역전 됨 -> 제어 역전<br/><br/> 
- 프레임워크는 일반적인 해결책만 제공 <br/><br/>
- 애플리케이션에 따라 달라질 수 있는 특정한 동작은 비워둠 
  - 완성되지 않은 채로 남겨진 동작을 "훅"이라고 부름 
  - 훅의 구현 방식은 애플리케이션의 컨텍스트에 따라 달라짐 
  - 훅은 프레임워크 코드에서 호출하는 프레임워크의 특정 부분임 
  - 재정의된 훅은 제어 역전 원리에 따라 프레임워크가 원하는 시점에 호출 됨 <br/><br/>
