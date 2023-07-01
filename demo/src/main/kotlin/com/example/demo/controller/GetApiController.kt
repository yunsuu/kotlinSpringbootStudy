package com.example.demo.controller
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.FileWriter

@RestController //REST API Controller 동작
class GetApiController {
    @GetMapping("/")
    fun helloWorldRouter(): String {
        return "Hello World"
    }

    @GetMapping("/read")
    fun readDataRouter(): String {
        val resource = ClassPathResource("static/data.txt")
        val file = resource.file
        // 파일 읽기
        val fileContent = file.readText()
        return "File content: $fileContent"

    }

    @GetMapping("/write")
    fun writeDataRouter(): String {
        val resource = ClassPathResource("static/data.txt")
        val file = resource.file


        // 파일 쓰기 (추가)
        val fileWriter = FileWriter(file, true)
        fileWriter.appendLine("This is additional content.")
        println("File written successfully.")
        fileWriter.close()


        // 파일 읽기
        val fileContent = file.readText()
        println("File content: $fileContent")
        return "File content: $fileContent"

    }
}
