# 책임 주도 설계
- 데이터보다 행동을 먼저 결정
  - 행동은 곧 책임 
  - 데이터는 객체가 책임을 수행하는 데 필요한 재료를 제공할 뿐 
  - 책임은 객체의 입장이 아니라, 객체가 참여하는 **협력에 적합해야**함
- 협력은 메시지 전송자가 시작한다.
  - 협력에 적합한 책임 == 메시지 전송자에게 적합한 책임 
  - 메시지를 전송해야하는데, 누구에게 전송하지?

- 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
- 시스템 책임을 더 작은 책임으로 분할한다.
- 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
- 객체가 책임을 수행하는 도중, 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
- 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.



# GRASP 패턴
- `General Responsibility Assignment Software Pattern`
1. 도메인 개념 정리 (완벽 x. 빠르게 설계와 구현 진행)
2. 정보 전문가에게 책임 할당  
   - 책임을 수행할 정보를 알고있는 객체에게 책임을 할당 -> `INFORMATION EXPERT`패턴
   - 데이터와 정보는 다르니 주의 
3. 높은 응집도 & 낮은 결합도의 설계를 선택하라
    - `HIGH COHESION`
    - `LOW COUPLING`
4. 창조자에게 객체 생성 책임을 할당하라
   - `CREATOR`패턴
   - 객체 A를 생성해야 할 때 어떤 객체에게 생성 책임을 할당할까? 아래 조건을 최대한 많이 만족하는 B에게 할당해야 한다.
     - B가 A객체를 포함하거나 참조한다.
     - B가 A객체를 기록한다.
     - B가 A객체를 긴밀하게 사용한다.
     - B가 A객체를 초기화 하는 데 필요한 데이터를 가지고 있다. (B는 A에 대한 정보 전문가다.)
   - 어떤 방식으로든 생성되는 객체와 연결되거나, 관련될 필요가 있는 객체에 해당 객체를 생성할 책임을 맡기는 것
   - 이미 존재하는 객체 사이의 관계를 이용 -> 낮은 결합도 유지 