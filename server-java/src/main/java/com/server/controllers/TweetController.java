package com.server.controllers;

import com.server.services.TweetService;
import com.server.dto.NegativeReasonCountDTO;
import com.server.dto.NegativeReasonDTO;
import com.server.dto.SentimentStatsDTO;
import com.server.dto.TweetAirlineDTO;
import com.server.dto.TweetDTO;
import com.server.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/tweet")
    public ResponseEntity<List<TweetDTO>> getAllTweets() {
        List<TweetDTO> tweets = tweetService.getAllTweets();
        if (tweets.isEmpty()) {
            throw new ResourceNotFoundException("No tweets found");
        }
        return ResponseEntity.ok(tweets);
    }

    @GetMapping("/tweetSentiment")
    public ResponseEntity<List<SentimentStatsDTO>> getSentimentStats() {
        List<SentimentStatsDTO> stats = tweetService.getSentimentStats();
        if (stats.isEmpty()) {
            throw new ResourceNotFoundException("No sentiment statistics found");
        }
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/tweetNegativeReason")
    public ResponseEntity<List<NegativeReasonCountDTO>> getAllNegativeReasons() {
        List<NegativeReasonCountDTO> count = tweetService.getAllNegativeReasons();
        if (count.isEmpty()) {
            throw new ResourceNotFoundException("No negative reasons found.");
        }
        return ResponseEntity.ok(count);
    }

    @GetMapping("/tweetReason")
    public ResponseEntity<List<NegativeReasonDTO>> getDistinctNegativeReasons() {
        List<NegativeReasonDTO> reasons = tweetService.getDistinctNegativeReasons();
        if (reasons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(List.of(new NegativeReasonDTO("No negative reasons found")));
        }
        return ResponseEntity.ok(reasons);
    }

    @GetMapping("/tweetAirline")
    public ResponseEntity<List<String>> getDistinctAirline() {
        List<String> airlines = tweetService.getDistinctAirline().stream()
                .map(TweetAirlineDTO::getAirline) // Преобразуем DTO обратно в строку
                .collect(Collectors.toList());

        if (airlines.isEmpty()) {
            throw new ResourceNotFoundException("No airlines found");
        }

        return ResponseEntity.ok(airlines);
    }
}
