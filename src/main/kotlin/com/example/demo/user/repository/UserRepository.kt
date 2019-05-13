package com.example.demo.user

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface UserRepository {

    @Select("SELECT * FROM user;")
    fun selectUserList(): List<User>

    @Select("SELECT * FROM user WHERE id = #{id}")
    fun selectUserById(@Param("id") id: Int?): User

    @Insert("INSERT INTO user(name, hobby) values(#{name}, #{hobby})")
    fun insertUserById(user: User): Int

    @Update("UPDATE user SET name=#{name}, hobby=#{hobby} WHERE id=#{id}")
    fun updateUserById(user: User): Int

    @Delete("DELETE FROM user WHERE id=#{id}")
    fun deleteUserById(@Param("id") id: Int?): Int
}