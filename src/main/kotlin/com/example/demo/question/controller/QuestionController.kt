package com.example.demo.question

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionController {

    @Autowired
    lateinit var questionService: QuestionService

    // 全件取得
    @GetMapping("questions")
    fun getQuestionList(): List<Question> {
        return questionService.getQuestionList()
    }

    // 1件取得
    @GetMapping("question/{id}")
    fun getQuestionById(@PathVariable("id") id: Int?): Question {
        return questionService.getQuestionById(id)
    }

    // 1件作成
    @PostMapping("/question")
    fun createQuestionById(@RequestBody question: Question): List<Question> {
        return questionService.getInsertQuestion(question)
    }

    // 1件編集
    @PutMapping("/question/{id}")
    fun updateQuestionById(@PathVariable("id") id: Int, @RequestBody question: Question): Question {
        return questionService.getUpdateQuestion(id, question)
    }

    // 1件削除
    @DeleteMapping("/question/{id}")
    fun deleteQuestionById(@PathVariable("id") id: Int?): Question {
        return questionService.getDeleteQuestionById(id)
    }
}