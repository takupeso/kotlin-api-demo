package com.example.demo.question

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface QuestionRepository {

    @Select("SELECT * FROM question;")
    fun selectQuestionList(): List<Question>

    @Select("SELECT * FROM question WHERE id = #{id}")
    fun selectQuestionById(@Param("id") id: Int?): Question

    @Insert("INSERT INTO question(title, content) values(#{title}, #{content})")
    fun insertQuestionById(question: Question): Int

    @Update("UPDATE question SET title=#{title}, content=#{content} WHERE id=#{id}")
    fun updateQuestionById(question: Question): Int

    @Delete("DELETE FROM question WHERE id=#{id}")
    fun deleteQuestionById(@Param("id") id: Int?): Int
}