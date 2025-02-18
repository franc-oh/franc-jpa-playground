package com.franc.domain.account.service;

import com.franc.domain.account.dto.AccountListDTO;
import com.franc.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * 사용자 목록 조회
     * @param page (페이지 No)
     * @param size (페이지에 노출될 건수)
     * @return AccountListDTO.Response
     * @throws Exception
     */
    public AccountListDTO.Response getAccounts(int page, int size) throws Exception {
        Sort sort = Sort.by(
                Sort.Order.desc("accountId"));

        Pageable paging = PageRequest.of(page, size, sort);

        return AccountListDTO.Response.getListFromEntityList(
                    accountRepository.findAll(paging).getContent());
    }
}
