//package com.example.Journal.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class SentimentConsumerService {
//    @Autowired
//    private MailService emailService;
//
//    @KafkaListener(topics = "weekly-sentiments", groupId = "weekly-sentiment-group")
//    public void consume(SentimentData sentimentData) {
//        sendEmail(sentimentData);
//    }
//
//    private void sendEmail(SentimentData sentimentData) {
//        emailService.sendEmail(sentimentData.getEmail(), "Sentiment for previous week", sentimentData.getSentiment());
//    }
//}
