package spring.edd.domain;

public class Member {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    db가 자동적으로 생성해주는걸 identity
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
