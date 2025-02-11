package com.franc.domain.account.dto;

import com.franc.domain.account.domain.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO - 사용자등록
 */
public record AccountSaveDTO() {

    /**
     * Request
     * @param name
     * @param email
     */
    public record Request(
            @NotBlank
            String name,
            @NotBlank @Email
            String email
    ) {

        // DTO -> VO
        public static Account toEntity(AccountSaveDTO.Request dto) {
            return Account.builder()
                    .name(dto.name())
                    .email(dto.email())
                    .build();
        }

    }
}