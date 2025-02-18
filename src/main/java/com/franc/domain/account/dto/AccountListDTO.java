package com.franc.domain.account.dto;

import com.franc.domain.account.domain.Account;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * DTO - 사용자 목록 조회
 */
public record AccountListDTO() {

    /**
     * 응답문
     * @return accounts
     */
    public record Response(
            List<AccountInfo> accounts
    ) {

        // EntityList -> DTOList
        public static AccountListDTO.Response getListFromEntityList(List<Account> accountList) {
            if (Objects.isNull(accountList) || accountList.isEmpty())
                return new AccountListDTO.Response(Collections.emptyList());

            return new AccountListDTO.Response(
                accountList.stream()
                    .flatMap(account -> fromEntity(account).stream())
                    .toList()
            );
        }

        // Entity -> DTO
        public static Optional<AccountListDTO.AccountInfo> fromEntity(Account account) {
            if(Objects.isNull(account) || Objects.isNull(account.getAccountId())) return Optional.empty();

            return Optional.of(
                    new AccountListDTO.AccountInfo(
                            account.getAccountId(),
                            account.getName(),
                            account.getStatus().getCode(),
                            account.getEmail(),
                            account.getVipYn(),
                            account.getInsertAt()
                    )
            );
        }

    }

    /**
     * Nested Object
     * @param accountId
     * @param name
     * @param status
     * @param email
     * @param vipYn
     * @param joinAt
     */
    public record AccountInfo(
            Long accountId,
            String name,
            Integer status,
            String email,
            Boolean vipYn,
            LocalDateTime joinAt
    ){}
}