package spring.edd.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.edd.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member re = repository.findById(member.getId()).get();
        //여기서 get이 옵셔널에서 값을 가져올때 근데 get만 쓰는것 좋은 방법은 아님

        //Assertions.assertThat(member).isEqualTo(re);
        //option + enter
        assertThat(member).isEqualTo(re);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("sp");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("sp");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
