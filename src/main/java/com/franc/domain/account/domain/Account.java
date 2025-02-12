package com.franc.domain.account.domain;

import com.franc.domain.account.domain.code.Status;
import com.franc.domain.account.domain.code.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 회원 Entity
 */

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId; // 회원ID

    @Column(nullable = false, length = 100)
    private String name; // 회원이름

    @Convert(converter = StatusConverter.class)
    @Column(nullable = false)
    private Status status; // 상태

    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @Column(nullable = false)
    private Boolean vipYn;

    @Column(nullable = false, updatable = false)
    private LocalDateTime insertAt;


    // 새 레코드가 삽입되기 전, 자동으로 시간 맵핑
    @PrePersist
    protected void onCreate() {
        this.insertAt = LocalDateTime.now();
    }
}
