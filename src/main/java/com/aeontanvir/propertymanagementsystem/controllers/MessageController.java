package com.aeontanvir.propertymanagementsystem.controllers;


import com.aeontanvir.propertymanagementsystem.apiresponse.ApiResponse;
import com.aeontanvir.propertymanagementsystem.dtos.MessageDto;
import com.aeontanvir.propertymanagementsystem.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<MessageDto>>> getAll() {
        List<MessageDto> messages = messageService.getAll();
        return ResponseEntity.ok(ApiResponse.success("Message retrieved successfully.", messages));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MessageDto>> geById(@PathVariable Long id) {
        MessageDto message = messageService.getById(id);
        return ResponseEntity.ok(ApiResponse.success("Message retrieved successfully.", message));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MessageDto>> create(@RequestBody MessageDto messageDto) {
        MessageDto createdMessage = messageService.create(messageDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Message created successfully.", createdMessage));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<MessageDto>> update(@PathVariable Long id,
            @RequestBody MessageDto messageDto) {
        MessageDto updatedMessage = messageService.update(id, messageDto);
        return ResponseEntity.ok(ApiResponse.success("Message updated successfully.", updatedMessage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MessageDto>> replace(@PathVariable Long id,
            @RequestBody MessageDto messageDto) {
        MessageDto updatedMessage = messageService.replace(id, messageDto);
        return ResponseEntity.ok(ApiResponse.success("Message updated successfully.", updatedMessage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        messageService.removeById(id);
        return ResponseEntity.ok(ApiResponse.success("Message deleted successfully.", null));
    }

}
