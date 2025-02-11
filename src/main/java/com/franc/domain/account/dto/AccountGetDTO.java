package com.franc.domain.account.dto;

import com.franc.domain.account.domain.Account;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO - 사용자조회
 */
public record AccountGetDTO() {

    /**
     * 응답문
     * @param accountId
     * @param name
     * @param status
     * @param email
     * @param vipYn
     * @param joinAt
     */
    public record Response(Long accountId,
                           String name,
                           String status,
                           String email,
                           Boolean vipYn,
                           LocalDateTime joinAt) {

        // VO -> DTO
        public static AccountGetDTO.Response fromEntity(Account account) {
            if(Objects.isNull(account) || Objects.isNull(account.getAccountId())) return null;

            return new AccountGetDTO.Response(
                    account.getAccountId(),
                    account.getName(),
                    account.getStatus(),
                    account.getEmail(),
                    account.getVipYn(),
                    account.getInsertAt()
            );
        }

    }
}