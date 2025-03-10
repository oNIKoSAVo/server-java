package com.server.services;

import com.server.dto.AirlineDTO;
import com.server.dto.NegativeReasonCountDTO;
import com.server.dto.NegativeReasonDTO;
import com.server.dto.SentimentStatsDTO;
import com.server.dto.TweetAirlineDTO;
import com.server.dto.TweetDTO;
import com.server.repositories.TweetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<TweetDTO> getAllTweets() {
        return tweetRepository.findAllTweets();
    }

    public List<SentimentStatsDTO> getSentimentStats() {
        return tweetRepository.findSentimentStats();
    }

    public List<NegativeReasonCountDTO> getAllNegativeReasons() {
        return tweetRepository.findAllNegativeReasons();
    }

    public List<NegativeReasonDTO> getDistinctNegativeReasons() {
        List<NegativeReasonDTO> reasons = tweetRepository.findDistinctNegativeReasons();
        return reasons.isEmpty() ? List.of(new NegativeReasonDTO("No data available")) : reasons;
    }

    public List<TweetAirlineDTO> getDistinctAirline() {
        List<AirlineDTO> airlines = tweetRepository.findDistinctAirline();
        return airlines.stream()
                .map(airlineDTO -> new TweetAirlineDTO(airlineDTO.getAirline())) // Берем строку из объекта
                .collect(Collectors.toList());
    }
}
