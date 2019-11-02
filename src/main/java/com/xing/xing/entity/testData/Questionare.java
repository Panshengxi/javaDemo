package com.xing.xing.entity.testData;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Questionare {
    private Integer questionareId;
    private Integer questionNum;
    private Integer taskId;
    @Autowired
    private ArrayList<Question> questions;

}
