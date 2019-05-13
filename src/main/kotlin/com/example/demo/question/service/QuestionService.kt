package com.example.demo.question

interface QuestionService {

    fun getQuestionList(): List<Question>

    fun getQuestionById(id: Int?): Question

    fun getInsertQuestion(question: Question): List<Question>

    fun getUpdateQuestion(id: Int, question: Question): Question

    fun getDeleteQuestionById(id: Int?): Question

}