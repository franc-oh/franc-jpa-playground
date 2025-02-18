package com.franc.domain.account.controller;

import com.franc.domain.account.service.AccountService;
import com.franc.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;


    /**
     * 사용자 목록 조회
     * @param page
     * @param size
     * @return AccountListDTO.Response
     * @throws Exception
     */
    @GetMapping("/list")
    public ApiResponse<?> getAccountsPaging(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) throws Exception {

        return ApiResponse.ok(accountService.getAccounts(page, size));
    }

}
