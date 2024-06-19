package com.example.monolithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MathController {

    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a + b);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addPost(@RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(body.get("a") + body.get("b"));
    }

    @GetMapping("/subtract")
    public ResponseEntity<Integer> subtract(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a - b);
    }

    @PostMapping("/subtract")
    public ResponseEntity<Integer> subtractPost(@RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(body.get("a") - body.get("b"));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Integer> multiply(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a * b);
    }

    @PostMapping("/multiply")
    public ResponseEntity<Integer> multiplyPost(@RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(body.get("a") * body.get("b"));
    }

    @GetMapping("/divide")
    public ResponseEntity<Integer> divide(@RequestParam int a, @RequestParam int b) {
        if (b == 0) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(a / b);
    }

    @PostMapping("/divide")
    public ResponseEntity<Integer> dividePost(@RequestBody Map<String, Integer> body) {
        if (body.get("b") == 0) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(body.get("a") / body.get("b"));
    }

    @GetMapping("/exponentiate")
    public ResponseEntity<Integer> exponentiate(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok((int) Math.pow(a, b));
    }

    @PostMapping("/exponentiate")
    public ResponseEntity<Integer> exponentiatePost(@RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok((int) Math.pow(body.get("a"), body.get("b")));
    }
}
