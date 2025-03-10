package com.server.repositories;

import com.server.dto.AirlineDTO;
import com.server.dto.NegativeReasonCountDTO;
import com.server.dto.NegativeReasonDTO;
import com.server.dto.SentimentStatsDTO;
import com.server.dto.TweetDTO;
import com.server.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

        // Получение всех твитов
        @Query("SELECT new com.server.dto.TweetDTO(t.text, t.airline, t.airlineSentiment) FROM Tweet t")
        List<TweetDTO> findAllTweets();

        // Статистика по мнению пользователей к авиалиниям
        @Query("SELECT new com.server.dto.SentimentStatsDTO(t.airline, " +
                        "SUM(CASE WHEN t.airlineSentiment = 'negative' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN t.airlineSentiment = 'neutral' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN t.airlineSentiment = 'positive' THEN 1 ELSE 0 END)) " +
                        "FROM Tweet t GROUP BY t.airline")
        List<SentimentStatsDTO> findSentimentStats();

        // Количество негативных признаков
        @Query("SELECT new com.server.dto.NegativeReasonCountDTO(t.airline, t.negativereason, COUNT(t)) " +
                        "FROM Tweet t WHERE t.negativereason IS NOT NULL " +
                        "GROUP BY t.airline, t.negativereason")
        List<NegativeReasonCountDTO> findAllNegativeReasons();

        // Получение списка уникальных негативных признаков
        @Query("SELECT new com.server.dto.NegativeReasonDTO(t.negativereason) FROM Tweet t WHERE t.negativereason IS NOT NULL")
        List<NegativeReasonDTO> findDistinctNegativeReasons();

        // Получение списка авиакомпаний
        @Query("SELECT new com.server.dto.AirlineDTO(t.airline) FROM Tweet t GROUP BY t.airline")
        List<AirlineDTO> findDistinctAirline();
}
