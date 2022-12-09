package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;

@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSourceAccessor accessor;

    public String get(String code, Object... values) {
        return this.accessor.getMessage(code, values);
    }
}
