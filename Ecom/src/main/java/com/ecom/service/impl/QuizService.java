package com.ecom.service.impl;

import com.ecom.entity.QuizDetails;
import com.ecom.modal.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public String getQuestionsFromCSV(MultipartFile file) throws Exception {
        System.out.println("internal application.... 2");
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            System.out.println("internal application.... 3");
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                    .withType(Question.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

          //  return csvToBean.parse();
            return convertListToJson(csvToBean.parse());
        }
    }
    public List<QuizDetails> getAllQuizDetails() {
        String sql = "SELECT * FROM quizdetails";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(QuizDetails.class));
    }

    private static String convertListToJson(List<Question> questionList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(questionList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
