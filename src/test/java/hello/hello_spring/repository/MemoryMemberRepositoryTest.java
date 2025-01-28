package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 메서드가 끝날 때 마다 호출
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("종민");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("지혜");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("지혜2");
        repository.save(member2);

        Member result = repository.findByName(member2.getName()).get();
        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findByAll() {
        Member member1= new Member();
        member1.setName("지혜");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("지혜");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
