package spring.edd.repository;

import org.springframework.stereotype.Repository;
import spring.edd.domain.Member;

import javax.swing.text.html.Option;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

//    private final EntityManager em;
//    public JpaMemberRepository(EntityManager em) {
//        this.em = em;
//    }
//    스프링은 JPA를 사용하려면 엔티티매니저를 주입 받아야한다.
//    스프링부트는 만들어진걸 인잭션 받아야 한다.

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    //오버라이드 만드는거
    //옵션 + 엔터

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
