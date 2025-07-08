package com.app;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email/generate")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    // ✅ POST API — used by frontend body JSON
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }

    // ✅ GET API — used via URL parameters
    @GetMapping
    public ResponseEntity<String> generateEmailViaGet(
            @RequestParam("emailContent") String emailContent,
            @RequestParam(value = "tone", required = false) String tone) {

        EmailRequest emailRequest = new EmailRequest(emailContent, tone);
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
