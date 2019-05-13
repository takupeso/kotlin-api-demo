package com.example.demo.question

import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionServiceImpl : QuestionService {

    @Autowired
    lateinit var questionRepository: QuestionRepository

    override fun getQuestionList(): List<Question> {
        return questionRepository.selectQuestionList()
    }

    override fun getQuestionById(id: Int?): Question {
        return questionRepository.selectQuestionById(id)
    }

    override fun getInsertQuestion(question: Question): List<Question> {
        questionRepository.insertQuestionById(question)
        return questionRepository.selectQuestionList()
    }

    override fun getUpdateQuestion(id: Int, question: Question): Question {
        question.id = id
        return questionRepository.selectQuestionById(id)
    }

    override fun getDeleteQuestionById(@Param("id") id: Int?): Question {
        questionRepository.deleteQuestionById(id)
        return questionRepository.selectQuestionById(id)
    }
}