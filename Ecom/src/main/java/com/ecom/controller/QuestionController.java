package com.ecom.controller;


import com.ecom.common.ApiResponse;
import com.ecom.entity.QuizDetails;
import com.ecom.modal.UserModal;
import com.ecom.repo.QuizDetailsRepository;
import com.ecom.service.impl.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuizService quizService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("testName") String testName,
                                             @RequestParam("type") String type,
                                             @RequestParam("duration") String duration,
                                             @RequestParam("subType") String subType,
                                             @RequestParam("totalMarks") String totalMarks,
                                             @RequestParam("marksDetails") String marksDetails
    ) {
        try {
            System.out.println("internal application....");
            String questions = quizService.getQuestionsFromCSV(file);

            // Create a new QuizDetails object
            QuizDetails quizDetails = new QuizDetails();
            quizDetails.setTestName(testName);
            quizDetails.setType(type);
            quizDetails.setDuration(duration);
            quizDetails.setSubType(subType);
            quizDetails.setQuestionDetails(questions);
            quizDetails.setTotalMarks(totalMarks);
            quizDetails.setMarksDetails(marksDetails);
            quizDetails.setCreatedDate(String.valueOf(System.currentTimeMillis())); // You might want to set the actual date

            String sql = "INSERT INTO quizdetails (testName, type, duration, subType, questionDetails, totalMarks, marksDetails, createdDate) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sql,
                    quizDetails.getTestName(),
                    quizDetails.getType(),
                    quizDetails.getDuration(),
                    quizDetails.getSubType(),
                    quizDetails.getQuestionDetails(),
                    quizDetails.getTotalMarks(),
                    quizDetails.getMarksDetails(),
                    quizDetails.getCreatedDate()
            );


            return ResponseEntity.ok(new ApiResponse("Test Uploaded", "200", ""));
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            return ResponseEntity.ok(new ApiResponse("Test Upload Fail", "201", e.toString()));
        }
    }

    @RequestMapping(value = "/getTestList", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserList() {
        List<QuizDetails> data = quizService.getAllQuizDetails();
        return ResponseEntity.ok(new ApiResponse("OK", "200", data));
    }


}
