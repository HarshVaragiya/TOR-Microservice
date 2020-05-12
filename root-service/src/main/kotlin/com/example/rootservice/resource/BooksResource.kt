package com.example.rootservice.resource

import com.example.rootservice.models.BookInfoResponse
import com.example.rootservice.models.HttpbinIPResponse
import com.example.rootservice.models.UserBooksResponse
import com.example.rootservice.models.UserRequestResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/book/")
class BooksResource() {

    val restTemplate:RestTemplate = RestTemplate()

    var logger: Logger = LoggerFactory.getLogger((BooksResource::class.java))

    @RequestMapping("/getInfo/{username}")
    fun getBookInfo(@PathVariable("username") username: String, request: HttpServletRequest, @RequestHeader headers: Map<String, String>):UserRequestResponse{
        logger.warn("[+] Incoming Request from ${request.remoteAddr} for user $username")
        headers.forEach { (key: String?, value: String?) -> logger.warn(String.format("Request Header '%s' => %s", key, value)) }

        val responseObject : UserRequestResponse = UserRequestResponse()
        responseObject.username = username
        val userBooksObject : UserBooksResponse = UserBooksResponse()
        if (username == "harsh"){
            userBooksObject.booksRead = listOf(0)
            userBooksObject.booksToRead = listOf(2)
        }else if(username == "nirav"){
            userBooksObject.booksRead = listOf(1)
            userBooksObject.booksToRead = listOf(0)
        }

        for (bookId in userBooksObject.booksRead){
            restTemplate.getForObject("http://yit7m3eeuotbmpzq.onion:8001/library/$bookId",BookInfoResponse::class.java)?.let { responseObject.booksRead.add(it) };
        }
        for (bookId in userBooksObject.booksToRead){
            restTemplate.getForObject("http://yit7m3eeuotbmpzq.onion:8001/library/$bookId",BookInfoResponse::class.java)?.let { responseObject.booksToRead.add(it) };
        }
        return responseObject
    }

    @RequestMapping("/getProxyIp")
    fun getProxyIp():HttpbinIPResponse{
        val response : HttpbinIPResponse = restTemplate.getForObject("http://httpbin.org/ip",HttpbinIPResponse::class.java)!!
        return response
    }


}