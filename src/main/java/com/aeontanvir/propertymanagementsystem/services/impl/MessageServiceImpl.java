package com.aeontanvir.propertymanagementsystem.services.impl;

import com.aeontanvir.propertymanagementsystem.domains.Message;
import com.aeontanvir.propertymanagementsystem.domains.Property;
import com.aeontanvir.propertymanagementsystem.domains.User;
import com.aeontanvir.propertymanagementsystem.dtos.MessageDto;
import com.aeontanvir.propertymanagementsystem.exceptions.ResourceNotFoundException;
import com.aeontanvir.propertymanagementsystem.helpers.ModelMapperHelper;
import com.aeontanvir.propertymanagementsystem.repositories.MessageRepository;
import com.aeontanvir.propertymanagementsystem.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapperHelper modelMapperHelper;
    @Override
    public List<MessageDto> getAll() {
        List<Message> messages = messageRepository.findAll();
        return modelMapperHelper.convertToDtoList(messages, MessageDto.class);
    }

    @Override
    public MessageDto getById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        return modelMapperHelper.convertToDto(message, MessageDto.class);
    }

    @Override
    public MessageDto create(MessageDto messageDto) {
        Message message = modelMapperHelper.convertToEntity(messageDto, Message.class);
        Message savedMessage = messageRepository.save(message);
        return modelMapperHelper.convertToDto(savedMessage, MessageDto.class);
    }

    @Override
    public MessageDto replace(Long id, MessageDto messageDto) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        messageDto.setId(existingMessage.getId());
        Message newMessage = modelMapperHelper.convertToEntity(messageDto, Message.class);
        Message updatedMessage = messageRepository.save(newMessage);
        return modelMapperHelper.convertToDto(updatedMessage, MessageDto.class);
    }

    @Override
    public MessageDto update(Long id, MessageDto messageDto) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));

        if (messageDto.getMessage() != null) {
            existingMessage.setMessage(messageDto.getMessage());
        }

        Message updatedMessage = messageRepository.save(existingMessage);
        return modelMapperHelper.convertToDto(updatedMessage, MessageDto.class);
    }


    @Override
    public void removeById(Long id) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));

        messageRepository.delete(existingMessage);
    }
}
