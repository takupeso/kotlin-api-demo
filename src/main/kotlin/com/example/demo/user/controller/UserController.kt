package com.example.demo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    // 全件取得
    @GetMapping("users")
    fun getUserList(): List<User> {
        return userService.getUserList()
    }

    // 1件取得
    @GetMapping("user/{id}")
    fun getUserById(@PathVariable("id") id: Int?): User {
        return userService.getUserById(id)
    }

    // 1件作成
    @PostMapping("/user")
    fun createUserById(@RequestBody user: User): List<User> {
        return userService.getInsertUser(user)
    }

    // 1件編集
    @PutMapping("/user/{id}")
    fun updateUserById(@PathVariable("id") id: Int, @RequestBody user: User): User {
        return userService.getUpdateUser(id, user)
    }

    // 1件削除
    @DeleteMapping("/user/{id}")
    fun deleteUserById(@PathVariable("id") id: Int?): User {
        return userService.getDeleteUserById(id)
    }
}