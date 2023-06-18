package com.aeontanvir.propertymanagementsystem.services;

import com.aeontanvir.propertymanagementsystem.dtos.MessageDto;
import com.aeontanvir.propertymanagementsystem.dtos.PropertyDto;

import java.util.List;

public interface MessageService {
    public List<MessageDto> getAll();
    public MessageDto getById(Long id);
    public MessageDto create(MessageDto messageDto);
    public MessageDto replace(Long id, MessageDto messageDto);
    public MessageDto update(Long id, MessageDto messageDto);
    public void removeById(Long id);
}
