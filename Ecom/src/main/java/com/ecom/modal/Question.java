package com.ecom.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

public class Question {
    @JsonProperty("que")
    @CsvBindByName
    private String que;

    @JsonProperty("opt1")
    @CsvBindByName
    private String opt1;

    @JsonProperty("opt2")
    @CsvBindByName
    private String opt2;

    @JsonProperty("opt3")
    @CsvBindByName
    private String opt3;

    @JsonProperty("opt4")
    @CsvBindByName
    private String opt4;

    @JsonProperty("correctAnswer")
    @CsvBindByName
    private String correctAnswer;

    @JsonProperty("correctAnswerDetails")
    @CsvBindByName
    private String correctAnswerDetails;

    @JsonProperty("queImage")
    @CsvBindByName
    private String queImage;

    @JsonProperty("queType")
    @CsvBindByName
    private String queType;

    @JsonProperty("title1")
    @CsvBindByName
    private String title1;

    @JsonProperty("title2")
    @CsvBindByName
    private String title2;

    @JsonProperty("name1")
    @CsvBindByName
    private String name1;

    @JsonProperty("value1")
    @CsvBindByName
    private String value1;

    @JsonProperty("name2")
    @CsvBindByName
    private String name2;

    @JsonProperty("value2")
    @CsvBindByName
    private String value2;

    @JsonProperty("name3")
    @CsvBindByName
    private String name3;

    @JsonProperty("value3")
    @CsvBindByName
    private String value3;

    @JsonProperty("name4")
    @CsvBindByName
    private String name4;

    @JsonProperty("value4")
    @CsvBindByName
    private String value4;

    @JsonProperty("que1")
    @CsvBindByName
    private String que1;

    // Getters and setters
}
