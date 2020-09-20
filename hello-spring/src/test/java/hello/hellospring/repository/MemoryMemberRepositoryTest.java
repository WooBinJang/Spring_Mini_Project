package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

     @AfterEach // 한번 테스트를 할 때마다 실행
     public void afterEarch(){
         repository.clearStore();
     } // 테스트는 순서에 상관없이 테스트해야함 이러므로 테스트를 한번 할때마다 데이터를 클리어를 해주기위한 메서드

     @Test
     public  void save() {
         Member member = new Member();
         member.setName("spring");

         repository.save(member);

         Member result = repository.findById(member.getId()).get();
         // System.out.println("result = " + (result==member) );
         // Assertions.assertEquals(member,result);
         assertThat(member).isEqualTo(result);

     }

     @Test
    public void findByName(){
         Member member1 =new Member();
         member1.setName("spring1");
         repository.save(member1);

         Member member2 =new Member(); // shift +F6 변수이름 한번에 바꾸기
         member2.setName("spring2");
         repository.save(member2);

         Member result = repository.findByName("spring1").get();

         assertThat(result).isEqualTo(member1);
     }

     @Test
    public void  findAll() {
         Member member1 =new Member();
         member1.setName("spring1");
         repository.save(member1);

         Member member2 =new Member(); // shift +F6 변수이름 한번에 바꾸기
         member2.setName("spring2");
         repository.save(member2);

         List<Member> result = repository.findAll();

         assertThat(result.size()).isEqualTo(2);
     }

}
