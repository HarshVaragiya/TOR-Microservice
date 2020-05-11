package com.example.bookratingservice.resource

import com.example.bookratingservice.models.BookInfoResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/library/")
class BookRatingResource {

    var logger: Logger = LoggerFactory.getLogger((BookRatingResource::class.java))

    @RequestMapping("/{bookId}")
    fun getBookRating(@PathVariable("bookId") bookId: Int,request: HttpServletRequest):BookInfoResponse{
        logger.warn("[+] Incoming Request from ${request.remoteAddr} for BookId $bookId")
        val response = BookInfoResponse()
        if (bookId == 0){
            response.name = "Permanent Record"
            response.genre = listOf("whistleblowing","spy","autobiography")
            response.description = "Life story of Edward Snowden who exposed the mass surveillance programs of the United States of America "
            response.author = "Edward Snowden"
        } else if(bookId == 1){
            response.name = "Elon Musk"
            response.genre = listOf("business","biography")
            response.description = "Deep Dive into life of SpaceX, Tesla CEO Elon Musk"
            response.author = "Ashlee vance"
        } else {
            response.name = "The Alchemist"
            response.genre = listOf("life")
            response.description = "Experience the story of a lifetime as a young boy who becomes the wind"
            response.author = "Paulo Coelho"
        }
        response.bookId = bookId
        return response
    }

}